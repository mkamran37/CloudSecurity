 <%@page import="action.encryption"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="javax.crypto.SecretKey"%>
<%@page import="javax.crypto.KeyGenerator"%>
<%@page import="java.util.Random"%>
<%@page import="action.Mail"%>
<%@page import="action.decryption"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="action.Dbconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                                keyGen.init(128);
                               SecretKey secretKey = keyGen.generateKey();
                                System.out.println("secret key:" + secretKey);
                              // converting secretkey to String
                                byte[] be = secretKey.getEncoded();//encoding secretkey
                               String skey = Base64.encode(be);
                                System.out.println("converted secretkey to string:" + skey);
                               // String cipher = new encryption().encrypt(str, secretKey)
    
    
    
    
    String filename=request.getParameter("filename");
     String owner=request.getParameter("owner");
      String data=request.getParameter("data");
      
      Random r= new Random();
      int i=r.nextInt(10000 - 5000) + 5000;
      String publickey = i+"";
      //String msg = "File name :"+filename+"\nDecryption Key :"+dkey;
      Random r1= new Random();
      int i1=r1.nextInt(10000 - 5000) + 5000;
      String privatekey = i1+"";
      
      try{
           Connection con = Dbconnection.getConnection();
                            Statement st = con.createStatement();
       
                            int j = st.executeUpdate("insert into keygen(filename,owner,data,dkey,privatekey)values('"+filename+"','"+owner+"','"+data+"','"+publickey+"','"+skey+"')");
    
      if (j !=0){
         // Mail m = new Mail();
         // m.secretMail(msg,filename,filename);
          response.sendRedirect("cloudaviewfiles.jsp?msg=success");
      }
      else{
          response.sendRedirect("cloudaviewfiles.jsp?msgg=Failed");
      }
    
} catch (Exception ex) {
    response.sendRedirect("cloudaviewfiles.jsp?g=Already Generated");
                                        ex.printStackTrace();
                                    }

                                %>
    