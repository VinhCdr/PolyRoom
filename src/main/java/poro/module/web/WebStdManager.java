package poro.module.web;

/**
 *
 * @author vinh
 */
public class WebStdManager {

    private static WebServer ws;
    private static WebHandler wh;
    private static Thread thread;

    public static void loading() {
        ws = new WebServer();
        wh = new WebConfirmStd();
        ws.setWebHandler(wh);
    }

    public static String getAddress() {
        if (ws == null) {
            loading();
        }
        return ws.getAddress();
    }

    public static void start() {
        if (thread != null && thread.isAlive()) {
            return;
        }

        if (ws == null) {
            loading();
        }

        thread = new Thread(ws);
        thread.start();
    }
}
