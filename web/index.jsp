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
<META HTTP-EQUIV="Refresh" CONTENT="11000;URL=mapBox.jsp">
<script type="text/javascript">
            function processRecords(){
            document.getElementById("mainContent").src = "timer.jsp";
            }
</script>
<style type="text/css"><%@ include file="css/estilo.css"%></style>
<style type="text/css">
        html, body {margin:0; padding:0;height: 100%;}
        form, iframe { margin:0; padding:0; height:100%; width:100%; display:block;border:none; }
    </style>
</head-->
<body> <!--onload="processRecords()"-->
<!--script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<div class="loader-page">   
        <iframe id="mainContent" width="100%" style="border:none" seamless src="loader.jsp"></iframe>
</div-->
    <div id="padre">
        <%@include file="loader.html" %>
        <div class="box">
             
            <form  name="pl"  action="proceso.jsp" method="post">
                <input type="submit" value="Programacion Lineal" >
                
            </form>
            <form  name="scheduling"  action="sched.jsp" method="post">
                <input type="submit" value="Scheduling" >   
            </form>
            <form  name="mapboxCoca"  action="http://diazmilanromero-env.drx87ed6qr.us-east-1.elasticbeanstalk.com/" method="post">
                <input type="submit" value="Entrega de productos" >  
            </form>
        </div>
    </div>


</body>
</html>