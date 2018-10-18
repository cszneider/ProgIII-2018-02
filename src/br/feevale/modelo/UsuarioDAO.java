package br.feevale.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.feevale.DBAccess.Conexao;
import br.feevale.DBAccess.DBAccessException;
import br.feevale.DBAccess.PoolDeConexoes;

public class UsuarioDAO {
	
	public static Usuario buscaUsuarioPorId( Integer idUsuario ) throws SQLException {
		
		Conexao cnx = PoolDeConexoes.getInstance().getConexao();
		
		try {
			String cmd = "select * from Usuarios where idUsuario = ?";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setInt( 1, idUsuario );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				return carregaInformacoesDoUsuario( rs );
			} else {
				return null;
			}
		} finally {
			cnx.libera();
		}
	}

	public static Usuario buscaUsuarioPorEmail( String dsEmail ) throws SQLException {
		
		Conexao cnx = PoolDeConexoes.getInstance().getConexao();
		
		try {
			String cmd = "select * from Usuarios where dsEmail = ?";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, dsEmail );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				return carregaInformacoesDoUsuario( rs );
			} else {
				return null;
			}
		} finally {
			cnx.libera();
		}
	}
	
	public static ArrayList<Usuario> getUsuariosComNome( String dsNome ) throws SQLException {

		Conexao cnx = PoolDeConexoes.getInstance().getConexao();
		
		try {
			String cmd = "select * from Usuarios where dsNome ilike ? order by dsNome";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, dsNome + "%" );
			
			ResultSet rs = ps.executeQuery();

			ArrayList<Usuario> result = new ArrayList<>();
			
			while( rs.next() ) {
				result.add( carregaInformacoesDoUsuario( rs ) );
			}
			
			return result;
		} finally {
			cnx.libera();
		}
	}

	private static Usuario carregaInformacoesDoUsuario(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario( rs.getInt( "idUsuario" ) );
		usuario.setDsNome( rs.getString( "dsNome" ) );
		usuario.setDsEmail( rs.getString( "dsEmail" ) );
		usuario.setDtInclusao( rs.getTimestamp( "dtInclusao" ) );
		usuario.setDtNascimento( rs.getTimestamp( "dtNascimento" ) );
		usuario.setDsInfoSenha( rs.getString( "dsInfoSenha" ) );
		usuario.setTpSexo( rs.getString( "tpSexo" ) );
		usuario.setDsRenda( rs.getDouble( "dsRenda" ) );
		
		return usuario;
	}

	public static void insere( Usuario usuario ) throws SQLException {
		
		Conexao cnx = PoolDeConexoes.getInstance().getConexao();
		
		try {
			String cmd = "insert into usuarios \r\n" + 
					"( idUsuario, dsNome, dsEmail, dtInclusao, dtNascimento, dsInfoSenha, tpSexo, dsRenda )\r\n" + 
					"values\r\n" + 
					"( ?, ?, ?, ?, ?, ?, ?, ? )";
			
			testaRegrasDeNegocio( usuario );
			
			usuario.setDtInclusao( new Timestamp( System.currentTimeMillis() ) );
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setInt( 1, usuario.getIdUsuario() );
			ps.setString( 2, usuario.getDsNome() );
			ps.setString( 3, usuario.getDsEmail() );
			ps.setTimestamp( 4, usuario.getDtInclusao() );
			ps.setTimestamp( 5, usuario.getDtNascimento() );
			ps.setString( 6, usuario.getDsInfoSenha() );
			ps.setString( 7, usuario.getTpSexo() );
			ps.setDouble( 8, usuario.getDsRenda() );
			
			ps.execute();
		} finally {
			cnx.libera();
		}
	}
	
	public static void altera( Usuario usuario ) {
		// preencher com o código da alteração no DB (update)
		// não esquecer de testar as regras de negócio
	}
	
	public static void exclui( Usuario usuario ) {
		// preencher com o código da exclusão
	}

	private static void testaRegrasDeNegocio(Usuario usuario) throws DBAccessException {

		if( !usuario.getTpSexo().matches( "M|F|O|N" ) ) {
			throw new DBAccessException( "O sexo do usuário precisa ser: M - Masculino; F - Feminino; O - Outros; N - Não desejo informar." );
		}
	}
	
}