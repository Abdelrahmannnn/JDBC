package eg.edu.alexu.csd.oop.jdbc.cs06;

import eg.edu.alexu.csd.oop.db.DBMS_N;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

public class MyStatement implements java.sql.Statement {
    ArrayList<String> SQLCommands ;
    private Connection connection;
    private MyResultSet resultSet;
    DBMS_N dbms;
    boolean closed = false;
    public MyStatement() {
        connection = new MyConnection();
        SQLCommands = new ArrayList<>();
        resultSet = new MyResultSet();
        dbms = new DBMS_N();
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        Object[][] arr = dbms.executeQuery(sql);
        resultSet.setArray(arr);
        resultSet.setTagNames(dbms.copyColumnNames(sql));
        resultSet.setSql(sql);
        return resultSet;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        return dbms.executeUpdateQuery(sql);
    }

    @Override
    public void close() throws SQLException {
        if(closed)
            return;
        closed = true;

    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        return dbms.executeStructureQuery(sql);
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetType() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        if(!closed){
            SQLCommands.add(sql);
            System.out.println("Batch is added successfully!");
        }else{
            throw new SQLException();
        }

    }

    @Override
    public void clearBatch() throws SQLException {
        if(!closed){
            SQLCommands.clear();
            System.out.println("Batch is cleared successfully!");
        }else{
            throw new SQLException();
        }
    }

    @Override
    public int[] executeBatch() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException();
    }
    public Connection getConnection(String path) throws SQLException {
        if(!closed){
            return connection;
        }else{
            throw new SQLException();
        }
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPoolable() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
