/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Model;

/**
 *
 * @author ACER
 */
public class Cinema {
    private Integer ID;
    private String NamaCinema;
    private String Kota;
    private Integer Jumlah;

    
    public Cinema(){}

    public Cinema(String NamaCinema, String Kota, Integer Jumlah){
        this.NamaCinema = NamaCinema;
        this.Kota = Kota;
        this.Jumlah = Jumlah;
    }

    public Integer getID(){
        return ID;
    }

    public void setID(Integer ID){
        this.ID = ID;
    }

    public String getNamaCinema(){
        return NamaCinema;
    }

    public void setNamaCinema(String NamaCinema){
        this.NamaCinema = NamaCinema;
    }

    public String getKota(){
        return Kota;
    }

    public void setKota(String Kota){
        this.Kota = Kota;
    }

    public Integer getJumlah(){
        return Jumlah;
    }

    public void setJumlah(Integer Jumlah){
        this.Jumlah = Jumlah;
    }
}
