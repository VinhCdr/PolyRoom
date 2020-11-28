package poro.model.database;

/**
 *
 * @author vinh
 */
public class Config {
//    private String pathConfig;
//    private FileHelper fileHelper;
    private String dbDriver;
    private String dbURL;
    private String dbUser;
    private String dbPassword;
    private int svWebPort;

    public Config() {
        this.dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.dbURL = "jdbc:sqlserver://localhost:1433;databaseName=polyroom;";
        this.dbUser = "sa";
        this.dbPassword = "123";
        this.svWebPort = 8090;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
    
    
}
