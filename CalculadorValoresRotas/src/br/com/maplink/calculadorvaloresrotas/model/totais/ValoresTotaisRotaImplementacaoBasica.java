package br.com.maplink.calculadorvaloresrotas.model.totais;

import br.com.maplink2.webservices.RouteTotals;

/**
 * 
 * @author luizleme
 *
 */
class ValoresTotaisRotaImplementacaoBasica implements IValoresTotaisRota {

	private RouteTotals routeTotal;

	public ValoresTotaisRotaImplementacaoBasica(RouteTotals routeTotals) {
		init(routeTotals);
	}

	private void init(RouteTotals routeTotals) {
		if (routeTotals == null) {
			throw new NullPointerException();
		} else {
			this.routeTotal = routeTotals;
		}
	}

	@Override
	public String tempoTotal() {
		return routeTotal.getTotalTime();
	}

	@Override
	public double distanciaTotal() {
		return routeTotal.getTotalDistance();
	}

	@Override
	public double custoDeCombustivel() {
		return routeTotal.getTotalfuelCost();
	}

	@Override
	public double custoTotalConsiderandoPedagio() {
		return routeTotal.getTotaltollFeeCost();
	}
	

}
