package eg.edu.alexu.csd.oop.jdbc.cs06;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class MyResultSetMetaData implements ResultSetMetaData {
    private String[] tagNames;
    private String[] types;
    private String sql ;


    public void setTypes(String[] types) {
        this.types = types;
    }

    public void setSql (String sql){
        this.sql = sql ;
    }

    public void setTagNames(String[] tagNames) {
        this.tagNames = tagNames;
    }

    @Override
    public int getColumnCount() throws SQLException {
        return tagNames.length ;
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int isNullable(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
       if(column>0&&column<=tagNames.length){
           return tagNames[column-1] ;
       }else{
           System.out.println("Error!");
           throw new SQLException() ;
       }
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        if(column>0&&column<=tagNames.length){
            return tagNames[column-1] ;
        }else{
            throw new SQLException() ;
        }
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getScale(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTableName(int column) throws SQLException {
       String sub= sql.substring(sql.toLowerCase().indexOf("from"));
       String[] arr =sub.split("[ ]+") ;
       return arr[1] ;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        if(column>0&&column<=types.length){
            if(types[column-1].equals("varchar")){
                return Types.VARCHAR;
            }else{
                return Types.INTEGER;
            }
        }
        throw new SQLException();
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        if(column>0&&column<=types.length){
            return types[column-1];
        }
        throw new SQLException();
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
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

