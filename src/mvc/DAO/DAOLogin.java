/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mvc.DAOInterface.ILogin;
import mvc.Koneksi.Koneksi;
import static mvc.Koneksi.Koneksi.connection;
import mvc.Model.Login;
import mvc.Model.Movie;
import mvc.View.FormMovie;
import mvc.View.FormLogin;

/**
 *
 * @author ACER
 */
public class DAOLogin implements ILogin{
    Connection con;
    String txtNama;
    public DAOLogin()
    {
        con = Koneksi.connection();
    }

    @Override
    public boolean checkLogin(String txtUsn, String txtPass) {
        boolean login = false;
        try {
            String sql = "SELECT * FROM tblakun WHERE username = ? AND password =?;";
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtUsn);
            pst.setString(2, txtPass);
            java.sql.ResultSet rs = pst.executeQuery();
            
            if (rs.next())
            {
                login = true;
                txtNama = rs.getString("name");
            }
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return login;
    }
    
    public String getNamaUser()
    {
        return txtNama;
    }
    
    public void insert(Login login) {
        PreparedStatement statement = null;
        String sql = "INSERT INTO tblakun (name, username, password) VALUES (?, ?, ?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, login.getTxtName());
            statement.setString(2, login.getTxtUsn());
            statement.setString(3, login.getTxtPass());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Input");
            }
        }
    }
}
