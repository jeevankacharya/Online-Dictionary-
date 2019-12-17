package io.javabrains.onlinedictonary;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DictServlet")
public class DictServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            Entry entry = EntryDbUtil.getData(request.getParameter("lookup"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(entry));
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        /*try {
            String searchText = request.getParameter("lookup");
            Connection con = DatabaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from entries where word='" + searchText + "'");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(rs.toString())); //this is how simple GSON works


//            while (rs.next())
//                data.append(rs.getString(1)).append("  ").append(rs.getString(2)).append("  ").append(rs.getString(3)).append("\n");
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


//        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
//        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//        response.getWriter().write(data.toString());


*/    }

}
