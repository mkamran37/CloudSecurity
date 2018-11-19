<%@page import="java.sql.*"%>
<%@page import="databaseconnection.*"%>
<%@ page session="true" %>
<%
    String username = request.getParameter("username");
    System.out.println(username);
    String password = request.getParameter("password");
    System.out.println(password);
    try{
       
        String user=null;
        //String password=null;
        Connection con=databasecon.getconnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from cloudb where username='"+username+"' and password='"+password+"'");
       if(rs.next())
        {
           user = rs.getString(2);
		   session.setAttribute("user",user);
		   System.out.println("User:"+user);
                   
			response.sendRedirect("cloudbhome.jsp?msg=login success");
        }
       else 
        {
            response.sendRedirect("cloudb.jsp?m1=LoginFail");
                }
	}
    catch(Exception e)
    {
        System.out.println("Error in emplogact"+e.getMessage());
    }
%>