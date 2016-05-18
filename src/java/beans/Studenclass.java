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
@Table(name = "studenclass", catalog = "esptimetable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenclass.findAll", query = "SELECT s FROM Studenclass s"),
    @NamedQuery(name = "Studenclass.findById", query = "SELECT s FROM Studenclass s WHERE s.id = :id"),
    @NamedQuery(name = "Studenclass.findBySymestre", query = "SELECT s FROM Studenclass s WHERE s.symestre = :symestre"),
    @NamedQuery(name = "Studenclass.findBySpes", query = "SELECT s FROM Studenclass s WHERE s.spes = :spes"),
    @NamedQuery(name = "Studenclass.findByDescription", query = "SELECT s FROM Studenclass s WHERE s.description = :description"),
    @NamedQuery(name = "Studenclass.findByStudentSize", query = "SELECT s FROM Studenclass s WHERE s.studentSize = :studentSize")})
public class Studenclass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "symestre")
    private String symestre;
    @Column(name = "spes")
    private String spes;
    @Column(name = "description")
    private String description;
    @Column(name = "studentSize")
    private Integer studentSize;
    @OneToMany(mappedBy = "idStudenClass", fetch = FetchType.EAGER)
    private List<Course> courseList;

    public Studenclass() {
    }

    public Studenclass(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymestre() {
        return symestre;
    }

    public void setSymestre(String symestre) {
        this.symestre = symestre;
    }

    public String getSpes() {
        return spes;
    }

    public void setSpes(String spes) {
        this.spes = spes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStudentSize() {
        return studentSize;
    }

    public void setStudentSize(Integer studentSize) {
        this.studentSize = studentSize;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        if (!(object instanceof Studenclass)) {
            return false;
        }
        Studenclass other = (Studenclass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Studenclass[ id=" + id + " ]";
    }
    
}
