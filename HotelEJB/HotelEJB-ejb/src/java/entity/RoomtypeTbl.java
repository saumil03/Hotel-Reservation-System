/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "roomtype_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomtypeTbl.findAll", query = "SELECT r FROM RoomtypeTbl r"),
    @NamedQuery(name = "RoomtypeTbl.findByRoomtypeId", query = "SELECT r FROM RoomtypeTbl r WHERE r.roomtypeId = :roomtypeId"),
    @NamedQuery(name = "RoomtypeTbl.findByRoomType", query = "SELECT r FROM RoomtypeTbl r WHERE r.roomType = :roomType"),
    @NamedQuery(name = "RoomtypeTbl.findByRoomtypePrice", query = "SELECT r FROM RoomtypeTbl r WHERE r.roomtypePrice = :roomtypePrice"),
@NamedQuery(name = "findRoomPriceByRoomtypeId", query = "SELECT r FROM RoomtypeTbl r WHERE r.roomtypeId = :roomtypeId")})

public class RoomtypeTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roomtype_id")
    private Integer roomtypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "room_type")
    private String roomType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roomtype_price")
    private double roomtypePrice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "roomtypeId")
    private RoomTbl roomTbl;

    public RoomtypeTbl() {
    }

    public RoomtypeTbl(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public RoomtypeTbl(Integer roomtypeId, String roomType, double roomtypePrice) {
        this.roomtypeId = roomtypeId;
        this.roomType = roomType;
        this.roomtypePrice = roomtypePrice;
    }

    public Integer getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomtypePrice() {
        return roomtypePrice;
    }

    public void setRoomtypePrice(double roomtypePrice) {
        this.roomtypePrice = roomtypePrice;
    }

    public RoomTbl getRoomTbl() {
        return roomTbl;
    }

    public void setRoomTbl(RoomTbl roomTbl) {
        this.roomTbl = roomTbl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomtypeId != null ? roomtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomtypeTbl)) {
            return false;
        }
        RoomtypeTbl other = (RoomtypeTbl) object;
        if ((this.roomtypeId == null && other.roomtypeId != null) || (this.roomtypeId != null && !this.roomtypeId.equals(other.roomtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoomtypeTbl[ roomtypeId=" + roomtypeId + " ]";
    }
    
}
