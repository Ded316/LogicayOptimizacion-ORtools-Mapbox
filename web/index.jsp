<%-- 
    Document   : index
    Created on : 01-dic-2019, 22:09:20
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>OR-Tools y Mapbox</title>
<style type="text/css"><%@ include file="css/estilo.css"%></style>
</head>
<body bgcolor="#FFFFFF">
<form  name="pl"  action="proceso.jsp" method="post">
    <input type="submit" value="Programacion Lineal" >
    
</form>
<form  name="scheduling"  action="sched.jsp" method="post">
    <input type="submit" value="Scheduling" >   
</form>
<form  name="mapboxCoca"  action="http://diazmilanromero-env.drx87ed6qr.us-east-1.elasticbeanstalk.com/" method="post">
    <input type="submit" value="Entrega de productos" >  
</form>


</body>
</html>