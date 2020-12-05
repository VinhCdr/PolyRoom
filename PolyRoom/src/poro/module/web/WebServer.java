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
    InetSocketAddress isa;

    @Override
    public void run() {
        try {
            webHandler = new WebHandler();

            isa = new InetSocketAddress(Config.WEB_SERVER_PORT);
            httpServer = HttpServer.create(isa, 5);
            httpServer.createContext("/poro", webHandler);
            
            httpServer.start();
            
            System.out.println(getAddress());
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public String getAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress() + ":" + isa.getPort() + "/poro";
    }

    public static void main(String[] args) {
        WebServer ws = new WebServer();
        ws.run();
    }
    
}
