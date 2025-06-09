/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc.DAOInterface;

import java.util.List;
import mvc.Model.Rate;

/**
 *
 * @author ACER
 */
public interface IRate {
    public void insert(Rate rate);
    public void update(Rate rate);
    public void delete(int id);
    public List<Rate> getAll();
    public List<Rate> getCariRating(String title);
}
