/*
 * Instituto Federal de Educação, Ciência e Tecnologia da Paraíba
 * Campus Campina Grande
 * Componente Curricular: Desenvolvimento Web
 * 
 * Sistema de Locadora WEB
 * 
 * @author Hallyson Gustavo, Vinicius Fernandes
 * 
 * 
 */

package locadora.logica;

public class Usuario {
	
	private String nome;
	private String senha;
	
	
	/**
	 * 
	 * @return nome do usuário
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Set nome de usuário
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return senha do usuario
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Set senha do usuario
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
