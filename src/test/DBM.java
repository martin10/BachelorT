package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBM{
    private String db_server;
    private String db_user;
    private String db_password;
    private String db_driver;

    public Connection connection = null;

    public DBM() throws Exception {
        init();
    }

   
    private void init()throws Exception{
        // Editer dette hvis du er kobla mot en annen database.
        db_server   = "jdbc:mysql://sql4.freemysqlhosting.net/sql435045";
        db_user     = "sql435045";
        db_password = "mG2%nR5!";
        db_driver   = "com.mysql.jdbc.Driver";
        Class.forName(db_driver);
    }   
   
    public Connection initConnection() throws Exception{
        if( this.connection == null ){
            this.connection = DriverManager.getConnection(db_server, db_user, db_password);
            this.connection.setAutoCommit(false);
        }else if( this.connection.isClosed() ){
            this.connection = null;
            this.connection = DriverManager.getConnection(db_server, db_user, db_password);
            this.connection.setAutoCommit(false);
        }
        return this.connection;
    }

    
    public void closeConnection(){
        try {
            if(this.connection != null ){
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commitConnection(){
        try {
            if( this.connection != null && !this.connection.isClosed() ){
                this.connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollbackConnection(){
        try {
            if( this.connection != null && !this.connection.isClosed() ){
                this.connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}