package com.example.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="audience")
/**
 *  Tabla audience
 */
public class Audience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Se crean la columna id
     */
    private Integer id;
     /**
     * Se crean la columna name
     */
    private String name;
     /**
     * Se crean la columna owner
     */
    private String owner;
     /**
     * Se crean la columna capacity
     */
    private Integer capacity;
     /**
     * Se crean la columna description
     */
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("audiences")
    /**
     *  para llamar los datos de category
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    /**
     * para llamar los datos de message
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    /**
     * para llamar los dtaos de reservation
     */
    private List<Reservation> reservations;
    
    /**
     * 
     * @return
     */
    public Integer getId() {
        return id;
    }
    /**
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return
     */
    public String getOwner() {
        return owner;
    }
    /**
     * 
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * 
     * @return
     */
    public Integer getCapacity() {
        return capacity;
    }
    /**
     * 
     * @param capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 
     * @return
     */
    public Category getCategory() {
        return category;
    }
    /**
     * 
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * 
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * 
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * 
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * 
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }   
    

}