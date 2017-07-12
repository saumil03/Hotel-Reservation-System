/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;

import hotel.AdminSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Nirmoh
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    @EJB
    private static AdminSessionBeanRemote adminSessionBean;
    

    public static AdminSessionBeanRemote getAdminSessionBean() {
        return adminSessionBean;
    }

    public static void setAdminSessionBean(AdminSessionBeanRemote adminSessionBean) {
        Main.adminSessionBean = adminSessionBean;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new AdminLogin().setVisible(true);
    }
    
}
