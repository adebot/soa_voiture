/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "voitures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voitures.findAll", query = "SELECT v FROM Voitures v"),
    @NamedQuery(name = "Voitures.findById", query = "SELECT v FROM Voitures v WHERE v.id = :id"),
    @NamedQuery(name = "Voitures.findByNom", query = "SELECT v FROM Voitures v WHERE v.nom = :nom")})
public class Voitures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "ID_couleur", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Couleur iDcouleur;

    public Voitures() {
    }

    public Voitures(Long id) {
        this.id = id;
    }

    public Voitures(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Couleur getIDcouleur() {
        return iDcouleur;
    }

    public void setIDcouleur(Couleur iDcouleur) {
        this.iDcouleur = iDcouleur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voitures)) {
            return false;
        }
        Voitures other = (Voitures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Voitures[ id=" + id + " ]";
    }
    
}
