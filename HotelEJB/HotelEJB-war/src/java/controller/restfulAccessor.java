/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SAUMIL
 */
@ManagedBean
public class restfulAccessor {
    public String get(){
      return ClientBuilder.newClient().target("http://localhost:8080/HotelEJB-war")
                .path("webresources/generic")
                .request(MediaType.APPLICATION_XML)
                .get().toString();
        
        
        }
}
