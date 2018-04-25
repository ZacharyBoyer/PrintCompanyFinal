/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.*;
import PrintCompanyService.*;
import dao.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zach
 */
public class PMCServlet extends HttpServlet {
   locationService locServc;
    locationDao locDao;
    clientService clientServc;
    ClientDao clientDao;
    MarketingAgentDao mADao;
    MarketingAgentService mAServc;
    orderDao oDao;
    orderService oServc;
    loginDao lDao;
    loginService lServc;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcURL;
    userType uT;
    
    @Override
    public void init() throws ServletException {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
               // "jdbc:mysql://localhost:3306/printmarketing";
        jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
                //"root";
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        locDao = new locationDao(jdbcURL, jdbcUserName, jdbcPassword);
        locServc = new locationService();
        clientDao = new ClientDao(jdbcURL, jdbcUserName, jdbcPassword);
        clientServc = new clientService();
        mADao = new MarketingAgentDao(jdbcURL, jdbcUserName, jdbcPassword);
        mAServc = new MarketingAgentService();
        oDao = new orderDao(jdbcURL, jdbcUserName, jdbcPassword);
        oServc = new orderService();
        lDao = new loginDao(jdbcURL, jdbcUserName, jdbcPassword);
        lServc = new loginService();
        uT = new userType();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PMCServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PMCServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Client methods. Click on the + sign on the left to edit the code."> 
    protected void viewClients(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Client> clientList = new ArrayList();
        String msgVisibility="";
        
        if(uT.getType().equals("admin")){
            msgVisibility= "";
        }
        else{
            msgVisibility="hidden";
        }
        request.setAttribute("messageVis", msgVisibility);
        clientList = clientServc.viewClients(clientDao);

        request.setAttribute("clientList", clientList);
        RequestDispatcher dispt = request.getRequestDispatcher("viewClientList.jsp");
        dispt.forward(request, response);
    }

    private void showEditClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Client client = clientServc.showClient(id, clientDao);
            request.setAttribute("client", client);

            RequestDispatcher dispatcher = request.getRequestDispatcher("EditClient.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int AgentId = Integer.parseInt(request.getParameter("AgentId"));
        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String StreetNumber = request.getParameter("SNum");
        String StreetName = request.getParameter("SName");
        String City = request.getParameter("City");
        String Province = request.getParameter("Province");
        String PostalCode = request.getParameter("Postal");
        String TelOffice = request.getParameter("ONum");
        String TelCell = request.getParameter("CNum");
        String Email = request.getParameter("Email");
        String Company = request.getParameter("CName");
        String CompanyType = request.getParameter("CType");

        Client client = new Client(id, AgentId, FirstName, LastName, StreetNumber, StreetName, City, Province, PostalCode, TelOffice, TelCell, Email, Company, CompanyType);

        try {
            clientServc.updateClient(client, clientDao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("clientList");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int res =0;
        int id = Integer.parseInt(request.getParameter("id"));
        if(!(Integer.parseInt(request.getParameter("aId")) == uT.getId()) && !uT.getType().equals("admin")){
            res=0;
        } else if((Integer.parseInt(request.getParameter("aId")) == uT.getId()) || uT.getType().equals("admin")) {
            try {
                res = clientDao.deleteClient(id);
            } catch (SQLException ex) {
                Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        response.sendRedirect("clientList?res=" + res);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int AgentId = Integer.parseInt(request.getParameter("AgentId"));
        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String StreetNumber = request.getParameter("SNum");
        String StreetName = request.getParameter("SName");
        String City = request.getParameter("City");
        String Province = request.getParameter("Province");
        String PostalCode = request.getParameter("Postal");
        String TelOffice = request.getParameter("ONum");
        String TelCell = request.getParameter("CNum");
        String Email = request.getParameter("Email");
        String Company = request.getParameter("CName");
        String CompanyType = request.getParameter("CType");

        int res = clientServc.addClient(AgentId, FirstName, LastName, StreetNumber, StreetName, City, Province, PostalCode, TelOffice, TelCell, Email, Company, CompanyType, clientDao);

        if (res > 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientList");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("errorjsp.jsp");
        }

    }

    private void newClientForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("userId", uT.getId());
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddClient.jsp");
        dispatcher.forward(request, response);
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Order methods. Click on the + sign on the left to edit the code."> 
    protected void viewOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Order> oList = new ArrayList();
        oList = oServc.viewOrders(oDao);
        String msgVisibility="";
        
        if(uT.getType().equals("admin")){
            msgVisibility= "hidden";
        }
        else{
            msgVisibility="";
        }
        request.setAttribute("messageVis", msgVisibility);
        request.setAttribute("oList", oList);
        RequestDispatcher dispt = request.getRequestDispatcher("viewOrderList.jsp");
        dispt.forward(request, response);
    }

    private void showEditOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            
            Order oObj = oServc.showOrder(id, oDao);
            request.setAttribute("order", oObj);
            
            ArrayList<MarketingAgent> mAs = mAServc.viewAllMarketingAgents(mADao);
            request.setAttribute("agents",mAs);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditOrder.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        if (!request.getParameter("FlyerImg").equals("")) {
            File theFile = new File(request.getParameter("FlyerImg"));
            FileInputStream input = new FileInputStream(theFile);

            try {
                Order oObj = new Order(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("AgentId")), Integer.parseInt(request.getParameter("clientId")), Integer.parseInt(request.getParameter("flyerQty")),
                        Integer.parseInt(request.getParameter("personalCopy")), request.getParameter("flyerLayout"), request.getParameter("paymentInformation"),
                        request.getParameter("invoiceNumber"), request.getParameter("comments"), Boolean.parseBoolean(request.getParameter("isFlyerArtApproved")), Boolean.parseBoolean(request.getParameter("isPaymentRecived")), input);

                oServc.updateOrder(oObj, oDao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Order oObj = new Order(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("AgentId")), Integer.parseInt(request.getParameter("clientId")), Integer.parseInt(request.getParameter("flyerQty")),
                        Integer.parseInt(request.getParameter("personalCopy")), request.getParameter("flyerLayout"), request.getParameter("paymentInformation"),
                        request.getParameter("invoiceNumber"), request.getParameter("comments"), Boolean.parseBoolean(request.getParameter("isFlyerArtApproved")), Boolean.parseBoolean(request.getParameter("isPaymentRecived")));

                oServc.updateOrderWoImg(oObj, oDao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        response.sendRedirect("orderList");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
         int res =0;
        int id = Integer.parseInt(request.getParameter("id"));

        try {
          res = oDao.deleteOrder(id);
        } catch (SQLException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

         response.sendRedirect("orderList?res=" + res);
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        FileInputStream input = null;
        File theFile = new File(request.getParameter("FlyerImg"));
        input = new FileInputStream(theFile);
 
       final int res = oServc.addOrder(Integer.parseInt(request.getParameter("AgentId")), Integer.parseInt(request.getParameter("clientId")), Integer.parseInt(request.getParameter("flyerQty")),
                Integer.parseInt(request.getParameter("personalCopy")), request.getParameter("flyerLayout"), request.getParameter("paymentInformation"),
                request.getParameter("invoiceNumber"), request.getParameter("comments"), Boolean.parseBoolean(request.getParameter("isFlyerArtApproved")),
                Boolean.parseBoolean(request.getParameter("isPaymentRecived")), input, oDao);
        int id = oDao.viewLastId();
        
        oDao.addLocXorder(id, request.getParameterValues("loc"));
        
        if (res == 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("orderList");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("orderList");
        }
    }

    private void newOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ArrayList<Location> locs;
        locs = locServc.viewLocationNames(locDao);
        ArrayList<Client> names;
        names = clientServc.viewClientNames(clientDao);
        request.setAttribute("userId", uT.getId());
        
        request.setAttribute("LocNames", locs);
        request.setAttribute("clientNames", names);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddOrder.jsp");
        dispatcher.forward(request, response);
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MarketingAgent methods. Click on the + sign on the left to edit the code."> 
    protected void viewMarketingAgents(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<MarketingAgent> mAList = new ArrayList();

        try {
            mAList = mAServc.viewAllMarketingAgents(mADao);
        } catch (SQLException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        request.setAttribute("mAList", mAList);
        RequestDispatcher dispt = request.getRequestDispatcher("viewAgentList.jsp");
        dispt.forward(request, response);
    }

    private void showEditMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
       
            int id = Integer.parseInt(request.getParameter("id"));
            if(id!=1){
                 try {
            MarketingAgent mA = mAServc.viewMarketingAgent(id, mADao);
            request.setAttribute("agent", mA);

            RequestDispatcher dispatcher = request.getRequestDispatcher("EditAgent.jsp");
            dispatcher.forward(request, response);
                 } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }else if(id==1){
        response.sendRedirect("agentList?res=" + 2);
    }
    }

    private void updateMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String Email = request.getParameter("Email");
        String UserName = request.getParameter("userName");
        String Password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNum");

        MarketingAgent mA = new MarketingAgent(id, FirstName, LastName, Email, UserName, Password, phoneNumber);

        try {
            mAServc.updateMarketingAgent(mA, mADao);
            lServc.updateLogin(UserName, Password, id, lDao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("agentList");
    }

    private void deleteMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
          int res=0;
        int id = Integer.parseInt(request.getParameter("id"));
        if(id!=1){
        res = mADao.deleteMarketingAgent(id);
         lServc.deleteLogin(id, lDao);

        }else if(id==1){
            res =2;
        }
       
        response.sendRedirect("agentList?res="+res + "&id="+id);
    }

    private void addMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String Email = request.getParameter("Email");
        String UserName = request.getParameter("userName");
        String Password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNum");

        int res = mAServc.addMarketingAgent(FirstName, LastName, Email, UserName, Password, phoneNumber, mADao);
        
        try {
            res += lServc.addLogin(UserName, Password, "agent", mAServc.viewMarketingAgent(UserName, mADao), lDao);
        } catch (SQLException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        if (res > 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("agentList");
            dispatcher.forward(request, response);
}
    }

    private void newMarketingAgentForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddAgent.jsp");
        dispatcher.forward(request, response);
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Location methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the Location <code> methods.
     */
    protected void viewLocations(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Location> locList = new ArrayList();
        try {
            locList = locServc.viewAllLocations(locDao);
        } catch (SQLException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("locList", locList);
        RequestDispatcher dispt = request.getRequestDispatcher("viewLocations.jsp");
        dispt.forward(request, response);

    }

    private void showEditLocation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String Sid = request.getParameter("id");
            int id = Integer.parseInt(Sid);
            System.out.println(id);
            Location loc = locServc.viewLocation(id, locDao);
            request.setAttribute("location", loc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("EditLocation.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private void updateLocation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        int cap = Integer.parseInt(request.getParameter("Capacity"));

        Location loc = new Location(id, name, cap);

        try {
            locServc.updateLocation(loc, locDao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("locList");
    }

    private void deleteLocation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int res = 0;
        int id = Integer.parseInt(request.getParameter("id"));

         res = locDao.deleteLocation(id);

        response.sendRedirect("locList?res=" + res);
    }

    private void addLocation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        int cap = Integer.parseInt(request.getParameter("Capacity"));

        int res = locServc.addLocation(name, cap, locDao);

        if (res > 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("locList");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("viewLocations.jsp");
        }

    }

    private void newLocationForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddLocation.jsp");
        dispatcher.forward(request, response);
    }// </editor-fold>
    private void loginCheck(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> res;
        RequestDispatcher dispatcher = null;
        try {
            String login = request.getParameter("login");
            String pass = request.getParameter("password");            
          
            res = lDao.checkLogin(login, pass);
          
          if(res.size()==3){
              
          if(res.get(0).equals("1")&&res.get(1).equals("admin")){
              uT.setId(Integer.parseInt(res.get(2)));
              uT.setType(res.get(1));
              request.setAttribute("user", uT);
              dispatcher = request.getRequestDispatcher("adminPage.jsp");
          }
          else if(res.get(0).equals("1")&&res.get(1).equals("agent")){
               uT.setId(Integer.parseInt(res.get(2)));
              uT.setType(res.get(1));
              request.setAttribute("user", uT);
              dispatcher = request.getRequestDispatcher("agentPage.jsp");
          }
          }
          else if(res.get(0).equals("0")){
              request.setAttribute("Message", "Not a valid Login");
              dispatcher = request.getRequestDispatcher("login.jsp");
          }
          
              dispatcher.forward(request, response);
          
        } catch (ServletException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showLogin(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = null;
        try {
            dispatcher = request.getRequestDispatcher("login.jsp");
              dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void agentTransfer(HttpServletRequest request, HttpServletResponse response) {
        int res =0;
        try {
            res = mADao.agentTransfer(Integer.parseInt(request.getParameter("id")));
            if(res==1){
                res=mADao.deleteMarketingAgent(Integer.parseInt(request.getParameter("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            try {
                
                response.sendRedirect("agentList");
            } catch (IOException ex) {
                Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                response.sendRedirect("agentList");
            } catch (IOException ex) {
                Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void showAdminPage(HttpServletRequest request, HttpServletResponse response){
        try {
           RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
              dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showAgentPage(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("agentPage.jsp");
        } catch (IOException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response){
        uT= new userType();
        RequestDispatcher dispatcher = null;
        try {
             dispatcher = request.getRequestDispatcher("login.jsp");
             dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
          Logger.getLogger(PMCServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
