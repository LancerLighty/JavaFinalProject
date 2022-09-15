package com.example.finaltask;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "MySQL", value = "/MySQL")
public class MySQL {
    // ------------------ MySQL Info ------------------
    private static final String PORT = "3306";
    private static final String DATABASE_NAME = "userdb";
    private static final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DATABASE_NAME;
    private static final String PASSWORD = "teklemamporia2007";
    private static final String USERNAME = "root";
    private static final String TABLE_NAME = "User";

    public String findInfo(String whatToSearch, String name, String whatToReturn) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String info = null;
        try {
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + TABLE_NAME + " where " + whatToSearch + " = \"" + name + "\"");
            while(rs.next()) {
                info = rs.getString(whatToReturn);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("დაერორდა შემდეგი ერორით: " + e);
        }
        return info;
    }
    public void insertInfo(String a, String b, String c, String d, String e, String f, String g) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String insert = "insert into User (id, name, surname, username, email, password, profession) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setString(4, d);
            pstmt.setString(5, e);
            pstmt.setString(6, f);
            pstmt.setString(7, g);
            pstmt.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
