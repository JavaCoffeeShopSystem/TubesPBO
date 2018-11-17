/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.awt.List;

import MainProgram.Item;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Ronaldo
 */
public class DataAccess {
    
    public void addStock(Item itm){
        
        String query = "INSERT INTO stock VALUES (?,?,?)";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1,"Kopi");
            st.setString(2,"12");
            st.setString(3,"1200");
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
//    public List<Stock> showStock(){
//        
//    }
    
}
