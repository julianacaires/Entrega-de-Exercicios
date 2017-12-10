package service;

import to.MercadoriaTO;
import dao.MercadoriaDAO;


public class MercadoriaService {
	MercadoriaDAO dao;
	
	public MercadoriaService() {
		dao = new MercadoriaDAO();
	}
	
	public void criar(MercadoriaTO to) {
		dao.incluir(to);
	}
	
	public void atualizar(MercadoriaTO to){
		dao.atualizar(to);
	}
	
	public void excluir(MercadoriaTO to){
		dao.excluir(to);
	}
	
	public MercadoriaTO carregar(int codMerca){
		MercadoriaTO to = dao.carregar(codMerca);
		return to;
	}
}
