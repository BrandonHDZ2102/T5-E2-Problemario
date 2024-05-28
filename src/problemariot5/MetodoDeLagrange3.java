
package problemariot5;

public class MetodoDeLagrange3 {
    public static void main(String[] args) {
        // Definir los puntos (x, y)
        double[] x = {1, 2, 4, 5};
        double[] y = {0, 1, 1.386294, 1.609438};

        // Valor de x para la interpolación
        double xInterpolacion = 3;

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
//1.0, 0.0; // Valores de x
//2.0, 1.0; // Valores de x
//4.0, 1.386294; // Valores de x
//5.0, 1.609438; // Valores de x

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 3.0 es: 1.151292