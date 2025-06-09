/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.DAO;

import mvc.DAOInterface.IActor;
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
import mvc.Model.Actor;

/**
 *
 * @author ACER
 */
public class DAOActor implements IActor{
    Connection connection;
    final String insert = "INSERT INTO tblactors (name, birth_date, nationality, biography) VALUES (?, ?, ?, ?)";
    final String update = "UPDATE tblactors SET name=?, birth_date=?, nationality=?, biography=? WHERE id=?";
    final String delete = "DELETE FROM tblactors WHERE id=?";
    final String select = "SELECT * FROM tblactors";
    final String carinama = "SELECT * FROM tblactors WHERE name LIKE ?";
    
    public DAOActor()
        {
            connection = Koneksi.connection();
        }
    
    public void insert (Actor actor)
    {
        PreparedStatement statement = null;
        try
        {
            statement = connection.prepareStatement(insert);
            statement.setString(1, actor.getName());
            statement.setString(2, actor.getBirthDate());
            statement.setString(3, actor.getNationality());
            statement.setString(4, actor.getBiography());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next())
            {
                actor.setId(rs.getInt(1));
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
    
    public void update(Actor actor) {
        PreparedStatement statement = null;
        try 
        {
            statement = connection.prepareStatement(update);
            statement.setString(1, actor.getName());
            statement.setString(2, actor.getBirthDate());
            statement.setString(3, actor.getNationality());
            statement.setString(4, actor.getBiography());
            statement.setInt(5, actor.getId());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
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
    
    public List<Actor> getAll() {
        List<Actor> la = null;
        try 
        {
            la = new ArrayList<Actor>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setId(rs.getInt("id"));
                actor.setName(rs.getString("name"));
                actor.setBirthDate(rs.getString("birth_date"));
                actor.setNationality(rs.getString("nationality"));
                actor.setBiography(rs.getString("biography"));
                la.add(actor);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
    public List<Actor> getCariActor(String name) {
        List<Actor> la = null;
        try 
        {
            la = new ArrayList<Actor>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) 
            {
                Actor actor = new Actor();
                actor.setId(rs.getInt("id"));
                actor.setName(rs.getString("name"));
                actor.setBirthDate(rs.getString("birth_date"));
                actor.setNationality(rs.getString("nationality"));
                actor.setBiography(rs.getString("biography"));
                la.add(actor);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
}
