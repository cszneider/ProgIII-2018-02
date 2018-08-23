package br.feevale.telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaExemplo extends JFrame {
	
	private int tamLinha = 30;
	private int margem = 30;
	private int tamColuna = ( 800 - ( 2 * 30 ) )/12;
	
	public TelaExemplo() {
		
		setBounds( 120, 100, 800, 350 );

		setLayout( null );
		Container container = getContentPane();

		setTituloDoPrograma( "Feevale - Prog III" );
		
		addLabel( 1,  4, "Codigo" );
		addLabel( 5,  4, "Nome" );
		addLabel( 1,  5, "Logradouro" );
		
		setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	}
	
	private void setTituloDoPrograma( String titulo ) {

		Color cor = new Color( 173, 255, 77 );
		Font fonte = new Font( "Kailasa", Font.PLAIN, 20 );
		
		// 1 passo: criar o objet o
		JLabel lbl = new JLabel( titulo );
		// 2 passo: adicionar ao container
		getContentPane().add( lbl );
		// 3 passo: dimensiono e posiciono o elemento
		lbl.setBounds( 0, 0, 800, 35 );
		
		lbl.setForeground( cor );
		lbl.setBackground( Color.DARK_GRAY );
		lbl.setOpaque( true );
		lbl.setFont( fonte );
		lbl.setHorizontalAlignment( SwingConstants.CENTER );
	}

	public JLabel addLabel( int coluna, int linha, String texto ) {
		 
		int x = xDaColuna( coluna );
		int y = yDaLinha( linha );
		
		JLabel l = new JLabel( texto );
		l.setBounds( x, y, 200, 32 );
		getContentPane().add( l );
		
		return l;
	}
	
	private int yDaLinha(int linha) {
		return ( linha - 1 ) * tamLinha;
	}

	private int xDaColuna(int coluna) {

		return margem + ( (coluna - 1) * tamColuna );
	}

	public static void main(String[] args) {
		new TelaExemplo();
	}
}





















