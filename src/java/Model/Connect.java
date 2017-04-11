/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author phuoc
 */
public class Connect {
    public ArrayList<DanhBa> list=new ArrayList<>();
    Connection con=null;
    public void connectCSDL(){
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyDanhBa","sa","123456");
           
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void TruyVan(String sql){
        
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DanhBa db=new DanhBa();
                db.tentheubao=rs.getString("TenTheuBao");
                db.sdt=rs.getString("SoDienThoai");
                db.diachi=rs.getString("DiaChi");
                list.add(db);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("loi" + e + e.getMessage());

        }
        
        
        
    }
    
   
      public void Insert(String ten,String sdt,String diachi) throws SQLException{
        int a=0;
        connectCSDL();
        String sql="insert into DanhBa(TenTheuBao,SoDienThoai,DiaChi) values (?,?,?)";
            PreparedStatement ps=null;
        
        try {
            ps=con.prepareStatement(sql);
             ps.setString(1,ten);
             ps.setString(2,sdt);
            ps.setString(3,diachi);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
        }
     }
       
      
      
      
      
       
    
    

