# T5 - E2   -  Problemario

## Integrantes:
- Brandon Hernández Espinosa
- Italia Yoselin Lozada Olvera



## Método De Correlación:
### Descripción: 

El método de interpolación correlacional se basa en que la relación entre las variables puede describirse con una función de correlación que capta la tendencia en los datos. Este método es útil cuando la relación entre las variables no es completamente lineal y puede mejorarse con términos que reflejen mejor la naturaleza de la relación.

### Pseudocódigo 
```

Inicio

// Paso 1: Recopilación de Datos
// Suponemos que tenemos los datos en dos listas: x_data y y_data
x_data = [x0, x1, x2, ..., xn]
y_data = [y0, y1, y2, ..., yn]

// Paso 2: Selección del Modelo de Correlación
// En este ejemplo, usaremos un modelo lineal: y = mx + b

// Paso 3: Cálculo de Parámetros (usando mínimos cuadrados)
n = longitud(x_data)

sum_x = 0
sum_y = 0
sum_x2 = 0
sum_xy = 0

para i desde 0 hasta n-1:
    sum_x = sum_x + x_data[i]
    sum_y = sum_y + y_data[i]
    sum_x2 = sum_x2 + x_data[i] * x_data[i]
    sum_xy = sum_xy + x_data[i] * y_data[i]

// Resolver las ecuaciones normales para encontrar m y b
// m = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x)
m = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x)

// b = (sum_y - m * sum_x) / n
b = (sum_y - m * sum_x) / n

// Paso 4: Interpolación
// Función para estimar y para un valor dado de x usando el modelo lineal
función estimar_y(x):
    retornar m * x + b

// Ejemplo de uso:
x_estimar = 2.5
y_estimado = estimar_y(x_estimar)
imprimir("El valor estimado de y para x =", x_estimar, "es", y_estimado)

Fin

```


### Implementación 
- Implementación en C#:

```
  using System;
using System.Collections.Generic;
using System.Linq;

public class InterpolacionCorrelacional
{
    public static void Main(string[] args)
    {
        // Paso 1: Recopilación de Datos
        List<double> xData = new List<double> { 1, 2, 3, 4 };
        List<double> yData = new List<double> { 2, 3, 5, 4 };

        // Paso 2 y 3: Selección del Modelo de Correlación y Cálculo de Parámetros (usando mínimos cuadrados)
        double m, b;
        CalcularParametros(xData, yData, out m, out b);

        // Paso 4: Interpolación
        double xEstimar = 2.5;
        double yEstimado = EstimarY(xEstimar, m, b);
        Console.WriteLine($"El valor estimado de y para x = {xEstimar} es {yEstimado}");
    }

    // Función para calcular los parámetros m y b del modelo lineal
    public static void CalcularParametros(List<double> xData, List<double> yData, out double m, out double b)
    {
        int n = xData.Count;

        double sumX = xData.Sum();
        double sumY = yData.Sum();
        double sumX2 = xData.Sum(x => x * x);
        double sumXY = xData.Zip(yData, (x, y) => x * y).Sum();

        m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b = (sumY - m * sumX) / n;
    }

    // Función para estimar y para un valor dado de x usando el modelo lineal
    public static double EstimarY(double x, double m, double b)
    {
        return m * x + b;
    }
}
```


### Ejemplos en java:

[Ejemplo 1](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCorrelacion1.java)

[Ejemplo 2](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCorrelacion2.java)

[Ejemplo 3](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCorrelacion3.java)

[Ejemplo 4](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCorrelacion4.java)




------------------------------------------------------------------------------------------

## Método De Minimos Cuadros
### Descripción: 
El método de mínimos cuadrados es una técnica común en métodos numéricos para ajustar una línea o curva a un conjunto de datos de forma que la suma de los cuadrados de las diferencias entre los valores observados y los predichos por la línea o curva ajustada sea lo más pequeña posible. 


### Pseudocódigo 
```
Inicio
   // Paso 1: Recopilación de Datos
// Suponemos que tenemos los datos en dos listas: x_data y y_data
x_data = [x0, x1, x2, ..., xn]
y_data = [y0, y1, y2, ..., yn]

// Paso 2: Cálculo de Parámetros
n = longitud(x_data)

sum_x = 0
sum_y = 0
sum_x2 = 0
sum_xy = 0

para i desde 0 hasta n-1:
    sum_x = sum_x + x_data[i]
    sum_y = sum_y + y_data[i]
    sum_x2 = sum_x2 + x_data[i] * x_data[i]
    sum_xy = sum_xy + x_data[i] * y_data[i]

// Resolver las ecuaciones normales para encontrar m y b
m = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x)
b = (sum_y - m * sum_x) / n

// Paso 3: Interpolación
función estimar_y(x):
    retornar m * x + b

// Ejemplo de uso:
x_estimar = 2.5
y_estimado = estimar_y(x_estimar)
imprimir("El valor estimado de y para x =", x_estimar, "es", y_estimado)

Fin

```


### Implementacón: 
- Implementacion en C#

```
using System;
using System.Collections.Generic;
using System.Linq;

public class MinimosCuadrados
{
    public static void Main(string[] args)
    {
        // Paso 1: Recopilación de Datos
        List<double> xData = new List<double> { 1, 2, 3, 4 };
        List<double> yData = new List<double> { 2, 3, 5, 4 };

        // Paso 2: Cálculo de Parámetros
        double m, b;
        CalcularParametros(xData, yData, out m, out b);

        // Paso 3: Mostrar los parámetros
        Console.WriteLine($"Pendiente (m): {m}");
        Console.WriteLine($"Intersección (b): {b}");

        // Paso 4: Interpolación
        double xEstimar = 2.5;
        double yEstimado = EstimarY(xEstimar, m, b);
        Console.WriteLine($"El valor estimado de y para x = {xEstimar} es {yEstimado}");
    }

    // Función para calcular los parámetros m y b del modelo lineal
    public static void CalcularParametros(List<double> xData, List<double> yData, out double m, out double b)
    {
        int n = xData.Count;

        double sumX = xData.Sum();
        double sumY = yData.Sum();
        double sumX2 = xData.Sum(x => x * x);
        double sumXY = xData.Zip(yData, (x, y) => x * y).Sum();

        // Fórmulas para m y b
        m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b = (sumY - m * sumX) / n;
    }

    // Función para estimar y para un valor dado de x usando el modelo lineal
    public static double EstimarY(double x, double m, double b)
    {
        return m * x + b;
    }
}

 
```


### Ejemplos en java:

[Ejemplo 1](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCuadradosMinimos1.java)

[Ejemplo 2](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCuadradosMinimos2.java)

[Ejemplo 3](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCuadradosMinimos3.java)

[Ejemplo 4](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeCuadradosMinimos4.java)




--------------------------------------------------------------------------------------

## Método De Regresión:
### Descripción: 
La regresión se usa para ver cómo una variable dependiente (Y) se relaciona con una o más variables independientes (X). Básicamente, queremos armar un modelo matemático que nos cuente cómo la variable dependiente cambia con base en las variables independientes.


### Pseudocódigo 
```
Inicio

   // Paso 1: Recopilación de Datos
// Suponemos que tenemos los datos en dos listas: x_data y y_data
x_data = [x0, x1, x2, ..., xn]
y_data = [y0, y1, y2, ..., yn]

// Paso 2: Cálculo de Parámetros
n = longitud(x_data)

sum_x = 0
sum_y = 0
sum_x2 = 0
sum_xy = 0

para i desde 0 hasta n-1:
    sum_x = sum_x + x_data[i]
    sum_y = sum_y + y_data[i]
    sum_x2 = sum_x2 + x_data[i] * x_data[i]
    sum_xy = sum_xy + x_data[i] * y_data[i]

// Resolver las ecuaciones normales para encontrar m y b
m = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x)
b = (sum_y - m * sum_x) / n

// Paso 3: Predicción
función predecir_y(x):
    retornar m * x + b

// Ejemplo de uso:
x_predecir = 2.5
y_predicho = predecir_y(x_predecir)
imprimir("El valor predicho de y para x =", x_predecir, "es", y_predicho)

Fin

```


### Implementación: 
- Implementacion en C#

```
  using System;
using System.Collections.Generic;
using System.Linq;

public class RegresionLineal
{
    public static void Main(string[] args)
    {
        // Paso 1: Recopilación de Datos
        List<double> xData = new List<double> { 1, 2, 3, 4 };
        List<double> yData = new List<double> { 2, 3, 5, 4 };

        // Paso 2: Cálculo de Parámetros
        double m, b;
        CalcularParametros(xData, yData, out m, out b);

        // Paso 3: Mostrar los parámetros
        Console.WriteLine($"Pendiente (m): {m}");
        Console.WriteLine($"Intersección (b): {b}");

        // Paso 4: Predicción
        double xPredecir = 2.5;
        double yPredicho = PredecirY(xPredecir, m, b);
        Console.WriteLine($"El valor predicho de y para x = {xPredecir} es {yPredicho}");
    }

    // Función para calcular los parámetros m y b del modelo lineal
    public static void CalcularParametros(List<double> xData, List<double> yData, out double m, out double b)
    {
        int n = xData.Count;

        double sumX = xData.Sum();
        double sumY = yData.Sum();
        double sumX2 = xData.Sum(x => x * x);
        double sumXY = xData.Zip(yData, (x, y) => x * y).Sum();

        // Fórmulas para m y b
        m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b = (sumY - m * sumX) / n;
    }

    // Función para predecir y para un valor dado de x usando el modelo lineal
    public static double PredecirY(double x, double m, double b)
    {
        return m * x + b;
    }
}


```


### Ejemplos en java

[Ejemplo 1](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeRegresion1.java)

[Ejemplo 2](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeRegresion2.java)

[Ejemplo 3](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeRegresion3.java)

[Ejemplo 4](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeRegresion4.java)




---------------------------------------------------------------------------------------------

## Método De Interpolación De Lagrange.
### Descripción: 

El método de interpolación de Lagrange es una técnica en métodos numéricos que permite encontrar un polinomio que pasa por un conjunto de puntos dados. Este polinomio se utiliza para interpolar valores intermedios entre los puntos dados.

### Pseudocódigo: 
```

Inicio

   // Paso 1: Recopilación de Datos
// Suponemos que tenemos los datos en dos listas: x_data y y_data
x_data = [x0, x1, x2, ..., xn]
y_data = [y0, y1, y2, ..., yn]

// Paso 2: Construcción del Polinomio de Lagrange
función polinomio_lagrange(i, x):
    resultado = 1
    para j desde 0 hasta n:
        si j != i:
            resultado *= (x - x_data[j]) / (x_data[i] - x_data[j])
    retornar resultado

función polinomio_interpolador(x):
    resultado = 0
    para i desde 0 hasta n:
        resultado += y_data[i] * polinomio_lagrange(i, x)
    retornar resultado

// Paso 3: Interpolación
// Ejemplo de uso:
x_interpolar = 2.5
y_interpolado = polinomio_interpolador(x_interpolar)
imprimir("El valor interpolado de y para x =", x_interpolar, "es", y_interpolado)

Fin

```


### Implementación: 
- Implementacion en C#

```
 using System;
using System.Collections.Generic;
using System.Linq;

public class InterpolacionLagrange
{
    public static void Main(string[] args)
    {
        // Paso 1: Recopilación de Datos
        List<double> xData = new List<double> { 1, 2, 3, 4 };
        List<double> yData = new List<double> { 2, 3, 5, 4 };

        // Paso 2: Construcción del Polinomio de Lagrange y Evaluación
        double xInterpolar = 2.5;
        double yInterpolado = InterpolarLagrange(xInterpolar, xData, yData);

        // Paso 3: Mostrar el Resultado
        Console.WriteLine($"El valor interpolado de y para x = {xInterpolar} es {yInterpolado}");
    }

    // Función para calcular el polinomio de Lagrange
    public static double PolinomioLagrange(int i, double x, List<double> xData)
    {
        double resultado = 1;
        for (int j = 0; j < xData.Count; j++)
        {
            if (j != i)
            {
                resultado *= (x - xData[j]) / (xData[i] - xData[j]);
            }
        }
        return resultado;
    }

    // Función para interpolar usando el método de Lagrange
    public static double InterpolarLagrange(double x, List<double> xData, List<double> yData)
    {
        double resultado = 0;
        for (int i = 0; i < xData.Count; i++)
        {
            resultado += yData[i] * PolinomioLagrange(i, x, xData);
        }
        return resultado;
    }
}

```


### Ejemplos en java

[Ejemplo 1](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeLagrange1.java)

[Ejemplo 2](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeLagrange2.java)

[Ejemplo 3](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeLagrange3.java)

[Ejemplo 4](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeLagrange4.java)



----------------------------------------------------------------------------------


## Método De Interpolación De Newton.
### Descripción: 

El método de interpolación de Newton es otra técnica utilizada en métodos numéricos para encontrar un polinomio que pase a través de un conjunto de puntos dados. A diferencia del método de Lagrange, el método de Newton utiliza las diferencias divididas para calcular el polinomio interpolante.

### Pseudocódigo 
```

Inicio
   // Paso 1: Recopilación de Datos
// Suponemos que tenemos los datos en dos listas: x_data y y_data
x_data = [x0, x1, x2, ..., xn]
y_data = [y0, y1, y2, ..., yn]

// Paso 2: Cálculo de Diferencias Divididas
// Crear una tabla de diferencias divididas
para i desde 0 hasta n:
    f[i, 0] = y_data[i]

para j desde 1 hasta n:
    para i desde 0 hasta n-j:
        f[i, j] = (f[i+1, j-1] - f[i, j-1]) / (x_data[i+j] - x_data[i])

// Paso 3: Construcción del Polinomio de Newton
función polinomio_newton(x):
    resultado = f[0, 0]
    temp = 1
    para i desde 1 hasta n:
        temp *= (x - x_data[i-1])
        resultado += f[0, i] * temp
    retornar resultado

// Paso 4: Interpolación
// Ejemplo de uso:
x_interpolar = 2.5
y_interpolado = polinomio_newton(x_interpolar)
imprimir("El valor interpolado de y para x =", x_interpolar, "es", y_interpolado)

Fin

```

### Implementación: 
- Implementacion en Python

```
using System;
using System.Collections.Generic;

public class InterpolacionNewton
{
    public static void Main(string[] args)
    {
        // Paso 1: Recopilación de Datos
        List<double> xData = new List<double> { 1, 2, 3, 4 };
        List<double> yData = new List<double> { 2, 3, 5, 4 };

        // Paso 2: Cálculo de Diferencias Divididas
        double[,] f = CalcularDiferenciasDivididas(xData, yData);

        // Paso 3: Construcción del Polinomio de Newton y Evaluación
        double xInterpolar = 2.5;
        double yInterpolado = InterpolarNewton(xInterpolar, xData, f);

        // Paso 4: Mostrar el Resultado
        Console.WriteLine($"El valor interpolado de y para x = {xInterpolar} es {yInterpolado}");
    }

    // Función para calcular las diferencias divididas
    public static double[,] CalcularDiferenciasDivididas(List<double> xData, List<double> yData)
    {
        int n = xData.Count;
        double[,]

```


### Ejemplos en java:

[Ejemplo 1](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeNewton1.java)

[Ejemplo 2](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeNewton2.java)

[Ejemplo 3](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeNewton3.java)

[Ejemplo 4](https://github.com/BrandonHDZ2102/T5-E2-Problemario/blob/main/src/problemariot5/MetodoDeNewton4.java)



---------------------------------------------------------------------------------
