/*
 * Original Main.java in "jersey-quickstart-grizzly2" does not have license descritption.
 * Jersey is licensed under CDDLv1.1 or GPLv2.
 * So, This Main.java might be licensed CDDLv1.1 or GPLv2 also.
 */
package exercise;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * copied and customized from:
 * 
 * @see https://github.com/jersey/jersey/tree/master/archetypes/jersey-quickstart-grizzly2
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8580/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * 
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in net.glamenvseptzen.jersey.ex1 package
        final ResourceConfig rc = new ResourceConfig()
                .packages("exercise");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),
                rc);
    }

    /**
     * Main method.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at "
                        + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));
        System.in.read();
        server.stop();
    }
}
