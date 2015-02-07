package com.elevenware.ntaas;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NtaasApplication {

    private Server server;
    private static final Logger log = LoggerFactory.getLogger(NtaasApplication.class);

    private void start() {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(Integer.getInteger("ntaas.server.port", 8080));
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.mvc.templateBasePath.freemarker",
                "freemarker");

        jerseyServlet.setInitParameter("javax.ws.rs.Application",
                NtaasConfig.class.getCanonicalName());

        try {
            try {
                jettyServer.start();
                jettyServer.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            jettyServer.destroy();
        }
    }

    public static void main(String...args) {

         NtaasApplication application = new NtaasApplication();
        application.start();

    }

}
