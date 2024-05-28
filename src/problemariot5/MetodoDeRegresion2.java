
package problemariot5;

public class MetodoDeRegresion2 {
     public static void main(String[] args) {
        // Datos de ejemplo
        double[] temperatura = {10, 20, 30, 40, 50};
        double[] presionAtmosferica = {1.02, 1.01, 1.00, 0.99, 0.98};

        // Calcula la regresión
        double[] regresion = calcularRegresion(temperatura, presionAtmosferica);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la recta de regresion es: y = " + regresion[0] + "x + " + regresion[1]);

        // Predice la presión atmosférica para una temperatura de 35 grados Celsius
        double temperaturaPrediccion = 35;
        double presionPrediccion = predecirPresionAtmosferica(temperaturaPrediccion, regresion);
        System.out.println("La presion atmosferica estimada para una temperatura de " + temperaturaPrediccion + " grados Celsius es: " + presionPrediccion);
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

    // Método para predecir la presión atmosférica para una temperatura dada
    public static double predecirPresionAtmosferica(double temperatura, double[] regresion) {
        return regresion[0] * temperatura + regresion[1];
    }
}

//ENTRADA
//10.0, 1.02; // Valores de x
//20.0, 1.01; // Valores de x
//30.0, 1.00; // Valores de x
//40.0, 0.99; // Valores de x
//50.0, 0.98; // Valores de x

//SALIDA (RESULTADO)
//La ecuacion de la recta de regresion es: y = -0.001x + 1.03
//La presion atmosferica estimada para una temperatura de 35 grados Celsius es: 0.995