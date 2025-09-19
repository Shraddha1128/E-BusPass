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
public class EditBusRoute3 extends HttpServlet {

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
        String Id = request.getParameter("Id");
            
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
             String busrouteno = request.getParameter("busrouteno");
            String busnumber = request.getParameter("busnumber");
            String busroute = request.getParameter("busroute");
            String starttime = request.getParameter("starttime");
            String endtime = request.getParameter("endtime");
              //String dfile = request.getParameter("DriverLicense");
            try
            {
                Connection con  = DataBaseConnection.initailisedDatabase();
                
                PreparedStatement st = con.prepareStatement("update BusRoute set BusRouteNo=?, BusNumber=?, BusRoute=?, StartTime=?, EndTime=? where Id='"+Id+"' ;");
               st.setString(1, busrouteno);
                st.setString(2, busnumber);
                st.setString(3, busroute);
                st.setString(4, starttime);
                st.setString(5, endtime);
                st.executeUpdate();
                
                response.sendRedirect("./BusRoute");
                
            
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
