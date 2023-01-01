package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class DBConn {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;

    public DBConn() {
        url = "jdbc:mysql://localhost/virus_shooter";
        uname = "root";
        pass = "root";
        setConnectionAndStatement();
    }

    private void setConnectionAndStatement() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    public ArrayList<DB> getAll() {
        ArrayList<DB> allData = new ArrayList<>();

        try {
            query = "SELECT * FROM virus_shooter ORDER BY score DESC;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String user = rs.getString(1);
                String scores = Integer.toString(rs.getInt(2)) ;
                String dates = rs.getString(3);
                System.out.println("USER: '"+user+ " score: '" + scores +"' "+ "'date: "+dates);
            }
        } catch (SQLException ex) {
            System.err.print("Error getting the data : " + ex.getMessage());
            System.exit(1);
        }
        System.out.println(allData);
        return allData;
    }

    public void save(DB score) {
        try {
            query = "INSERT INTO virus_shooter VALUES('%s','%d','%s')";
            query = String.format(
                    query,
                    score.getGameUser(),
                    score.getScore(),
                    score.getDateTime());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex) {
            System.err.print("Error inserting data : " + ex.getMessage());
            System.exit(1);
        }
    }
}