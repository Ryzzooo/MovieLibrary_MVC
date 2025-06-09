/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Model;

import java.sql.Date;

/**
 * Actor model class
 * @author ACER
 */
public class Actor {
    private Integer id;
    private String name;
    private String birthDate;
    private String nationality;
    private String biography;

    // Constructors
    public Actor() {}

    public Actor(String name, String birthDate, String nationality, String biography) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.biography = biography;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
