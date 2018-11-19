<%@page import="action.download1"%>
<%@page import="action.download"%>
<%@page import="java.sql.*"%>
<%@page import="databaseconnection.databasecon"%>
<%@ page session="true" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Internet Business
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Securing Cloud Data under Key Exposure</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<link rel="icon" href="img/architecture.jpg"></link>
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.hslides.1.0.js"></script>
<script type="text/javascript">
$((function () {
    $('#accordion').hSlides({
        totalWidth: 920,
        totalHeight: 300,
        minPanelWidth: 111,
        maxPanelWidth: 911,
		easing: "easeOutBack",
		activeClass: 'current'
    });
}));
</script>
</head>
<body id="top">
<div id="header">
  <div class="wrapper">
    <div class="fl_left">
     
    
    </div>
      <div class="fl_right"><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Securing Cloud Data under Key Exposure</h1> </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div id="topbar">
  <div class="wrapper">
    <div id="topnav">
      <ul>
        <li><a href="user.jsp">Home</a></li>
       
        <li><a href="vf.jsp">View Files</a></li>
     <li><a href="download.jsp">Verify</a></li>
     
     
     <li class="active"><a href="dload.jsp">Download</a></li>
        <li><a href="owner.jsp">Logout</a></li>
        
      </ul>
    </div><br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div id="featured_slide">
  <div class="wrapper">
    <div class="featured_content">
      <ul id="accordion">
        <li class="current">
          






            <br><br><br><br>


<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="action.Dbconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                   <%
                          String[] filename = request.getQueryString().split(",");
                           
                   
                       request.setAttribute("filename",filename[0]);
                       request.setAttribute("owner",filename[0]);
                        
                    %>
                    <center> 
                        <h2>Merge Split Data and Decrypt </h2>
                            <form action="download3" method="post">
                                <label>Splitdata 1  :</label><input type="text" name="filenamee" value="<%=filename[0]+".txt.part0"%>"  style="margin-left: 30px" class="textbox"/><br /><br />
                                <label>Splitdata 2 :</label><input type="text" name="dkey" value="<%=filename[0]+".txt.part1"%>" required="" class="textbox"/><br /><br />
                                <input type="submit" value="Download" class="button" /><br /><br />
                            </form>
                  </center></div>
        
         </li>
      
       
          
        
      </ul>
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div id="container">
  <div class="wrapper">
    <div id="content">
      <h2>About This </h2>
      <p>THE world recently witnessed a massive surveillance
program aimed at breaking users? privacy.
Perpetrators were not hindered</a>.</p>
      <p>by the various security
measures deployed within the targeted services .
For instance, although these services relied on encryption
mechanisms to guarantee data confidentiality</p>
      <p>the
necessary keying material was acquired by means of
back doors, bribe, or coercion..</p>
      
    </div>
    <div id="column">
      <div class="holder">
        <h2>Know More..!</h2>
        <ul id="latestnews">
          <li> <img class="imgl" src="img/cloud.jpg" alt="" />
            <p>The encryption key is exposed and only the viable
means to guarantee confidentiality is to limit the adversary
access to the ciphertext.</p>
          </li>
        </ul>
      </div>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div id="copyright">
  <div class="wrapper">
    
    <p class="lf">Developed by <a href="http://1000projects.org/">1000 Projects</a></p> <br class="clear" />
  </div>
</div>
</body>
</html>