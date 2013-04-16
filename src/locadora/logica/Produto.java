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

public class Produto {

	private String titulo;
	private String classificacao;
	private double preco;
	private String cpfLocador;
	private int id;
	
	/**
	 * 
	 * @return título
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Set título
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * 
	 * @return classificação
	 */
	public String getClassificacao() {
		return classificacao;
	}
	
	/** 
	 * Set classificação
	 * @param classificacao
	 */
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	/**
	 * 
	 * @return preço
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Set preço
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * 
	 * @return cpf do locador
	 */
	public String getCpfLocador() {
		return cpfLocador;
	}
	
	/**
	 * Set cpf do locador
	 * @param cpfLocador
	 */
	public void setCpfLocador(String cpfLocador) {
		this.cpfLocador = cpfLocador;
	}
	
	/**
	 * 
	 * @return id do produto
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set id do produto
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
 