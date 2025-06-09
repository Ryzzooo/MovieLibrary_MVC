/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.DAO;

import mvc.DAOInterface.ICinema;
import mvc.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.Model.Cinema;

/**
 *
 * @author ACER
 */
public class DAOCinema implements ICinema {
    Connection connection;
    final String insert = "INSERT INTO tblcinema (nama_cinema, kota, jumlah) VALUES (?, ?, ?)";
    final String update = "UPDATE tblcinema SET nama_cinema=?, kota=?, jumlah=? where id=?";
    final String delete = "DELETE FROM tblcinema WHERE id=?";
    final String select = "SELECT * FROM tblcinema";
    final String caricinema = "SELECT * FROM tblcinema WHERE nama_cinema LIKE ?";
    
    public DAOCinema(){
        connection = Koneksi.connection();
    }

    public void insert (Cinema cinema){
       PreparedStatement statement = null; 
       try{
    
            statement = connection.prepareStatement(insert);
            statement.setString(1, cinema.getNamaCinema());
            statement.setString(2,cinema.getKota());
            statement.setInt(3, cinema.getJumlah());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()){
                cinema.setID(rs.getInt(1));
            }
       }
       catch (SQLException ex){
           System.out.println("Berhasil Input");
       }
       finally{
           try{
               statement.close();
           }
           catch (SQLException ex){
               System.out.println("Gagal Input");
           }
       }
}
    
    @Override
    public void update(Cinema cinema){
    PreparedStatement statement = null;
    try{
        statement = connection.prepareStatement(update);
        statement.setString(1, cinema.getNamaCinema());
        statement.setString(2, cinema.getKota());
        statement.setInt(3, cinema.getJumlah());
        statement.setInt(4, cinema.getID());
        statement.executeUpdate();
    }
    catch (SQLException ex){
        System.out.println("Berhasil Update");
    }
    finally{
        try{
            statement.close();
        }
        catch (SQLException ex){
            System.out.println("Gagal Update");
        }
    }
}
    public void delete(int ID) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Delete");
            }
        }
    }
    public List<Cinema> getAll() {
        List<Cinema> lc = null;
        try 
        {
            lc = new ArrayList<Cinema>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setID(rs.getInt("ID"));
                cinema.setNamaCinema(rs.getString("Nama_Cinema"));
                cinema.setKota(rs.getString("Kota"));
                cinema.setJumlah(rs.getInt("Jumlah"));
                lc.add(cinema);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCinema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }
    

    public List<Cinema> getCariCinema(String NamaCinema) {
        List<Cinema> lc = null;
        try 
        {
            lc = new ArrayList<Cinema>();
            PreparedStatement st = connection.prepareStatement(caricinema);
            st.setString(1, "%" + NamaCinema + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) 
            {
                Cinema cinema = new Cinema();
                cinema.setID(rs.getInt("id"));
                cinema.setNamaCinema(rs.getString("nama_cinema"));
                cinema.setJumlah(rs.getInt("jumlah"));
                lc.add(cinema);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCinema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }  
}

