
package problemariot5;

public class MetodoDeLagrange4 {
     public static void main(String[] args) {
        // Definir los puntos (x, y) correspondientes a la función seno
        double[] x = {0, Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2};
        double[] y = {0, 0.5, Math.sqrt(2) / 2, Math.sqrt(3) / 2, 1};

        // Valor de x para la interpolación
        double xInterpolacion = Math.PI / 8;

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
//0.0, 0.0; // Valores de x
//0.5235987755982988, 0.5; // Valores de x
//0.7853981633974483, 0.7071067811865476; // Valores de x
//1.0471975511965976, 0.8660254037844386; // Valores de x
//1.5707963267948966, 1.0; // Valores de x

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 0.39269908169872414 es: 0.4646832222461538