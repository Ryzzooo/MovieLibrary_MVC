/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Model;

/**
 *
 * @author ACER
 */
public class Rate {
    private Integer id;
    private String title;
    private Double rating;
    private String review;
    
    public Rate(){}
    
    public Rate(String title, Double rating, String review)
    {
        this.title = title;
        this.rating = rating;
        this.review = review;
        
    }
    
    public Integer getID()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getReview()
    {
        return review;
    }
    
    public void setReview(String review)
    {
        this.review = review;
    }
    
    public Double getRating()
    {
        return rating;
    }
    
    public void setRating(Double rating)
    {
        this.rating = rating;
    }
}
