/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.DAOInterface;

import java.util.List;
import mvc.Model.Movie;

/**
 * Interface for Movie DAO
 * @author ACER
 */
public interface IMovie {
    public void insert(Movie movie);
    public void update(Movie movie);
    public void delete(int id);
    public List<Movie> getAll();
    public List<Movie> getCariTitle(String title);
}
