/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import entity.RoomtypeTbl;
import hotel.CustomerSessionBean;
import hotel.CustomerSessionBeanRemote;
import javax.ejb.EJB;

/**
 * REST Web Service
 *
 * @author SAUMIL
 */
@Path("hoteldata")
public class HotelDataService {

    @Context
    private UriInfo context;
    
    private CustomerSessionBeanRemote cus = new CustomerSessionBean();
    /**
     * Creates a new instance of HotelDataService
     */
    public HotelDataService() {
    }

    /**
     * Retrieves representation of an instance of rest.HotelDataService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
//        List li = new ArrayList<String>();
//        li.add("abc");
//        li.add("123");
//        li.add("Hemal");
//        return li;
        List<RoomtypeTbl> r = null;
        r = (List<RoomtypeTbl>) cus.AllRoomType();
      //  System.out.println(r);
//        RoomtypeTbl rt1 = new RoomtypeTbl();
//        rt1.setRoomType("rthu1");
//        rt1.setRoomtypeId(1);
//        rt1.setRoomtypePrice(1234.56);
//        RoomtypeTbl rt2 = new RoomtypeTbl();
//        rt2.setRoomType("rt1");
//        rt2.setRoomtypeId(1);
//        rt2.setRoomtypePrice(1234.56);
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        array.add(r.get(0).getRoomType());
        array.add(r.get(1).getRoomType());
        json.put("roomTypeList", array);
        return json.toJSONString();
        
        /*
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        array.add("1");
        array.add("2");
        json.put("friends", array);

        return json.toJSONString();
*/

    
    }

    /**
     * PUT method for updating or creating an instance of HotelDataService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
