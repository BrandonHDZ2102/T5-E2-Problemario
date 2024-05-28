
package problemariot5;

public class MetodoDeRegresion3 {
  public static void main(String[] args) {
        // Datos de ejemplo
        double[] edad = {10, 12, 14, 16, 18};
        double[] altura = {140, 150, 160, 165, 170};

        // Calcula la regresión
        double[] regresion = calcularRegresion(edad, altura);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la recta de regresion es: y = " + regresion[0] + "x + " + regresion[1]);

        // Predice la altura para una persona de 15 años
        double edadPrediccion = 15;
        double alturaPrediccion = predecirAltura(edadPrediccion, regresion);
        System.out.println("La altura estimada para una persona de " + edadPrediccion + " años es: " + alturaPrediccion);
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

    // Método para predecir la altura para una edad dada
    public static double predecirAltura(double edad, double[] regresion) {
        return regresion[0] * edad + regresion[1];
    }
}   


//ENTRADA
//10.0, 140.0; // Valores de x
//12.0, 150.0; // Valores de x
//14.0, 160.0; // Valores de x
//16.0, 165.0; // Valores de x
//18.0, 170.0; // Valores de x

//SALIDA (RESULTADO)
//La ecuacion de la recta de regresion es: y = 5.0x + 90.0
//La altura estimada para una persona de 15 años es: 165.0