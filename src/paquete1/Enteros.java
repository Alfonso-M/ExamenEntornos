package paquete1;
/**
 * 
 * @author almip
 *
 */
public class Enteros {
	/**
	 * Calcula el factorial de un número, si se le pasa n con valor 0 saca 
	 * como resultado 1, este metodo se llama a si mismo para calcular el 
	 * factorial del numero que recibe.
	 * @param n Es un entero y el numero que se usa para calcular el factorial
	 * @return El factorial de n
	 */
public static int r_factorial(int n) {
		int resultado;

		if (n == 0) {
			resultado = 1;
		} else {
			resultado = n * r_factorial(n - 1);
		}
		return resultado;
}

/**
 * Calcula el factorial de un numero que recibe como parametro, usa un bucle 
 * for para ello.
 * @param n Es un entero y el numero que se usa para calcular el factorial.
 * @return El factorial de n.
 */
public static int factorial(int n) {
		int resultado;

		resultado = 1;
		for (int i = 2; i <= n; i++) {
			resultado = resultado * i;
		}
		return resultado;
}

/**
 * Recibiendo dos enteros devuelve verdadero si el primer numero es 
 * divisible entre el segundo (dividir el primero entre el segundo da 
 * resto 0) y falso en caso contrario.
 * @param multiplo numero a dividir.
 * @param divisor numero que divide.
 * @return Verdadero o falso si el primer numero es divisible entre el segundo.
 */
public static boolean divisible(int multiplo, int divisor) {
		boolean resultado;

		if (multiplo % divisor == 0) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
}

/**
 * Recibiendo dos enteros devuelve verdadero si el primer numero es 
 * multiplo del segundo (dividir el primero entre el segundo da resto 
 * 0) y falso en caso contrario.
 * @param multiplo numero a dividir.
 * @param divisor que divide.
 * @return Verdadero o falso si el primer numero es multiplo del segundo.
 */
public static boolean multiplo(int mult, int divisor) {
		boolean resultado;

		try {
			if (mult % divisor == 0) {
				resultado = true;
			} else {
				resultado = false;
			}
		} catch (ArithmeticException e) {
			resultado = false;
		}
		return resultado;
}

/**
 * Recibe un numero y comprueba que no tenga ningun divisor lo que lo 
 * convierte en primo dando como resultado verdadero de serlo y falso 
 * de no serlo y para calcular si es primo o no llama al metodo 
 * "divisible".
 * @param n Numero entero que se usa para comprobar si es o no primo.
 * @return Verdadero o falso dependiendo de si n es verdadero o falso.
 */
public static boolean esPrimo(int n) {
		boolean primo;

		if (n <= 1) {
			primo = false;
		} else {
			primo = true;
			int i = 2;
			while (primo && i <= n / 2) {
				if (divisible(n, i)) {
					primo = false;
				} else {
					i++;
				}
			}
		}
		return primo;
}

/**
 * Este metodo cuanta el numero de primos que hay desde 2 hasta el 
 * numero que recibe como parametro y usando al metodo "esPrimo" 
 * comprueba cual es primo y en caso de serlo suma 1 a un acumulador.
 * @param n Numero entero hasta el que se va ha estar buscando numeros primos.
 * @return El numero de primos que hay desde 2 hasta el n.
 */
public static int n_primos(int n) {
		int resultado = 0;

		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado++;
			}
		}
		return resultado;
}

/**
 * Muestra los primos que hay hasta el numero que recibe como parametro 
 * usando esPrimo y n_primos para calcularlos.
 * @param n Numero entero hasta el que se va ha estar buscando numeros primos.
 * @return Todos los numeros primos que hay desde 2 hasta n.
 */
public static int[] primosHasta(int n) {
		int[] resultado;

		resultado = new int[n_primos(n)];
		int cont = 0;
		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
		}

		return resultado;
}

/**
 * Recibe un numero n como parametro y usando esPrimo para determinar cual 
 * es primo y mostrar los n primeros primos.
 * @param n Numero entero que indica la cantidad de numeros primos ha buscar.
 * @return Los primeros n numeros primos.
 */
public static int[] primerosPrimos(int n) {
		int[] resultado = new int[(n < 0) ? 0 : n];

		int cont = 0;
		int i = 2;
		while (cont < n) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
			i++;
		}

		return resultado;
	}
}
