package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Client;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDao {
    private String url ="jdbc:mysql://localhost:3306/printmarketing";
    private String userDB="root";
    private String passDB="";
    
    public ClientDao(){
    }
    
    public ClientDao(String url, String userDB, String passDB){
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
                System.out.println("connected                                                                                                          ");
           }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       } catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       return conn;
   }
    
    public int addClient(Client userObj){
        int res = 0;
        String sql = "INSERT INTO `clients` (`id`, `agentId`, `firstName`, `lastName`, `streetNumber`, `streetName`, `city`, `province`, `postalCode`, `telOffice`, `telCell`, `email`, `company`, `companyType`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1,userObj.getAgentId());
                stmt.setString(2, userObj.getFirstName());
                stmt.setString(3, userObj.getLastName());
                stmt.setString(4, userObj.getStreetNumber());
                stmt.setString(5, userObj.getStreetName());
                stmt.setString(6, userObj.getCity());
                stmt.setString(7, userObj.getProvince());
                stmt.setString(8, userObj.getPostalCode());
                stmt.setString(9, userObj.getTelOffice());
                stmt.setString(10, userObj.getTelCell());
                stmt.setString(11, userObj.getEmail());
                stmt.setString(12, userObj.getCompany());
                stmt.setString(13, userObj.getCompanyType());
                
                res = stmt.executeUpdate();
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
    
   public ArrayList<Client> viewClients(){
       ArrayList<Client> clientList = new ArrayList();
       String sql = "SELECT * FROM clients";
    int id, AgentId;
    String FirstName, LastName, StreetNumber, StreetName, City, Province, PostalCode, TelOffice, TelCell, Email, Company, CompanyType;
    
       
       try{
        Connection conn = getConnection();
           try (Statement stmt = conn.createStatement()) {
               ResultSet resultSet = stmt.executeQuery(sql);
               
               while(resultSet.next()){
          id = resultSet.getInt("id");
          AgentId = resultSet.getInt("agentId");
          FirstName = resultSet.getString("firstName"); 
          LastName = resultSet.getString("lastName"); 
          StreetNumber = resultSet.getString("streetNumber"); 
          StreetName = resultSet.getString("streetName"); 
          City = resultSet.getString("city"); 
          Province = resultSet.getString("province"); 
          PostalCode = resultSet.getString("postalCode"); 
          TelOffice = resultSet.getString("telOffice");  
          TelCell = resultSet.getString("telCell"); 
          Email = resultSet.getString("email"); 
          Company = resultSet.getString("company"); 
          CompanyType = resultSet.getString("companyType"); 
                   
                   Client userObj = new Client();
                   
                   userObj.setId(id);
                   userObj.setAgentId(AgentId);
                   userObj.setFirstName(FirstName);
                   userObj.setLastName(LastName);
                   userObj.setStreetNumber(StreetNumber);
                   userObj.setStreetName(StreetName);
                   userObj.setCity(City);
                   userObj.setProvince(Province);
                   userObj.setPostalCode(PostalCode);
                   userObj.setTelOffice(TelOffice);
                   userObj.setTelCell(TelCell);
                   userObj.setEmail(Email);
                   userObj.setCompany(Company);
                   userObj.setCompanyType(CompanyType);
                   clientList.add(userObj);
               }
               resultSet.close();
           }
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return clientList;
   }
   
   public Client showClient(int id) throws SQLException{
       Client userObj = null;
       String sql = "SELECT * FROM clients WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();
       
       while(result.next()){         
           userObj = new Client();
           userObj.setId(result.getInt("id"));
            userObj.setAgentId(result.getInt("agentId"));
            userObj.setFirstName(result.getString("firstName"));
            userObj.setLastName(result.getString("lastName"));
            userObj.setStreetNumber(result.getString("streetNumber"));
            userObj.setStreetName(result.getString("streetName"));
            userObj.setCity(result.getString("city"));
            userObj.setProvince(result.getString("province"));
            userObj.setPostalCode(result.getString("postalCode"));
            userObj.setTelOffice(result.getString("telOffice"));
            userObj.setTelCell(result.getString("telCell"));
            userObj.setEmail(result.getString("email"));
            userObj.setCompany(result.getString("company"));
            userObj.setCompanyType(result.getString("companyType"));
       }
       return userObj;
   }
   
   public boolean updateClient(Client userObj) throws SQLException{
       boolean res;
       String sql = "UPDATE clients SET `agentId` = ?, `firstName` = ?, `lastName` = ?, `streetNumber` = ?, `streetName` = ?, `city` = ?, `province` = ?, `postalCode` = ?, `telOffice` = ?, `telCell` = ?, `email` = ?, `company` = ?, `companyType` = ? WHERE `clients`.`id` = ?;";
       
       Connection con = getConnection();
       PreparedStatement stmt = con.prepareStatement(sql);
       
                
                stmt.setInt(1,userObj.getAgentId());
                stmt.setString(2, userObj.getFirstName());
                stmt.setString(3, userObj.getLastName());
                stmt.setString(4, userObj.getStreetNumber());
                stmt.setString(5, userObj.getStreetName());
                stmt.setString(6, userObj.getCity());
                stmt.setString(7, userObj.getProvince());
                stmt.setString(8, userObj.getPostalCode());
                stmt.setString(9, userObj.getTelOffice());
                stmt.setString(10, userObj.getTelCell());
                stmt.setString(11, userObj.getEmail());
                stmt.setString(12, userObj.getCompany());
                stmt.setString(13, userObj.getCompanyType());
                stmt.setInt(14,userObj.getId());
                
                res = stmt.executeUpdate() > 0;
       
                return res;
   }
   
   public int deleteClient(int id) throws SQLException{
       String sql = "DELETE from clients WHERE id = ?";
       Connection con = getConnection();
       PreparedStatement stmnt = con.prepareStatement(sql);
       
       stmnt.setInt(1, id);
       
       int res = stmnt.executeUpdate();
       con.close();
       return res;
   }
     public ArrayList<Client> viewClientNames(){
                 ArrayList<Client> names = new ArrayList<>();
         try {
             
             String sql = "SELECT `id`, `firstName`, `lastName` FROM clients;";
             Client client;
             Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet res = stmt.executeQuery();
             while(res.next()){
                 client = new Client();
                 client.setId(res.getInt("id"));
                 client.setFirstName(res.getString("firstName"));
                 client.setLastName(res.getString("lastName"));
                 names.add(client);
             }          
                 if(conn!=null && !conn.isClosed()){
         conn.close();
        } 
         } catch (SQLException ex) {
             Logger.getLogger(locationDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return names;
     }
   
}
