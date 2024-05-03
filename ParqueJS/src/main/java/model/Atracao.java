package model;

public class Atracao {
	private int id;
	private String nome;
    private String categoria;
    private double preco;
    private String img;
    private int quantidade;
    
    public Atracao() {
		
		
	}
    
	public Atracao(int id, String nome, String categoria, double preco, String img, int quantidade) {
		
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.img = img;
		this.quantidade = quantidade;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Atracao [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + ", img=" + img
				+ ", quantidade=" + quantidade + "]";
	}

	
    
	
	

}
