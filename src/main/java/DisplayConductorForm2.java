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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DisplayConductorForm2 extends HttpServlet {

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
        String did = request.getParameter("ConductorId");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PassFormFilled</title>"); 
            out.println("<link href=\"bootstrap/assets/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"    <link href=\"bootstrap/assets/dist/css/headers.css\" rel=\"stylesheet\">\n" +
"    <link href=\"bootstrap/assets/dist/css/sidebars.css\" rel=\"stylesheet\">\n" +
"    <link href=\"bootstrap/assets/dist/css/grid.css\" rel=\"stylesheet\">\n" +
"     <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"\n" +
"    <!-- Font Awesome for Icons -->\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\" integrity=\"sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"\n" +
"");
            out.println("<style>\n" +
"  .instructions-container {\n" +
"        padding: 20px;\n" +
"        background-color: #f8f9fa; /* Light background for better readability */\n" +
"        border-radius: 20px; /* Rounded corners */\n" +
"        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */\n" +
"        margin-left: 0; /* Align container to the left */\n" +
"        margin-right: auto; /* Ensure the container does not shift to the right */\n" +
"        max-width: 100%;\n" +
"    }\n" +
"\n" +
"    .instructions-container h2 {\n" +
"        font-size: 1.15rem;\n" +
"        margin-bottom: 20px;\n" +
"        color: #3F3DBF; /* Color matching the overall theme */\n" +
"        font-weight: bold;\n" +
"    }\n" +
"\n" +
"    .instructions-container ol {\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"        list-style-position: inside; /* List numbers inside the content box */\n" +
"        font-size: 15px;\n" +
"        color: #6E078E; \n" +
"    }\n" +
"\n" +
"    .instructions-container li {\n" +
"        margin-bottom: 15px;\n" +
"        font-size: 13px;\n" +
"    }\n" +
"\n" +
"    .instructions-container strong {\n" +
"        font-size: 15px;\n" +
"        color: #6E078E; /* Color for emphasis */\n" +
"    }\n" +
"\n" +
"    .instructions-container ul {\n" +
"        margin: 10px 0 10px 20px; /* Indentation for sub-lists */\n" +
"        padding: 0;\n" +
"        list-style-type: disc; /* Bullets for sub-lists */\n" +
"    }\n" +
"\n" +
"    .instructions-container ul li {\n" +
"        font-size: 10px;\n" +
"        color: #333; /* Darker text color for readability */\n" +
"    }\n" +
"        .nav-link.active, .nav-link.text-white {\n" +
"            color: white;\n" +
"        }\n" +
"\n" +
"        .nav-link:hover {\n" +
"            background-color: #B06DC4;\n" +
"            color: white;\n" +
"        }\n" +
"\n" +
"        .dropdown-menu-dark {\n" +
"            background-color: #B06DC4;\n" +
"        }\n" +
"\n" +
"        .sidebar-icons {\n" +
"            font-size: 25px;\n" +
"            margin: 5px;\n" +
"            padding: 5px;\n" +
"        }\n" +
"    \n" +
"        .bd-placeholder-img {\n" +
"            font-size: 1.125rem;\n" +
"            text-anchor: middle;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            user-select: none;\n" +
"        }\n" +
"\n" +
"        @media (min-width: 768px) {\n" +
"            .bd-placeholder-img-lg {\n" +
"                font-size: 3.5rem;\n" +
"            }\n" +
"        }\n" +
"\n" +
"        .b-example-divider {\n" +
"            width: 100%;\n" +
"            height: 3rem;\n" +
"            background-color: rgba(0, 0, 0, .1);\n" +
"            border: solid rgba(0, 0, 0, .15);\n" +
"            border-width: 1px 0;\n" +
"            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);\n" +
"        }\n" +
"\n" +
"        .nav-link.active, .nav-link.text-white {\n" +
"            color: white; /* White text */\n" +
"        }\n" +
"\n" +
"        .nav-link:hover {\n" +
"            background-color: #B06DC4; /* Slightly lighter purple for hover */\n" +
"            color: white;\n" +
"        }\n" +
"\n" +
"        .dropdown-menu-dark {\n" +
"            background-color: #B06DC4; /* Match the sidebar color */\n" +
"        }\n" +
"\n" +
"        .b-example-vr {\n" +
"            flex-shrink: 0;\n" +
"            width: 1.5rem;\n" +
"            height: 100vh;\n" +
"        }\n" +
"\n" +
"        .bi {\n" +
"            vertical-align: -.125em;\n" +
"            fill: currentColor;\n" +
"        }\n" +
"\n" +
"        .nav-scroller {\n" +
"            position: relative;\n" +
"            z-index: 2;\n" +
"            height: 2.75rem;\n" +
"            overflow-y: hidden;\n" +
"        }\n" +
"\n" +
"        .nav-scroller .nav {\n" +
"            display: flex;\n" +
"            flex-wrap: nowrap;\n" +
"            padding-bottom: 1rem;\n" +
"            margin-top: -1px;\n" +
"            overflow-x: auto;\n" +
"            text-align: center;\n" +
"            white-space: nowrap;\n" +
"            -webkit-overflow-scrolling: touch;\n" +
"        }\n" +
"\n" +
"        .btn-bd-primary {\n" +
"            --bd-violet-bg: #712cf9;\n" +
"            --bd-violet-rgb: 112.520718, 44.062154, 249.437846;\n" +
"\n" +
"            --bs-btn-font-weight: 600;\n" +
"            --bs-btn-color: var(--bs-white);\n" +
"            --bs-btn-bg: var(--bd-violet-bg);\n" +
"            --bs-btn-border-color: var(--bd-violet-bg);\n" +
"            --bs-btn-hover-color: var(--bs-white);\n" +
"            --bs-btn-hover-bg: #6528e0;\n" +
"            --bs-btn-hover-border-color: #6528e0;\n" +
"            --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);\n" +
"            --bs-btn-active-color: var(--bs-btn-hover-color);\n" +
"            --bs-btn-active-bg: #5a23c8;\n" +
"            --bs-btn-active-border-color: #5a23c8;\n" +
"        }\n" +
"\n" +
"        .bd-mode-toggle {\n" +
"            z-index: 1500;\n" +
"        }\n" +
"\n" +
"        .bd-mode-toggle .dropdown-menu .active .bi {\n" +
"            display: block !important;\n" +
"        }\n"
                    + ".form-container {\n" +
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
"    input[type=\"text\"], input[type=\"date\"], input[type=\"email\"], input[type=\"file\"], input[type=\"time\"] {\n" +
"        width: 100%;\n" +
"        padding: 10px;\n" +
"        border: 1px solid #ddd;\n" +
"        border-radius: 8px;\n" +
"        background-color: #f9f9f9;\n" +
"        transition: all 0.3s ease;\n" +
"    }\n" +
"    select\n" +
"    {\n" +
"        color: grey;\n" +
"        width: 100%;\n" +
"        padding: 12px;\n" +
"        border: 0px solid #ddd;\n" +
"        border-radius: 8px;\n" +
"        background-color: #f9f9f9;\n" +
"        transition: all 0.3s ease;\n" +
"         outline: none;\n" +
"        border-color: #7e42e3;\n" +
"        background-color: #fff;\n" +
"\n" +
"    }\n" +
"    input[type=\"text\"]:focus, input[type=\"date\"]:focus, input[type=\"email\"]:focus, input[type=\"file\"]:focus, input[type=\"time\"]: focus {\n" +
"        outline: none;\n" +
"        border-color: #7e42e3;\n" +
"        background-color: #fff;\n" +
"    }\n" +
"    .submit-btn, .link-btn {\n" +
"        background-color: #7e42e3;\n" +
"        color: white;\n" +
      
"        border: none;\n" +
"        border-radius: 8px;\n" +
"        font-size: 18px;\n" +
"        cursor: pointer;\n" +
"        transition: background-color 0.3s ease;\n" +
"        text-align: center;\n" +
"        text-decoration: none;\n" +
"        display: inline-block;\n"
                    + "width : 100px;"
                    + "heigth : 40px;" +
                    
"    }\n" +
"    .submit-btn:hover, .link-btn:hover {\n" +
"        background-color: #5c31c9;\n" +
"    }\n" +
"    .button-container {\n" +
"        margin-top: 20px;\n" +
"        display: flex;\n" +
"        justify-content: space-around;\n" +
"    }"
                    + " </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\" style=\"background: linear-gradient(to right,#B06DC4 ,#3F3DBF, #B06DC4  ); position: relative; margin-top: 5px;\">\n" +
"    <header class=\"d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom\">\n" +
"        <a href=\"/\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none\">\n" +
"            <span class=\"fs-4\" > <img src=\"\" width=70px height=60px> <b style=\"color: white; font-size: 38px; padding : 5px;\">E-Bus Pass</b></span>\n" +
"        </a>\n" +
"        <ul class=\"nav nav-pills\">\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link active\" aria-current=\"page\" style=\"border-radius: 20px; height: 45px; width: 140px; padding: 5px 43px; font-size: 25px; font-family: monospace; background-color:  #B06DC4; border : 1px white; color : white;\">Home</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">Features</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">Pricing</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">FAQs</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">About</a></li>\n" +
"        </ul>\n" +
"    </header>\n" +
"    <div class=\"container1\" style=\"background-color: #DFCFE4;; border-radius: 18px;\">\n" +
"        <div class=\"row\">\n" +

"            <div class=\"col-12\" style=\"text-align : left;\">");
            try
            {
                Connection con = DataBaseConnection.initailisedDatabase();
                PreparedStatement st = con.prepareStatement("SELECT * FROM Conductor where ConductorId='"+did+"' ;");
                ResultSet rs = st.executeQuery();
                out.println("<div class=\"container form-container\">\n" +
"             <div class=\"header\">\n" +
"            <h1>E-Bus Pass</h1>\n" +
"            <h4>Conductor Form</h4>\n" +
"        </div>");
                while(rs.next()) {
    String id = rs.getString("Id");
    String dids = rs.getString("ConductorId");
    String dname = rs.getString("ConductorName");
    String dnum = rs.getString("ConductorNumber");
    String daddress = rs.getString("ConductorAddress");
    String busno = rs.getString("BusRouteNumber");
    String dbusro = rs.getString("BusRoute");
    String dst = rs.getString("StartTime");
    String det = rs.getString("EndTime");
    String dl = rs.getString("DrivingLicense");

    out.println("\n" +
"        <!-- Existing form fields here -->\n" +
"\n" +
"        <!-- New Driver's Information Section -->\n"
            + "<input type='hidden' value="+dids+" name='DriverId'>"
                    + "<input type='hidden' value="+dl+" name='DriverLicense'>" + 
"        <br>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"drivername\">Enter Conductor's Name:</label>\n" +
"                <input type=\"text\" name=\"conductorname\" value="+dname+" required>\n" +
"            </div>\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"driverid\">Enter Conductor's ID:</label>\n" +
"                <input type=\"text\" name=\"conductorid\" value="+dids+" >\n" +
"            </div>\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"drivernum\">Enter Conductor's Phone Number:</label>\n" +
"                <input type=\"text\" name=\"conductornum\" value="+dnum+" >\n" +
"            </div>\n" +
"        </div>\n" +
"        <br>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-md-12\">\n" +
"                <label for=\"driveraddress\">Enter Conductor's Address:</label>\n" +
"                <input type=\"text\" name=\"conductoraddress\" value="+daddress+" >\n" +
"            </div>\n" +
"        </div>\n" +
"        \n" +
"        <br>\n" +
"    \n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"busrouteno\">Select Bus Route No:</label>\n" +
"                <input type=\"text\" name=\"busrouteno\" value="+busno+">\n" +
"            </div>\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"busroute\">Select Bus Route:</label>\n" +
"                <input type=\"text\" name=\"busroute\" value="+dbusro+" >\n" +
"            </div>\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"starttime\">Start Time:</label>\n" +
"                <input type=\"time\" name=\"starttime\" value="+dst+">\n" +
"            </div>\n" +
"        </div>\n" +
"\n" +
"        <br>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-md-4\">\n" +
"                <label for=\"endtime\">End Time:</label>\n" +
"                <input type=\"time\" name=\"endtime\" value="+det+">\n" +
"            </div>\n" +
"        </div>\n" +
"        <br>\n"+"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <label for=\"uaadhar\">Uploaded Aadhar Card:</label>\n" +
"                    <a href=\"Documents/" + dl + "\" target=\"_blank\">View DrivingLicense <i class=\"fas fa-eye\"></i></a>\n" +
"                </div>\n" +
"            </div>\n" +
"            <br><br>\n" +
"\n" +
"\n" +
"        <br><br>\n" +

"\n" +
"    \n" +
"</div>");               
                }     
            }
            catch(Exception e)
            {
                out.println(e);
            }
            
            out.println("</div>\n" +
"\n" +
"            \n" +
"</div>\n" +
"\n" +
"            </div>\n" +

"        </div>\n" +
"\n" +
"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n" +
"");
            
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
            Logger.getLogger(PassFormFilled.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PassFormFilled.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PassFormFilled.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PassFormFilled.class.getName()).log(Level.SEVERE, null, ex);
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
