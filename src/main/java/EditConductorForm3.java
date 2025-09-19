/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DELL
 */
public class EditConductorForm3 extends HttpServlet {

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
        String did = request.getParameter("DriverId");
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateForm</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet UpdateForm at " + request.getContextPath() + "</h1>");
            String conductorId = request.getParameter("conductorid");
            String conductorname = request.getParameter("conductorname");
            String conductornumber = request.getParameter("conductornum");
            String conductoraddress = request.getParameter("conductoraddress");
            String conductorbusrouteno = request.getParameter("busrouteno");
             String conductorbusroute = request.getParameter("busroute");
             String conductorstarttime = request.getParameter("starttime");
             String conductorendtime = request.getParameter("endtime");
              String dfile = request.getParameter("DriverLicense");
            try
            {
                Connection con  = DataBaseConnection.initailisedDatabase();
                
                PreparedStatement st = con.prepareStatement("update Conductor set ConductorId=?, ConductorName=?, ConductorNumber=?, ConductorAddress=?, BusRouteNumber=?,BusRoute=?,StartTime=?,EndTime=?, DrivingLicense=? where ConductorId='"+did+"' ;");
               st.setString(1, conductorId);
                    st.setString(2, conductorname);
                    st.setString(3, conductornumber);
                    st.setString(4, conductoraddress);
                    st.setString(5, conductorbusrouteno);
                    st.setString(6, conductorbusroute);
                   st.setString(7, conductorstarttime);
                    st.setString(8, conductorendtime);
                    st.setString(9, dfile);
                st.executeUpdate();
                response.sendRedirect("./Drivers");
                 
                
            
            }
            catch(ClassNotFoundException | SQLException e)
            {
                out.println(e);
            }
            
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

}
