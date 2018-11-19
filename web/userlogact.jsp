<%@page import="java.sql.*"%>
<%@page import="databaseconnection.*"%>
<%@ page session="true" %>
<%
    String email = request.getParameter("email");
    System.out.println(email);
    String password = request.getParameter("password");
    System.out.println(password);
    try{
       
        String user=null;
        //String password=null;
        Connection con=databasecon.getconnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from user where email='"+email+"' and password='"+password+"'");
       if(rs.next())
        {
           email = rs.getString(5);
		   session.setAttribute("email",email);
		   System.out.println("User:"+email);
                   
			response.sendRedirect("userhome.jsp?msg");
        }
       else 
        {
            response.sendRedirect("user.jsp?m1");
                }
	}
    catch(Exception e)
    {
        System.out.println("Error in emplogact"+e.getMessage());
    }
%>