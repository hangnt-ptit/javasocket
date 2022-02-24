/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hethongltonline;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class MainServer {    
    
    public static void main(String[] args) {
        new AuthLogin().start();
        new Thread(new getQuestion()).start();
    }
}
    
// port 13333 su dung de giup client ket noi voi server, login bang MSV
class AuthLogin extends Thread{

        @Override
        public void run() {
            boolean connect = false;
        
        try {
            ServerSocket server = new ServerSocket(13333);
            System.out.println("Server is ready...");
            while(true){
                Socket conn = server.accept();
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                System.out.println("Server Connnected To Client!");

                String strUsername = dis.readUTF();
                String strPassword = dis.readUTF();
                
                if(strUsername.equals(strPassword) != true){
                    connect = false;
                }
                else{
                    if(ConnectToDatabase.getMaSV(strUsername) != true){
                        connect = false;
                    }
                    else 
                        connect = true;
                }
                
                dos.writeBoolean(connect);
                
                dis.close();
                dos.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        
    }

// port 13334 ket noi client voi server de lay cau hoi.
class getQuestion implements Runnable{

        @Override
        public void run() {
            try {
                ServerSocket server1 = new ServerSocket(13334);
                System.out.println("Server is ready....");
                
                while(true){
                    Socket conn = server1.accept();
                    
                    DataInputStream dis = new DataInputStream(conn.getInputStream());
                    String examCode = dis.readUTF();
                    
                    System.out.println(examCode);
                    
                    ArrayList<String> listq = null;
                    try {
                        listq = (ArrayList<String>) ConnectToDatabase.getQuestion(examCode);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    
                    
                    
                    ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
                    oos.writeObject(listq);
                    
                    dis.close();
                    oos.close();
                    conn.close();
                }   
            } catch (IOException ex) {
                ex.printStackTrace();  
            }
        }
        
        
    }
