package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
	private BigDecimal valor;
    private int quantidade;

    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    }

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;

	}

	public BigDecimal getValorTotal() {
		BigDecimal bd = new BigDecimal(quantidade);
		return this.valorUnitario.multiply(bd);
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Item{" +
				"produto=" + produto +
				", valorUnitario=" + valorUnitario +
				", valor=" + valor +
				", quantidade=" + quantidade +
				'}';
	}
}
