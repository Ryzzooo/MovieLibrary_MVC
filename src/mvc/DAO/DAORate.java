/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.DAOInterface.IRate;
import mvc.Koneksi.Koneksi;
import mvc.Model.Rate;

/**
 *
 * @author ACER
 */
public class DAORate implements IRate{
    Connection connection;
    final String insert = "INSERT INTO tblrate (title, rating, review) VALUES (?, ?, ?)";
    final String update = "UPDATE tblrate SET title=?, rating=?, review=? WHERE id=?";
    final String delete = "DELETE FROM tblrate WHERE id=?";
    final String select = "SELECT * FROM tblrate";
    final String carinama = "SELECT * FROM tblrate WHERE title LIKE ?";
    
    public DAORate() {
        connection = Koneksi.connection();
    }
    
    public void insert(Rate rate) 
    {
        PreparedStatement statement = null;
        try 
        {
            statement = connection.prepareStatement(insert);
            statement.setString(1, rate.getTitle());
            statement.setDouble(2, rate.getRating());
            statement.setString(3, rate.getReview());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) 
            {
                rate.setId(rs.getInt(1));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Berhasil Input");
        } 
        finally 
        {
            try 
            {
                statement.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Gagal Input");
            }
        }
    }
    
    public void update(Rate rate) {
        PreparedStatement statement = null;
        try 
        {
            statement = connection.prepareStatement(update);
            statement.setString(1, rate.getTitle());
            statement.setDouble(2, rate.getRating());
            statement.setString(3, rate.getReview());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Berhasil Update");
        } 
        finally 
        {
            try 
            {
                statement.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Gagal Update");
            }
        }
    }
    
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
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
    
    public List<Rate> getAll() {
        List<Rate> lr = null;
        try 
        {
            lr = new ArrayList<Rate>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Rate rate = new Rate();
                rate.setId(rs.getInt("id"));
                rate.setTitle(rs.getString("title"));
                rate.setRating(rs.getDouble("rating"));
                rate.setReview(rs.getString("review"));
                lr.add(rate);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAORate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
    
    public List<Rate> getCariRating(String title) {
        List<Rate> lr = null;
        try 
        {
            lr = new ArrayList<Rate>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + title + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) 
            {
                Rate rate = new Rate();
                rate.setId(rs.getInt("id"));
                rate.setTitle(rs.getString("title"));
                rate.setRating(rs.getDouble("rating"));
                rate.setReview(rs.getString("review"));
                lr.add(rate);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
    
}
