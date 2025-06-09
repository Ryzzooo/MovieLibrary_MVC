/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Controller;

import static java.lang.Double.parseDouble;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.DAO.DAORate;
import mvc.DAOInterface.IRate;
import mvc.Model.Rate;
import mvc.Model.TabelModelRate;
import mvc.View.FormActor;
import mvc.View.FormRating;

/**
 *
 * @author ACER
 */
public class ControllerRate {
    FormRating frame;
    IRate implRate;
    List<Rate> lr;
    
    public ControllerRate(FormRating frame)
    {
        this.frame = frame;
        implRate = new DAORate();
        lr = implRate.getAll();
    }
    
    public void reset()
    {
        frame.getTxtID().setText("");
        frame.getTxtTitle().setText("");
        frame.getTxtRating().setText("");
        frame.getTxtReview().setText("");
    }
    
    public void isiTable() 
    {
        lr = implRate.getAll();
        TabelModelRate tmb = new TabelModelRate(lr);
        frame.getTabelData().setModel(tmb);
    }
    
    public void isiField(int row) 
    {
        frame.getTxtID().setText(lr.get(row).getID().toString());
        frame.getTxtTitle().setText(lr.get(row).getTitle());
        frame.getTxtRating().setText(lr.get(row).getRating().toString());
        frame.getTxtReview().setText(lr.get(row).getReview());
    }
    
    public void insert()
    {
        if (!frame.getTxtTitle().getText().trim().isEmpty() && 
            !frame.getTxtRating().getText().trim().isEmpty() &&
            !frame.getTxtReview().getText().trim().isEmpty()) 
        {
            
            Rate rate = new Rate();
            rate.setTitle(frame.getTxtTitle().getText());
            rate.setRating(Double.parseDouble(frame.getTxtRating().getText()));
            rate.setReview(frame.getTxtReview().getText());
            implRate.insert(rate);
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
            Rate rate = new Rate();
            rate.setTitle(frame.getTxtTitle().getText());
            rate.setRating(Double.parseDouble(frame.getTxtRating().getText()));
            rate.setReview(frame.getTxtReview().getText());
            implRate.insert(rate);
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
            int id = Integer.parseInt(frame.getTxtID().getText());
            implRate.delete(id);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTableCariRate() 
    {
        lr = implRate.getCariRating(frame.getTxtCariRating().getText());
        TabelModelRate tmb = new TabelModelRate(lr);
        frame.getTabelData().setModel(tmb);
    }
    
    public void carinama() 
    {
        if (!frame.getTxtCariRating().getText().trim().isEmpty()) {
            implRate.getCariRating(frame.getTxtCariRating().getText());
            isiTableCariRate();
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}
