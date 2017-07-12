/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Collection;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author SAUMIL
 */
@Remote
public interface GuestSessionBeanRemote {

    Collection checkAvailability(Date dateFrom,Date dateTo,int roomTypeId);

    Object getRoomDetail(int room_id);

     Collection showBookingDetails();
    
}
