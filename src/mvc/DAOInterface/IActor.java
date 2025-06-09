/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc.DAOInterface;

import java.util.List;
import mvc.Model.Actor;
import mvc.Model.Movie;

/**
 *
 * @author ACER
 */
public interface IActor {
    public void insert(Actor actor);
    public void update(Actor actor);
    public void delete(int id);
    public List<Actor> getAll();
    public List<Actor> getCariActor(String name);
}
