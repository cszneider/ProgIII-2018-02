package br.feevale.telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class TelaExemplo extends JFrame implements ActionListener, MouseListener {
	
	private int tamLinha = 30;
	private int margem = 30;
	private int tamColuna = ( 800 - ( 2 * 30 ) )/12;
	
	private Color corOriginalDoBotao;
	
	public TelaExemplo() {
		
		setBounds( 120, 100, 800, 450 );

		setLayout( null );
		Container container = getContentPane();

		setTituloDoPrograma( "Feevale - Prog III" );
		
		addLabel( 1,  4, "Codigo" );
		addLabel( 5,  4, "Nome" );
		addLabel( 1,  5, "Logradouro" );
		
		JRadioButton rb1 = new JRadioButton( "Colorado" );
		rb1.setBounds( 200, 150, 120, 23 );
		container.add( rb1 );

		JRadioButton rb2 = new JRadioButton( "Fluminense" );
		rb2.setBounds( 200, 180, 120, 23 );
		container.add( rb2 );

		JRadioButton rb3 = new JRadioButton( "Novo Hamburgo" );
		rb3.setBounds( 200, 210, 120, 23 );
		container.add( rb3 );
		
		ButtonGroup bg = new ButtonGroup();
		bg.add( rb1 );
		bg.add( rb2 );
		bg.add( rb3 );
		
		JButton bt = new JButton( "Ação 1" );
		bt.setBounds( 545, 350, 120, 30 );
		container.add( bt );
		
		// Para adicionar qualquer monitor (listener) a um elemento,
		// é necessário executar as seguintes ações:
		//
		// 1) Implementar o Listener desejado 
		//    - para nosso exemplo, implementaremos o ActionListener,
		//      que nos obriga a criar o método actionPerformed() como 
		//      pode ser visto abaixo, nesta classe.
		// 2) Associar o listener ao elemento swing desejado.
		//    - para nosso exemplos, faremos a conexao com o botão:
		
		bt.addActionListener( this );
		bt.addMouseListener( this );
		bt.setOpaque( true );
		
		bt = new JButton( "Ação 2" );
		bt.setBounds( 665, 350, 120, 30 );
		container.add( bt );
		bt.setOpaque( true );
		
		bt.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				executaAcaoDoSegundoBotao( e );
			}
		} );
		
		bt.addMouseListener( this );
		
		setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	}
	
	protected void executaAcaoDoSegundoBotao(ActionEvent e) {

		JOptionPane.showMessageDialog( null, "Este é a ação associada ao segundo botão" );
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

	@Override
	public void actionPerformed( ActionEvent e ) {

		JOptionPane.showMessageDialog( null, "Hello World!" );
	}

	@Override
	public void mouseClicked( MouseEvent e ) {}

	@Override
	public void mousePressed( MouseEvent e ) {}

	@Override
	public void mouseReleased( MouseEvent e ) {}

	@Override
	public void mouseEntered( MouseEvent e ) {
		
		System.out.println( "****************" );
		JButton bt = (JButton) e.getSource();
		corOriginalDoBotao = bt.getBackground();
		
		System.out.println( bt.getText() );
		
		bt.setBackground( Color.RED );
	}

	@Override
	public void mouseExited( MouseEvent e ) {

		System.out.println( "#############" );
		JButton bt = (JButton) e.getSource();
		bt.setBackground( corOriginalDoBotao );
	}
}





















