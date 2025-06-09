/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Controller;

import javax.swing.JOptionPane;
import mvc.DAO.DAOLogin;
import mvc.DAOInterface.ILogin;
import mvc.Model.Login;
import mvc.View.FormHome;
import mvc.View.FormMovie;
import mvc.View.FormLogin;
import mvc.View.Register;
import java.lang.String;

/**
 *
 * @author ACER
 */
public class ControllerLogin {
    FormLogin framelogin;
    Register frameregister;
    ILogin implLogin;
    
    public ControllerLogin(FormLogin framelogin)
    {
        this.framelogin = framelogin;
        implLogin = new DAOLogin();
    }
    
    public ControllerLogin(Register frameregister)
    {
        this.frameregister = frameregister;
        implLogin = new DAOLogin();
    }
    
    public void Login()
    {
        String txtUsn = framelogin.getTxtUsn().getText();
        String txtPass = framelogin.getTxtPass().getText();
        if (implLogin.checkLogin(txtUsn, txtPass))
        {
            JOptionPane.showMessageDialog(framelogin, "login berhasil");
            String nama = implLogin.getNamaUser();
            framelogin.dispose();
            FormHome fh = new FormHome();
            fh.setVisible(true);
            fh.pack();
            fh.setLocationRelativeTo(null);
        }
        else
        {
            JOptionPane.showMessageDialog(framelogin, "gagal login");
        }
    }
    
    public void Register()
    {
        Login login1 = new Login();
        login1.setTxtName(frameregister.getTxtName().getText());
        login1.setTxtUsn(frameregister.getTxtUsn().getText());
        login1.setTxtPass(frameregister.getTxtPass().getText());
        implLogin.insert(login1);
        frameregister.dispose();
        new FormLogin().setVisible(true);
    }
}
