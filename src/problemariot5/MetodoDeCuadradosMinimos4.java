
package problemariot5;

public class MetodoDeCuadradosMinimos4 {
  public static void main(String[] args) {
        // Datos de ejemplo
        double[] tiempo = {1, 2, 3, 4, 5};
        double[] bacterias = {100, 200, 400, 800, 1600};

        // Calcula la regresión por mínimos cuadrados (curva exponencial)
        double[] regresion = calcularMinimosCuadrados(tiempo, bacterias);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la curva exponencial de regresion es: y = " + regresion[0] + " * e^(" + regresion[1] + "x)");

        // Predice la cantidad de bacterias para t = 6 días
        double tiempoPrediccion = 6;
        double bacteriasPrediccion = predecirBacterias(tiempoPrediccion, regresion);
        System.out.println("La cantidad estimada de bacterias para t = " + tiempoPrediccion + " dias es: " + bacteriasPrediccion);
    }

    // Método para calcular la regresión por mínimos cuadrados (curva exponencial)
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        int n = x.length;
        double sumY = 0, sumXY = 0, sumXX = 0, sumXLogY = 0, sumXLogX = 0;

        // Calcula las sumas necesarias para los coeficientes de la regresión
        for (int i = 0; i < n; i++) {
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
            sumXLogY += x[i] * Math.log(y[i]);
            sumXLogX += x[i] * x[i];
        }

        // Calcula los coeficientes de la regresión
        double b = (n * sumXY - sumXLogY) / (n * sumXX - sumXLogX);
        double a = (sumY - b * sumXLogY) / n;

        return new double[]{Math.exp(a), b};
    }

    // Método para predecir la cantidad de bacterias para un tiempo dado
    public static double predecirBacterias(double tiempo, double[] regresion) {
        return regresion[0] * Math.exp(regresion[1] * tiempo);
    }
}   

//ENTRADA
//1.0, 100.0; // Valores de x
//2.0, 200.0; // Valores de x
//3.0, 400.0; // Valores de x
//4.0, 800.0; // Valores de x
//5.0, 1600.0; // Valores de x

//SALIDA (RESULTADO)
//La ecuacion de la curva exponencial de regresion es: y = 100.0 * e^(0.6931471805599453x)
//La cantidad estimada de bacterias para t = 6 días es: 3200.0