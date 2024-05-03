package model;

import java.util.ArrayList;
import java.util.List;

import model.ItemCarrinho;

public class Carrinho {

    private List<ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(int produtoId, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produtoId, quantidade);
        itens.add(item);
    }

    public void removerItem(int produtoId) {
        itens.removeIf(item -> item.getProdutoId() == produtoId);
    }

    public void alterarQuantidadeItem(int produtoId, int novaQuantidade) {
        for (ItemCarrinho item : itens) {
            if (item.getProdutoId() == produtoId) {
                item.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double getValorTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
           
            double precoProduto = getPreco(item.getProdutoId());
            total += precoProduto * item.getQuantidade();
        }
        return total;
    }

  
    private double getPreco(int produtoId) {
       
        return 0.0; 
    }

	
}

