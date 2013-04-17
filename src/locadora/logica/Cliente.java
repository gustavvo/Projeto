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


public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String id;
	
	/**
	 * @return retorna o nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Set nome
	 * @param nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return retorna o cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Set cpf
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * 
	 * @return telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Set telefone
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * 
	 * @return id do cliente
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set id do cliente
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Cliente() {
	}
	
}
