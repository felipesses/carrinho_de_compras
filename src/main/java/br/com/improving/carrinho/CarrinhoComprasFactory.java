package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	Map<String, CarrinhoCompras> carrinhosCompras = new HashMap<String, CarrinhoCompras>();

	public CarrinhoComprasFactory() {
	}

	public CarrinhoCompras criar(String identificacaoCliente) {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

		if (carrinhoCompras.containsKey(identificacaoCliente)) {
			carrinhoCompras = null;
		} else {
			carrinhosCompras.put(identificacaoCliente, carrinhoCompras);
		}

		return carrinhoCompras;

	}

	public BigDecimal getValorTicketMedio(Item item) {

		List<CarrinhoCompras> listaCarrinhos = new ArrayList<>(carrinhosCompras.values());

		for (int i = 0; i < listaCarrinhos.size(); i++) {
			listaCarrinhos.get(i).getValorTotal(item).plus().divide(new BigDecimal(i));
		}

		BigDecimal valorTicketMedio = (BigDecimal) listaCarrinhos;
		return valorTicketMedio.setScale(2, RoundingMode.HALF_EVEN);

	}

	public boolean invalidar(String identificacaoCliente) {
		try {

			carrinhosCompras.remove(identificacaoCliente);
			return true;

		} catch (RuntimeException e) {
			return false;
		}

	}
}
