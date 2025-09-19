/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
public class DViewForm1 extends HttpServlet {

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
        String user = request.getParameter("UserName");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DownLoadForm</title>"); 
            out.println("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">"
                    + "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">");
            out.println("<style>\n" +
"    body {\n" +
"        background: linear-gradient(to right, #f0f4f7, #d9e4ec);\n" +
"        font-family: Arial, sans-serif;\n" +
"    }\n" +
"    .form-container {\n" +
"        background-color: #DFCFE4;\n" +
"        border-radius: 10px;\n" +
"        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);\n" +
"        padding: 30px;\n" +
"        margin: 20px auto;\n" +
"    }\n" +
"    .header {\n" +
"        background: linear-gradient(to right, #B06DC4 ,#3F3DBF);\n" +
"        color: white;\n" +
"        text-align: center;\n" +
"        padding: 20px;\n" +
"        border-radius: 10px 10px 0 0;\n" +
"        margin-top: 5px;\n" +
"    }\n" +
"    .header h1, .header h4 {\n" +
"        margin: 0;\n" +
"    }\n" +
"    label {\n" +
"        font-size: 16px;\n" +
"        color: #4c63d2;\n" +
"        font-weight: bold;\n" +
"        margin-top: 10px;\n" +
"    }\n" +
"    input[type=\"text\"], input[type=\"date\"], input[type=\"email\"], input[type=\"file\"] {\n" +
"        width: 100%;\n" +
"        padding: 10px;\n" +
"        border: 1px solid #ddd;\n" +
"        border-radius: 8px;\n" +
"        background-color: #f9f9f9;\n" +
"        transition: all 0.3s ease;\n" +
"    }\n" +
"    input[type=\"text\"]:focus, input[type=\"date\"]:focus, input[type=\"email\"]:focus, input[type=\"file\"]:focus {\n" +
"        outline: none;\n" +
"        border-color: #7e42e3;\n" +
"        background-color: #fff;\n" +
"    }\n" +
"    .print-btn {\n" +
"        background-color: #7e42e3;\n" +
"        color: white;\n" +
"        padding: 12px 30px;\n" +
"        border: none;\n" +
"        border-radius: 8px;\n" +
"        font-size: 18px;\n" +
"        cursor: pointer;\n" +
"        transition: background-color 0.3s ease;\n" +
"    }\n" +
"    .print-btn:hover {\n" +
"        background-color: #5c31c9;\n" +
"    }\n" +
"</style>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet DownLoadForm at " + request.getContextPath() + "</h1>");
            HttpSession session = request.getSession();
            String suser = (String)session.getAttribute("user");
            String semail = (String)session.getAttribute("email");
            out.println("<div class=\"container form-container\">\n" +
"        <div class=\"header\">\n" +
"            <h1>E-Bus Pass</h1>\n" +
"            <h4>Application Form</h4>\n" +
"        </div>");
            try
            {
                Connection con = DataBaseConnection.initailisedDatabase();
                PreparedStatement st = con.prepareStatement("select * from studentinfo where CollegeId='"+user+"' ;");
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
            String fname = rs.getString("FirstName");
            String mname = rs.getString("MiddleName");
            String lname = rs.getString("LastName");
            String coll = rs.getString("CollegeName");
            String collid = rs.getString("CollegeId");
            String bdate = rs.getString("BirthDate");
            String email = rs.getString("Email");
            String sdate = rs.getString("StartDate");
            
            String edate = rs.getString("EndDate");
            String year = rs.getString("Year");
            String busno = rs.getString("BusNo");
            String busroute = rs.getString("BusRoute");
            String taddress = rs.getString("TAddress");
            String paddress = rs.getString("PAddress");
            String ucollid = rs.getString("UploadCollegeId");
            String ubona = rs.getString("Bonafide");
            String ufee = rs.getString("CollegeReciept");
            String ubusfee = rs.getString("CollegeBusReciept");
            String uaadhar = rs.getString("AadharCard");
            String uphoto = rs.getString("Photo");
            out.println("<div id=\"printArea\">"); 
            out.println("" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"fname\">Enter First Name:</label>\n" +
"                    <input type=\"text\"  name=\"fname\" value="+fname+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"mname\">Enter Middle Name:</label>\n" +
"                    <input type=\"text\"  name=\"mname\" value="+mname+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"lname\">Enter Last Name:</label>\n" +
"                    <input type=\"text\"  name=\"lname\" value="+lname+" required=\"required\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"coll\">Enter College Name:</label>\n" +
"                    <input type=\"text\"  name=\"coll\" value="+coll+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"collid\">Enter College ID:</label>\n" +
"                    <input type=\"text\"  name=\"collid\" value="+collid+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"bdate\">Enter Date of Birth:</label>\n" +
"                    <input type=\"date\"  name=\"bdate\" value="+bdate+" required=\"required\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"email\">Enter Email:</label>\n" +
"                    <input type=\"email\"  name=\"email\" value="+email+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"sdate\">Enter Start Date of Pass:</label>\n" +
"                    <input type=\"date\"  name=\"sdate\" value="+sdate+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-4\">\n" +
"                    <label for=\"sdate\">Enter Start End of Pass:</label>\n" +
"                    <input type=\"date\"  name=\"sdate\" value="+edate+" required=\"required\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row \">\n" +
"      <div class=\"col-4 themed-grid-col\">\n" +
"      	<label for=\"taddress\">Enter Year </label>\n" +
"                    <input type=\"text\"  name=\"year\" value="+year+" required=\"required\" >\n" +
"      </div>\n" +
"      <div class=\"col-4 themed-grid-col\">\n" +
"      	<label for=\"busno\">Enter Bus Number:</label>\n" +
"                    <input type=\"text\"  name=\"busno\" value="+busno+" required=\"required\">\n" +
"        </div>\n" +
"      <div class=\"col-4 themed-grid-col\">\n" +
"      	<label for=\"busroute\">Enter Bus Route:</label>\n" +
"        <input type=\"text\"  name=\"busroute\" value="+busroute+" required=\"required\">\n" +
"      </div>\n" +
"    </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-6\">\n" +
"                    <label for=\"taddress\">Enter Temporary Address:</label>\n" +
"                    <input type=\"text\"  name=\"taddress\" value="+taddress+" required=\"required\">\n" +
"                </div>\n" +
"                <div class=\"col-md-6\">\n" +
"                    <label for=\"paddress\">Enter Permanent Address:</label>\n" +
"                    <input type=\"text\"  name=\"paddress\" value="+paddress+" required=\"required\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n");
out.println("" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"ucollid\">Uploaded College ID:</label>\n" +
"                    <a href=\"Documents/" + ucollid + "\" target=\"_blank\">View College ID <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"uphoto\">Uploaded Passport Size Photo:</label>\n" +
"                    <a href=\"Documents/" + uphoto + "\" target=\"_blank\">View Passport Size Photo <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"ubona\">Uploaded Bonafide Certificate:</label>\n" +
"                    <a href=\"Documents/" + ubona + "\" target=\"_blank\">View Bonafide Certificate <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"ufee\">Uploaded Fee Receipt of Current Year:</label>\n" +
"                    <a href=\"Documents/" + ufee + "\" target=\"_blank\">View Fee Receipt <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"ubusfee\">Uploaded Fee Receipt of Bus of Current Year:</label>\n" +
"                    <a href=\"Documents/" + ubusfee + "\" target=\"_blank\">View Bus Fee Receipt <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"uaadhar\">Uploaded Aadhar Card:</label>\n" +
"                    <a href=\"Documents/" + uaadhar + "\" target=\"_blank\">View Aadhar Card <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br><br>\n" +
"   ");
out.println("" +
"            <div class=\"row justify-content-center\">\n" +
"                <button type=\"button\" class=\"print-btn\" onclick=\"window.print();\">Print</button>\n" +
"            </div>\n" +
"   ");

                }
                out.println(" </div></div>");
                
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
            Logger.getLogger(DownLoadForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DownLoadForm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DownLoadForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DownLoadForm.class.getName()).log(Level.SEVERE, null, ex);
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
