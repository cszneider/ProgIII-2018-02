package br.feevale.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

import br.feevale.modelo.Usuario;
import br.feevale.modelo.UsuarioDAO;

public class DBExemplos {

	public void buscaUsuarioComDAO() throws SQLException {
	
		Usuario usuario = UsuarioDAO.buscaUsuarioPorId( 10 );
		
		if( usuario != null ) {
			System.out.println( "Usuario encontrado: " + usuario.getDsNome() );
		} else {
			System.out.println("O usuário não foi encontrado");
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection cnx = conectaComBanco();

		try {
			
//			executaInsertModo1( cnx, 2, "John Mayer", "john@hotmail.com", "M", 35923.33 );
//			executaInsertModo2( cnx, 3, "Paul McArtney", "paulmc@gmail.com", "M", 9135223.43 );
			
			listaUsuariosSelect( cnx );
			
		} finally {
			cnx.close();
			System.out.println( "Conexão com o banco encerrada" );
		}
	}

	private static void listaUsuariosSelect( Connection cnx ) throws SQLException {

		String cmd = "select * from usuarios where tpSexo = 'M';";
		
		Statement st = cnx.createStatement();
		ResultSet resultado = st.executeQuery( cmd );

		if( resultado.next() ) {

			while( !resultado.isAfterLast() ) {
				
				String nome = resultado.getString( "dsNome" );
				Integer id = resultado.getInt( 1 );
				String email = resultado.getString( "dsEmail" );
				Double renda = resultado.getDouble( "dsRenda" );
				
				System.out.println( String.format( "%d - %-20.20s %-17.17s %9.2f", id, nome, email, renda ) );
				
				resultado.next();
			}
		} else {
			System.out.println( "Nenhum resultado obtido" );
		}
	}

	private static void executaInsertModo2( Connection cnx, 
			int id, String nome, String email, 
			String sexo, double proventos) throws SQLException {

		String cmd = "insert into usuarios \r\n" + 
				"( idUsuario, dsNome, dsEmail, dtInclusao, tpSexo, dsRenda )\r\n" + 
				"values\r\n" + 
				"( ?, ?, ?, ?, ?, ? )";
		
		Calendar agora = Calendar.getInstance();
		
		PreparedStatement ps = cnx.prepareStatement( cmd );
		ps.setInt( 1, id );
		ps.setString( 2, nome );
		ps.setString( 3, email );
		ps.setTimestamp( 4, new Timestamp( agora.getTimeInMillis() ) );
		ps.setString( 5, sexo );
		ps.setDouble( 6, proventos );

		ps.execute();
	}

	private static void executaInsertModo1( Connection cnx, 
			int id, String nome, String email, 
			String sexo, double proventos ) throws SQLException {

		
		String cmd = "insert into usuarios \r\n" + 
				"( idUsuario, dsNome, dsEmail, dtInclusao, tpSexo, dsRenda )\r\n" + 
				"values\r\n" + 
				"( %d, '%s', '%s', current_timestamp, '%s', %s )";
		
		cmd = String.format( cmd, id, nome, email, sexo, Double.toString( proventos ) );
		
		System.out.println( cmd );
		
		Statement st = cnx.createStatement();
		st.execute( cmd );
		
	}

	private static Connection conectaComBanco() throws ClassNotFoundException, SQLException {

		String driverJDBC = "org.postgresql.Driver";
		String urlBanco = "jdbc:postgresql://localhost:5432/ProgIII";
		String nomeUsuario = "postgres";
		String senha = "feevale";

		Class.forName( driverJDBC );
		System.out.println( "Driver importado!" );
		
		Connection result = DriverManager.getConnection( 
				urlBanco, 
				nomeUsuario, 
				senha );
		
		System.out.println( "Conex�o estabelecida!" );
		
		return result;
	}	
}







