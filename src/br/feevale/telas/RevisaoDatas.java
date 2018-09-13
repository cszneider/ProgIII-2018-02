package br.feevale.telas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RevisaoDatas {
	
	public static void main(String[] args) {
		
		Calendar agora = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
		System.out.println( "Entrada : " + sdf.format( new Date( agora.getTimeInMillis() ) ) );
		
		System.out.println( "Dia da Semana: " + agora.get( Calendar.DAY_OF_WEEK ) );

		for( int i = 0; i < 10; i++ ) {

			agora.add( Calendar.DAY_OF_MONTH, 28 );
			System.out.println( (i + 1) + " Prestacao : " + sdf.format( new Date( agora.getTimeInMillis() ) ) );
		}
		
		Calendar nascimento = Calendar.getInstance();
		nascimento.set( 1960, 10, 25 );
		
		System.out.println( "Dia da semana: " + nascimento.get( Calendar.DAY_OF_WEEK ) );
	}
	
}






