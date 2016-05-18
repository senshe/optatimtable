/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "timeslot", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeslot.findAll", query = "SELECT t FROM Timeslot t"),
    @NamedQuery(name = "Timeslot.findById", query = "SELECT t FROM Timeslot t WHERE t.id = :id"),
    @NamedQuery(name = "Timeslot.findByTimeslotIndex", query = "SELECT t FROM Timeslot t WHERE t.timeslotIndex = :timeslotIndex"),
    @NamedQuery(name = "Timeslot.findByH", query = "SELECT t FROM Timeslot t WHERE t.h = :h")})
public class Timeslot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "timeslotIndex")
    private Integer timeslotIndex;
    @Column(name = "h")
    
    private String h;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimeslot", fetch = FetchType.EAGER)
    private List<Period> periodList;

    public Timeslot() {
    }

    public Timeslot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimeslotIndex() {
        return timeslotIndex;
    }

    public void setTimeslotIndex(Integer timeslotIndex) {
        this.timeslotIndex = timeslotIndex;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    @XmlTransient
    public List<Period> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Period> periodList) {
        this.periodList = periodList;
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
        if (!(object instanceof Timeslot)) {
            return false;
        }
        Timeslot other = (Timeslot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Timeslot[ id=" + id + " ]";
    }
    
}
