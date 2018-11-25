/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import MainProgram.Item;
import MainProgram.TblMenu;
import MainProgram.TblPenjualan;
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
            System.out.println(jual.getNama());
            System.out.println(jual.getHarga());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addMenu(TblMenu tm) {

        String query = "INSERT INTO menu (nama, harga, url) VALUES (?,?,?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, tm.getNama());
            st.setDouble(2, tm.getHarga());
            st.setString(3, tm.getUrl());
            st.execute();

            if (tm.getTipe().equals("makanan")) {
                String query2 = "INSERT INTO " + tm.getTipe() + " (id_menu) VALUES ((Select id_menu from menu where nama = '" + tm.getNama() + "'))";
                st = ConnectionManager.getConnection().prepareStatement(query2);
                st.execute();
            }

            if (tm.getTipe().equals("minuman")) {
                String query2 = "INSERT INTO " + tm.getTipe() + " (id_menu, category) VALUES ((Select id_menu from menu where nama = '" + tm.getNama() + "'), '" + tm.getKategori() + "')";
                System.out.println(query2);
                st = ConnectionManager.getConnection().prepareStatement(query2);
                st.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
