package br.feevale.telas;

import java.util.ArrayList;
import java.util.HashMap;

public class RevisaoCollection {
	
	public static void main(String[] args) {
		
		// Exemplo com array
		
		Integer[] alturas = new Integer[ 10 ];
		
		alturas[ 0 ] = new Integer( 10 );
		alturas[ 1 ] = new Integer( 425 );
		alturas[ 2 ] = 22;
		
		
		for( Integer vlr : alturas ) {
			System.out.println( vlr );
		}
		
		int valor = 15;
		
		Integer[] anterior = alturas;
		alturas = new Integer[ 45 ];
		
		System.out.println( "\n--[ Array de Integer ]----------------------");
		for( int i = 0; i < anterior.length; i++ ) {
			alturas[ i ] = anterior[ i ];
		}
		
		// Exemplo com ArrayList
		
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add( 10 );
		al.add( new Integer( 425 ) );
		al.add( 22 );
		al.set( 2, 120 );
		
		Integer vl1 = al.get( 0 );
		
		System.out.println( "\n--[ ArrayList ]----------------------");
		for( Integer vlr : al ) {
			System.out.println( vlr );
		}
		
		HashMap<String, Double> hm = new HashMap<>();
		
		hm.put( "Joao", 1.75 );
		hm.put( "Maria", 1.89 );
		hm.put( "Marcelo", 1.62 );
		
		Double vlr = hm.get( "Maria" );
		System.out.println( "Tamanho da maria: " + vlr );
		
	}
	
}









