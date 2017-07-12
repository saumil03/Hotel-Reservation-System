/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import javax.ejb.Remote;

/**
 *
 * @author SAUMIL
 */
@Remote
public interface HotelSessionBeanRemote {

    String getData(String var);
    
}
