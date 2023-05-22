package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    public Produto(Long codigo, String descricao) {
    }

    public Long getCodigo() {
		return codigo;
    }

    public String getDescricao() {
		return descricao;
    }

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produto)) return false;
		Produto produto = (Produto) o;
		return getCodigo().equals(produto.getCodigo()) &&
				getDescricao().equals(produto.getDescricao());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCodigo(), getDescricao());
	}
}