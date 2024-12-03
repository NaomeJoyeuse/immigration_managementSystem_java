/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Naome
 */
@Entity
public class Immigrant implements Serializable{
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "immigrantID")
    private Integer immigrantID;

    @Column(name = "fullName")
    private String firstName;



    @Column(name = "passportNumber")
    private String passportNumber;
    
    private Date EnteringDate;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;
      @ManyToMany(fetch=FetchType.EAGER)
   @JoinTable(name = "Immigrant_Visa",
        joinColumns = @JoinColumn(name = "immigrantID"),
        inverseJoinColumns = @JoinColumn(name = "visaID"))
    private List<Visa> visas;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "Immigrant_Intent",
            joinColumns = @JoinColumn(name = "immigrantID"),
            inverseJoinColumns = @JoinColumn(name = "intentID"))
    private List<Intent> intents;

    public Immigrant() {
    }

    public Immigrant(Integer immigrantID) {
        this.immigrantID = immigrantID;
    }

    public Immigrant(Integer immigrantID, String firstName, String passportNumber, Date EnteringDate, Country country, List<Visa> visas, List<Intent> intents) {
        this.immigrantID = immigrantID;
        this.firstName = firstName;

        this.passportNumber = passportNumber;
        this.EnteringDate = EnteringDate;
        this.country = country;
        this.visas = visas;
        this.intents = intents;
    }

    public Integer getImmigrantID() {
        return immigrantID;
    }

    public void setImmigrantID(Integer immigrantID) {
        this.immigrantID = immigrantID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getEnteringDate() {
        return EnteringDate;
    }

    public void setEnteringDate(Date EnteringDate) {
        this.EnteringDate = EnteringDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Visa> getVisas() {
        return visas;
    }

    public void setVisas(List<Visa> visas) {
        this.visas = visas;
    }

    public List<Intent> getIntents() {
        return intents;
    }

    public void setIntents(List<Intent> intents) {
        this.intents = intents;
    }
    
}