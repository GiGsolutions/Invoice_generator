
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gepardas
 */


public class DataBaseInjection {
    
    private static final String DB_PATH = System.getProperty("user.dir") + "/Invoice.accdb";
     
    private String name;
    private Long code;
    private String adress;
    private String city;
    private String country;
    private String phone;
    private String email;

    public DataBaseInjection(String name, String code, String adress, String city, String country, String phone, String email) {
        this.name = name;
        this.code = Long.parseLong(code);
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }
    
     public void addClient( ){
     
  
 // connecting to the database
         try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://" + DB_PATH + ";showschema=true",
                "Username",
                "Password")) {
            

           
           String sqlString = "INSERT INTO Client" + "(Name, Code, Adress, Country, City, Phone, Email)"
//                   +name+","
//                   +code+"," 
//                   +adress+"," 
//                   +country+","
//                   +city+","  
//                   +phone+","
//                   +email  
//                   +")"
                   +"VALUES (?,?,?,?,?,?,?)";
//                   


            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
 
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, code);
            preparedStatement.setString(3, adress);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, country);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, email);
            
            
            
            
            
     System.out.println(code);
    
    } catch (SQLException ex) {
            System.err.println("(e)Class[KKLOrdersDAO] | Module[insertOrder]: " + ex);
        }
           
    
    
    
    
    
    }
    
    
}
