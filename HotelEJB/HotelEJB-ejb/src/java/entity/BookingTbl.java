/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SAUMIL
 */
@Entity
@Table(name = "booking_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingTbl.findAll", query = "SELECT b FROM BookingTbl b"),
    @NamedQuery(name = "BookingTbl.findByBookingId", query = "SELECT b FROM BookingTbl b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingTbl.findByDateFrom", query = "SELECT b FROM BookingTbl b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BookingTbl.findByDateTo", query = "SELECT b FROM BookingTbl b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BookingTbl.findByService", query = "SELECT b FROM BookingTbl b WHERE b.service = :service"),
    @NamedQuery(name = "BookingTbl.findByBookingAmount", query = "SELECT b FROM BookingTbl b WHERE b.bookingAmount = :bookingAmount"),
    @NamedQuery(name = "findBookingByCustId", query = "SELECT b FROM BookingTbl b WHERE b.custId = :custId")})

public class BookingTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Size(max = 255)
    @Column(name = "service")
    private String service;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booking_amount")
    private double bookingAmount;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private PaymentTbl paymentTbl;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private CustomerTbl custId;
    @JoinColumn(name = "room_no", referencedColumnName = "room_no")
    @ManyToOne(optional = false)
    private RoomTbl roomNo;

    public BookingTbl() {
    }

    public BookingTbl(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingTbl(Integer bookingId, Date dateFrom, Date dateTo, double bookingAmount) {
        this.bookingId = bookingId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookingAmount = bookingAmount;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public PaymentTbl getPaymentTbl() {
        return paymentTbl;
    }

    public void setPaymentTbl(PaymentTbl paymentTbl) {
        this.paymentTbl = paymentTbl;
    }

    public CustomerTbl getCustId() {
        return custId;
    }

    public void setCustId(CustomerTbl custId) {
        this.custId = custId;
    }

    public RoomTbl getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(RoomTbl roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingTbl)) {
            return false;
        }
        BookingTbl other = (BookingTbl) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookingTbl[ bookingId=" + bookingId + " ]";
    }
    
}
