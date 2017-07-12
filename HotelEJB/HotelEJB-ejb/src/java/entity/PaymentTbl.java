/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SAUMIL
 */
@Entity
@Table(name = "payment_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTbl.findAll", query = "SELECT p FROM PaymentTbl p"),
    @NamedQuery(name = "PaymentTbl.findByPaymentId", query = "SELECT p FROM PaymentTbl p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "PaymentTbl.findByCardNo", query = "SELECT p FROM PaymentTbl p WHERE p.cardNo = :cardNo"),
    @NamedQuery(name = "PaymentTbl.findByCardType", query = "SELECT p FROM PaymentTbl p WHERE p.cardType = :cardType")})
public class PaymentTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_no")
    private int cardNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "card_type")
    private String cardType;
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    @OneToOne(optional = false)
    private BookingTbl bookingId;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private CustomerTbl custId;

    public PaymentTbl() {
    }

    public PaymentTbl(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentTbl(Integer paymentId, int cardNo, String cardType) {
        this.paymentId = paymentId;
        this.cardNo = cardNo;
        this.cardType = cardType;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public BookingTbl getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingTbl bookingId) {
        this.bookingId = bookingId;
    }

    public CustomerTbl getCustId() {
        return custId;
    }

    public void setCustId(CustomerTbl custId) {
        this.custId = custId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTbl)) {
            return false;
        }
        PaymentTbl other = (PaymentTbl) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaymentTbl[ paymentId=" + paymentId + " ]";
    }
    
}
