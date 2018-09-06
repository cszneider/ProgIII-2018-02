package br.feevale.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaTriangulo extends TelaBase {
	
	private JTextField catAdj;
	private JTextField catOpo;
	private JTextField hipot;
	
	public TelaTriangulo() {
		super( "Triangulo Retângulo" );
		
		addLabel( 1, 5, "Cateto Adjacente" );
		catAdj = addCampoTexto( 3, 5, 2 ); 

		addLabel( 1, 6, "Cateto Oposto" );
		catOpo = addCampoTexto( 3, 6, 2 ); 
		
		addLabel( 1, 7, "Hipotenusa" );
		hipot = addCampoTexto( 3, 7, 2 ); 
		
		JButton bt = addBotao( 2, 9, 4, "Calcular" );
		bt.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculaTriangulo();
			}
		});
		
		setVisible( true );
	}
	
	protected void calculaTriangulo() {

		String txCA = catAdj.getText();
		String txCO = catOpo.getText();
		String txHP = hipot.getText();

		int qtParametrosFornecidos = contaParametrosValidos( txCA, txCO, txHP );
		
		switch( qtParametrosFornecidos ) {
			case 0 : JOptionPane.showMessageDialog( null, "Forneça algum dado para o cálculo do triangulo" );
					 break;
			case 1 : JOptionPane.showMessageDialog( null, "Dados insuficientes para cálculo do Triangulo Retângulo" );
					 break;
			case 2 : calculaDadoQueFalta( txCA, txCO, txHP );
			         break;
			case 3 : verificaDadosDoTriangulo( txCA, txCO, txHP );
		}
	}

	private void calculaDadoQueFalta(String txCA, String txCO, String txHP) {

		if( txCA.isEmpty() && !txCO.isEmpty() && !txHP.isEmpty() ) {
			double vlCo = Double.parseDouble( txCO );
			double vlHp = Double.parseDouble( txHP );
			double vlCa = Math.sqrt( vlHp * vlHp - vlCo * vlCo );

			catAdj.setText( Double.toString( vlCa ) );
		} else if( !txCA.isEmpty() && txCO.isEmpty() && !txHP.isEmpty() ) {

			double vlCa = Double.parseDouble( txCA );
			double vlHp = Double.parseDouble( txHP );
			double vlCo = Math.sqrt( vlHp * vlHp - vlCa * vlCa );

			catOpo.setText( Double.toString( vlCo ) );
			
		} else {
			
			double vlCa = Double.parseDouble( txCA );
			double vlCo = Double.parseDouble( txCO );
			double vlHp = Math.sqrt( vlCo * vlCo + vlCa * vlCa );

			hipot.setText( Double.toString( vlHp ) );
		}
	}

	private void verificaDadosDoTriangulo( String txCA, String txCO, String txHP ) {

		double vlCa = Double.parseDouble( txCA );
		double vlCo = Double.parseDouble( txCO );
		double vlHp = Double.parseDouble( txHP );
		
		double vlHpCalc = Math.sqrt( vlCa * vlCa + vlCo * vlCo );
		
		if( vlHpCalc == vlHp ) {
			JOptionPane.showMessageDialog( null, "Os dados fornecidos conferem com um triângulo retângulo" );
		} else {
			JOptionPane.showMessageDialog( null, "Os dados fornecidos não formam um triângulo retângulo" );
		}
	}

	private int contaParametrosValidos( String txCA, String txCO, String txHP) {

		if( txCA.isEmpty() && txCO.isEmpty() && txHP.isEmpty() ) {
			return 0;
		} else if( ( !txCA.isEmpty() && txCO.isEmpty() && txHP.isEmpty() ) ||
				   ( txCA.isEmpty() && !txCO.isEmpty() && txHP.isEmpty() ) || 
				   ( txCA.isEmpty() && txCO.isEmpty() && !txHP.isEmpty() ) ) {
			return 1;
		} else if( ( !txCA.isEmpty() && !txCO.isEmpty() && txHP.isEmpty() ) ||
				   ( txCA.isEmpty() && !txCO.isEmpty() && !txHP.isEmpty() ) || 
				   ( !txCA.isEmpty() && txCO.isEmpty() && !txHP.isEmpty() ) ) {
			return 2;
		} else {
			return 3;
		}
	}

	public static void main(String[] args) {
		new TelaTriangulo();
	}
}