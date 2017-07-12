/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SAUMIL
 */
@Remote
public interface AdminSessionBeanRemote {

    Boolean addRoom(Object objRoom);

    Boolean updateRoom(Object objRoom);

    Boolean deleteRoom(int room_id);

    List getAllRoomList();
 List AllRoomType();
    int loginAdmin(String emailId, String password);
   Collection showBookingDetails() ;
   List getRoomType(String type);

    Collection getBookingByPrice(double min, double max);
    Collection getBookingByDate(Date fromDate, Date toDate);
}
