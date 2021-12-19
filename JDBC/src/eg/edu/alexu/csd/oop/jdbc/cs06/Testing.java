package eg.edu.alexu.csd.oop.jdbc.cs06;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class Testing {
    public static void main(String[] args) throws SQLException {
        Driver driver = new MyDriver();
        Properties info = new Properties();
        /*your database folder location*/
        File dbDir = new File("islam");
        info.put("path", dbDir.getAbsoluteFile());
        Connection connection = driver.connect("jdbc:xmldb://localhost", info);
    }
}
