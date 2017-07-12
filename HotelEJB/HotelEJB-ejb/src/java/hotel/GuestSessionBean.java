/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import entity.BookingTbl;
import entity.CustomerTbl;
import entity.RoomTbl;
import entity.RoomtypeTbl;
import java.util.Date;
import java.util.Collection;
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
@TransactionManagement(value=TransactionManagementType.CONTAINER)

public class GuestSessionBean implements GuestSessionBeanRemote, GuestSessionBeanLocal {
  @javax.persistence.PersistenceContext(unitName="HotelEJB-ejbPU")
    private EntityManager em;

    @Override
 public Collection checkAvailability(Date dateFrom,Date dateTo,int roomTypeId){
      
//Query query = em.createQuery("SELECT count(*) FROM presidentDB.BOOKING_TBL where date_from >= '"+b.getDateFrom()+"' and date_to <= '"+b.getDateTo()+"'");
//String q = "select b.roomNo from BOOKING_TBL b,ROOM_TBL r where r.roomtype_id="+r.getRoomtypeId().getRoomtypeId()+" and (b.date_from between '"+b.getDateFrom()+"' and '"+b.getDateTo()+"') or (b.date_to between '"+b.getDateFrom()+"' and '"+b.getDateTo()+"')  and r.room_no=b.room_no";



//Query query = em.createQuery("SELECT b FROM BookingTbl b JOIN FETCH RoomTbl r ON b.room_no = r.room_no WHERE r.roomtype_id = :roomtypeId and ((b.date_from between :dateFrom AND :dateTo) OR (b.date_to between :dateFrom AND :dateTo)");
  Query query = em.createQuery("select DISTINCT b FROM BookingTbl b,RoomTbl r where r.roomtypeId= :roomTypeId and ((b.dateFrom between :dateFrom AND  :dateTo) OR (b.dateTo between :dateFrom and :dateTo)) ");
RoomtypeTbl roomtype = em.find(RoomtypeTbl.class,roomTypeId );
   
query.setParameter("roomTypeId",roomtype);
query.setParameter("dateFrom",dateFrom);
query.setParameter("dateTo",dateTo);

 
                  return (Collection<BookingTbl>) query.getResultList();
    }
        
        
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Object getRoomDetail(int room_id) {
        
        Query query = em.createQuery("SELECT book FROM RoomTbl book where book.roomId =:roomId ");
RoomTbl room = em.find(RoomTbl.class,room_id );
query.setParameter("roomId",room);


   
        return (Collection<RoomTbl>) query.getResultList();
    }
    
   @Override
    public Collection showBookingDetails() {

        Query query = em.createQuery("SELECT b FROM BookingTbl b");

        return (Collection<BookingTbl>) query.getResultList();

    }

    
}
