<%-- 
    Document   : roomtype
    Created on : 20-Apr-2017, 4:31:33 PM
    Author     : SAUMIL
--%>

<%@page import="service.HotelDataService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1><% 
             HotelDataService objService = new HotelDataService();
        
        out.println(objService.getJson()+"hello");
        
        
        %> </h1>
   
    </body>
</html>
