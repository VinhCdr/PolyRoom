package poro.module;

/**
 *
 * @author vinh
 */
interface Config {

    String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=polyroom;";
    String DB_USER = "sa";
    String DB_PASSWORD = "123";
    int WEB_SERVER_PORT = 8090;
    String MAIL_ACCOUNT = "noreply.vinh.bot@gmail.com";
    String MAIL_NAME = "PolyRoom Noreply";
    String MAIL_PASSWORD = "Admin0123/";

}
