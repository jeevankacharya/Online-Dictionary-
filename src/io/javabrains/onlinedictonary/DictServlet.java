package io.javabrains.onlinedictonary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DictServlet")
public class DictServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String data="";

        try {
            Connection con = DatabaseConnection.initializeDatabase();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from entries");
            while(rs.next())
                data= data + rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"\n";
            con.close();
//            System.out.println("Data obtained");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        String text = "some text";

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(data);
    }
}
