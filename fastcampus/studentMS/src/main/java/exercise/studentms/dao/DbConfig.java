package exercise.studentms.dao;

public class DbConfig {
    private String dbUrl;
    private String dbId;
    private String dbPassword;
    private String dbDriver;

    public DbConfig(String dbUrl, String dbId, String dbPassword, String dbDriver) {
        this.dbUrl = dbUrl;
        this.dbId = dbId;
        this.dbPassword = dbPassword;
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbId() {
        return dbId;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}
