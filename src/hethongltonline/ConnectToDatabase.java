/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hethongltonline;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class ConnectToDatabase {
    
    private static String serverName = "localhost";
    private static String dbName = "LAPTRINHMANG";
    private static String port = "1433";
    private static String instance = "";
    private static String user = "sa";
    private static String password = "hangnt2508";
    
    // ham ket noi server voi database
    public static Connection getSQLConnection() throws ClassNotFoundException, SQLException{
        String url = "jdbc:sqlserver://" + serverName + ":" + 
                port + "\\" + instance + ";databaseName=" +
                dbName;
        
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + 
                port + ";databaseName=" +
                dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, password);
    }
    
    // ham check ma sinh vien co ton tai trong csdl khong
    public static boolean getMaSV(String str) throws ClassNotFoundException, SQLException{
        
        boolean check = false;
        
        Connection conn = getSQLConnection();
        
        String query = "select MSV from SINHVIEN where MSV = '" + str + "'";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        
        ArrayList<String> arr = new ArrayList<String>();
        
        while(rs.next()){           
            arr.add(rs.getString("MSV"));
        }
        if(arr.isEmpty()){
            check = false;
        }
        else check = true;
    return check;
    }
    
    //ham dung de lay cau hoi tu Database
    public static List<String> getQuestion(String n) throws ClassNotFoundException, SQLException{
        List<String> listQuestion = new ArrayList<String>();
        
        int[] soCau = new int[100];
        Arrays.fill(soCau, 1000);
        
        Random rand = new Random();
        
        Connection conn = getSQLConnection();
        String query = "select CAUHOI,NOIDUNG,CAUA,CAUB,CAUC,CAUD,DAPAN from LTW_" + n;
        
        
        int count = 0;
        
        while(count < 4){
            int k = rand.nextInt(100);
            if(soCau[k] != 1){
                soCau[k] = 1;
                count++;
            }
        }
        
        count = -1;
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
            if(soCau[count] > 0){
                listQuestion.add(rs.getString("CAUHOI"));
                listQuestion.add(rs.getString("NOIDUNG"));
                listQuestion.add(rs.getString("CAUA"));
                listQuestion.add(rs.getString("CAUB"));
                listQuestion.add(rs.getString("CAUC"));
                listQuestion.add(rs.getString("CAUD"));
                listQuestion.add(rs.getString("DAPAN"));
            }
        }
        return listQuestion;
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    }
}
