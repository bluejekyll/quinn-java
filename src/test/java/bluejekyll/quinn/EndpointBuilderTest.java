package bluejekyll.quinn;

import org.junit.Test;

public class EndpointBuilderTest {
    @Test
    public void testNewEndpoint() {
        new QuinnInitializer().init();
        EndpointBuilder builder = new EndpointBuilder();
    }
}