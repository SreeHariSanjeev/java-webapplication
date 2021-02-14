package com.db;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnection {

    
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    
    private Connection connection;
 
    private Properties properties;

    private Statement statement;
    
    private Properties getProperties()
    {
        if (properties == null)
        {
            properties = new Properties();
        
            properties.setProperty("user", USERNAME);
            
            properties.setProperty("password", PASSWORD);
            
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        
        return properties;
    }

    /**
     * Connect to the database  
     * 
     * @return Connection
     */
    public Connection connect() throws Exception
    {
    
        if (connection == null)
        {         
            try
            {
            	  Class.forName("com.mysql.cj.jdbc.Driver");
            	   connection     =   DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +  "user=root&password=");
               // connection = (Connection) DriverManager.getConnection(DATABASE_URL, getProperties());
            }
            catch ( Exception e)
            {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Disconnect database
     */
    public void disconnect()
    {
        if (connection != null)
        {
            try
            {
                connection.close();
             
                connection = null;
                
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Return the result set when a correct SQL statement is provided
     * 
     * @param query
     * @return
     * @throws SQLException 
     */
    public ResultSet select(String query) throws SQLException
    {        
        statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet;        
    }
    
    /**
     * Return the status when a SQL query is provided for INSERT, UPDATE or DELETE
     * 
     * @param query
     * @return
     * @throws SQLException 
     */
    public int createOrUpdateOrDelete(String query) throws SQLException
    {        
            statement = connection.createStatement();
            
            int result = statement.executeUpdate(query);
            
            return result;       
    }
    
}
