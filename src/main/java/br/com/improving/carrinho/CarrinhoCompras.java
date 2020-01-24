package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private Item item = new Item();
	private List<Item> itens = new ArrayList<Item>();
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	Boolean condicao = false;

	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		Item novoItem = new Item(produto, valorUnitario, quantidade);
		try {

			condicao = verificarProduto(itens, produto);

			if (condicao) {
				novoItem.setQuantidade(novoItem.getQuantidade() + quantidade);

				if (!novoItem.getValorUnitario().equals(valorUnitario))
					novoItem.setValorUnitario(valorUnitario);
			}

		} catch (RuntimeException e) {
			System.out.println(e);
		}

		itens.add(novoItem);
	}

	public boolean verificarProduto(List<Item> itens, Produto produto) {
		Boolean condicao = false;

		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getProduto().equals(produto))
				condicao = true;

		}

		return condicao;
	}

	public boolean removerItem(Produto produto) {

		Boolean posicao = false;

		for (int i = 0; i < itens.size(); i++) {
			Item item = itens.get(i);

			if (item.getProduto().equals(produto)) {
				posicao = true;

			}

			if (!posicao) {
				itens.remove(posicao);
				return true;
			}
		}

		return posicao;
	}

	public boolean removerItem(int posicaoItem) {

		Boolean possui_Item = true;

		try {
			itens.remove(posicaoItem);
			return possui_Item;
		} catch (RuntimeException e) {
			System.out.println("ERRO: " + e);
			return possui_Item = false;
		}
	}

	public BigDecimal getValorTotal(Item item) {

		for (int i = 0; i < itens.size(); i++) {
			itens.get(i).getValorTotal().plus();
		}

		return (BigDecimal) itens;
	}

	public Collection<Item> getItens() {
		if (itens == null) {
			itens = new ArrayList<>();
		}
		return itens;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public boolean containsKey(Object key) {
		return this.containsKey(key);
	}

}