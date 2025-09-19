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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class EditBusRoute2 extends HttpServlet {

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
        String Id = request.getParameter("Id");
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
"    input[type=\"text\"], input[type=\"date\"], input[type=\"email\"], input[type=\"file\"], input[type=\"time\"] {\n" +
"        width: 100%;\n" +
"        padding: 10px;\n" +
"        border: 1px solid #ddd;\n" +
"        border-radius: 8px;\n" +
"        background-color: #f9f9f9;\n" +
"        transition: all 0.3s ease;\n" +
"    }\n" +
"    input[type=\"text\"]:focus, input[type=\"date\"]:focus, input[type=\"email\"]:focus, input[type=\"file\"]:focus, input[type=\"time\"]:focus {\n" +
"        outline: none;\n" +
"        border-color: #7e42e3;\n" +
"        background-color: #fff;\n" +
"    }\n" +
"    .submit-btn {\n" +
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
            out.println("<div class=\"container form-container\">\n"
                    + " <div class=\"header\">\n" +
"        <h1>Bus Route Management</h1>\n" +
"        <h4>Route & Timing Form</h4>\n" +
"    </div>\n" +
"    " );
            try
            {
                Connection con = DataBaseConnection.initailisedDatabase();
                PreparedStatement st = con.prepareStatement("select * from BusRoute where Id='"+Id+"' ;");
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    String id = rs.getString("Id");
            String busrouteno = rs.getString("BusRouteNo");
            String busnumber = rs.getString("BusNumber");
            String busroute = rs.getString("BusRoute");
            String starttime = rs.getString("StartTime");
            String endtime = rs.getString("EndTIme");
            
            out.println("<form method='post' action='./EditBusRoute3'>"
                    + "<input type='hidden' value="+id+" name='Id' >"
                    + "<div class=\"row\">\n" +
"            <div class=\"col-3\">\n" +
"                <label for=\"busrouteno\">Bus Route No:</label>\n"
                    + "<input type=\"text\" name=\"busrouteno\" value="+busrouteno+">" +

"            </div>\n" +
"            <div class=\"col-3\">\n" +
"                <label for=\"busnumber\">Bus Number:</label>\n" +
"                <input type=\"text\" name=\"busnumber\" value="+busnumber+" >\n" +
"            </div>\n" +
"            <div class=\"col-3\">\n" +
"                <label for=\"busroute\">Bus Route:</label>\n"
        + "<input type=\"text\" name=\"busroute\" value="+busroute+">" +

"            </div>\n" +
"        </div>\n" +
"\n" +
"        <br>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-md-3\">\n" +
"                <label for=\"starttime\">Start Time:</label>\n" +
"                <input type=\"time\" name=\"starttime\" value="+starttime+">\n" +
"            </div>\n" +
"            <div class=\"col-md-3\">\n" +
"                <label for=\"endtime\">End Time:</label>\n" +
"                <input type=\"time\" name=\"endtime\" value="+endtime+">\n" +
"            </div>\n" +
"        </div>\n"
        + "<br><br><br>"
        + "<div class=\"row justify-content-center\">\n" +
"            <button type=\"submit\" class=\"submit-btn\">Edit</button>\n" +
"        </div>"
        + "</form>" +
"        ");
            
            
            

                }
                out.println(" </div></div>");
                
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
