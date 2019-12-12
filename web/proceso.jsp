<%-- 
    Document   : proceso
    Created on : 03-dic-2019, 4:24:47
    Author     : Daniel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- importamos todas nuestras clases -->
<%@page import="clases_ORtools.*" %>
<!--%@page import="com.google.ortools.linearsolver.MPConstraint"%-->
<!--%@page import="com.google.ortools.linearsolver.MPObjective"%-->
<!--%@page import="com.google.ortools.linearsolver.MPSolver"%-->
<!--%@page import="com.google.ortools.linearsolver.MPVariable"%-->

<html>
    <head>
    <title>Max Ganancia</title>
    <style type="text/css"><%@ include file="css/estilo.css"%></style>
    
    </head>
    
    <body>
        <div id="ORtoolTag">
            
        
    <%
        /*podemos utilizar todas las cases que hallamos importado*/
        CocaColaProgramacionLineal o= new CocaColaProgramacionLineal();
        o.cocaColaPL();
        
        /*String sn1=request.getParameter("numero1");
        String sn2=request.getParameter("numero2");
        Integer n1=Integer.parseInt(sn1);
        Integer n2=Integer.parseInt(sn2);
        /*aqui somos libre de usar todos los metodos de nuestras clases*/
       // o.setNumero1(n1);
        //o.setNumero2(n2);

        
        out.println(o.nroVar()+"</br>");
        out.println(o.nroRestricciones()+"</br>");
        out.println("<h1>Solucion</h1></br>");
        out.println(o.solucion()+"</br></br>");
        out.println(o.maxGanancia()+"</br>");
        
        %>
        </div>
        <!--
        String[] operaciones=request.getParameterValues("operacion");
        if(operaciones!= null){
            for (int i=0;i<operaciones.length;i++){
                if(operaciones[i].matches("suma")){
                    /*absolutamente todos los metodos*/
                    text=text+"- "+o.suma()+"<br>";
                }
                if(operaciones[i].matches("resta")){
                    text=text+"- "+o.resta()+"<br>";
                }
                if(operaciones[i].matches("multiplicacion")){
                    text=text+"- "+o.multiplicacion()+"<br>";
                }
                if(operaciones[i].matches("division")){
                    text=text+"- "+o.division()+"<br>";
                }
                if(operaciones[i].matches("residuo")){
                    text=text+"- "+o.residuo()+"<br>";
                }
            }
        }else{
            text=text+"No selecciono ninguna operacion";
        }

    %-->
   
   
        <div class="box2">
            <form  name="f2"  action="index.jsp" method="post">
                <input type="submit" value="Volver" >
            </form>
        </div>
    
    </body>
</html>