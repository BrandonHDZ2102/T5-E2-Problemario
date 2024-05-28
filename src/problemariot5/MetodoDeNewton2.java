
package problemariot5;

public class MetodoDeNewton2 {
public static void main(String[] args) {
        // Datos de ejemplo
        double[] x = {1, 2, 4, 5};
        double[] y = {3, 7, 15, 31};

        // Valor a interpolar
        double xInterpolar = 3;

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
//1, 2, 4, 5; // Datos de x
//3, 7, 15, 31; // Datos de y
//3; // Valor a interpolar

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 3 es 11.0
