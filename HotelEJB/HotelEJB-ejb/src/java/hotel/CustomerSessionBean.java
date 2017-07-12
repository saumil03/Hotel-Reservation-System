/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import entity.*;
import entity.CustomerTbl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SAUMIL
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class CustomerSessionBean implements CustomerSessionBeanRemote, CustomerSessionBeanLocal {

    @javax.persistence.PersistenceContext(unitName = "HotelEJB-ejbPU")
    private EntityManager em;

    @Override
    public Collection showBookingDetails() {

        Query query = em.createQuery("SELECT b FROM BookingTbl b");

        return (Collection<BookingTbl>) query.getResultList();

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Boolean bookRoom(Object objRoom) {
        System.out.println("In Book room Session bean : ");
        BookingTbl book = (BookingTbl) objRoom;
        em.persist(book);

        return true;
    }

    @Override
    public Boolean changeBooking(Object objBook) {

        BookingTbl book = (BookingTbl) objBook;

        em.persist(book);
        return true;
    }

    @Override
    public Boolean deleteBooking(int booking_id) {
        String query = "DELETE FROM presidentDB.BOOKING_TBL WHERE booking_id=" + booking_id;
        Query q = em.createNativeQuery(query);

        q.executeUpdate();
        return true;
    }

    @Override
    public Boolean registerUser(Object objUser) {
        CustomerTbl u = (CustomerTbl) objUser;

        em.persist(u);
        return true;
    }

    @Override
    public int loginUser(String userId, String pass) {

        Query query = em.createQuery("SELECT c FROM CustomerTbl c WHERE c.custEmail = '" + userId + "' AND c.custPassword ='" + pass + "'");
        CustomerTbl i = (CustomerTbl) query.getResultList().get(0);
        return i.getCustId();
    }

    @Override
    public List getAllRooms() {

        List<RoomtypeTbl> results = em.createNamedQuery("RoomTbl.findAll").getResultList();
        return results;

    }

    @Override
    public List AllRoomType() {
         //System.out.println("In All Room type list.........");
  
        //Query query = em.createQuery("SELECT b FROM RoomtypeTbl b");
          List<RoomtypeTbl> results = em.createNamedQuery("RoomtypeTbl.findAll").getResultList();
       
  
     //   List<RoomtypeTbl> r = query.getResultList();
       // for (RoomtypeTbl ra : r){
       // System.out.println(ra.getRoomType());
   // }
    
        return results;
    }

    @Override
    public List getRoomListByRoomType(Object roomtype) {
        RoomtypeTbl r = (RoomtypeTbl) roomtype;
        Query q = em.createQuery(
                "SELECT r FROM RoomTbl r WHERE r.roomtypeId =:rmid");
        q.setParameter("rmid", r);
        List<RoomTbl> result = q.getResultList();
        return result;
    }

    @Override
    public int getRoomNoByRoomId(int roomId) {
        RoomTbl a = (RoomTbl) em.createNamedQuery("findRoomNoByRoomId")
                .setParameter("roomId", roomId)
                .getResultList().get(0);
        return a.getRoomNo();
    }

    @Override
    public double getRoomPriceByRoomtypeId(int roomtypeId) {
        RoomtypeTbl a = (RoomtypeTbl) em.createNamedQuery("findRoomPriceByRoomtypeId")
                .setParameter("roomtypeId", roomtypeId)
                .getResultList().get(0);
        return a.getRoomtypePrice();
    }

    @Override
    public Collection showBookingByCustomerId(Object cust) {
        CustomerTbl c = (CustomerTbl) cust;
        Collection<BookingTbl> a =  em.createNamedQuery("findBookingByCustId")
                .setParameter("custId", c)
                .getResultList();

        return a;
    }

    @Override
    public Boolean updateBooking(Object objRoom) {
        BookingTbl book = (BookingTbl) objRoom;
        Query query = em.createQuery(
      "UPDATE BookingTbl b SET b.bookingAmount = :bookingAmount , b.dateFrom = :dateFrom, b.dateTo = :dateTo, b.roomNo = :roomNo, b.service = :service WHERE b.bookingId = :bookingId");
  query.setParameter("bookingAmount", book.getBookingAmount());
  query.setParameter("dateFrom", book.getDateFrom());
  query.setParameter("dateTo", book.getDateTo());
  query.setParameter("roomNo", book.getRoomNo());
  query.setParameter("service", book.getService());
  query.setParameter("bookingId", book.getBookingId());
  
        int i = query.executeUpdate();
        
        if(i==1){
        return true;
    }
    return false;
    }

   
}
