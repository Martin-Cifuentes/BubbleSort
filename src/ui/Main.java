package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
	public static int[] nombreDelArreglo;
	public final static String SEP = " ";
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		pedirDatos();
		

	}
	public static void pedirDatos() throws IOException {
		try {
			
		
			int cantLineas;
			System.out.println("Ingrese La cantidad de lineas y las edades");
			
			cantLineas = Integer.parseInt(br.readLine());
			
			String line = "";
			String ans = "";
			for(int i = 0; i < cantLineas; i++) {
				line = br.readLine();
				String[] parts = line.split(SEP);
				double[] ages = toDoubleArray(parts);
				//System.out.println(printArray(ages));
				double prom = bubbleShort(ages);
				organizeArray(ages);
				ans += "[" + prom + "]" + printArray(ages);
			}
			System.out.println("\nEdades oprganizadas:");
			System.out.println(ans);
		}
		catch(NumberFormatException nfe) {
			System.out.println("La cantidad de lineas debe ser numerico");
		}
	}
	/*
3
5.41 6.23 2.39 3.45 1.84
7.25 3.18 8.42 6.42 4.36 5.78
6.89 2.56 4.44 9.56 2.273

	 */
	public static double bubbleShort(double[] nombreDelArreglo) {
		int changes = 0;
		int laps = 0;
		for(int j = 0; j < nombreDelArreglo.length-1; j++) {
			for(int i = 0; i < nombreDelArreglo.length-1; i++) {
				if(nombreDelArreglo[i]>nombreDelArreglo[i+1]) {
					double temp = nombreDelArreglo[i];
					nombreDelArreglo[i] = nombreDelArreglo[i + 1];
					nombreDelArreglo[i + 1] = temp;
					changes++;
				}
				
			}
			laps++;
		}
		
		return 1.0*changes/laps;
		
	}
	public static void organizeArray(double[] array) {
		for( int i = 0; i<array.length; i++) {
			array[i] = array[i] * 100;
			array[i] = (int)array[i];
			array[i] = array[i]/100;
		}
	}
	public static String printArray(double[] array) {
		String s = "";
		for (int i = 0; i < array.length; i++) {
			s += array[i] + " ";
		}
		return s + "\n";
	}
	public static double[] toDoubleArray(String[] strArray) {
		double[] doubleArray = new double[strArray.length];
		try {
			for(int i = 0; i< strArray.length; i++) {
				doubleArray[i] = Double.parseDouble(strArray[i]);
			}
		}
		catch(NumberFormatException nfe) {
			System.out.println("Las edades deben ser numericas");
		}
		
		return doubleArray;
		
	}
}
