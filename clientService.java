/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintCompanyService;

import Model.Client;
import dao.ClientDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Zach
 */
public class clientService {
 
    public int addClient(int AgentId, String FirstName,String  LastName, String StreetNumber, String StreetName, 
                        String  City, String  Province, String  PostalCode, String  TelOffice, String TelCell,
                        String Email, String Company,String CompanyType, ClientDao cDao){
        int  res = 0;
        Client clientObj = new Client();
        //Add agent id null check
        if(FirstName != null && LastName != null && StreetNumber != null && StreetName != null && City != null &&  Province != null &&  
                PostalCode != null &&  TelOffice != null && TelCell != null && Email != null && Company != null && CompanyType != null)
        {
           clientObj.setAgentId(AgentId);
            clientObj.setFirstName(FirstName);
            clientObj.setLastName(LastName);
            clientObj.setStreetNumber(StreetNumber);
            clientObj.setStreetName(StreetName);
            clientObj.setCity(City);
            clientObj.setProvince(Province);
            clientObj.setPostalCode(PostalCode);
            clientObj.setTelOffice(TelOffice);
            clientObj.setTelCell(TelCell);
            clientObj.setEmail(Email);
            clientObj.setCompany(Company);
            clientObj.setCompanyType(CompanyType);
            res = cDao.addClient(clientObj);
        }
        return res;
    }
    
    public ArrayList<Client> viewClients(ClientDao cDao){
        ArrayList<Client> clientList = new ArrayList<>();
        clientList = cDao.viewClients();
        return clientList;
    }
    
    public Client showClient(int id, ClientDao cDao) throws SQLException{
        Client clientObj = cDao.showClient(id);
        return clientObj;
    }
    
    public boolean updateClient(Client clientObj, ClientDao cDao) throws SQLException{
        boolean res = cDao.updateClient(clientObj);
        return res;
    }
    
    public void deleteClient(int id, ClientDao cDao) throws SQLException{
      cDao.deleteClient(id);
       }
   public ArrayList<Client> viewClientNames(ClientDao cDao){
        ArrayList<Client> names;
        names = cDao.viewClientNames();
        return names;
    }
}
