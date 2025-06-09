/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Controller;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.DAO.DAOCinema;
import mvc.DAOInterface.ICinema;
import mvc.Model.Cinema;
import mvc.Model.TabelModelCinema;
import mvc.View.FormCinema;

/**
 *
 * @author ACER
 */
public class ControllerCinema {
    FormCinema frame;
    ICinema implCinema;
    List<Cinema> lc;
    private int ID;
    
    public ControllerCinema(FormCinema frame)
    {
        this.frame = frame;
        implCinema = new DAOCinema();
        lc = implCinema.getAll();
    }
    
    public void reset()
    {
        frame.getTxtID().setText("");
        frame.getTxtNamaCinema().setText("");
        frame.getTxtKota().setText("");
        frame.getTxtJumlah().setText("");
    }
    
    public void isiTable() 
    {
        lc = implCinema.getAll();
        TabelModelCinema tmb = new TabelModelCinema(lc);
        frame.getTabelData().setModel(tmb);
    }
    
    public void isiField(int row) 
    {
        frame.getTxtID().setText(lc.get(row).getID().toString());
        frame.getTxtNamaCinema().setText(lc.get(row).getNamaCinema());
        frame.getTxtJumlah().setText(lc.get(row).getJumlah().toString());
        frame.getTxtKota().setText(lc.get(row).getKota());
    }
    
    public void insert()
    {
        if (!frame.getTxtNamaCinema().getText().trim().isEmpty() && 
            !frame.getTxtKota().getText().trim().isEmpty())
        {
            
            Cinema cinema = new Cinema();
            cinema.setNamaCinema(frame.getTxtNamaCinema().getText());
            cinema.setJumlah(Integer.valueOf(frame.getTxtJumlah().getText()));
            cinema.setKota(frame.getTxtKota().getText());
            implCinema.insert(cinema);
            JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    
    public void update()
    {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            Cinema cinema = new Cinema();
            cinema.setNamaCinema(frame.getTxtNamaCinema().getText());
            cinema.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            cinema.setKota(frame.getTxtKota().getText());
            cinema.setID(Integer.parseInt(frame.getTxtID().getText()));
            implCinema.update(cinema);
            JOptionPane.showMessageDialog(null, "Update Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }
    
    public void delete() 
    {
        if (!frame.getTxtID().getText().trim().isEmpty()) 
        {
            int ID = Integer.parseInt(frame.getTxtID().getText());
            implCinema.delete(ID);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTableCariNama() 
    {
        lc = implCinema.getCariCinema(frame.getTxtCariNama().getText());
        TabelModelCinema tmb = new TabelModelCinema(lc);
        frame.getTabelData().setModel(tmb);
    }
    
    public void carinama() 
    {
        if (!frame.getTxtCariNama().getText().trim().isEmpty()) {
            implCinema.getCariCinema(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}

