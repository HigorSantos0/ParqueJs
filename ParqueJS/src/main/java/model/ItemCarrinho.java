package model;

public class ItemCarrinho {

    private int produtoId;
    private int quantidade;

    public ItemCarrinho(int produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemCarrinho{" +
                "produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
