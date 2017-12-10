package to;

public class MercadoriaTO {
	private int id;
	private int codMercadoria;
	private String descricao;
	private String tipo;
	private double preco;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodMercadoria() {
		return codMercadoria;
	}
	
	public void setCodMercadoria(int codMercadoria) {
		this.codMercadoria = codMercadoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
