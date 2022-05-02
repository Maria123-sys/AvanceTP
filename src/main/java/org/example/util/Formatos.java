package org.example.util;

public class Formatos {
	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
	    return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}
}
