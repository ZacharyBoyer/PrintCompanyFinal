package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro S
 */
public class loginDao {
    private String url ="";
    private String userDB="";
    private String passDB="";
    
    public loginDao(){
    }
    
    public loginDao(String url, String userDB, String passDB){
        this.url = url;
        this.userDB = userDB;
        this.passDB = passDB;
    }
    
       protected Connection getConnection(){
       Connection conn = null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           if(conn==null || conn.isClosed()){
                conn = DriverManager.getConnection(url, userDB, passDB);
                System.out.println("connected");
           }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       } catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       return conn;
   }
    
    
    
    
    
    public int addLogin(String userName, String password, String role, int agentId){
       int res =0;
       
       String sql = "INSERT INTO `login` (`userName`, `password`, `role`,`agentId`) VALUES (?,?,?,?);";
         try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                 stmt.setString(1,userName);
                stmt.setString(2, password);
                stmt.setString(3, role);
                stmt.setInt(4, agentId);
                
                res = stmt.executeUpdate();
                conn.close();
            }
         } catch (SQLException ex) {
            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public int updateLogin(String userName, String password, int agentId){
       int res = 0;
        try {           
            String sql = "UPDATE `login` SET `userName`=?,`password`=? WHERE `agentId`=?";
            
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,userName);
            stmt.setString(2, password);
            stmt.setInt(3, agentId);

            res = stmt.executeUpdate();
            conn.close();
                   
        } catch (SQLException ex) {
            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return res;
    }
    
    public int deleteLogin(int id){
         int res = 0;
        try {                   
            String sql = "DELETE FROM `login` WHERE `login`.`agentId` = ?";
            Connection conn = getConnection();
            PreparedStatement stmnt = conn.prepareStatement(sql);
            
            stmnt.setInt(1, id);
            
             res = stmnt.executeUpdate();                        
        } catch (SQLException ex) {
            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ArrayList<String> checkLogin(String userName, String password){
         ArrayList<String> res = new ArrayList<>();
         String userNm="", pass="", role="", id ="";
                          
            String sql = "SELECT `userName`, `password`, `role`, `id` FROM `login` WHERE `login`.`userName` =?";
            Connection conn = getConnection();
             try {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            
            stmnt.setString(1, userName);
            
            ResultSet result = stmnt.executeQuery();
            if(result.next()){
             userNm = result.getString("userName");
             pass = result.getString("password");
             role = result.getString("role");
             id = result.getString("id");
            }
            if(userNm.equals(userName)&&pass.equals(password)){
            res.add("1");
            res.add(role);
            res.add(id);
            }else{
                res.add("0");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
