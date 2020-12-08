package poro.module.web;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vinh
 */
public class WebHandler implements HttpHandler{

    @Override
    public void handle(HttpExchange he) throws IOException {
        sendResponse(he, "hihí".getBytes(Charset.forName("UTF-8")));
        System.out.println(getRequestUrl(he, "id"));
        System.out.println(getRequestUrl(he, "otp"));
    }
    
    public String getRequestUrl(HttpExchange he, String param) {
        String uri = he.getRequestURI().toString();
        String data = uri.substring(uri.indexOf("?") + 1);
        String[] dataArr = data.split("&");
        Map<String, String> map = new HashMap<>();
        for (String s : dataArr) {
            String[] keyValue = s.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        return map.get(param) == null ? "" : map.get(param);
    }
    
    public void sendResponse(HttpExchange he, byte[] data) throws IOException {
        he.sendResponseHeaders(200, data.length);
        OutputStream os = he.getResponseBody();
        os.write(data);
        os.flush();
        os.close();
    }
    
}
