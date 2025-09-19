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
public class ReNewPass extends HttpServlet {

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
        out.println("<title>Servlet ReNewPass</title>"); 
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
"    .form-group label {\n" +
"        font-weight: bold;\n" +
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
"    .update-btn {\n" +
"        background-color: #7e42e3;\n" +
"        color: white;\n" +
"        padding: 12px 30px;\n" +
"        border: none;\n" +
"        border-radius: 8px;\n" +
"        font-size: 18px;\n" +
"        cursor: pointer;\n" +
"        transition: background-color 0.3s ease;\n" +
"    }\n" +
"    .update-btn:hover {\n" +
"        background-color: #5c31c9;\n" +
"    }\n" +
"</style>");
        out.println("</head>");
        out.println("<body>");
        
        HttpSession session = request.getSession();
        String suser = (String)session.getAttribute("user");
        String semail = (String)session.getAttribute("email");

        out.println("<div class=\"container form-container\">\n" +
"        <div class=\"header\">\n" +
"            <h1>E-Bus Pass</h1>\n" +
"            <h4>Application Form</h4>\n" +
"        </div>");

        try {
            Connection con = DataBaseConnection.initailisedDatabase();
            PreparedStatement st = con.prepareStatement("select * from studentinfo where CollegeId='" + suser + "' ;");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String edate = rs.getString("EndDate");

                // Convert 'edate' to LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate endDate = LocalDate.parse(edate, formatter);
                LocalDate currentDate = LocalDate.now();

                // Check if the pass is expired or valid
                String status = (endDate.isBefore(currentDate) || endDate.equals(currentDate)) ? "Expired" : "Valid";

                // If the status is "Valid", show a message and do not display the form
                if (status.equals("Valid")) {
                    out.println("<div class='alert alert-success' role='alert'>");
                    out.println("Your bus pass is still valid. No need to renew at this time.");
                    out.println("</div>");
                } else {
                    // If expired, show the renewal form
                    String id = rs.getString("Id");
                    String fname = rs.getString("FirstName");
                    String mname = rs.getString("MiddleName");
                    String lname = rs.getString("LastName");
                    String coll = rs.getString("CollegeName");
                    String collid = rs.getString("CollegeId");
                    String bdate = rs.getString("BirthDate");
                    String email = rs.getString("Email");
                    String sdate = rs.getString("StartDate");
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

                    // Render the form only if pass is expired
                    
    // Start of form
    out.println("<form method='post' action='./UpdateForm1'>");

    // Hidden fields
    out.println("<input type='hidden' value=" + id + " name='Id'>"
            + "<input type='hidden' value=" + ucollid + " name='UploadCollegeId'>"
            + "<input type='hidden' value=" + ubona + " name='Bonafide'>"
            + "<input type='hidden' value=" + ufee + " name='CollegeReciept'>"
            + "<input type='hidden' value=" + ubusfee + " name='CollegeBusReciept'>"
            + "<input type='hidden' value=" + uaadhar + " name='AadharCard'>"
            + "<input type='hidden' value=" + uphoto + " name='Photo'>");

    // Start of form fields
     out.println("<div class='form-group'>");
    // Name fields
    out.println("<div class='row'>"
            + "<br><br>"
            + "<div class='col-md-4'>"
            + "<label for='fname'>Enter First Name:</label>"
            + "<input type='text' name='fname' value=" + fname + " required='required'>"
            + "</div>"
            + "<div class='col-md-4'>"
            + "<label for='mname'>Enter Middle Name:</label>"
            + "<input type='text' name='mname' value=" + mname + " required='required'>"
            + "</div>"
            + "<div class='col-md-4'>"
            + "<label for='lname'>Enter Last Name:</label>"
            + "<input type='text' name='lname' value=" + lname + " required='required'>"
            + "</div>"
            + "</div><br>");

    // College and Date of Birth fields
    out.println("<div class='row'>"
            + "<div class='col-md-4'>"
            + "<label for='coll'>Enter College Name:</label>"
            + "<input type='text' name='coll' value=" + coll + " required='required'>"
            + "</div>"
            + "<div class='col-md-4'>"
            + "<label for='collid'>Enter College ID:</label>"
            + "<input type='text' name='collid' value=" + collid + " required='required'>"
            + "</div>"
            + "<div class='col-md-4'>"
            + "<label for='bdate'>Enter Date of Birth:</label>"
            + "<input type='date' name='bdate' value=" + bdate + " required='required'>"
            + "</div>"
            + "</div><br>");

    // Email and Start Date of Pass fields
    out.println("<div class='row'>"
            + "<div class='col-md-4'>"
            + "<label for='email'>Enter Email:</label>"
            + "<input type='email' name='email' value=" + email + " required='required'>"
            + "</div>"
            + "<div class='col-md-4'>"
            + "<label for='sdate'>Enter Start Date of Pass:</label>"
            + "<input type='date' name='sdate' value=" + edate + " required='required'>"
            + "</div>"
            + "</div><br>");

    // Year, Bus Number, and Bus Route fields
    out.println("<div class='row'>"
            + "<div class='col-4 themed-grid-col'>"
            + "<label for='year'>Enter Year:</label>"
            + "<input type='text' name='year' value=" + year + " required='required'>"
            + "</div>"
            + "<div class='col-4 themed-grid-col'>"
            + "<label for='busno'>Enter Bus Number:</label>"
            + "<input type='text' name='busno' value=" + busno + " required='required'>"
            + "</div>"
            + "<div class='col-4 themed-grid-col'>"
            + "<label for='busroute'>Enter Bus Route:</label>"
            + "<input type='text' name='busroute' value=" + busroute + " required='required'>"
            + "</div>"
            + "</div><br>");

    // Temporary and Permanent Address fields
    out.println("<div class='row'>"
            + "<div class='col-md-6'>"
            + "<label for='taddress'>Enter Temporary Address:</label>"
            + "<input type='text' name='taddress' value=" + taddress + " required='required'>"
            + "</div>"
            + "<div class='col-md-6'>"
            + "<label for='paddress'>Enter Permanent Address:</label>"
            + "<input type='text' name='paddress' value=" + paddress + " required='required'>"
            + "</div>"
            + "</div><br>");

    // Uploaded College ID field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='ucollid'>Uploaded College ID:</label>"
            + "<a href='Documents/" + ucollid + "' target='_blank'>View College ID <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='ucollid' accept='Documents/*'>"
            + "</div>"
            + "</div><br>");

    // Uploaded Passport Size Photo field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='uphoto'>Uploaded Passport Size Photo:</label>"
            + "<a href='Documents/" + uphoto + "' target='_blank'>View Passport Size Photo <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='uphoto' accept='Documents/*'>"
            + "</div>"
            + "</div><br>");

    // Uploaded Bonafide Certificate field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='ubona'>Uploaded Bonafide Certificate:</label>"
            + "<a href='Documents/" + ubona + "' target='_blank'>View Bonafide Certificate <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='ubona' accept='Documents/*'>"
            + "</div>"
            + "</div><br>");

    // Uploaded Fee Receipt field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='ufee'>Uploaded Fee Receipt of Current Year:</label>"
            + "<a href='Documents/" + ufee + "' target='_blank'>View Fee Receipt <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='ufee' accept='Documents/*'>"
            + "</div>"
            + "</div><br>");

    // Uploaded Bus Fee Receipt field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='ubusfee'>Uploaded Fee Receipt of Bus of Current Year:</label>"
            + "<a href='Documents/" + ubusfee + "' target='_blank'>View Bus Fee Receipt <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='ubusfee' accept='Documents/*'>"
            + "</div>"
            + "</div><br>");

    // Uploaded Aadhar Card field with view option
    out.println("<div class='row'>"
            + "<div class='col-12'>"
            + "<label for='uaadhar'>Uploaded Aadhar Card:</label>"
            + "<a href='Documents/" + uaadhar + "' target='_blank'>View Aadhar Card <i class='fas fa-eye'></i></a> <label>(optional)</label>"
            + "<input type='file' name='uaadhar' accept='Documents/*'>"
            + "</div>"
            + "</div><br><br>");

    // Submit button
    out.println("<div class='row justify-content-center'>"
            + "<button type='submit' class='update-btn'>Submit</button>"
            + "</div>");

    // End of form
    out.println("</div></form>");
                    }
                }
            }
        
    


        catch (Exception e) {
    out.println(e);
}

        out.println("</div>"); // End of form-container
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
