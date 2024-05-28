
package problemariot5;

public class MetodoDeLagrange1 {
    public static void main(String[] args) {
        // Puntos dados para la interpolación (x, y)
        double[] x = {1, 6, 3, 4, 7};
        double[] y = {5, 2, 5, 9, 11};

        // Valor de x para la interpolación
        double xInterpolacion = 2.5;

        // Realizar la interpolación de Lagrange
        double resultado = lagrangeInterpolacion(x, y, xInterpolacion);

        // Imprimir el resultado
        System.out.println("El valor interpolado de y para x = " + xInterpolacion + " es: " + resultado);
    }

    // Método para calcular la interpolación de Lagrange
    public static double lagrangeInterpolacion(double[] x, double[] y, double xInterpolacion) {
        double resultado = 0;
        for (int i = 0; i < x.length; i++) {
            double termino = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    termino *= (xInterpolacion - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }
        return resultado;
    }
}

//ENTRADA
//1.0, 5.0; // Valores de x
//6.0, 2.0; // Valores de x
//3.0, 5.0; // Valores de x
//4.0, 9.0; // Valores de x
//7.0, 11.0; // Valores de x

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 2.5 es: 6.5