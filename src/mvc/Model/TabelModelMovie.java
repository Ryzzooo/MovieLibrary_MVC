/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Table model for Movie
 * @author ACER
 */
public class TabelModelMovie extends AbstractTableModel {
    List<Movie> lb;
    
    public TabelModelMovie(List<Movie> lb) {
        this.lb = lb;
    }
    
    @Override
    public int getColumnCount() {
        return 8;
    }
    
    @Override
    public int getRowCount() {
        return lb.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "ID";
            case 2:
                return "Tittle";
            case 3:
                return "Genre";
            case 4:
                return "Director";
            case 5:
                return "Release Year";
            case 6:
                return "Rating";
            case 7:
                return "Description";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return lb.get(row).getId();
            case 2:
                return lb.get(row).getTitle();
            case 3:
                return lb.get(row).getGenre();
            case 4:
                return lb.get(row).getDirector();
            case 5:
                return lb.get(row).getReleaseYear();
            case 6:
                return lb.get(row).getRating();
            case 7:
                return lb.get(row).getDescription();
            default:
                return null;
        }
    }
}