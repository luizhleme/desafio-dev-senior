package br.com.maplink.calculadorvaloresrotas.model.totais;

import br.com.maplink2.webservices.RouteTotals;

/**
 * 
 * @author luizleme
 *
 */
public final class ValoresTotaisRota {
	
	private ValoresTotaisRota() {
	}
	
	public static IValoresTotaisRota valueOf(RouteTotals routeTotals) {
		return new ValoresTotaisRotaImplementacaoBasica(routeTotals);
	}

}
