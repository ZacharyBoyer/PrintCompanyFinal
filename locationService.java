/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintCompanyService;

import Model.Location;
import dao.locationDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alessandro Sousa 
 */
public class locationService {
    
    public ArrayList<Location> viewAllLocations(locationDao lDao) throws SQLException{
    ArrayList<Location> locList = new ArrayList();
    locList = lDao.viewAllLocations();
    return locList;
    }
    
    public Location viewLocation(int id, locationDao lDao ) throws SQLException{
        Location loc = lDao.viewLocation(id);
        return loc;        
    }
    
    public boolean updateLocation(Location loc, locationDao lDao) throws SQLException{
        boolean res = lDao.updateLocation(loc);
        return res;
    }
    
    public int addLocation(String name, int Cap, locationDao lDao){
        int res = 0; 
           Location loc = new Location();

            loc.setLocationName(name);
            loc.setDistrCap(Cap);
            res = lDao.addLocation(loc);
    
        return res;               
    }
    
    public void deleteLocation(int id, locationDao lDao) throws SQLException{
        lDao.deleteLocation(id);
    }
    
    public ArrayList<Location> viewLocationNames(locationDao lDao){
        ArrayList<Location> locs;
        locs = lDao.viewLocationNames();
        return locs;
    }
    
        // <editor-fold defaultstate="collapsed" desc="LocationXOrder methods. Click on the + sign on the left to edit the code."> 

    public void addLocXorder(int orderId, int locId, locationDao lDao){
        
        lDao.addLocXorder(orderId, locId);
        
    }
    
    // </editor-fold>
}
