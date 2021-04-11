package modelo;

public class Database {
    String url;
    String usr;
    String pwd;
    String driver;
    
    public Database () {
    this.url = "jdbc:mysql://192.168.100.12:3306/estudiantes";
    this.usr = "root";
    this.pwd = "";
    this.driver = "com.mysql.jdbc.Driver";
    }

    public String getUrl() {
        return url;
    }

    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }

    public String getDriver() {
        return driver;
    }
   
}


