/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nirmoh
 */
@Entity
@Table(name = "customer_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerTbl.findAll", query = "SELECT c FROM CustomerTbl c"),
    @NamedQuery(name = "CustomerTbl.findByCustId", query = "SELECT c FROM CustomerTbl c WHERE c.custId = :custId"),
    @NamedQuery(name = "CustomerTbl.findByCustName", query = "SELECT c FROM CustomerTbl c WHERE c.custName = :custName"),
    @NamedQuery(name = "CustomerTbl.findByCustAddress", query = "SELECT c FROM CustomerTbl c WHERE c.custAddress = :custAddress"),
    @NamedQuery(name = "CustomerTbl.findByCustEmail", query = "SELECT c FROM CustomerTbl c WHERE c.custEmail = :custEmail"),
    @NamedQuery(name = "CustomerTbl.findByCustPassword", query = "SELECT c FROM CustomerTbl c WHERE c.custPassword = :custPassword")})
public class CustomerTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cust_id")
    private Integer custId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cust_name")
    private String custName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cust_address")
    private String custAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cust_email")
    private String custEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "cust_password")
    private String custPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<PaymentTbl> paymentTblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<BookingTbl> bookingTblCollection;

    public CustomerTbl() {
    }

    public CustomerTbl(Integer custId) {
        this.custId = custId;
    }

    public CustomerTbl(Integer custId, String custName, String custAddress, String custEmail, String custPassword) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
        this.custPassword = custPassword;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    @XmlTransient
    public Collection<PaymentTbl> getPaymentTblCollection() {
        return paymentTblCollection;
    }

    public void setPaymentTblCollection(Collection<PaymentTbl> paymentTblCollection) {
        this.paymentTblCollection = paymentTblCollection;
    }

    @XmlTransient
    public Collection<BookingTbl> getBookingTblCollection() {
        return bookingTblCollection;
    }

    public void setBookingTblCollection(Collection<BookingTbl> bookingTblCollection) {
        this.bookingTblCollection = bookingTblCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTbl)) {
            return false;
        }
        CustomerTbl other = (CustomerTbl) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerTbl[ custId=" + custId + " ]";
    }
    
}
