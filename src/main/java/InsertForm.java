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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class InsertForm extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertForm</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet InsertForm at " + request.getContextPath() + "</h1>");
            
            String fname = request.getParameter("fname");
            String mname = request.getParameter("mname");
            String lname = request.getParameter("lname");
            String coll = request.getParameter("coll");
            String collid = request.getParameter("collid");
            String bdate = request.getParameter("bdate");
            String email = request.getParameter("email");
            String sdate = request.getParameter("sdate");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(sdate, formatter);

        // Calculate end date as 3 months from the start date
        LocalDate endDate = startDate.plusMonths(3);

        // Format the start and end dates back to String for storage
        String startDateStr = startDate.format(formatter);
        String edate = endDate.format(formatter);
            //String  = request.getParameter("edate");
            String year = request.getParameter("year");
            String busno = request.getParameter("busno");
            String busroute = request.getParameter("busroute");
            String taddress = request.getParameter("taddress");
            String paddress = request.getParameter("paddress");
            String ucollid = request.getParameter("ucollid");
            String ubona = request.getParameter("ubona");
            String ufee = request.getParameter("ufee");
            String ubusfee = request.getParameter("ubusfee");
            String uaadhar = request.getParameter("uaadhar");
            String uphoto = request.getParameter("uphoto");
            
            try
            {
                Connection con  = DataBaseConnection.initailisedDatabase();
                PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM studentinfo WHERE Email = ? AND CollegeId = ?");
                checkStmt.setString(1, email);
                checkStmt.setString(2, collid);
                
                ResultSet rs = checkStmt.executeQuery();
                
                if (rs.next()) {
                   
                    out.println("<h2>Error: You have already applied for the pass!</h2>");
                } else {
                PreparedStatement st = con.prepareStatement("insert into studentinfo (FirstName,MiddleName,LastName,CollegeName,CollegeId,BirthDate,Email,StartDate,EndDate,Year,BusNo,BusRoute,TAddress,PAddress,UploadCollegeId,Bonafide,CollegeReciept,CollegeBusReciept,AadharCard,Photo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                st.setString(1, fname);
                st.setString(2, mname);
                st.setString(3, lname);
                st.setString(4, coll);
                st.setString(5, collid);
                st.setString(6, bdate);
                st.setString(7, email);
                st.setString(8, sdate);
                st.setString(9, edate);
                st.setString(10, year);
                st.setString(11, busno);
                st.setString(12, busroute);
                st.setString(13, taddress);
                st.setString(14, paddress);
                st.setString(15, ucollid);
                st.setString(16, ubona);
                st.setString(17, ufee);
                st.setString(18, ubusfee);
                st.setString(19, uaadhar);
                st.setString(20,uphoto);
                st.executeUpdate();
                out.println("<script type=\"text/javascript\">");
                    out.println("alert('Form has been successfully filled. Now your pass has been generated');");
                    out.println("window.location.href = './StudentHomePage.html';"); 
                    out.println("</script>");
                
                
            }
            }
            catch(Exception e)
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
