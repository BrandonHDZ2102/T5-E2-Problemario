
package problemariot5;

public class MetodoDeNewton3 {
   public static void main(String[] args) {
        // Datos de ejemplo
        double[] x = {1, 2, 3, 4};
        double[] y = {0, 1, 8, 27};

        // Valor a interpolar
        double xInterpolar = 2.5;

        // Calcula la interpolación de Newton
        double yInterpolado = interpolarNewton(xInterpolar, x, y);

        // Imprime el resultado
        System.out.println("El valor interpolado de y para x = " + xInterpolar + " es " + yInterpolado);
    }

    // Método de interpolación de Newton
    public static double interpolarNewton(double x, double[] xData, double[] yData) {
        int n = xData.length;
        double[] coeffs = new double[n];

        // Inicializa los coeficientes como los valores de y
        for (int i = 0; i < n; i++) {
            coeffs[i] = yData[i];
        }

        // Calcula los coeficientes del polinomio de Newton
        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) {
                coeffs[i] = (coeffs[i] - coeffs[i - 1]) / (xData[i] - xData[i - j]);
            }
        }

        // Evalúa el polinomio interpolante en x
        double result = coeffs[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result = result * (x - xData[i]) + coeffs[i];
        }

        return result;
    }
}

//ENTRADA
//1, 2, 3, 4; // Datos de x
//0, 1, 8, 27; // Datos de y
//2.5; // Valor a interpolar

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 2.5 es 4.875
