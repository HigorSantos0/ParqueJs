package model;

import java.util.ArrayList;
import java.util.List;

public class Parque {
    private String nome;
    private int id;
    private List<Atracao> atracoes;
    
    public Parque() {
    	
    }
    
    public Parque(String nome, int id, List<Atracao> atracoes) {
	
		this.nome = nome;
		this.id = id;
		this.atracoes = atracoes;
	}
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Getters and setters (unchanged)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atracao> getAtracoes() {
        // Return a defensive copy to prevent modification of the original list
        return new ArrayList<>(atracoes);
    }

    public void setAtracoes(List<Atracao> atracoes) {
        this.atracoes = atracoes;
    }

    public void addAtracao(Atracao atracao) {
        this.atracoes.add(atracao);
    }


    @Override
    public String toString() {
        return "Parque [nome=" + nome + ", atracoes=" + atracoes + "]";
    }
}
