<%@page import="java.sql.*"%>
<%@page import="databaseconnection.*"%>

<html>
<head>
<title>Registration Page</title>

</head>

<body>
<%

String id= request.getParameter("id");
String username= request.getParameter("username");
String password= request.getParameter("password");

String dob= request.getParameter("dob");
String email= request.getParameter("email");

String city= request.getParameter("city");


String contactno=request.getParameter("contactno");




//BigInteger phno = new BigInteger(phoneno);

try
{

Connection con=databasecon.getconnection();

PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
ps.setString(1,id);
ps.setString(2,username);
ps.setString(3,password);
ps.setString(4,dob);
ps.setString(5,email);
ps.setString(6,city);

ps.setString(7,contactno);


ps.executeUpdate();


//out.print(Successfully Registered);

response.sendRedirect("user.jsp?msg=success");
    out.println("USER REGISTERED SUCCESSFULLY");
}
catch(Exception e1)
{
out.println(e1.getMessage());
}


%>
</body>
</html>


