/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankproject.DAO;
import com.bankproject.Services.DataBaseConnection;
import com.bankproject.models.AdminModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO {
   public static ArrayList<AdminModel> getData( ){
       Connection con  = null;
       ArrayList<AdminModel> am=new ArrayList<AdminModel>();
       try{
           con = DataBaseConnection.getConnection();
           String sql = "select * from admin";
           
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               String adminID=rs.getString(1);
               String adminPassword= rs.getString(2);
               AdminModel a=new AdminModel(adminID, adminPassword);
               am.add(a);
           }
       }
       catch(Exception e){
           System.out.println("Something went wrong!");
       }
       return am;
   }
}
