/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;


import MainProgram.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class DataAccess {

    public void addStock(Item itm) {

        String query = "INSERT INTO barang (nama, jml, satuan, harga) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, itm.getName());
            st.setInt(2, itm.getQua());
            st.setString(3, itm.getUnit());
            st.setInt(4, itm.getPrice());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Item> showStock() {
        List<Item> listItem = new ArrayList<>();

        String query = "SELECT * FROM barang;";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Item i = new Item();
                i.setId(rs.getInt("id_barang"));
                i.setName(rs.getString("nama"));
                i.setQua(rs.getInt("jml"));
                i.setUnit(rs.getString("satuan"));
                i.setPrice(rs.getInt("harga"));
                listItem.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listItem;
    }

//      public void showHistory(){
//          
//          
//      }  
}
