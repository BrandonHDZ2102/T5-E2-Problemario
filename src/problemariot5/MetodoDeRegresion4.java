
package problemariot5;

public class MetodoDeRegresion4 {
    public static void main(String[] args) {
        // Datos de ejemplo
        double[] anosExperiencia = {1, 2, 3, 4, 5};
        double[] salario = {30000, 35000, 40000, 45000, 50000};

        // Calcula la regresión
        double[] regresion = calcularRegresion(anosExperiencia, salario);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la recta de regresion es: salario = " + regresion[0] + " * anosExperiencia + " + regresion[1]);

        // Predice el salario para alguien con 6 años de experiencia
        double anosExperienciaPrediccion = 6;
        double salarioPrediccion = predecirSalario(anosExperienciaPrediccion, regresion);
        System.out.println("El salario estimado para alguien con " + anosExperienciaPrediccion + " años de experiencia es: $" + salarioPrediccion);
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

    // Método para predecir el salario para un número dado de años de experiencia
    public static double predecirSalario(double anosExperiencia, double[] regresion) {
        return regresion[0] * anosExperiencia + regresion[1];
    }
}

//ENTRADA
//1.0, 30000.0; // Valores de x
//2.0, 35000.0; // Valores de x
//3.0, 40000.0; // Valores de x
//4.0, 45000.0; // Valores de x
//5.0, 50000.0; // Valores de x

//SALIDA (RESULTADO)
//La ecuacion de la recta de regresion es: salario = 5000.0 * anosExperiencia + 25000.0
//El salario estimado para alguien con 6 años de experiencia es: $30000.0