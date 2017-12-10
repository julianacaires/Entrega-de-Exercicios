package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.MercadoriaTO;

public class MercadoriaDAO {
	public void incluir(MercadoriaTO to) {
		String sqlInsert = "INSERT INTO MERCADORIAS (cod_mercadoria, descricao, tipo, preco) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodMercadoria());
			stm.setString(2, to.getDescricao());
			stm.setString(3, to.getTipo());
			stm.setDouble(4, to.getPreco());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); 
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(MercadoriaTO to) {
		String sqlUpdate = "UPDATE mercadorias SET cod_mercadoria = ?, descricao = ?, tipo = ? , preco = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getCodMercadoria());
			stm.setString(2, to.getDescricao());
			stm.setString(3, to.getTipo());
			stm.setDouble(4, to.getPreco());
			stm.setInt(5, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(MercadoriaTO to) {
		String sqlDelete = "DELETE FROM mercadorias WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MercadoriaTO carregar(int id) {
		MercadoriaTO to = new MercadoriaTO();
		String sqlSelect = "SELECT cod_mercadoria, descricao, tipo, preco FROM mercadorias WHERE mercadorias.id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCodMercadoria(rs.getInt("cod_mercadoria"));
					to.setDescricao(rs.getString("descricao"));
					to.setTipo(rs.getString("tipo"));
					to.setPreco(rs.getDouble("preco"));
					
				} else {
					to.setId(-1);
					to.setCodMercadoria(0);
					to.setDescricao(null);
					to.setTipo(null);
					to.setPreco(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public ArrayList<MercadoriaTO> listarMercadorias() {
		MercadoriaTO to;
		ArrayList<MercadoriaTO> lista = new ArrayList<>();
		String sqlSelect = "";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new MercadoriaTO();
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<MercadoriaTO> listarMercadorias(String chave) {
		MercadoriaTO to;
		ArrayList<MercadoriaTO> lista = new ArrayList<>();
		String sqlSelect = "";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new MercadoriaTO();
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}
}