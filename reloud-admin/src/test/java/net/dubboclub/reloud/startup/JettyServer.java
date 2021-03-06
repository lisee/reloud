package net.dubboclub.reloud.startup;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by bieber on 2015/5/26.
 */
public class JettyServer {
    
    public static void main(String[] args) throws Exception {
        final Server server = new Server(8088);
        WebAppContext webAppContext = new WebAppContext("reloud-admin/src/main/webapp", "/");
        webAppContext.setMaxFormContentSize(1024*1024*60);
        server.setHandler(webAppContext);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        server.start();
        server.join();
    }
}
