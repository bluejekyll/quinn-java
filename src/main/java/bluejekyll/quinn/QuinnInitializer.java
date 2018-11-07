package bluejekyll.quinn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class QuinnInitializer {
    private static final String QUINN_LIB = "libquinn_ffi";

    public QuinnInitializer() {
    }

    public void init() {
        final String osName = System.getProperty("os.name");

        final String ext;
        final String pkg;
        if (osName == null) {
            throw new RuntimeException("os.name is not present");
        } else if (osName.startsWith("Linux")) {
            ext = "so";
            pkg = "linux_x64";
        } else if (osName.startsWith("Darwin")) {
            ext = "dylib";
            pkg = "darwin_x64";
        } else if (osName.startsWith("Windows")) {
            ext = "dll";
            pkg = "windows_x64";
        } else {
            throw new RuntimeException(String.format("unsupported OS: %s", osName));
        }

        final String libName = String.format("%s.%s", QUINN_LIB, ext);
        final String pkgName = String.format("lib/%s/%s", pkg, libName);

        // create a temporary file for the lib
        File tempLib;
        try {
            tempLib = File.createTempFile(QUINN_LIB, ext);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tempLib.deleteOnExit();

        // get the library from the classpath
        try (InputStream libIn = QuinnInitializer.class.getResourceAsStream(pkgName)) {
            if (libIn == null) {
                throw new RuntimeException(String.format("could not find %s in classpath", pkgName));
            }

            // write the data from the the lib to the temp_lib
            try (OutputStream libOut = new FileOutputStream(tempLib)) {
                byte[] buffer = new byte[4096];
                int read = -1;
                while ((read = libIn.read(buffer)) > 0) {
                    libOut.write(buffer, 0, read);
                }

                libOut.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Now that the library is on the Filesystem, we should be able to load it
        System.load(tempLib.getAbsolutePath());
    }
}