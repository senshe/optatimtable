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
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "lecture", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecture.findAll", query = "SELECT l FROM Lecture l"),
    @NamedQuery(name = "Lecture.findById", query = "SELECT l FROM Lecture l WHERE l.id = :id"),
    @NamedQuery(name = "Lecture.findByLectureIndexInCourse", query = "SELECT l FROM Lecture l WHERE l.lectureIndexInCourse = :lectureIndexInCourse"),
    @NamedQuery(name = "Lecture.findByLocked", query = "SELECT l FROM Lecture l WHERE l.locked = :locked")})
@PlanningEntity()
public class Lecture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "lectureIndexInCourse")
    private Integer lectureIndexInCourse;
    @Column(name = "locked")
    private Boolean locked;
    @JoinColumn(name = "id_TypeLecture", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Typelecture idTypeLecture;
    @JoinColumn(name = "id_Course", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course idCourse;
    @JoinColumn(name = "id_Period", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Period idPeriod;
    @JoinColumn(name = "id_Room", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Room idRoom;

    public Lecture() {
    }

    public Lecture(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLectureIndexInCourse() {
        return lectureIndexInCourse;
    }

    public void setLectureIndexInCourse(Integer lectureIndexInCourse) {
        this.lectureIndexInCourse = lectureIndexInCourse;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Typelecture getIdTypeLecture() {
        return idTypeLecture;
    }

    public void setIdTypeLecture(Typelecture idTypeLecture) {
        this.idTypeLecture = idTypeLecture;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }
@PlanningVariable(valueRangeProviderRefs = {"periodRange"})
    public Period getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(Period idPeriod) {
        this.idPeriod = idPeriod;
    }
@PlanningVariable(valueRangeProviderRefs = {"roomRange"})
    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
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
        if (!(object instanceof Lecture)) {
            return false;
        }
        Lecture other = (Lecture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Lecture[ id=" + id + " ]";
    }
    
}
