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
public class InsertBusRoute extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String busno = request.getParameter("busno");
            String busname = request.getParameter("busname");
            String starttime = request.getParameter("starttime");
            String endtime = request.getParameter("endtime");
            
            Connection con = null;
            PreparedStatement checkStmt = null;
            PreparedStatement insertStmt = null;
            ResultSet rs = null;
            
            try {
                con = DataBaseConnection.initailisedDatabase();

                // Check if the driver already exists
                checkStmt = con.prepareStatement("SELECT * FROM busroutes WHERE BusNo = ?;");
                checkStmt.setString(1, busno);
                rs = checkStmt.executeQuery();

                if (rs.next()) {
                    // If driver exists, show a message
                    out.println("<h2>Driver with ID " + busno + " already exists!</h2>");
                } else {
                    // If driver doesn't exist, insert the new record
                    insertStmt = con.prepareStatement("INSERT INTO busroutes(BusNumber, BusName, StartTime, EndTime) VALUES (?, ?, ?, ?);");
                    insertStmt.setString(1, busno);
                    insertStmt.setString(2, busname);
                    insertStmt.setString(3, starttime);
                    insertStmt.setString(4, endtime);
                    insertStmt.executeUpdate();
                    out.println("<h2>Bus Routes successfully inserted!</h2>");
                }
            } catch (SQLException e) {
                out.println("<h2>Error: " + e.getMessage() + "</h2>");
            } finally {
                // Close all resources
                if (rs != null) rs.close();
                if (checkStmt != null) checkStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (con != null) con.close();
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
            Logger.getLogger(InsertDrivers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertDrivers.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertDrivers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertDrivers.class.getName()).log(Level.SEVERE, null, ex);
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
