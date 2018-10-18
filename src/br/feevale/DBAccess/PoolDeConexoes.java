package br.feevale.DBAccess;

import java.util.ArrayList;

// Classe singleton para manipular um conjunto de objetos
// Conexao
public class PoolDeConexoes {
	
	private ArrayList<Conexao> conexoes;
	
	private PoolDeConexoes() {
		// instanciar o atributo conexoes
		// e iniciá-lo com 10 conexões ao Banco de Dados
	}
	
	public static PoolDeConexoes getInstance() {

		// Substituir este return null pela lógica da criação
		// de classes Singleton, conforme visto em aula e especificado
		// na classe Parametros.
		return null;
	}
	
	public Conexao getConexao() {
		
		// Substituir este return null pelo return de um objeto Conexao;
		// Para obter a conexão, o método deverá percorrer a lista de conexões
		// (atributo 'conexoes') testando se a conexão está livre;
		// caso esteja livre, reserve a conexao através do método
		// reserva() e retorne esta conexão;  Se a conexão não estiver livre
		// teste a próxima e assim sucessivamente.
		
		return null;
	}
}