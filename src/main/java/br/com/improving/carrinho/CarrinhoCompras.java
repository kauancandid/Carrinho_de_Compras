package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {


	private ArrayList<Item> itemsDoCarrinho;

	/**
     * Método adicionar
	 * Obs: Permite a adição de um novo item no carrinho de compras. Caso o item já exista no
	 * carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
	 *
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *

     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {

		int posicaoAtual = -1;
		for (int i = 0; i < getItens().size() && posicaoAtual < 0; i++) {
			Item itemAtual = itemsDoCarrinho.get(i);

			if (itemAtual.getProduto().equals(produto)) {
				posicaoAtual = i;
			}

		}

		try {
			if (!(posicaoAtual < 0)) {
				Item itemAtual = itemsDoCarrinho.get(posicaoAtual);
				quantidade = itemAtual.getQuantidade() + quantidade;
				if (itemAtual.getValorUnitario() == valorUnitario) {
					valorUnitario = itemAtual.getValorUnitario();
				}
				Item item = new Item(produto, valorUnitario, quantidade);
				item.setValor(item.getValorTotal());

				itemsDoCarrinho.set(posicaoAtual, item);
			} else {
				Item item = new Item(produto, valorUnitario, quantidade);
				item.setValor(item.getValorTotal());
				getItens().add(item);
			}
		} catch (RuntimeException e) {
			e.getStackTrace();
		}
    }

    /**
	 * Método remover pelo produto
	 * Obs: Permite a remoção do item que representa este produto do carrinho de compras.
     */
    public boolean removerItem(Produto produto) {
		for(Item itens: itemsDoCarrinho){
			if(itens.getProduto() == produto){
				return true;
			}
		}
		return false;
    }

    /**
	 * Método remover pela posição
	 * Obs: Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     */
    public boolean removerItem(int posicaoItem) {
		try {
			itemsDoCarrinho.remove(posicaoItem);
			return true;
		}
		catch(RuntimeException e) {
			return false;
		}
    }

    /**
	 * Método para retornar valor total
	 * obs: Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     */
    public BigDecimal getValorTotal() {
		BigDecimal result = null;
		for(Item itens: itemsDoCarrinho){
			result.add(itens.getValorTotal());
			}
		return result;
	}


    /**
	 * Método para retornar itens:
     * Obs: Retorna a lista de itens do carrinho de compras.
     */
    public Collection<Item> getItens() {
		if (itemsDoCarrinho != null) {
			return this.itemsDoCarrinho;
		}
		return itemsDoCarrinho = new ArrayList<>();
    }
}