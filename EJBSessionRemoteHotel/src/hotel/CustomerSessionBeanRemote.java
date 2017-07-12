/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author SAUMIL
 */
@Remote
public interface CustomerSessionBeanRemote {

    Collection showBookingDetails();

    Boolean bookRoom(Object objRoom);

    Boolean changeBooking(Object objBook);

    Boolean deleteBooking(int booking_id);

    Boolean registerUser(Object objUser);

    int loginUser(String userId, String pass);

    List getAllRooms();

    List AllRoomType();

    List getRoomListByRoomType(Object roomtype);

    int getRoomNoByRoomId(int roomId);

    double getRoomPriceByRoomtypeId(int roomtypeId);

    Collection showBookingByCustomerId(Object cust);

    Boolean updateBooking(Object objRoom);

    
}
