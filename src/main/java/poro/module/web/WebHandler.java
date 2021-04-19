package poro.module.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vinh
 */
abstract public class WebHandler implements HttpHandler {

    @Override
    abstract public void handle(HttpExchange he) throws IOException;
    
    abstract public String getSite();

    /**
     * Lấy dữ liệu kiểu Get của HttpExchange
     * 
     * @param he Một đối tượng HttpExchange
     * @param param Key của value muốn lấy
     * @return Trả về value của key tương ứng, nếu không có key, trả về chuổi rỗng
     */
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
