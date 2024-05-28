package problemariot5;


public class MetodoDeCorrelacion3 {
    
    public static void main(String[] args) {
        // Datos de ejemplo
        double[] xData = {-3, -1, 1, 3, 5};
        double[] yData = {9, 1, 1, 9, 25};

        // Valor a interpolar
        double xInterpolar = 2;

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
//-3, -1, 1, 3, 5; // Datos de x
//9, 1, 1, 9, 25; // Datos de y
//2; // Valor a interpolar

//SALIDA (RESULTADO)
//El valor interpolado de y para x = 2 es 5.0