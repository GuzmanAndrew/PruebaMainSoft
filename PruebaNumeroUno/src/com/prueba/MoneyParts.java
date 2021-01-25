package com.prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class MoneyParts {

	public static void main(String[] args) {
		
		double m = 0.1;
		ArrayList<Double> numero = new ArrayList<>();
		build(m, numero, 0.00);
	}
	
	public static void build(double m, ArrayList<Double> numeros, double d) {
	
		if (d == m) {
			System.out.println("Lista de numeros: " + numeros);
		} else {
			double[] r = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10,20, 50, 100, 200};
			
			for (double i : r) {
				d += i;
				if (d <= m) {
					numeros.add(i);				
					build(m, numeros, d);
					numeros.remove(numeros.indexOf(i));
				}
				d -= i;
			}
		}
	}


}
