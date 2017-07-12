/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import entity.BookingTbl;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;
import javax.persistence.Query;

/**
 *
 * @author SAUMIL
 */
@Local
public interface GuestSessionBeanLocal {

    public Collection checkAvailability(Date dateFrom,Date dateTo,int roomTypeId);
 
    Object getRoomDetail(int room_id);
    public Collection showBookingDetails();
   
    
}
