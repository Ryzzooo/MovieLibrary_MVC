/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.DAO.DAOActor;
import mvc.DAOInterface.IActor;
import mvc.Model.Actor;
import mvc.Model.Movie;
import mvc.Model.TabelModelActor;
import mvc.View.FormActor;

/**
 *
 * @author ACER
 */
public class ControllerActor {
    
    FormActor frame;
    IActor implActor;
    List<Actor> la;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public ControllerActor(FormActor frame)
    {
        this.frame = frame;
        implActor = new DAOActor();
        la = implActor.getAll();
    }
    
    public void reset()
    {
        frame.getTxtID().setText("");
        frame.getTxtName().setText("");
        frame.getTxtBirthday().setText("");
        frame.getTxtNationality().setText("");
        frame.getTxtBiography().setText("");
    }
    
    public void isiTable() 
    {
        la = implActor.getAll();
        TabelModelActor tmb = new TabelModelActor(la);
        frame.getTabelData().setModel(tmb);
    }
    
    public void isiField(int row) 
    {
        frame.getTxtID().setText(la.get(row).getId().toString());
        frame.getTxtName().setText(la.get(row).getName());
        frame.getTxtBirthday().setText(la.get(row).getBirthDate().toString());
        frame.getTxtNationality().setText(la.get(row).getNationality());
        frame.getTxtBiography().setText(la.get(row).getBiography());
    }
    
    public void insert() throws ParseException
    {
        if (!frame.getTxtName().getText().trim().isEmpty() && 
            !frame.getTxtBirthday().getText().trim().isEmpty() &&
            !frame.getTxtNationality().getText().trim().isEmpty() &&
            !frame.getTxtBiography().getText().trim().isEmpty()) 
        {
            
            Actor actor = new Actor();
            actor.setName(frame.getTxtName().getText());
            actor.setBirthDate(frame.getTxtBirthday().getText());
            actor.setNationality(frame.getTxtNationality().getText());
            actor.setBiography(frame.getTxtBiography().getText());
            implActor.insert(actor);
            JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    
    public void update() throws ParseException
    {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            Actor actor = new Actor();
            actor.setName(frame.getTxtName().getText());
            actor.setBirthDate(frame.getTxtBirthday().getText());
            actor.setNationality(frame.getTxtNationality().getText());
            actor.setBiography(frame.getTxtBiography().getText());
            implActor.insert(actor);
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
            implActor.delete(id);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTableCariActor() 
    {
        la = implActor.getCariActor(frame.getTxtCariActor().getText());
        TabelModelActor tmb = new TabelModelActor(la);
        frame.getTabelData().setModel(tmb);
    }
    
    public void carinama() 
    {
        if (!frame.getTxtCariActor().getText().trim().isEmpty()) {
            implActor.getCariActor(frame.getTxtCariActor().getText());
            isiTableCariActor();
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
    
}
