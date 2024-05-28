package problemariot5;

public class MetodoDeCorrelacion1 {
 
      public static void main(String[] args) {
        // Datos de ejemplo
        double[] xData = {0, 1, 2, 3, 4, 5};
        double[] yData = {10, 20, 35, 55, 80, 110};

        // Valor a interpolar
        double xInterpolar = 2.5;

        // Calcula la interpolación correlacional
        double yInterpolado = interpolarCorrelacional(xInterpolar, xData, yData);

        // Imprime el resultado
        System.out.println("El valor interpolado de y para x = " + xInterpolar + " es " + yInterpolado);
    }

    // Método de interpolación correlacional
    public static double interpolarCorrelacional(double x, double[] xData, double[] yData) {
        // Busca los dos puntos más cercanos
        int i = 0;
        while (i < xData.length && xData[i] < x) {
            i++;
        }
        
        // Si el valor a interpolar está fuera del rango, realiza una interpolación lineal
        if (i == 0) {
            return yData[0] + (yData[1] - yData[0]) * (x - xData[0]) / (xData[1] - xData[0]);
        } else if (i == xData.length) {
            return yData[xData.length - 1] + (yData[xData.length - 1] - yData[xData.length - 2])
                    * (x - xData[xData.length - 1]) / (xData[xData.length - 1] - xData[xData.length - 2]);
        }
        
        // Interpola correlacionalmente entre los dos puntos más cercanos
        double x1 = xData[i - 1];
        double x2 = xData[i];
        double y1 = yData[i - 1];
        double y2 = yData[i];
        
        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }
}

//ENTRADA
//0, 1, 2, 3, 4, 5; // Datos de x
//10, 20, 35, 55, 80, 110; // Datos de y
//2.5; // Valor a interpolar

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 2.5 es 45.0