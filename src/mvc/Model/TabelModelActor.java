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
public class TabelModelActor extends AbstractTableModel{
    
    List<Actor> la;
    
    public TabelModelActor(List<Actor> la) {
        this.la = la;
    }

    @Override
    public int getRowCount() 
    {
        return la.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) 
    {
        switch (column) 
        {
            case 0:
                return row + 1;
            case 1:
                return la.get(row).getName();
            case 2:
                return la.get(row).getBirthDate();
            case 3:
                return la.get(row).getNationality();
            case 4:
                return la.get(row).getBiography();
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
                return "Name";
            case 2:
                return "Birthday";
            case 3:
                return "Nationality";
            case 4:
                return "Biography";
            default:
                return null;
        }
    }
    
}
