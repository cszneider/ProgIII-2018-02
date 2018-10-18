package br.feevale.DBAccess;

import java.io.IOException;

public class TestaParametros {
	
	public static void main(String[] args) throws IOException {
			
		Parametros prm = Parametros.getInstance();
		
		System.out.println( "URL Banco: " + prm.getParametro( "urlBanco" ) );
		System.out.println( "CNPJ     : " + prm.getParametro( "cnpj" ) );
		System.out.println( "Nro Sala : " + prm.getParametro( "nrSala" ) );
	}
}