package poro.module.web;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.nio.charset.Charset;
import poro.module.FileManager;
import poro.module.db.DatabaseManager;
import poro.module.db.DatabaseRefresh;
import poro.module.db.data.TempMuonPhong;

/**
 *
 * @author vinh
 */
public class WebConfirmStd extends WebHandler{

    @Override
    public void handle(HttpExchange he) throws IOException {
        String send = "";
        try {
            DatabaseRefresh.refresh();
            String sid = super.getRequestUrl(he, "id");
            if (!sid.matches("\\d")) {
                throw new RuntimeException("id không phải số");
            }
            
            int id = Integer.parseInt(sid);
            String otp = super.getRequestUrl(he, "otp");
            
            TempMuonPhong temp = new TempMuonPhong();
            temp.setIdTemp(id);
            temp.setOtp(otp);
            int ok = DatabaseManager.executeUpdate(temp, TempMuonPhong.EXECUTE_CONFIRM_BY_ID_OTP);
            if (ok == 0) {
                throw new RuntimeException("Xác nhận thất bại");
            }
            send = "Xác nhận thành công";
        } catch (Exception ex) {
            System.out.println(ex);
            send = "Đường dẫn không đúng hoặc đã bị hủy";
        }
        String web = new FileManager("asset/html/web_confirm_std.html").readString();
        super.sendResponse(he, String.format(web, send).getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public String getSite() {
        return "/porostd";
    }
    
}
