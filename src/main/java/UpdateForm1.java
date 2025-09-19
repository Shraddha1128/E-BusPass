import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateForm1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateForm</title>");            
            out.println("</head>");
            out.println("<body>");

            // Retrieving parameters
            String id = request.getParameter("Id");
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
            String year = request.getParameter("year");
            String busno = request.getParameter("busno");
            String busroute = request.getParameter("busroute");
            String taddress = request.getParameter("taddress");
            String paddress = request.getParameter("paddress");
            
            // Directly retrieve parameters without null checks
           String ubona = request.getParameter("ubona");
if (ubona == null || ubona.isEmpty()) {
    ubona = request.getParameter("Bonafide");
}

String ucollid = request.getParameter("ucollid");
if (ucollid == null || ucollid.isEmpty()) {
    ucollid = request.getParameter("UploadCollegeId");
}

String ufee = request.getParameter("ufee");
if (ufee == null || ufee.isEmpty()) {
    ufee = request.getParameter("CollegeReciept");
}

String ubusfee = request.getParameter("ubusfee");
if (ubusfee == null || ubusfee.isEmpty()) {
    ubusfee = request.getParameter("CollegeBusReciept");
}

String uaadhar = request.getParameter("uaadhar");
if (uaadhar == null || uaadhar.isEmpty()) {
    uaadhar = request.getParameter("AadharCard");
}

String uphoto = request.getParameter("uphoto");
if (uphoto == null || uphoto.isEmpty()) {
    uphoto = request.getParameter("Photo");
}

// Database connection and update
Connection con = null;
PreparedStatement st = null;

try {
    con = DataBaseConnection.initailisedDatabase();
    String updateQuery = "UPDATE studentinfo SET FirstName=?, MiddleName=?, LastName=?, "
            + "CollegeName=?, CollegeId=?, BirthDate=?, Email=?, StartDate=?, EndDate=?, "
            + "Year=?, BusNo=?, BusRoute=?, TAddress=?, PAddress=?, UploadCollegeId=?, "
            + "Bonafide=?, CollegeReciept=?, CollegeBusReciept=?, AadharCard=?, Photo=? "
            + "WHERE Id='"+id+"'";  // Use prepared statement for ID

    st = con.prepareStatement(updateQuery);
    // Set parameters for the prepared statement
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

    // Set AadharCard parameter
    
        st.setString(19, uaadhar);
    

    st.setString(20, uphoto);
   // st.setString(21, id); // Set ID for WHERE clause

    st.executeUpdate();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('Form has been updated successfully.');");
    out.println("window.location.href = './StudentHomePage.html';"); 
    out.println("</script>");
    
} catch (ClassNotFoundException | SQLException e) {
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
