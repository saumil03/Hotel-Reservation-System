/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.AdminTbl;
import entity.BookingTbl;
import entity.RoomTbl;
import entity.RoomtypeTbl;
import hotel.AdminSessionBeanRemote;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SAUMIL
 */
@ManagedBean
@SessionScoped
public class AdminController {
    @EJB
    private AdminSessionBeanRemote adminSessionBean;

RoomTbl room=new RoomTbl();
Date dateFrom = new Date();
Date dateTo = new Date();
Collection<BookingTbl> b;

    public Collection<BookingTbl> getB() {
        return b;
    }

    public void setB(Collection<BookingTbl> b) {
        this.b = b;
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

int amountSelect = 0;
RoomtypeTbl roomtype=new RoomtypeTbl();

    public int getAmountSelect() {
        return amountSelect;
    }

    public void setAmountSelect(int amountSelect) {
        this.amountSelect = amountSelect;
    }
AdminTbl admin = new AdminTbl();

    public AdminTbl getAdmin() {
        return admin;
    }

    public void setAdmin(AdminTbl admin) {
        this.admin = admin;
    }

    public RoomtypeTbl getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomtypeTbl roomtype) {
        this.roomtype = roomtype;
    }
    public RoomTbl getRoom() {
        return room;
    }

    public void setRoom(RoomTbl room) {
        this.room = room;
    }
    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
    }
    
    
    public String addRoom(){
        room.setRoomtypeId(roomtype);
        Boolean result = adminSessionBean.addRoom(room);
        
        
        
        return "adminHome?faces-redirect=true";
    }
    
    public String updateRoom(){
        room.setRoomtypeId(roomtype);
        Boolean result = adminSessionBean.updateRoom(room);
        
        
        
        return "adminHome?faces-redirect=true";
    }
    
    public String getsLogin(){
      
        if(admin.getAdminId()==null)
        {
            
            return "Login";
        }
       
        return "Logout";
    }
    
    
     public List allRoomList() {
        return adminSessionBean.getAllRoomList();

    }
     
     public Collection showAllBookings(){
          return adminSessionBean.showBookingDetails();
     }
    
    public String login() {
        
        
        int adminId = adminSessionBean.loginAdmin(admin.getAdminEmail(), admin.getAdminPassword());

        if (adminId > 0) {

            admin.setAdminId(adminId);
            return "adminHome?faces-redirect=true";
        } else {
            return "login?faces-redirect=true";
        }

    }
    
    
    
   
     public void bookingByDate() throws ParseException{
         if(dateFrom==null || dateTo==null){
             String sDate1="31/12/1998";  
    Date dateFrom=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
      dateTo = dateFrom;
             
         }
       b = adminSessionBean.getBookingByDate(dateFrom, dateTo);
      
     }   
    
    public void bookingByPrice(){
        Double min = null,max = null;
        if (amountSelect == 1){
            min = 100.0;
            max = 200.0;
        }
        else if (amountSelect == 2){
            min = 200.0;
            max = 300.0;
        }
        else if (amountSelect == 3){
            min = 300.0;
            max = 400.0;
        }
        else{
            min = 00.0;
            max = 00.0;
        }
        System.out.print("max = "+max);
         b = adminSessionBean.getBookingByPrice(min, max);
        
    }
}