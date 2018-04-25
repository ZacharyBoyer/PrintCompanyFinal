/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintCompanyService;

import Model.Order;
import dao.orderDao;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Zach
 */
public class orderService {
 
    public int addOrder(int agentId, int clientId, int flyerQuantity, int personalCopies, String flyerLayout, String paymentInfo, String invoiceNum, String comments, Boolean flyerArtApprovl, Boolean paymentRecvd, FileInputStream flyerImg, orderDao oDao){
        int  res = 0;
        Order ordr = new Order();
        
            ordr.setAgentId(agentId);
            ordr.setClientId(clientId);
            ordr.setPersonalCopies(personalCopies);
            ordr.setFlyerQuantity(flyerQuantity);
            ordr.setFlyerLayout(flyerLayout);
            ordr.setPaymentInfo(paymentInfo);
            ordr.setInvoiceNum(invoiceNum);
            ordr.setComments(comments);
            ordr.setFlyerArtApprovl(flyerArtApprovl);
            ordr.setPaymentRecvd(paymentRecvd);
            ordr.setFile(flyerImg);
            res = oDao.addOrder(ordr);
     
        return res;
    }
    
    public ArrayList<Order> viewOrders(orderDao oDao){
        ArrayList<Order> oList = new ArrayList<>();
        oList = oDao.viewOrders();
        return oList;
    }
    
    public Order showOrder(int id, orderDao oDao) throws SQLException{
        Order ordr = oDao.showOrder(id);
        return ordr;
    }
    
    public boolean updateOrder(Order ordr, orderDao oDao) throws SQLException{
        boolean res = oDao.updateOrder(ordr);
        return res;
    }
    
      public boolean updateOrderWoImg(Order ordr, orderDao oDao) throws SQLException{
        boolean res = oDao.updateOrderWoImg(ordr);
        return res;
    }
      
    public void deleteOrder(int id, orderDao oDao) throws SQLException{
      oDao.deleteOrder(id);
       }

}
