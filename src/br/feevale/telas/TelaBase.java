package br.feevale.telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaBase extends JFrame implements FocusListener {
	
	private int tamLinha = 30;
	private int margem = 30;
	private int tamColuna = ( 800 - ( 2 * 30 ) )/12;
	
	private Color corFundoCampoTexto = new Color( 230, 230, 230 );
	
	public TelaBase( int x, int y, String titulo ) {
		
		setBounds( x, y, 800, 450 );

		setLayout( null );
		Container container = getContentPane();

		setTituloDoPrograma( titulo );
		
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	}
	
	public TelaBase( String titulo ) {
		
		setBounds( 120, 100, 800, 450 );

		setLayout( null );
		Container container = getContentPane();

		setTituloDoPrograma( titulo );
		
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

	public JTextField addCampoTexto( int coluna, int linha, int colunas ) {
		return addCampoTexto( coluna, linha, colunas, null );
	}
	
	public JTextField addCampoTexto( int coluna, int linha, int colunas, String texto ) {
		
		int x = xDaColuna( coluna );
		int y = yDaLinha( linha );
		
		JTextField l = new JTextField( texto );
		l.setBounds( x, y, colunas * tamColuna, tamLinha );
		getContentPane().add( l );
		
		l.addFocusListener( this );
		
		return l;
	}

	public JButton addBotao( int coluna, int linha, int colunas, String texto ) {
		
		int x = xDaColuna( coluna );
		int y = yDaLinha( linha );
		
		JButton l = new JButton( texto );
		l.setBounds( x, y, colunas * tamColuna, tamLinha );
		getContentPane().add( l );
		
		return l;
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

	@Override
	public void focusGained(FocusEvent e) {

		JTextField tf = (JTextField) e.getSource();
		tf.setBackground( corFundoCampoTexto );
		tf.setForeground( Color.RED );
	}

	@Override
	public void focusLost(FocusEvent e) {

		JTextField tf = (JTextField) e.getSource();
		tf.setBackground( Color.WHITE );
		tf.setForeground( Color.BLACK );
	}
}





















