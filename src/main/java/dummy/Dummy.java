/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danisarahadians
 */
@Entity
@Table(name = "dummy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dummy.findAll", query = "SELECT d FROM Dummy d"),
    @NamedQuery(name = "Dummy.findByTanggal", query = "SELECT d FROM Dummy d WHERE d.tanggal = :tanggal"),
    @NamedQuery(name = "Dummy.findById", query = "SELECT d FROM Dummy d WHERE d.id = :id")})
public class Dummy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Lob
    @Column(name = "gambar")
    private byte[] gambar;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Dummy() {
    }

    public Dummy(Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public byte[] getGambar() {
        return gambar;
    }

    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Dummy)) {
            return false;
        }
        Dummy other = (Dummy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.Dummy[ id=" + id + " ]";
    }
    
}
