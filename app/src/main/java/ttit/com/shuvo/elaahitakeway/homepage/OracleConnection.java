package ttit.com.shuvo.elaahitakeway.homepage;


import android.content.Context;
import android.database.SQLException;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnection {
    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@192.168.1.5:1521:TT";
    private static final String DEFAULT_USERNAME = "ecomfood_demo";
    private static final String DEFAULT_PASSWORD = "TTI";
    private Connection connection;
    Context context;


    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (java.sql.SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        return createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

}
