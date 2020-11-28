package poro;

/**
 *
 * @author vinh
 */
public class Config {
//    private String pathConfig;
//    private FileHelper fileHelper;
    private final String dbDriver;
    private final String dbURL;
    private final String dbUser;
    private final String dbPassword;
    private final int svWebPort;
    private final String mailAccount;
    private final String mailName;
    private final String mailPass;

    public Config() {
        this.dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.dbURL = "jdbc:sqlserver://localhost:1433;databaseName=polyroom;";
        this.dbUser = "sa";
        this.dbPassword = "123";
        this.svWebPort = 8090;
        this.mailAccount = "noreply.vinh.bot@gmail.com";
        this.mailPass = "Admin0123/";
        this.mailName = "PolyRoom Noreply";
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public int getSvWebPort() {
        return svWebPort;
    }

    public String getMailAccount() {
        return mailAccount;
    }

    public String getMailName() {
        return mailName;
    }

    public String getMailPass() {
        return mailPass;
    }
    
}
