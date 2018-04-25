/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zach
 */
public class Order {
    int id, agentId, clientId, flyerQuantity, personalCopies;
    String flyerLayout, paymentInfo, invoiceNum, comments;
    Boolean flyerArtApprovl, paymentRecvd;
    String img;
    FileInputStream file =null;
    
    
    //order constructor with id property
        public Order(int id, int agentId, int clientId, int flyerQuantity, int personalCopies, String flyerLayout, String paymentInfo, String invoiceNum, String comments, Boolean flyerArtApprovl, Boolean paymentRecvd, FileInputStream file) {
        this.id = id;
        this.agentId = agentId;
        this.clientId = clientId;
        this.flyerQuantity = flyerQuantity;
        this.personalCopies = personalCopies;
        this.flyerLayout = flyerLayout;
        this.paymentInfo = paymentInfo;
        this.invoiceNum = invoiceNum;
        this.comments = comments;
        this.flyerArtApprovl = flyerArtApprovl;
        this.paymentRecvd = paymentRecvd;
        this.file = file;
    }
        
        //order constructor without id property
        public Order(int agentId, int clientId, int flyerQuantity, int personalCopies, String flyerLayout, String paymentInfo, String invoiceNum, String comments, Boolean flyerArtApprovl, Boolean paymentRecvd, FileInputStream file) {
        this.agentId = agentId;
        this.clientId = clientId;
        this.flyerQuantity = flyerQuantity;
        this.personalCopies = personalCopies;
        this.flyerLayout = flyerLayout;
        this.paymentInfo = paymentInfo;
        this.invoiceNum = invoiceNum;
        this.comments = comments;
        this.flyerArtApprovl = flyerArtApprovl;
        this.paymentRecvd = paymentRecvd;
        this.file = file;
    }
        
        
        //order constructor without picture property
   public Order(int id,int agentId, int clientId, int flyerQuantity, int personalCopies, String flyerLayout, String paymentInfo, String invoiceNum, String comments, Boolean flyerArtApprovl, Boolean paymentRecvd) {
        this.id = id;
        this.agentId = agentId;
        this.clientId = clientId;
        this.flyerQuantity = flyerQuantity;
        this.personalCopies = personalCopies;
        this.flyerLayout = flyerLayout;
        this.paymentInfo = paymentInfo;
        this.invoiceNum = invoiceNum;
        this.comments = comments;
        this.flyerArtApprovl = flyerArtApprovl;
        this.paymentRecvd = paymentRecvd;
    }
    public Order() {

    }
    
    //getter and setter methods for order
        public FileInputStream getFile() {
        return file;
    }

    public void setFile(FileInputStream file) {
        this.file = file;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public Blob getImgBlob(){
        Blob blob = null;
        try {
            blob = new javax.sql.rowset.serial.SerialBlob(img.getBytes());
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
            return blob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getFlyerQuantity() {
        return flyerQuantity;
    }

    public void setFlyerQuantity(int flyerQuantity) {
        this.flyerQuantity = flyerQuantity;
    }

    public int getPersonalCopies() {
        return personalCopies;
    }

    public void setPersonalCopies(int personalCopies) {
        this.personalCopies = personalCopies;
    }

    public String getFlyerLayout() {
        return flyerLayout;
    }

    public void setFlyerLayout(String flyerLayout) {
        this.flyerLayout = flyerLayout;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getFlyerArtApprovl() {
        return flyerArtApprovl;
    }

    public void setFlyerArtApprovl(Boolean flyerArtApprovl) {
        this.flyerArtApprovl = flyerArtApprovl;
    }

    public Boolean getPaymentRecvd() {
        return paymentRecvd;
    }

    public void setPaymentRecvd(Boolean paymentRecvd) {
        this.paymentRecvd = paymentRecvd;
    }

}
