package br.feevale.modelo;

import java.sql.Timestamp;

public class Usuario {

	private Integer idUsuario;
	private String dsNome;
	private String dsEmail;
	private Timestamp dtInclusao;
	private Timestamp dtNascimento;
	private String dsInfoSenha;
	private String tpSexo;
	private Double dsRenda;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario( Integer idUsuario ) {
		this.idUsuario = idUsuario;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome( String dsNome ) {
		this.dsNome = dsNome;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail( String dsEmail ) {
		this.dsEmail = dsEmail;
	}

	public Timestamp getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao( Timestamp dtInclusao ) {
		this.dtInclusao = dtInclusao;
	}

	public Timestamp getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento( Timestamp dtNascimento ) {
		this.dtNascimento = dtNascimento;
	}

	public String getDsInfoSenha() {
		return dsInfoSenha;
	}

	public void setDsInfoSenha( String dsInfoSenha ) {
		this.dsInfoSenha = dsInfoSenha;
	}

	public String getTpSexo() {
		return tpSexo;
	}

	public void setTpSexo( String tpSexo ) {
		this.tpSexo = tpSexo;
	}

	public Double getDsRenda() {
		return dsRenda;
	}

	public void setDsRenda( Double dsRenda ) {
		this.dsRenda = dsRenda;
	}
}