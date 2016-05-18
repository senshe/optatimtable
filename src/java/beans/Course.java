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
@Table(name = "course", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code"),
    @NamedQuery(name = "Course.findByLectureSize", query = "SELECT c FROM Course c WHERE c.lectureSize = :lectureSize"),
    @NamedQuery(name = "Course.findByTpSize", query = "SELECT c FROM Course c WHERE c.tpSize = :tpSize"),
    @NamedQuery(name = "Course.findByTdSize", query = "SELECT c FROM Course c WHERE c.tdSize = :tdSize")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "lectureSize")
    private int lectureSize;
    @Basic(optional = false)
    @Column(name = "tpSize")
    private int tpSize;
    @Basic(optional = false)
    @Column(name = "tdSize")
    private int tdSize;
    @OneToMany(mappedBy = "idCourse", fetch = FetchType.EAGER)
    private List<Unavailableperiodpenalty> unavailableperiodpenaltyList;
    @JoinColumn(name = "id_Teacher", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Teacher idTeacher;
    @JoinColumn(name = "id_StudenClass", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Studenclass idStudenClass;
    @OneToMany(mappedBy = "idCourse", fetch = FetchType.EAGER)
    private List<Lecture> lectureList;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String code, int lectureSize, int tpSize, int tdSize) {
        this.id = id;
        this.code = code;
        this.lectureSize = lectureSize;
        this.tpSize = tpSize;
        this.tdSize = tdSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLectureSize() {
        return lectureSize;
    }

    public void setLectureSize(int lectureSize) {
        this.lectureSize = lectureSize;
    }

    public int getTpSize() {
        return tpSize;
    }

    public void setTpSize(int tpSize) {
        this.tpSize = tpSize;
    }

    public int getTdSize() {
        return tdSize;
    }

    public void setTdSize(int tdSize) {
        this.tdSize = tdSize;
    }

    @XmlTransient
    public List<Unavailableperiodpenalty> getUnavailableperiodpenaltyList() {
        return unavailableperiodpenaltyList;
    }

    public void setUnavailableperiodpenaltyList(List<Unavailableperiodpenalty> unavailableperiodpenaltyList) {
        this.unavailableperiodpenaltyList = unavailableperiodpenaltyList;
    }

    public Teacher getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Teacher idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Studenclass getIdStudenClass() {
        return idStudenClass;
    }

    public void setIdStudenClass(Studenclass idStudenClass) {
        this.idStudenClass = idStudenClass;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Course[ id=" + id + " ]";
    }
    
}
