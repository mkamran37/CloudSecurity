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
       
        Connection con=databasecon.getconnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from owner where username='"+username+"' and password='"+password+"'");
       if(rs.next())
        {
           user = rs.getString(2);
		   session.setAttribute("user",user);
		   System.out.println("User:"+user);
                   
			response.sendRedirect("ownerhome.jsp?msg=Login Success...!");
        }
       else 
        {
            response.sendRedirect("owner.jsp?m1=LoginFail");
        }
	}
    catch(Exception e)
    {
        System.out.println("Error in emplogact"+e.getMessage());
    }
%>