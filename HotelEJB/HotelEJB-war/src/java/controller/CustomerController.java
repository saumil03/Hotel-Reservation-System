/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entity.*;
import hotel.CustomerSessionBeanRemote;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author SAUMIL
 */
@ManagedBean
@SessionScoped
public class CustomerController {

    @EJB
    private CustomerSessionBeanRemote customerSessionBean;

    BookingTbl book = new BookingTbl();
    List<RoomTbl> roomList;
    List<RoomtypeTbl> roomtypeList;
    String cusId = "";
    int roomtype_id;
    RoomTbl rooms = new RoomTbl();
    RoomtypeTbl roomtype = new RoomtypeTbl();

    public List<RoomTbl> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomTbl> roomList) {
        this.roomList = roomList;
    }

    public void setRoomtypeList(List<RoomtypeTbl> roomtypeList) {
        this.roomtypeList = roomtypeList;
    }

    public List<RoomtypeTbl> getRoomstypeList() {
        return roomtypeList;
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

    public int getRoomtype_id() {
        return roomtype_id;
    }

    public void setRoomtype_id(int roomtype_id) {
        this.roomtype_id = roomtype_id;
    }
    CustomerTbl cus = new CustomerTbl();

    public CustomerTbl getCus() {
        return cus;
    }

    public void setCus(CustomerTbl cus) {
        this.cus = cus;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public BookingTbl getBook() {
        return book;
    }

    public void setBook(BookingTbl book) {
        this.book = book;
    }

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }

    public Collection findAll() {
        return customerSessionBean.showBookingDetails();
    }
    
    public Collection showBooking(){

     return customerSessionBean.showBookingByCustomerId(cus)  ; 
    }

    public String booksRoom() {
        rooms.setRoomNo(customerSessionBean.getRoomNoByRoomId(rooms.getRoomId()));
        
        book.setCustId(cus);
        book.setBookingAmount(customerSessionBean.getRoomPriceByRoomtypeId(roomtype.getRoomtypeId()));
        book.setRoomNo(rooms);

        customerSessionBean.bookRoom(book);
        return "home?faces-redirect=true";
    }

    public List allRoomTypeList() {
        return customerSessionBean.AllRoomType();

    }

    public List roomListByRoomType() {
       // setRoomtype(roomtype);
        // setRooms(rooms);
        return customerSessionBean.getRoomListByRoomType(roomtype);

    }

    public void onRoomTypeChange() {

        if (roomtype.getRoomtypeId() != null && !roomtype.getRoomtypeId().equals("")) {
            roomList = customerSessionBean.getRoomListByRoomType(roomtype);
        } else {
            System.out.println("errrrrrrrorrrrrrrrrrr" + roomtype.getRoomtypeId());
        }

    }

    public String registerUser() {

        Boolean result = customerSessionBean.registerUser(cus);
        System.out.println("result  : " + result);
        return "login?faces-redirect=true";
    }
    

    public String login() {
        
        int customerId = customerSessionBean.loginUser(cus.getCustEmail(), cus.getCustPassword());

        if (customerId > 0) {

            cus.setCustId(customerId);
            return "home?faces-redirect=true";
        } else {
            return "login?faces-redirect=true";
        }

    }
    public String getsLogin(){
      
        if(cus.getCustId()==null)
        {
            return "Login";
        }
         
        return "Logout";
    }
    
            public String updateBook(){
      rooms.setRoomNo(customerSessionBean.getRoomNoByRoomId(rooms.getRoomId()));
       // book.setBookingId(bookId);
        book.setCustId(cus);
        book.setBookingAmount(customerSessionBean.getRoomPriceByRoomtypeId(roomtype.getRoomtypeId()));
        book.setRoomNo(rooms);

        customerSessionBean.updateBooking(book);
        return "showBooking?faces-redirect=true";
    }
            
    public String updateBooking(int bookId){
      System.out.println("Booking Id == "+bookId);
      book.setBookingId(bookId);
      
        return "updateBooking?faces-redirect=true";
    }
    

}
