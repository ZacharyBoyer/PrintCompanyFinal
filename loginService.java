package PrintCompanyService;

import dao.loginDao;

/**
 *
 * @author Alessandro S
 */
public class loginService {
    
    public int addLogin(String userName, String password, String role, int agentId, loginDao lDao){
       int res = lDao.addLogin(userName, password, role, agentId);
        return res;
    }
    
    public int updateLogin(String userName, String password, int agentId, loginDao lDao){
        int res = lDao.updateLogin(userName, password, agentId);
        return res;
    }

    public int deleteLogin(int id, loginDao lDao){
        int res =0;
       res= lDao.deleteLogin(id);
       return res;
    }
    
    public void checkLogin(String userName, String password, loginDao lDao){
        lDao.checkLogin(userName, password);
    }
    
}

