package manejador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;
/**
 *
 * @author Daniel
 */
public class CocaColaProgramacionLineal extends SimpleTagSupport {
    
     static {
            System.loadLibrary("jniortools");
            }       
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
           

        
        MPSolver solver = new MPSolver(
                "CocaColaProgramacionLineal", MPSolver.OptimizationProblemType.GLOP_LINEAR_PROGRAMMING);

        /**
         * Capacidades de producción para cada tipo de Coca-Cola (se podrian ingresar por teclado
         * capacidad[N] = capacidad de producción semanal para la cocaN
         */
        int capacidad[] = {711019, 390194, 601187, 317935, 41910};

        /**
         * Variables de decisión
         * coca1 = Coca-Cola de 600 ml
         * coca2 = Coca-Cola de un litro
         * coca3 = Coca-Cola de un litro y medio
         * coca4 = Coca-Cola de dos litros y cuarto
         * coca5 = Coca-Cola de tres litros
         */
        double infinity = java.lang.Double.POSITIVE_INFINITY;
        //

        MPVariable coca1 = solver.makeNumVar(0.0, capacidad[0], "600 ml");
        MPVariable coca2 = solver.makeNumVar(0.0, capacidad[1], "Litro");
        MPVariable coca3 = solver.makeNumVar(0.0, capacidad[2], "Litro y medio");
        MPVariable coca4 = solver.makeNumVar(0.0, capacidad[3], "Dos litros y cuarto");
        MPVariable coca5 = solver.makeNumVar(0.0, capacidad[4], "Tres Litros");
        out.write("<h4>Number of variables = " + solver.numVariables()+"</h4>");


        /**
         * FUNCIÓN OBJETIVO - MAXIMIZAR
         * La función objetivo en este caso es maximizar las ganancias teniendo en cuenta el tiempo disponible
         * Z = 2.54 * coca1 + 7.49 * coca2 + 8.93 * coca3 + 17.07 * coca4 + 17.47 * coca5
         */
        double utilidad[] = {6.38, 9.87, 12.81, 15.95, 17.05};
        int utilidadesEnteras[] = new int[5];
        for (int i = 0; i < utilidadesEnteras.length; i++)
            utilidadesEnteras[i] = (int)Math.floor(Math.round(utilidad[i]*100));

        MPObjective objective = solver.objective();
        objective.setCoefficient(coca1, utilidadesEnteras[0]);
        objective.setCoefficient(coca2, utilidadesEnteras[1]);
        objective.setCoefficient(coca3, utilidadesEnteras[2]);
        objective.setCoefficient(coca4, utilidadesEnteras[3]);
        objective.setCoefficient(coca5, utilidadesEnteras[4]);
        objective.setMaximization();

        /**
         * Restricciones Planta de producción UNO
         * Tiempo de fabricacion para Coca-Cola de 600 ml: 0.00013 horas (aproximadamente 0.5 seg)
         * Tiempo de fabricacion para Coca-Cola de UN litro: 0.00027 horas (aproximadamente 1 seg)
         * 0.00013 * coca1 + 0.00027 * coca2  <= cantidad de horas mensuales
         * cantidad de horas mensuales en este caso = 160
         * debo multiplicar a ambos lados de la desigualdad por 100.000 para obtener el numero entero
         */
        MPConstraint restriccionTiempoPlantaUno = solver.makeConstraint(0.0, 16000000.0, "Planta UNO"); //200 * 100000
        restriccionTiempoPlantaUno.setCoefficient(coca1, 13); //0.00013 * 100000
        restriccionTiempoPlantaUno.setCoefficient(coca2, 27);


        /**
         * Tiempo de fabricación planta DOS
         * Tiempo de fabricacion para Coca-Cola de UN litro y medio : 0.00041 horas (aproximadamente 1,5 seg)
         * Tiempo de fabricacion para Coca-Cola de DOS litro y cuarto: 0.00069 horas (aproximadamente 2.5 seg)
         * Tiempo de fabricacion para Coca-Cola de TRES litro: 0.00083 horas (aproximadamente 3 seg)
         * 0.00041 * coca3 + 0.00069 * coca4 + 0.00083 * coca5 <= cantidad de horas mensuales
         */
        MPConstraint restriccionTiempoPlantaDos = solver.makeConstraint(0.0, 16000000, "Planta DOS");
        restriccionTiempoPlantaDos.setCoefficient(coca3, 41);
        restriccionTiempoPlantaDos.setCoefficient(coca4, 69);
        restriccionTiempoPlantaDos.setCoefficient(coca5, 83);

        out.write("<h5>Número de restricciones = " + solver.numConstraints()+"</h5>");

        /**
         * Me fijo si existe una solución óptima para el problema planteado
         * OPTIMAL => Existe efectivamente una solución óptima
         * FEASIBLE => Existen varias soluciones pero ninguna es la "óptima" aunque podría existir una
         */
        final MPSolver.ResultStatus resultStatus = solver.solve();
        if (resultStatus != MPSolver.ResultStatus.OPTIMAL) {
            out.write("<h5>EL PROBLEMA NO TIENE UNA SOLUCIÓN ÓPTIMA</h5>");
            return;
        }

        /**
         * Se muestran los valores para cada una de las variables de decisión
         */
        out.write("<h3>Solution</h3>");
        out.write("<h4>Coca-Cola de 0.6 litro = \t" + (int)Math.floor(Math.round(coca1.solutionValue())) + " - Holgura: \t" + (int)Math.floor(capacidad[0] - coca1.solutionValue())+"</h4>");
        out.write("<h4>Coca-Cola de 1.0 litro = \t" + (int)Math.floor(Math.round(coca2.solutionValue())) + " - Holgura: \t" + (int)Math.floor(capacidad[1] - coca2.solutionValue())+"</h4>");
        out.write("<h4>Coca-Cola de 1.5 litro = \t" + (int)Math.floor(Math.round(coca3.solutionValue())) + " - Holgura: \t" + (int)Math.floor(capacidad[2] - coca3.solutionValue())+"</h4>");
        out.write("<h4>Coca-Cola de 2.25 litros = \t" + (int)Math.floor(Math.round(coca4.solutionValue())) + " - Holgura: \t" + (int)Math.floor(capacidad[3] - coca4.solutionValue())+"</h4>");
        out.write("<h4>Coca-Cola de 3.0 litro = \t" + (int)Math.floor(Math.round(coca5.solutionValue())) + " - Holgura: \t" + (int)Math.floor(capacidad[4] - coca5.solutionValue())+"</h4>");

        /**
         * Muestro el valor de la función objetivo
         */
        out.write("<h4></h4>");
        out.write("<h4>Valor óptimo: la maxima ganancia que se puede obtener con esta demanda es de = " + Math.floor(Math.round(solver.objective().value()/100))+"</h4>");
    
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in CocaColaProgramacionLineal tag", ex);
        }
    }
    
}
