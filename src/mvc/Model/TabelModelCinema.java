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
public class TabelModelCinema extends AbstractTableModel {
    List<Cinema> lc;
    
    public TabelModelCinema(List<Cinema> lc) {
        this.lc = lc;
    }

    public int getRowCount() 
    {
        return lc.size();
    }

    public int getColumnCount() 
    {
        return 4;
    }

    public Object getValueAt(int row, int column) 
    {
        switch (column) 
        {
            case 0:
                return row + 1;
            case 1:
                return lc.get(row).getNamaCinema();
            case 2:
                return lc.get(row).getKota();
            case 3:
                return lc.get(row).getJumlah();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) 
    {
        switch (column) 
        {
            case 0:
                return "ID";
            case 1:
                return "Nama Cinema";
            case 2:
                return "Kota";
            case 3:
                return "Jumlah";
            default:
                return null;
        }
    }
}
