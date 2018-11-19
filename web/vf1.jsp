
<%@page import="java.sql.*"%>
<%@page import="databaseconnection.databasecon"%>
<%@ page session="true" %>
   
    <body>
     
        

<%@page import="action.decryption"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="action.Dbconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<center><p></p></center>
                    <center> 
                        <% 
                             //String username=session.getAttribute("username").toString();
                      String email=session.getAttribute("email").toString();
                    String  filename=request.getParameter("filename");
                   String  data=request.getParameter("data");
                   String  owner=request.getParameter("owner");
                   
                   
                  
                   
               
                            
        try {
        Connection con;
        Statement st;
        con = Dbconnection.getConnection();
        st = con.createStatement();
        int j = st.executeUpdate("insert into request(filename, data, owner,status,email) values ('"+filename+"','"+data+"','"+owner+"','No','"+email+"')");
        if (j != 0) {

            response.sendRedirect("vf.jsp?msg=Request_sent_to_CloudB");
        } else {
            response.sendRedirect("vf.jsp?m1=Request_failed");
        }



    } catch (Exception ex) {
        response.sendRedirect("vf.jsp?msgb=You_hava_already_given_request");
        ex.printStackTrace();
    }
%>