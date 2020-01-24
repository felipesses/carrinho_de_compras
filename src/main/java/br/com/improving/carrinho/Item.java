package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;

	public Item() {
	}

	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {

		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
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

		return BigDecimal.valueOf(quantidade).multiply(valorUnitario);

	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
