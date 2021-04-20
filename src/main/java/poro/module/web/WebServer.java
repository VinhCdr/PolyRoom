package poro.module.web;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
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
        String link = ":" + isa.getPort() + webHandler.getSite();
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("google.com"), 80);
            String ip = socket.getLocalAddress().getHostAddress();
            return ip + link;
        } catch (UnknownHostException | SocketException ex) {
            System.out.println(ex);
        }
        try {
            return InetAddress.getLocalHost().getHostName() + link;
        } catch (UnknownHostException ex1) {
            System.out.println(ex1);
        }
        return "localhost" + link;
    }

}
