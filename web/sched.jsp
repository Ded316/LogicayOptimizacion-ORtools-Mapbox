<%-- 
    Document   : sched
    Created on : 12-dic-2019, 9:25:18
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="clases_ORtools.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scheduling</title>
        <style type="text/css"><%@ include file="css/estilo.css"%></style>
    </head>
    <body>
        <div id="ORtoolTag">
            <%
                CocaColaScheduling o = new CocaColaScheduling();
                o.scheduling();
                
                out.println(o.solucion()+"</br>");
            %>
            
            
            
        </div>
        <div class="box2">    
            <form  name="f2"  action="index.jsp" method="post">
                <input type="submit" value="Volver" >
            </form>
        </div>
    </body>
</html>
