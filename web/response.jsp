<%@page import="action.Mail"%>
<%@page import="java.sql.*"%>
<%@page import="databaseconnection.databasecon"%>
<%@ page session="true" %>

<%   
String filename = request.getParameter("filename");

String email = request.getParameter("email");

String dkey1 = null;
String dkey2 = null;

       // String newfilename = filename+".part0";

try{
    int j =0;
     Connection con = databasecon.getconnection();
                            Statement st = con.createStatement();
                            Statement st1 = con.createStatement();
                            Statement st2 = con.createStatement();
                            ResultSet rs = null;
                            ResultSet rs1 = null;
                            ResultSet rs2 = null;
       rs = st.executeQuery("select owner from request where email='"+email+"' and filename='"+filename+"'");
        
          
          
          while( rs.next())
       {
       rs.getString("owner");
        System.out.println("owner name is   "  + rs.getString("owner")  ); 
         rs1 =st2.executeQuery("select dkey from cloudadata where owner='"+rs.getString("owner")+"' and filename='"+filename+"'");
          rs2 =st1.executeQuery("select dkey from cloudbdata where owner='"+rs.getString("owner")+"' and filename='"+filename+"'");                  
       
          
       
         
          if(rs1.next() && rs2.next() )
        {
         dkey1 =rs1.getString("dkey");
         dkey2 =rs2.getString("dkey");
         System.out.println("key is   "  + rs1.getString("dkey")  );
          j = st.executeUpdate("update request set status= 'yes', dkey1='"+rs1.getString("dkey")+"', dkey2='"+rs2.getString("dkey")+"' where filename='"+filename+"'and email='"+email+"'");
          if (j !=0){
         
              Mail m = new Mail();
          String msg ="File Name:"+filename+"\n cloud-a decryption key :"+dkey1+"  cloud-b decryption key : "+dkey2+"" ;     
          m.secretMail(msg,filename,email);
          response.sendRedirect("vuserreq.jsp?msg=success");
          
        }
          else{
          response.sendRedirect("vuserreq.jsp?m1=Failed");
      }
           }
      
       }
       
       
       
    
      
     
    
} catch (Exception ex) {
  ex.printStackTrace();
   }
   %>
