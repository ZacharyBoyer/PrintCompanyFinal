/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.*;
import PrintCompanyService.*;
import dao.*;
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
    String jdbcUserName;
    String jdbcPassword;
    String jdbcURL;
    userType uT;
public void init() throws ServletException {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
               // "jdbc:mysql://localhost:3306/printmarketing";
        jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
                //"root";
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        locDao = new locationDao(jdbcURL, jdbcUserName, jdbcPassword);
        locServc = new locationService();
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
}
