package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Atracao;

public class AtracaoDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public AtracaoDao(Connection con) {
		
		this.con = con;
	}
	public AtracaoDao() {
		
	}
	
	
	public List<Atracao>getAllAtracao(){
		List<Atracao> atracao = new ArrayList<>();
		
		try {
			query="select * from atracao";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Atracao row = new Atracao();
				row.setId(rs.getInt("id"));
				row.setNome(rs.getString("nome"));
				row.setCategoria(rs.getString("categoria"));
				row.setPreco(rs.getDouble("preco"));
				row.setImg(rs.getString("img"));
				atracao.add(row);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return atracao;
	}
	
	public Atracao getAtracaoById(int id) {
	    Atracao atracao = null;
	    try {
	        query = "SELECT * FROM atracao WHERE id = ?";
	        pst = this.con.prepareStatement(query);
	        pst.setInt(1, id);
	        rs = pst.executeQuery();
	        if (rs.next()) {
	            atracao = new Atracao();
	            atracao.setId(rs.getInt("id"));
	            atracao.setNome(rs.getString("nome"));
	            atracao.setCategoria(rs.getString("categoria"));
	            atracao.setPreco(rs.getDouble("preco"));
	            atracao.setImg(rs.getString("img"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return atracao;
	}
	
	public void addToCart(HttpSession session, int id, String nome, String categoria, double preco, int quantidade) {

	    List<Atracao> carrinho = (List<Atracao>) session.getAttribute("carrinho");

	    if (carrinho == null) {
	        carrinho = new ArrayList<>();
	        session.setAttribute("carrinho", carrinho);
	    }

	    Atracao newAtracao = new Atracao(id, nome, categoria, preco, "", quantidade);
	    newAtracao.setQuantidade(quantidade); // Defina a quantidade
	    carrinho.add(newAtracao);
	}


}
