/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc.DAOInterface;

import mvc.Model.Login;
import mvc.Model.Movie;

/**
 *
 * @author ACER
 */
public interface ILogin {
    public boolean checkLogin(String txtUsn, String txtPass);
    public void insert(Login login);
    public String getNamaUser();
}
