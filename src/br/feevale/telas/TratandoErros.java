package br.feevale.telas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TratandoErros {

	public static void main(String[] args) throws IOException {
		
		FileInputStream leitor = null;
		
		try {
			
			System.out.println( "Vou tentar abrir o arquivo" );
			leitor = new FileInputStream( "/User/carlos/projetos/Feevale/workspace/InterfacesSwing/src/br/feevale/telas/TelaAlunos.java" );
			System.out.println( "Arquivo aberto com sucesso!" );
			
		} catch( FileNotFoundException e ) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, "Não consegui abrir o arquivo: " + e.getMessage() );
		} finally {
			if( leitor != null ) {
				leitor.close();
			}
		}
		
	}
	
}