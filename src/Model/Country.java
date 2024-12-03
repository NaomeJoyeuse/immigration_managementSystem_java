/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Naome
 */
@Entity
public class Country implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Integer countryId;
    @Column(name = "country_name")
    private String name;
    private String city;
     @OneToMany(mappedBy = "country")
    private List<Immigrant> immigrants =new ArrayList<>();

//    @OneToMany(mappedBy = "country")
//    private List<Visa> visas =new ArrayList<>();
    @OneToOne(mappedBy = "country")
    private Embassy embassy;
    public Country() {
    }

    public Country(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Immigrant> getImmigrants() {
        return immigrants;
    }

    public void setImmigrants(List<Immigrant> immigrants) {
        this.immigrants = immigrants;
    }

    public Embassy getEmbassy() {
        return embassy;
    }

    public void setEmbassy(Embassy embassy) {
        this.embassy = embassy;
    }

    public Country(Integer countryId, String name, String city, Embassy embassy) {
        this.countryId = countryId;
        this.name = name;
        this.city = city;
        this.embassy = embassy;
    }
//  @Override
//    public String toString() {
//        return name;
//    }
    
}
