/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
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
public class Login extends HttpServlet {

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
        String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String role = request.getParameter("role");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUp</title>");            
            out.println("</head>");
            out.println("<body>");
            int flag = 0;
            String nam = "";
             String use ="";
             String pas = "";
             String rol = "";
             String emai = "";
            try
            {
                Connection con = DataBaseConnection.initailisedDatabase();
                PreparedStatement st = con.prepareStatement("select * from users where UserName='"+user+"' AND Password='"+pass+"' AND Role='"+role+"';");
                ResultSet rs = st.executeQuery();
                if(rs.next())
                {
                    nam = rs.getString("Name");
                    use = rs.getString("UserName");
                    pas = rs.getString("Password");
                    rol = rs.getString("Role");
                    emai = rs.getString("Email");
                    flag = 1;
                    
                }
                if(flag==1)
                {
                    if(role.equals("Administrator"))
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("name",nam);
                        session.setAttribute("user", use);
                        session.setAttribute("email", emai);
                        
                        
                        response.sendRedirect("./AdminHomePage.html");
                    }
                    else if(role.equals("Bus Driver/Conductor"))
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("name",nam);
                        session.setAttribute("user", use);
                       session.setAttribute("email", emai);
                        response.sendRedirect("./DriverHomePage.html");                        
                    }
                    else
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("name",nam);
                        session.setAttribute("user", use);
                        session.setAttribute("email", emai);
                        response.sendRedirect("./StudentHomePage.html");  
                    }
                }
                else
                {
                    
                    RequestDispatcher rd = request.getRequestDispatcher("./index.html");
                    out.print("<script type='text/javascript'>");
                    out.print("alert('Incorrect UserName or Password');");
                    out.print("</script>");
                    rd.include(request, response);
                  
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
