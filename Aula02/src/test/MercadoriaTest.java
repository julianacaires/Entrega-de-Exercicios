package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Mercadoria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MercadoriaTest {
	Mercadoria Mercadoria, copia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		Mercadoria = new Mercadoria(id, 1, "Bife a Parmegiana", "Prato Principal", 23.00);
		copia = new Mercadoria(id, 1, "Bife a Parmegiana", "Prato Principal", 23.00);
		System.out.println(Mercadoria);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void testCarregar() {
		System.out.println("carregar");
		Mercadoria fixture = new Mercadoria(1, 2, "Risoto com cupim assado", "Prato", 40.00);
		Mercadoria novo = new Mercadoria(1, 0, null, null, 0);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}
					
	@Test
	public void testCriar() {
		System.out.println("criar");
		Mercadoria.criar();
		id = Mercadoria.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", Mercadoria, copia);
	}
	
	@Test
	public void testAtualizar() {
		System.out.println("atualizar");
		Mercadoria.setTipo("Sobremesa");
		copia.setTipo("Sobremesa");
		Mercadoria.atualizar();
		Mercadoria.carregar();
		assertEquals("testa atualizacao", Mercadoria, copia);
	}

	@Test
	public void testExcluir() {
		System.out.println("excluir");
		copia.setId(0);
		copia.setCodMercadoria(0);
		copia.setDescricao(null);
		copia.setTipo(null);
		copia.setPreco(0);
		Mercadoria.excluir();
		Mercadoria.carregar();
		assertEquals("testa exclusao", Mercadoria, copia);
	}
	
}
