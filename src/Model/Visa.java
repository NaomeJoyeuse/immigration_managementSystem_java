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
public class Visa implements Serializable{
    @Id
    private String VisaId;
    private String Type;
@ManyToMany(mappedBy = "visas",fetch=FetchType.EAGER)
private List<Immigrant> immigrants;


    public Visa() {
    }

    public Visa(String VisaId) {
        this.VisaId = VisaId;
    }

    public Visa(String VisaId, String Type, List<Immigrant> immigrants) {
        this.VisaId = VisaId;
        this.Type = Type;
        this.immigrants = immigrants;
    }

    public String getVisaId() {
        return VisaId;
    }

    public void setVisaId(String VisaId) {
        this.VisaId = VisaId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public List<Immigrant> getImmigrants() {
        return immigrants;
    }

    public void setImmigrants(List<Immigrant> immigrants) {
        this.immigrants = immigrants;
    }

     @Override
    public String toString() {
        return Type;
    }
}
