package eg.edu.alexu.csd.oop.jdbc.cs06;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriver implements Driver {
    private MyStatement connectionManager;
    public MyDriver (){
        connectionManager = new MyStatement();
    }
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if(url.equals("calculator:xmldb://localhost")) {
            File dir = (File) info.get("path");
            String path = dir.getAbsolutePath();
            return connectionManager.getConnection(path);
        }
        throw new SQLException();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        File database = new File(url);
        return database.exists();
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        ArrayList<DriverPropertyInfo> driverPropertyInfo = new ArrayList<>();
        for(int i = 0 ; i < info.size() ; i++){
            driverPropertyInfo.add((DriverPropertyInfo)info.get("path"));
        }
        return (DriverPropertyInfo[])driverPropertyInfo.toArray();
    }

    @Override
    public int getMajorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMinorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean jdbcCompliant() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException();
    }
}
