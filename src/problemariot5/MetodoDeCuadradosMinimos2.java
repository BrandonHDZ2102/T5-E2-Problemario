package problemariot5;

public class MetodoDeCuadradosMinimos2 {
    
     public static void main(String[] args) {
        // Datos de ejemplo
        double[] tiempo = {1, 2, 3, 4, 5};
        double[] distancia = {2, 8, 18, 32, 50};

        // Calcula la regresión por mínimos cuadrados (parábola)
        double[] regresion = calcularMinimosCuadrados(tiempo, distancia);

        // Imprime los coeficientes de la regresión
        System.out.println("La ecuacion de la parabola de regresion es: y = " + regresion[0] + "x^2 + " + regresion[1] + "x + " + regresion[2]);

        // Predice la distancia recorrida para t = 6 horas
        double tiempoPrediccion = 6;
        double distanciaPrediccion = predecirDistancia(tiempoPrediccion, regresion);
        System.out.println("La distancia estimada para t = " + tiempoPrediccion + " horas es: " + distanciaPrediccion);
    }

    // Método para calcular la regresión por mínimos cuadrados (parábola)
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXX = 0, sumXY = 0, sumXXX = 0, sumXXXX = 0, sumXXY = 0;

        // Calcula las sumas necesarias para los coeficientes de la regresión
        for (int i = 0; i < n; i++) {
            double xi = x[i];
            double xiSquared = xi * xi;
            sumX += xi;
            sumY += y[i];
            sumXX += xiSquared;
            sumXY += xi * y[i];
            sumXXX += xiSquared * xi;
            sumXXXX += xiSquared * xiSquared;
            sumXXY += xiSquared * y[i];
        }

        // Resuelve el sistema de ecuaciones para obtener los coeficientes de la regresión
        double[][] coeficientes = {
            {sumXXXX, sumXXX, sumXX},
            {sumXXX, sumXX, sumX},
            {sumXX, sumX, n}
        };

        double[] constantes = {sumXXY, sumXY, sumY};

        // Utiliza la eliminación de Gauss para resolver el sistema de ecuaciones
        for (int i = 0; i < 3; i++) {
            double divisor = coeficientes[i][i];
            for (int j = i; j < 3; j++) {
                coeficientes[i][j] /= divisor;
            }
            constantes[i] /= divisor;
            for (int k = i + 1; k < 3; k++) {
                double multiplicador = coeficientes[k][i];
                for (int j = i; j < 3; j++) {
                    coeficientes[k][j] -= multiplicador * coeficientes[i][j];
                }
                constantes[k] -= multiplicador * constantes[i];
            }
        }

        double[] coeficientesRegresion = new double[3];
        for (int i = 2; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < 3; j++) {
                sum += coeficientes[i][j] * coeficientesRegresion[j];
            }
            coeficientesRegresion[i] = constantes[i] - sum;
        }

        return coeficientesRegresion;
    }

    // Método para predecir la distancia recorrida para un tiempo dado
    public static double predecirDistancia(double tiempo, double[] regresion) {
        return regresion[0] * tiempo * tiempo + regresion[1] * tiempo + regresion[2];
    }
}


//ENTRADA
//1.0, 2.0; // Valores de tiempo y distancia
//2.0, 8.0; // Valores de tiempo y distancia
//3.0, 18.0; // Valores de tiempo y distancia
//4.0, 32.0; // Valores de tiempo y distancia
//5.0, 50.0; // Valores de tiempo y distancia

//SALIDA (RESULTADO)
//La ecuacion de la parabola de regresion es: y = 2.0x^2 + 0.0x + 0.0
//La distancia estimada para t = 6.0 horas es: 72.0
