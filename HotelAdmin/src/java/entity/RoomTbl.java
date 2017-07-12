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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "room_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomTbl.findAll", query = "SELECT r FROM RoomTbl r"),
    @NamedQuery(name = "RoomTbl.findByRoomId", query = "SELECT r FROM RoomTbl r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "RoomTbl.findByRoomDetail", query = "SELECT r FROM RoomTbl r WHERE r.roomDetail = :roomDetail"),
    @NamedQuery(name = "RoomTbl.findByRoomNo", query = "SELECT r FROM RoomTbl r WHERE r.roomNo = :roomNo"),
    @NamedQuery(name = "RoomTbl.findByFloorNo", query = "SELECT r FROM RoomTbl r WHERE r.floorNo = :floorNo")})
public class RoomTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "room_id")
    private Integer roomId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "room_detail")
    private String roomDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "room_no")
    private int roomNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "floor_no")
    private String floorNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomNo")
    private Collection<BookingTbl> bookingTblCollection;
    @JoinColumn(name = "roomtype_id", referencedColumnName = "roomtype_id")
    @OneToOne(optional = false)
    private RoomtypeTbl roomtypeId;

    public RoomTbl() {
    }

    public RoomTbl(Integer roomId) {
        this.roomId = roomId;
    }

    public RoomTbl(Integer roomId, String roomDetail, int roomNo, String floorNo) {
        this.roomId = roomId;
        this.roomDetail = roomDetail;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    @XmlTransient
    public Collection<BookingTbl> getBookingTblCollection() {
        return bookingTblCollection;
    }

    public void setBookingTblCollection(Collection<BookingTbl> bookingTblCollection) {
        this.bookingTblCollection = bookingTblCollection;
    }

    public RoomtypeTbl getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(RoomtypeTbl roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomTbl)) {
            return false;
        }
        RoomTbl other = (RoomTbl) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoomTbl[ roomId=" + roomId + " ]";
    }
    
}
