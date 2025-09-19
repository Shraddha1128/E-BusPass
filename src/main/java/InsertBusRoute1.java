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

public class InsertBusRoute1 extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertBusRoute1</title>");
            out.println("</head>");
            out.println("<body>");
            
            String busrouteno = request.getParameter("busrouteno");
            String busnumber = request.getParameter("busnumber");
            String busroute = request.getParameter("busroute");
            String starttime = request.getParameter("starttime");
            String endtime = request.getParameter("endtime");
            
            Connection con = DataBaseConnection.initailisedDatabase();

            // Check if the bus route already exists
            PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM busroute WHERE BusRouteNo = ? And StartTime=? ANd EndTime=?");
            checkStatement.setString(1, busrouteno);
            checkStatement.setString(2, starttime);
            checkStatement.setString(3, endtime);
            
            ResultSet rs = checkStatement.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            
            if (count > 0) {
                // Route already exists, alert the user
                response.sendRedirect("./BusRoute");
                out.println("<script>alert('Bus route already exists!');</script>");
            } else {
                // Insert new bus route
                PreparedStatement insertStatement = con.prepareStatement("INSERT INTO busroute (BusRouteNo, BusNumber, BusRoute, StartTime, EndTime) VALUES (?, ?, ?, ?, ?)");
                insertStatement.setString(1, busrouteno);
                insertStatement.setString(2, busnumber);
                insertStatement.setString(3, busroute);
                insertStatement.setString(4, starttime);
                insertStatement.setString(5, endtime);
                insertStatement.executeUpdate();
                
                response.sendRedirect("./BusRoute");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // For debugging
        } finally {
            // Ensure database connection is closed (add this if your connection is not managed)
            // con.close(); 
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
            Logger.getLogger(InsertBusRoute1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertBusRoute1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertBusRoute1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertBusRoute1.class.getName()).log(Level.SEVERE, null, ex);
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
