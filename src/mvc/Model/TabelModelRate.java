/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class TabelModelRate extends AbstractTableModel {
    List<Rate> lr;
    
    public TabelModelRate(List<Rate> lr) {
        this.lr = lr;
    }

    @Override
    public int getRowCount() 
    {
        return lr.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) 
    {
        switch (column) 
        {
            case 0:
                return row + 1;
            case 1:
                return lr.get(row).getTitle();
            case 2:
                return lr.get(row).getRating();
            case 3:
                return lr.get(row).getReview();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) 
    {
        switch (column) 
        {
            case 0:
                return "No";
            case 1:
                return "Title";
            case 2:
                return "Rating";
            case 3:
                return "Review";
            default:
                return null;
        }
    }
}
