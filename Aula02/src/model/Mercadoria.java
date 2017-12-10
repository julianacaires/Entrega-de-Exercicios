package model;

import java.io.Serializable;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class Mercadoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int codMercadoria;
	private String descricao;
	private String tipo;
	private double preco;
	
	public Mercadoria() {
		
	}
	
	public Mercadoria(int id, int codMercadoria, String descricao, String tipo, double preco) {
		this.id = id;
		this.codMercadoria = codMercadoria;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = preco;
	}
	
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void criar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setId(id);
		to.setCodMercadoria(codMercadoria);
		to.setDescricao(descricao);
		to.setTipo(tipo);
		to.setPreco(preco);
		dao.incluir(to);
	}
	
	public void atualizar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setId(id);
		to.setCodMercadoria(codMercadoria);
		to.setDescricao(descricao);
		to.setTipo(tipo);
		to.setPreco(preco);
		dao.atualizar(to);
	}
	
	public void excluir() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setId(id);
		dao.excluir(to);
	}
	
	public void carregar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = dao.carregar(id);
		codMercadoria = to.getCodMercadoria();
		descricao = to.getDescricao();
		tipo = to.getTipo();
		preco = to.getPreco();
	}
	
	@Override
	public String toString() {
		return "Mercadoria [id=" + id + ", codMercadoria=" + codMercadoria + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", preco=" + preco + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercadoria other = (Mercadoria) obj;
		if (codMercadoria != other.codMercadoria)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
}
