
package problemariot5;

public class MetodoDeRegresion1 {
    public static void main(String[] args) {
        // Datos de ejemplo
        double[] horasEstudio = {1, 2, 3, 4, 5};
        double[] calificacionesExamen = {60, 70, 80, 85, 90};

        // Calcula la regresión
        double[] regresion = calcularRegresion(horasEstudio, calificacionesExamen);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la recta de regresion es: y = " + regresion[0] + "x + " + regresion[1]);

        // Predice la calificación del examen para 6 horas de estudio
        double horasPrediccion = 6;
        double calificacionPrediccion = predecirCalificacionExamen(horasPrediccion, regresion);
        System.out.println("La calificacion estimada del examen para " + horasPrediccion + " horas de estudio es: " + calificacionPrediccion);
    }

    // Método para calcular la regresión lineal
    public static double[] calcularRegresion(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;

        // Calcula las sumas necesarias para los coeficientes de la regresión
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
        }

        // Calcula los coeficientes de la regresión
        double m = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        return new double[]{m, b};
    }

    // Método para predecir la calificación del examen para un número dado de horas de estudio
    public static double predecirCalificacionExamen(double horasEstudio, double[] regresion) {
        return regresion[0] * horasEstudio + regresion[1];
    }
}

//ENTRADA
//1.0, 60.0; // Valores de x
//2.0, 70.0; // Valores de x
//3.0, 80.0; // Valores de x
//4.0, 85.0; // Valores de x
//5.0, 90.0; // Valores de x

//SALIDA (RESULTADO)
//La ecuacion de la recta de regresion es: y = 5.0x + 55.0
//La calificacion estimada del examen para 6 horas de estudio es: 85.0