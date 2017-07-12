/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import javax.ejb.Stateless;

/**
 *
 * @author SAUMIL
 */
@Stateless
public class HotelSessionBean implements HotelSessionBeanRemote, HotelSessionBeanLocal {

    @Override
    public String getData(String var) {
        return var;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
