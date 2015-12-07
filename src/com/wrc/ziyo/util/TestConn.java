/*    */ package com.wrc.ziyo.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ public class TestConn
/*    */ {
/*    */   public static void main(String[] arg)
/*    */   {
/*  8 */     Connection con = null;
/*  9 */     String sql = "select * from tb_users";
/*    */     try
/*    */     {
/* 13 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 14 */       String url = "jdbc:oracle:thin:@192.168.12.189:1521:orcl";
/*    */ 
/* 17 */       con = DriverManager.getConnection(url, "wu", "xiaowu2012");
/*    */ 
/* 20 */       Statement st = con.createStatement();
/* 21 */       ResultSet rs = st.executeQuery(sql);
/* 22 */       while (rs.next()) {
/* 23 */         System.out.println(rs.getString(2));
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 29 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name:     com.wrc.sshFrame.util.TestConn
 * JD-Core Version:    0.6.0
 */