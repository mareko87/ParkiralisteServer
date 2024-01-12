/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.connection.DBConnectionDefaults;
import domain.AbstractDomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Marko Milosevic
 */
public class DBBroker {
    private static DBBroker instance;
    private Connection connection;
    
    public static String jdbc;
    public static String localhost;
    public static String dbName;
    public static String username;
    public static String password;

    private DBBroker() {
        jdbc = DBConnectionDefaults.JDBC;
        localhost = DBConnectionDefaults.LOCALHOST;
        dbName = DBConnectionDefaults.DB_NAME;
        username = DBConnectionDefaults.USERNAME;
        password = DBConnectionDefaults.PASSWORD;
        try {
            System.out.println("DBBroker constructor: connection = DriverManager.getConnection(jdbc:" +
                    jdbc + "://localhost:" + localhost + "/" + dbName + ", username, password);" );
            
            connection
                    = DriverManager.getConnection("jdbc:" + jdbc + 
                            "://localhost:" + localhost +
                            "/" + dbName, 
                            username, password);

//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkiraliste", "root", "root");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection = null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance=new DBBroker();
        return instance;
    }
    
    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " 
                + ado.alijas() + " " + ado.join() + " ";
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " " 
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET " 
                + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    
}
