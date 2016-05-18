/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "period", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p"),
    @NamedQuery(name = "Period.findById", query = "SELECT p FROM Period p WHERE p.id = :id")})
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "idPeriod", fetch = FetchType.EAGER)
    private List<Unavailableperiodpenalty> unavailableperiodpenaltyList;
    @JoinColumn(name = "id_Day", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Day idDay;
    @JoinColumn(name = "id_Timeslot", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Timeslot idTimeslot;
    @OneToMany(mappedBy = "idPeriod", fetch = FetchType.EAGER)
    private List<Lecture> lectureList;

    public Period() {
    }

    public Period(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Unavailableperiodpenalty> getUnavailableperiodpenaltyList() {
        return unavailableperiodpenaltyList;
    }

    public void setUnavailableperiodpenaltyList(List<Unavailableperiodpenalty> unavailableperiodpenaltyList) {
        this.unavailableperiodpenaltyList = unavailableperiodpenaltyList;
    }

    public Day getIdDay() {
        return idDay;
    }

    public void setIdDay(Day idDay) {
        this.idDay = idDay;
    }

    public Timeslot getIdTimeslot() {
        return idTimeslot;
    }

    public void setIdTimeslot(Timeslot idTimeslot) {
        this.idTimeslot = idTimeslot;
    }

    @XmlTransient
    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
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
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Period[ id=" + id + " ]";
    }
    
}
