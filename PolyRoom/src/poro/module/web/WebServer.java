package poro.module.web;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import poro.module.Config;

/**
 *
 * @author vinh
 */
public class WebServer implements Runnable {

    HttpServer httpServer;
    WebHandler webHandler;
    InetSocketAddress isa = new InetSocketAddress(Config.WEB_SERVER_PORT);
    String site = "poro";

    public WebHandler getWebHandler() {
        return webHandler;
    }

    public void setWebHandler(WebHandler webHandler) {
        this.webHandler = webHandler;
    }
    
    @Override
    public void run() {
        try {
            httpServer = HttpServer.create(isa, 10);
            httpServer.createContext(webHandler.getSite(), webHandler);
            httpServer.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public String getAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress() + ":" + isa.getPort() + webHandler.getSite();
        } catch (UnknownHostException ex) {
            System.out.println(ex);
            return "";
        }
    }

}
