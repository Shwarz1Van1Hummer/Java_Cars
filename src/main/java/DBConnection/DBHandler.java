package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs {

    Connection dbconnection;

    public Connection getConnection(){
        String connectionString = "jdbc:postgresql://"+ Configs.dbhost + "/" + Configs.dbname;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dbconnection = DriverManager.getConnection(connectionString,Configs.dbuser, Configs.dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbconnection;
    }

}
