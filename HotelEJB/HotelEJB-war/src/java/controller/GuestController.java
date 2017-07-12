/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.BookingTbl;
import entity.RoomTbl;
import entity.RoomtypeTbl;
import hotel.GuestSessionBeanRemote;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author SAUMIL
 */
@ManagedBean
@SessionScoped
public class GuestController {

    @EJB
    private GuestSessionBeanRemote guestSessionBean;
    
    
BookingTbl objBook = new BookingTbl();
    List<RoomTbl> roomList;
    List<RoomtypeTbl> roomtypeList;
    RoomTbl rooms = new RoomTbl();
    RoomtypeTbl roomtype = new RoomtypeTbl();

    public BookingTbl getObjBook() {
        return objBook;
    }

    public void setObjBook(BookingTbl objBook) {
        this.objBook = objBook;
    }

    public List<RoomTbl> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomTbl> roomList) {
        this.roomList = roomList;
    }

    public List<RoomtypeTbl> getRoomtypeList() {
        return roomtypeList;
    }

    public void setRoomtypeList(List<RoomtypeTbl> roomtypeList) {
        this.roomtypeList = roomtypeList;
    }

    public RoomTbl getRooms() {
        return rooms;
    }

    public void setRooms(RoomTbl rooms) {
        this.rooms = rooms;
    }

    public RoomtypeTbl getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomtypeTbl roomtype) {
        this.roomtype = roomtype;
    }

    /**
     * Creates a new instance of GuestController
     */
    public GuestController() {
    }
  int i =0; 
    public Collection checkRoom() {
if(i==0){
    i++;
    return null;
}
 
        Date from = objBook.getDateFrom();
      
        Date to = objBook.getDateTo();
  
      
        if (from != null && to != null ) {
    
    System.out.println("----"+from);
            return guestSessionBean.checkAvailability(from,to,roomtype.getRoomtypeId());

        } else {
           
  
    System.out.println("----"+roomtype.getRoomtypeId());
             return  guestSessionBean.showBookingDetails();
        }

        //return b;
        //return guestSessionBean.checkAvailability(book.getDateFrom(),book.getDateTo(),roomtype.getRoomtypeId());
    }

}
