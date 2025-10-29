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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SBusRoute extends HttpServlet {

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
        //String id = request.getParameter("Id");
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
"        }\n" +
"    table {\n" +
"        width: 93%;\n" +
"        border-collapse: collapse;\n" +
"        margin-top: 40px;"
                    + "margin-right : 0px;\n" +
"    }\n" +
"    th, td {\n" +
"        border: 1px solid #ddd;\n" +
"        padding: 16px;\n" +
"        text-align: left;\n" +
"    }\n" +
"    th {\n" +
"        background-color: #f2f2f2;\n" +
"        color: #333;\n" +
"    }\n" +
"    tr:nth-child(even) {\n" +
"        background-color: #f9f9f9;\n" +
"    }\n" +
"    tr:hover {\n" +
"        background-color: #f1f1f1;\n" +
"    }\n" +
"    .action-btn {\n" +
"        padding: 5px 10px;\n" +
"        margin: 0 5px;\n" +
"        text-decoration: none;\n" +
"        border-radius: 4px;\n" +
"        color: white;\n" +
"    }\n" +
"    .view-btn { background-color: #4CAF50; }\n" +
"    .edit-btn { background-color: #FFA500; }\n" +
"    .delete-btn { background-color: #f44336; }\n" +
"    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\" style=\"background: linear-gradient(to right,#B06DC4 ,#3F3DBF, #B06DC4  ); position: relative; margin-top: 5px;\">\n" +
"    <header class=\"d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom\">\n" +
"        <a href=\"/\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none\">\n" +
"            <span class=\"fs-4\" > <img src=\"./images/logo.png\" width=70px height=60px> <b style=\"color: white; font-size: 38px; padding : 5px;\">E-Bus Pass</b></span>\n" +
"        </a>\n" +
"        <ul class=\"nav nav-pills\">\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link active\" aria-current=\"page\" style=\"border-radius: 20px; height: 45px; width: 140px; padding: 5px 43px; font-size: 25px; font-family: monospace; background-color:  #B06DC4; border : 1px white; color : white;\">Home</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">Features</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">Pricing</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">FAQs</a></li>\n" +
"            <li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" style=\"color: white; font-size: 20px;\">About</a></li>\n" +
"        </ul>\n" +
"    </header>\n" +
"    <div class=\"container1\" style=\"background-color: white; border-radius: 18px;\">\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-3\" style=\"text-align: left;\">\n" +
"                <div class=\"d-flex flex-column flex-shrink-0 p-3\" style=\"width: 260px;height: 700px; background-color: #3F3DBF; border-radius: 18px 0 0 18px;\">\n" +
"                    <ul class=\"nav nav-pills flex-column mb-auto\">\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a href=\"./AdminHomePage.html\" class=\"nav-link active\" style=\"padding-left: 15px; border-radius: 25px; background-color:  #B06DC4\">\n" +
"                                <i class=\"fa-solid fa-house sidebar-icons\"></i><b style=\"font-size: 18px;\">Home</b>\n" +
"                            </a>\n" +
"                        </li>\n" +
"                        <li>\n" +
"                            <a href=\"./PassFormFilled\" class=\"nav-link text-white\" style=\"margin-top: 7px;\">\n" +
"                                <i class=\"fa-solid fa-file-waveform sidebar-icons\"></i> <b style=\"font-size: 18px;\">E-Bus Pass Form</b>\n" +
"                            </a>\n" +
"                        </li>\n" +

"                        <li>\n" +
"                            <a href=\"#\" class=\"nav-link text-white\">\n" +
"                                <i class=\"fa-solid fa-box-open sidebar-icons\"></i><b style=\"font-size: 18px;\">LostAndFind </b>\n" +
"                            </a>\n" +
"                        </li>\n"
                    + "<li>\n" +
"                            <a href=\"./UDriver\" class=\"nav-link text-white\">\n" +
"                                <i class=\"fa-solid fa-box-open sidebar-icons\"></i><b style=\"font-size: 18px;\">Drivers </b>\n" +
"                            </a>\n" +
"                        </li>\n" +
"                         <li>\n" +
"                            <a href=\"./BusRoute\" class=\"nav-link text-white\">\n" +
"                                <i class=\"fa-solid fa-box-open sidebar-icons\"></i><b style=\"font-size: 18px;\">Bus Routes </b>\n" +
"                            </a>\n" +
"                        </li>" +
"                    </ul>\n" +
"                    <hr>\n" +
"                    <br><br><br>\n" +
"                    <div class=\"dropdown\" style=\"padding-left : 15px;\">\n" +
"                        <a href=\"#\" class=\"d-flex align-items-center text-white text-decoration-none dropdown-toggle\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
"                            <img src=\"https://github.com/mdo.png\" alt=\"\" width=\"32\" height=\"32\" class=\"rounded-circle me-2\">\n" +
"                            <strong><b>Profile</b></strong>\n" +
"                        </a>\n" +
"                        <ul class=\"dropdown-menu dropdown-menu-dark text-small shadow\">\n" +
"                            \n" +
"                            <li><a class=\"dropdown-item\" href=\"#\">Settings</a></li>\n" +
"                            <li><a class=\"dropdown-item\" href=\"#\">Profile</a></li>\n" +
"                            <li><hr class=\"dropdown-divider\"></li>\n" +
"                            <li><a class=\"dropdown-item\" href=\"#\">Sign out</a></li>\n" +
"                        </ul>\n" +
"                    </div>\n" +
"                    <br>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"col-9\" style=\"text-align : left;\">");
            try
            {
                Connection con = DataBaseConnection.initailisedDatabase();
                PreparedStatement st = con.prepareStatement("SELECT * FROM busroute ;");
                ResultSet rs = st.executeQuery();
                out.println("<table>");
out.println("    <thead>");
out.println("        <tr>");
//out.println("            <th>ID</th>");
out.println("            <th>Id</th>");
out.println("            <th>BusRouteNo</th>");
out.println("            <th>BusNumber</th>");

out.println("            <th>BusRoute</th>"); 
out.println("            <th>Start<br>Time</th>");
out.println("            <th>End<br>Time</th>");


out.println("        </tr>");
out.println("    </thead>");
out.println("    <tbody>");
                while(rs.next()) {
    String id = rs.getString("Id");
    String did = rs.getString("BusRouteNo");
    String dname = rs.getString("BusNumber");
    String daddress = rs.getString("BusRoute");

 
    String dst = rs.getString("StartTime");
    String det = rs.getString("EndTime");
    //String dl = rs.getString("DrivingLicense");

    out.println("        <tr>");
    out.println("            <td>" + id + "</td>");
    out.println("            <td>" + did + "</td>");
    out.println("            <td>" + dname + "</td>");
    out.println("            <td>" + daddress + "</td>");

       out.println("            <td>" + dst + "</td>");
       out.println("            <td>" + det + "</td>");
        //out.println("            <td><a href=\"Documents/" + dl + "\" target=\"_blank\">View DrivingLicense <i class=\"fas fa-eye\"></i></a></td>");
         
    out.println("        </tr>");
}

out.println("    </tbody>");
out.println("</table>");               
                
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
"            <br>\n" +
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
