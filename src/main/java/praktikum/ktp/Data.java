/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.ktp;

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
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.id = :id"),
    @NamedQuery(name = "Data.findByNoktp", query = "SELECT d FROM Data d WHERE d.noktp = :noktp"),
    @NamedQuery(name = "Data.findByNama", query = "SELECT d FROM Data d WHERE d.nama = :nama"),
    @NamedQuery(name = "Data.findByTgllahir", query = "SELECT d FROM Data d WHERE d.tgllahir = :tgllahir"),
    @NamedQuery(name = "Data.findByJeniskelamin", query = "SELECT d FROM Data d WHERE d.jeniskelamin = :jeniskelamin"),
    @NamedQuery(name = "Data.findByAlamat", query = "SELECT d FROM Data d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Data.findByAgama", query = "SELECT d FROM Data d WHERE d.agama = :agama"),
    @NamedQuery(name = "Data.findByStatus", query = "SELECT d FROM Data d WHERE d.status = :status"),
    @NamedQuery(name = "Data.findByPekerjaan", query = "SELECT d FROM Data d WHERE d.pekerjaan = :pekerjaan"),
    @NamedQuery(name = "Data.findByWarganegara", query = "SELECT d FROM Data d WHERE d.warganegara = :warganegara"),
    @NamedQuery(name = "Data.findByBerlakuhingga", query = "SELECT d FROM Data d WHERE d.berlakuhingga = :berlakuhingga")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "noktp")
    private String noktp;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tgllahir")
    @Temporal(TemporalType.DATE)
    private Date tgllahir;
    @Column(name = "jeniskelamin")
    private String jeniskelamin;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "agama")
    private String agama;
    @Column(name = "status")
    private String status;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Column(name = "warganegara")
    private String warganegara;
    @Column(name = "berlakuhingga")
    private String berlakuhingga;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Data() {
    }

    public Data(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getWarganegara() {
        return warganegara;
    }

    public void setWarganegara(String warganegara) {
        this.warganegara = warganegara;
    }

    public String getBerlakuhingga() {
        return berlakuhingga;
    }

    public void setBerlakuhingga(String berlakuhingga) {
        this.berlakuhingga = berlakuhingga;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "praktikum.ktp.Data[ id=" + id + " ]";
    }
    
}
