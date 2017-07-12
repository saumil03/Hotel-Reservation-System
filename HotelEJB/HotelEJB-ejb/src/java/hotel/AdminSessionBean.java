/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import entity.AdminTbl;
import entity.BookingTbl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entity.RoomTbl;
import entity.RoomtypeTbl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author SAUMIL
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanRemote, AdminSessionBeanLocal {

    @javax.persistence.PersistenceContext(unitName = "HotelEJB-ejbPU")
    private EntityManager em;

    @Override
    public Boolean addRoom(Object objRoom) {

        RoomTbl room = (RoomTbl) objRoom;

        em.persist(room);
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Boolean updateRoom(Object objRoom) {
        RoomTbl room = (RoomTbl) objRoom;
        Query query = em.createQuery(
      "UPDATE RoomTbl r SET r.floorNo=:floorNo , r.roomDetail=:roomDetail , r.roomtypeId=:roomtypeId WHERE r.roomId= :roomId");
  query.setParameter("floorNo", room.getFloorNo());
  query.setParameter("roomDetail", room.getRoomDetail());
  query.setParameter("roomtypeId", room.getRoomtypeId());
  query.setParameter("roomId", room.getRoomId());
  
  
        int i = query.executeUpdate();
        
        if(i==1){
        return true;
    }
    return false;
    
    }

    @Override
    public Boolean deleteRoom(int room_id) {
        String query = "DELETE FROM presidentDB.ROOM_TBL WHERE room_id=" + room_id;
        Query q = em.createNativeQuery(query);

        q.executeUpdate();
        return true;
    }

    @Override
    public List getAllRoomList() {
        Query query = em.createQuery("SELECT b FROM RoomTbl b");
        return (List<RoomTbl>) query.getResultList();
    }
    
   

    @Override
    public int loginAdmin(String emailId, String password) {
         Query query = em.createQuery("SELECT a FROM AdminTbl a WHERE a.adminEmail = '" + emailId + "' AND a.adminPassword ='" + password + "'");
        AdminTbl i = (AdminTbl) query.getResultList().get(0);
        return i.getAdminId();
    }
    
     @Override
    public Collection showBookingDetails() {

        Query query = em.createQuery("SELECT b FROM BookingTbl b");

        return (Collection<BookingTbl>) query.getResultList();

    }
    
    @Override
    public List AllRoomType() {
         System.out.println("In All Room type list.........");
  
        Query query = em.createQuery("SELECT b FROM RoomtypeTbl b");
        
  
        List<RoomtypeTbl> r = query.getResultList();
        for (RoomtypeTbl ra : r){
        System.out.println(ra.getRoomType());
    }
    
        return r;
    }
    
    @Override
    public List getRoomType(String type) {

        RoomtypeTbl object;
        
        List<RoomtypeTbl> roomTypeList = new ArrayList<>();
        try
        {
            object = (RoomtypeTbl) em.createNamedQuery("RoomtypeTbl.findByRoomType").setParameter("roomType", type).getSingleResult();
        }
        catch(NoResultException ex)
        {
            object = null;
        }
        
        roomTypeList.add(object);
        return roomTypeList;

    }

    @Override
    public Collection getBookingByPrice(double min, double max) {
      // BookingTbl b = (RoomtypeTbl) roomtype;
      //  SELECT * FROM presidentDB.booking_tbl where booking_amount>100 && booking_amount<201;
        Query q = em.createQuery(
                "SELECT distinct b FROM BookingTbl b WHERE b.bookingAmount > :min AND b.bookingAmount < :max");
        q.setParameter("min", min);
        q.setParameter("max", max);
        
        List<BookingTbl> result = q.getResultList();
        return result;
    }
    
    @Override
    public Collection getBookingByDate(Date fromDate, Date toDate) {
      // BookingTbl b = (RoomtypeTbl) roomtype;
      //  SELECT * FROM presidentDB.booking_tbl where booking_amount>100 && booking_amount<201;
        System.out.print("in dates......");
        Query q = em.createQuery(
                "SELECT distinct b FROM BookingTbl b WHERE (b.dateFrom between :dateFrom AND  :dateTo) OR (b.dateTo between :dateFrom and :dateTo)");
        q.setParameter("dateFrom", fromDate);
        q.setParameter("dateTo", toDate);
        
        List<BookingTbl> result = q.getResultList();
        return result;
    }
    
    

}
