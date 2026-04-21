import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class BookServlet extends HttpServlet {

    // ===================== DISPLAY =====================
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Book Store</h2>");

        // 🔹 EDIT FORM (ONLY SHOW WHEN CLICKED)
        String editId = request.getParameter("editId");

        if (editId != null) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String price = request.getParameter("price");
            String qty = request.getParameter("qty");

            out.println("<h3>Edit Book</h3>");
            out.println("<form action='books' method='post'>");

            out.println("<input type='hidden' name='id' value='" + editId + "'>");
            out.println("Title: <input type='text' name='title' value='" + title + "'><br>");
            out.println("Author: <input type='text' name='author' value='" + author + "'><br>");
            out.println("Price: <input type='text' name='price' value='" + price + "'><br>");
            out.println("Quantity: <input type='text' name='qty' value='" + qty + "'><br>");

            out.println("<input type='submit' name='action' value='update'>");
            out.println("</form><hr>");
        }

        // 🔹 ADD FORM
        out.println("<h3>Add New Book</h3>");
        out.println("<form action='books' method='post'>");

        out.println("ID: <input type='text' name='id'><br>");
        out.println("Title: <input type='text' name='title'><br>");
        out.println("Author: <input type='text' name='author'><br>");
        out.println("Price: <input type='text' name='price'><br>");
        out.println("Quantity: <input type='text' name='qty'><br>");

        out.println("<input type='submit' name='action' value='add'>");
        out.println("</form><hr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore", "root", "Samarpan");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ebookshop");

            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Qty</th><th>Action</th></tr>");

            while (rs.next()) {
                out.println("<tr>");

                int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                int qty = rs.getInt(5);

                out.println("<td>" + id + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + author + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("<td>" + qty + "</td>");

                out.println("<td>");

                // ❌ DELETE
                out.println("<form action='books' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<input type='submit' name='action' value='delete'>");
                out.println("</form>");

                // ✏️ EDIT
                out.println("<form action='books' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<input type='hidden' name='title' value='" + title + "'>");
                out.println("<input type='hidden' name='author' value='" + author + "'>");
                out.println("<input type='hidden' name='price' value='" + price + "'>");
                out.println("<input type='hidden' name='qty' value='" + qty + "'>");
                out.println("<input type='submit' name='action' value='edit'>");
                out.println("</form>");

                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            con.close();

        } catch (Exception e) {
            out.println("Error: " + e);
        }

        out.println("</body></html>");
    }

    // ===================== ACTION =====================
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore", "root", "Samarpan");

            // ➕ ADD
            if (action.equals("add")) {

                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                double price = Double.parseDouble(request.getParameter("price"));
                int qty = Integer.parseInt(request.getParameter("qty"));

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ebookshop VALUES (?, ?, ?, ?, ?)");

                ps.setInt(1, id);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.setDouble(4, price);
                ps.setInt(5, qty);

                ps.executeUpdate();
            }

            // ❌ DELETE
            else if (action.equals("delete")) {

                int id = Integer.parseInt(request.getParameter("id"));

                PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM ebookshop WHERE book_id=?");

                ps.setInt(1, id);
                ps.executeUpdate();
            }

            // ✏️ EDIT → Redirect to form
            else if (action.equals("edit")) {

                String id = request.getParameter("id");
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String price = request.getParameter("price");
                String qty = request.getParameter("qty");

                response.sendRedirect("books?editId=" + id +
                        "&title=" + title +
                        "&author=" + author +
                        "&price=" + price +
                        "&qty=" + qty);
                return;
            }

            // 🔥 FULL UPDATE
            else if (action.equals("update")) {

                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                double price = Double.parseDouble(request.getParameter("price"));
                int qty = Integer.parseInt(request.getParameter("qty"));

                PreparedStatement ps = con.prepareStatement(
                    "UPDATE ebookshop SET book_title=?, book_author=?, book_price=?, quantity=? WHERE book_id=?");

                ps.setString(1, title);
                ps.setString(2, author);
                ps.setDouble(3, price);
                ps.setInt(4, qty);
                ps.setInt(5, id);

                ps.executeUpdate();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("books");
    }
}