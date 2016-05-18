/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "unavailableperiodpenalty", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unavailableperiodpenalty.findAll", query = "SELECT u FROM Unavailableperiodpenalty u"),
    @NamedQuery(name = "Unavailableperiodpenalty.findById", query = "SELECT u FROM Unavailableperiodpenalty u WHERE u.id = :id")})
public class Unavailableperiodpenalty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_Course", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course idCourse;
    @JoinColumn(name = "id_Period", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Period idPeriod;

    public Unavailableperiodpenalty() {
    }

    public Unavailableperiodpenalty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public Period getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(Period idPeriod) {
        this.idPeriod = idPeriod;
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
        if (!(object instanceof Unavailableperiodpenalty)) {
            return false;
        }
        Unavailableperiodpenalty other = (Unavailableperiodpenalty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Unavailableperiodpenalty[ id=" + id + " ]";
    }
    
}
