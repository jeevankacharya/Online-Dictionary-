package io.javabrains.onlinedictonary;

import java.sql.*;

class DatabaseConnection {
    private static Connection con = null;

    static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/entries?useSSL=false", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }


//    public static void main(String args[]){
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con=DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/entries","root","root");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from entries");
//            while(rs.next())
//                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//    }
}
