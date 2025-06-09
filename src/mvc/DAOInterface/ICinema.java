/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc.DAOInterface;

import java.util.List;
import mvc.Model.Cinema;

/**
 *
 * @author ACER
 */
public interface ICinema {
    public void insert(Cinema cinema);
    public void update(Cinema cinema);
    public void delete(int ID);
    public List<Cinema> getAll();
    public List<Cinema> getCariCinema(String NamaCinema);
}

