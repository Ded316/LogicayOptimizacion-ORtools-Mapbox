package clases_ORtools;
import com.google.ortools.sat.*;

/**
 * Datos usados en el Scheduling
 *
 *      PROCESO                 Predecesores        Tiempo (horas/1000lts)
 *  A   Tratamiento del agua        --                  4
 *  B   Endulcorante                --                  2
 *  C   Jarabe Simple               A,B                 5
 *  D   Concentrado                 --                  2
 *  E   Jarabe terminado            C,D                 5
 *  F   Gas Carbonico CO2           --                  1
 *  G   Carbonador                  --                  1
 *  H   Bebida terminada            A,E,F,G             3
 *  I   Llenadora/Tapadora          H                   2
 *  J   Llenado y tapado            I                   3
 *  K   Inspección Post-llenado     J                   2
 *  L   Codificado                  K                   1
 *  M   Encajonado                  L                   1
 *  N   Transporte y distribución   M                   1
 */
public class CocaColaScheduling {
    static {
        System.loadLibrary("jniortools");
    }
    int duracion[] = {4, 2, 5, 2, 5, 1, 1, 3, 2, 3, 2, 1, 1, 1};
    CpModel modelo = new CpModel();
    int horizonte = 160;
    // Variables de decisión
    IntVar inicioA = modelo.newIntVar(0, horizonte, "Inicio A");
    IntVar finA = modelo.newIntVar(0, horizonte, "Fin A");

    IntVar inicioB = modelo.newIntVar(0, horizonte, "Inicio B");
    IntVar finB = modelo.newIntVar(0, horizonte, "Fin B");

    IntVar inicioC = modelo.newIntVar(0, horizonte, "Inicio C");
    IntVar finC = modelo.newIntVar(0, horizonte, "Fin C");

    IntVar inicioD = modelo.newIntVar(0, horizonte, "Inicio D");
    IntVar finD = modelo.newIntVar(0, horizonte, "Fin D");

    IntVar inicioE = modelo.newIntVar(0, horizonte, "Inicio E");
    IntVar finE = modelo.newIntVar(0, horizonte, "Fin E");

    IntVar inicioF = modelo.newIntVar(0, horizonte, "Inicio F");
    IntVar finF = modelo.newIntVar(0, horizonte, "Fin F");

    IntVar inicioG = modelo.newIntVar(0, horizonte, "Inicio G");
    IntVar finG = modelo.newIntVar(0, horizonte, "Fin G");

    IntVar inicioH = modelo.newIntVar(0, horizonte, "Inicio H");
    IntVar finH = modelo.newIntVar(0, horizonte, "Fin H");

    IntVar inicioI = modelo.newIntVar(0, horizonte, "Inicio I");
    IntVar finI = modelo.newIntVar(0, horizonte, "Fin I");

    IntVar inicioJ = modelo.newIntVar(0, horizonte, "Inicio J");
    IntVar finJ = modelo.newIntVar(0, horizonte, "Fin J");

    IntVar inicioK = modelo.newIntVar(0, horizonte, "Inicio K");
    IntVar finK = modelo.newIntVar(0, horizonte, "Fin K");

    IntVar inicioL = modelo.newIntVar(0, horizonte, "Inicio L");
    IntVar finL = modelo.newIntVar(0, horizonte, "Fin L");

    IntVar inicioM = modelo.newIntVar(0, horizonte, "Inicio M");
    IntVar finM = modelo.newIntVar(0, horizonte, "Fin M");

    IntVar inicioN = modelo.newIntVar(0, horizonte, "Inicio N");
    IntVar finN = modelo.newIntVar(0, horizonte, "Fin N");

    IntVar objetivo = modelo.newIntVar(0, horizonte, "makespan");
    CpSolver solver = new CpSolver();

    public void scheduling() throws Exception {
        /**
         * Matriz que muestra la duración de cada tarea expresada en horas/1000lts
         */
        

        /**
         * Representación de cada tarea que debe programarse
         * Para cada tarea hay que expresar su inicio, duración y fin
         * Las variables de inicio y fin de las tareas son variables del modelo (variables de decisión) ya que
         * serán manipuladas por el solver para encontrar la mejor solución o al menos una solución viable
         */

        /**
         * Terea A: Tratamiento de agua
         * Duración: 4 horas
         */

        IntervalVar tareaA = modelo.newIntervalVar(inicioA, duracion[0], finA, "Tratamiento Agua");

        /**
         * Terea B: Endulcorante
         * Duración: 2 horas
         */

        IntervalVar tareaB = modelo.newIntervalVar(inicioB, duracion[1], finB, "Endulcorante");

        /**
         * Terea C: Jarabe simple
         * Duración: 5 horas
         */

        IntervalVar tareaC = modelo.newIntervalVar(inicioC, duracion[2], finC, "Jarabe simple");

        /**
         * Terea D: Concentrado
         * Duración: 2 horas
         */

        IntervalVar tareaD = modelo.newIntervalVar(inicioD, duracion[3], finD, "Concentrado");

        /**
         * Terea E: Jarabe terminado
         * Duración: 5 horas
         */

        IntervalVar tareaE = modelo.newIntervalVar(inicioE, duracion[4], finE, "Jarabe terminado");

        /**
         * Terea F: Gas Carbonico CO2
         * Duración: 1 horas
         */

        IntervalVar tareaF = modelo.newIntervalVar(inicioF, duracion[5], finF, "Gas Carbonico CO2 ");

        /**
         * Terea G: Carbonador
         * Duración: 1 horas
         */

        IntervalVar tareaG = modelo.newIntervalVar(inicioG, duracion[6], finG, "Carbonador");

        /**
         * Terea H: Bebida terminada
         * Duración: 3 horas
         */

        IntervalVar tareaH = modelo.newIntervalVar(inicioH, duracion[7], finH, "Bebida terminada");

        /**
         * Terea I: Llenado/Tapadora
         * Duración: 2 horas
         */

        IntervalVar tareaI = modelo.newIntervalVar(inicioI, duracion[8], finI, "Llenado/Tapadora");

        /**
         * Terea J: Llenado y tapado
         * Duración: 3 horas
         */

        IntervalVar tareaJ = modelo.newIntervalVar(inicioJ, duracion[9], finJ, "Llenado y tapado");

        /**
         * Terea K: Inspección Post-llenado
         * Duración: 2 horas
         */

        IntervalVar tareaK = modelo.newIntervalVar(inicioK, duracion[10], finK, "Inspeccion Post-llenado");

        /**
         * Terea L: Codificado
         * Duración: 1 horas
         */

        IntervalVar tareaL = modelo.newIntervalVar(inicioL, duracion[11], finL, "Codificado");

        /**
         * Terea M: Encajonado
         * Duración: 1 horas
         */

        IntervalVar tareaM = modelo.newIntervalVar(inicioM, duracion[12], finM, "Encajonado");

        /**
         * Terea N: Transporte y distribución
         * Duración: 1 horas
         */

        IntervalVar tareaN = modelo.newIntervalVar(inicioN, duracion[13], finN, "Transporte y distribución");

        /**
         * Restricciones de precedencia
         */
        modelo.addLessOrEqual(finA, inicioC); //La tarea C comienza después de que termíne la tarea A
        modelo.addLessOrEqual(finB, inicioC); //La tarea C comienza después de que termíne la tarea A
        modelo.addLessOrEqual(finC, inicioE); //La tarea E comienza después de que termíne la tarea C
        modelo.addLessOrEqual(finD, inicioE);
        modelo.addLessOrEqual(finA, inicioH);
        modelo.addLessOrEqual(finE, inicioH);
        modelo.addLessOrEqual(finF, inicioH);
        modelo.addLessOrEqual(finG, inicioH);
        modelo.addLessOrEqual(finH, inicioI);
        modelo.addLessOrEqual(finI, inicioJ);
        modelo.addLessOrEqual(finJ, inicioK);
        modelo.addLessOrEqual(finK, inicioL);
        modelo.addLessOrEqual(finL, inicioM);
        modelo.addLessOrEqual(finM, inicioN);

        /**
         * Se le "dice" al modelo, que el objetivo del mismo es encontrar el tiempo minimo para complir con todas
         * las tareas
         */

        modelo.addMaxEquality(objetivo, new IntVar[] {finA, finB, finC, finD, finE, finF, finG, finH, finI, finJ, finK, finL, finM, finN});
        modelo.minimize(objetivo);


        /**
         * Solución
         * Se crea una instancia del solver, en este caso se utilizar el solver avanzado CP-SAT. Posteriormente, se
         * pasa por parámetro al solver el modelo generado.
         */
 
        CpSolverStatus estado = solver.solve(modelo);

        /**
         * A continuación se muestran los resultados obtenidos para cada tarea, expresando en que momento deben
         * comenzar y terminar
         */
        /**
         * Este mensaje es mostrado en el caso de que la solución encontrada sea la optima (única)
         */
        /*if (estado == CpSolverStatus.OPTIMAL){
            System.out.println("Longitud de solución optima: " + solver.objectiveValue());
            System.out.println("El tratamiento de agua comienza en: " + solver.value(inicioA) + " y termina en: " + solver.value(finA));
            System.out.println("Endulcorante comienza a las " + solver.value(inicioB) + " y termina en: " + solver.value(finB));
            System.out.println("Jarabe simple comienza a las " + solver.value(inicioC) + " y termina en: " + solver.value(finC));
            System.out.println("Concentrado comienza a las " + solver.value(inicioD) + " y termina en: " + solver.value(finD));
            System.out.println("Jarabe terminado comienza a las " + solver.value(inicioE) + " y termina en: " + solver.value(finE));
            System.out.println("Gas carbonico CO2 comienza a las " + solver.value(inicioF) + " y termina en: " + solver.value(finF));
            System.out.println("Carbonador comienza a las " + solver.value(inicioG) + " y termina en: " + solver.value(finG));
            System.out.println("Bebida terminada comienza a las " + solver.value(inicioH) + " y termina en: " + solver.value(finH));
            System.out.println("Llenadora/Tapadora comienza a las " + solver.value(inicioI) + " y termina en: " + solver.value(finI));
            System.out.println("Llenado y tapado comienza a las " + solver.value(inicioJ) + " y termina en: " + solver.value(finJ));
            System.out.println("Inspección Post-llenado comienza a las " + solver.value(inicioK) + " y termina en: " + solver.value(finK));
            System.out.println("Codificado comienza a las " + solver.value(inicioL) + " y termina en: " + solver.value(finL));
            System.out.println("Encajonado comienza a las " + solver.value(inicioM) + " y termina en: " + solver.value(finM));
            System.out.println("Transporte y distribución comienza a las " + solver.value(inicioN) + " y termina en: " + solver.value(finN));
        }
        */
    }
    public String solucion(){
        return
        "Longitud de solución optima: " + solver.objectiveValue() +
        "</br> El tratamiento de agua comienza en: " + solver.value(inicioA) + " y termina en: " + solver.value(finA) +
        "</br> Endulcorante comienza a las " + solver.value(inicioB) + " y termina en: " + solver.value(finB) + 
        "</br> Jarabe simple comienza a las " + solver.value(inicioC) + " y termina en: " + solver.value(finC) +
        "</br> Concentrado comienza a las " + solver.value(inicioD) + " y termina en: " + solver.value(finD) +
        "</br> Jarabe terminado comienza a las " + solver.value(inicioE) + " y termina en: " + solver.value(finE) +
        "</br> Gas carbonico CO2 comienza a las " + solver.value(inicioF) + " y termina en: " + solver.value(finF) + 
        "</br> Carbonador comienza a las " + solver.value(inicioG) + " y termina en: " + solver.value(finG) + 
        "</br> Bebida terminada comienza a las " + solver.value(inicioH) + " y termina en: " + solver.value(finH) + 
        "</br> Llenadora/Tapadora comienza a las " + solver.value(inicioI) + " y termina en: " + solver.value(finI) + 
        "</br> Llenado y tapado comienza a las " + solver.value(inicioJ) + " y termina en: " + solver.value(finJ) + 
        "</br> Inspección Post-llenado comienza a las " + solver.value(inicioK) + " y termina en: " + solver.value(finK) + 
        "</br> Codificado comienza a las " + solver.value(inicioL) + " y termina en: " + solver.value(finL) + 
        "</br> Encajonado comienza a las " + solver.value(inicioM) + " y termina en: " + solver.value(finM) + 
        "</br> Transporte y distribución comienza a las " + solver.value(inicioN) + " y termina en: " + solver.value(finN);
    }
}
