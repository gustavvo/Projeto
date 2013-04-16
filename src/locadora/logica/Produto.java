package locadora.logica;

public class Produto {

	private String titulo;
	private String classificacao;
	private double preco;
	private String cpfLocado;
	private int id;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getCpfLocado() {
		return cpfLocado;
	}
	
	public void setCpfLocado(String cpfLocado) {
		this.cpfLocado = cpfLocado;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
