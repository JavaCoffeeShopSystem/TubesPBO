/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import MainProgram.Item;
import MainProgram.TblBahan;
import MainProgram.TblMenu;
import MainProgram.TblPenjualan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class DataAccess {

    public void addStock(Item itm) {

        String query = "INSERT INTO barang (id_barang, nama, jml, satuan, harga) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, itm.getId());
            st.setString(2, itm.getName());
            st.setInt(3, itm.getQua());
            st.setString(4, itm.getUnit());
            st.setInt(5, itm.getPrice());

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

    public static void updateItem(Item itm) {

        String query = "UPDATE barang SET jml = ?, harga = ? WHERE id_barang = ?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, itm.getQua());
            st.setInt(2, itm.getPrice());
            st.setInt(3, itm.getId());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Item searchItem(int id) {
        Item i = null;

        String query = "SELECT * FROM barang WHERE id_barang = ?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                i = new Item();
                i.setId(rs.getInt("id_barang"));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void deleteItem(int id) {

        String query = "DELETE FROM barang WHERE id_barang = ?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, id);

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addPenjualan(TblPenjualan jual) {

        String query = "INSERT INTO penjualan (id_menu, harga, jumlah, tgl) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, jual.getId_menu());
            st.setInt(2, jual.getHarga());
            st.setInt(3, jual.getJml());
            st.setString(4, jual.getDate());

            st.execute();
            kurangiStock(jual);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void kurangiStock(TblPenjualan jual){
        //select bahan-bahan yang di perlukan pada suatu menu
        String query = "SELECT id_barang,jumlah FROM bahan where id_menu = " + jual.getId_menu();
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                //query select jml stok yang ada
                String query2 = "SELECT jml FROM barang where id_barang = "+ rs.getInt("id_barang");
                Statement st1 = ConnectionManager.getConnection().createStatement();
                ResultSet rs1 = st1.executeQuery(query2);
                rs1.next();
                // mengurangkan jml stok yang ada dengan bahan yang di perlukan
                int jml = rs1.getInt("jml") - (rs.getInt("jumlah")*jual.getJml());
                //update stok sesuai jml stok setelah dikurangi kebutuhan
                updateStock(rs.getInt("id_barang"),jml);
            }
        } catch (Exception e) {
        }
    }
    
    public void updateStock(int id,int jml){
        String query = "UPDATE barang SET jml = " + jml + " WHERE id_barang = " + id;
        System.out.println(query);
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    

    public static void addMenu(TblMenu tm,List<TblBahan> bhn) {

        String query = "INSERT INTO menu (nama, harga, url) VALUES (?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, tm.getNama());
            st.setDouble(2, tm.getHarga());
            st.setString(3, tm.getUrl());
            st.execute();
            
            if (tm.getTipe().equals("makanan")) {
                String query2 = "INSERT INTO " + tm.getTipe() + " (id_menu) VALUES ((Select id_menu from menu where nama = '"+ tm.getNama() +"'))";
                st = ConnectionManager.getConnection().prepareStatement(query2);
                st.execute();
            }
            
            if (tm.getTipe().equals("minuman")) {
                String query2 = "INSERT INTO " + tm.getTipe() + " (id_menu, category) VALUES ((Select id_menu from menu where nama = '"+ tm.getNama() +"'), '" + tm.getKategori() + "')";
                System.out.println(query2);
                st = ConnectionManager.getConnection().prepareStatement(query2);
                st.execute();
            }
            
            for (TblBahan tblBahan : bhn) {
                String query3 = "INSERT INTO bahan (id_menu,id_barang, jumlah) VALUES ((Select id_menu from menu where nama = '"+ tm.getNama() +"'), " + 
                        tblBahan.getIdBarang()+","+ tblBahan.getJml() +  ")";
                System.out.println(query3);
                st = ConnectionManager.getConnection().prepareStatement(query3);
                st.execute();
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
