package bluejekyll.quinn;

import org.bridj.Pointer;

import bluejekyll.quinn_ffi.Quinn_ffiLibrary;
import bluejekyll.quinn_ffi.Quinn_ffiLibrary.EndpointBuilderFFI;

public class EndpointBuilder {
    public EndpointBuilder() {
        Pointer<EndpointBuilderFFI> ptr = Quinn_ffiLibrary.endpointNewBuilder();
        Quinn_ffiLibrary.endpointBuilderFree(ptr);
    }
}