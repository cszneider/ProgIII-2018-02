package br.feevale.telas;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaExemplo extends JFrame {
	
	public TelaExemplo() {
		
		setBounds( 120, 100, 800, 350 );

		setLayout( new FlowLayout() );
		Container container = getContentPane();
		
		// 1 passo: criar o objeto
		JLabel lbl = new JLabel( "Prog III - Feevale" );
		// 2 passo: adicionar ao container
		//container.add( lbl );
		// 3 passo: dimensiono e posiciono o elemento
		lbl.setBounds( 400, 300, 200, 23 );
		
		
		setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	}
	
	
	public static void main(String[] args) {
		new TelaExemplo();
	}
}