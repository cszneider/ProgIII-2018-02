package br.feevale.telas;

public class TelaAlunos extends TelaBase {
	
	public TelaAlunos() {
		super( 200, 150, "Tela Manutenção ALUNOS" );
		
		addLabel( 5, 7, "Esta é a Tela Alunos" );
		
		addCampoTexto( 3, 4, 10 );
		addCampoTexto( 3, 5, 10 );
		addCampoTexto( 3, 6, 10 );
		
		setVisible( true );
	}
	
	public static void main(String[] args) {
		new TelaAlunos();
	}
}