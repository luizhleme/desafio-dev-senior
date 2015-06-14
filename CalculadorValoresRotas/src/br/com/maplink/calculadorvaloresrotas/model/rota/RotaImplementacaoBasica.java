package br.com.maplink.calculadorvaloresrotas.model.rota;

import br.com.maplink.calculadorvaloresrotas.builder.RouteStopBuilder;
import br.com.maplink.calculadorvaloresrotas.model.endereco.IEndereco;
import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo;
import br.com.maplink2.webservices.RouteDetails;
import br.com.maplink2.webservices.RouteStop;
import br.com.maplink2.webservices.Vehicle;

/**
 * 
 * @author luizleme
 *
 */
class RotaImplementacaoBasica implements IRota {

	private RouteStopBuilder routeStopBuilder;
	private RouteStop pontoDeOrigemDaRota;
	private RouteStop pontoDeDestinoDaRota;
	private TipoDeRota tipoDeRota;
	private Vehicle vehicle;
	private RouteDetails routeDetails;

	public RotaImplementacaoBasica(IEndereco enderecoOrigem,
			IEndereco enderecoDestino, IVeiculo veiculo, TipoDeRota tipoDeRota) {

		routeStopBuilder = new RouteStopBuilder();
		routeDetails = new RouteDetails();
		init(enderecoOrigem, enderecoDestino, veiculo, tipoDeRota);
	}

	private void init(IEndereco enderecoOrigem, IEndereco enderecoDestino,
			IVeiculo veiculo, TipoDeRota tipoDeRota) {
		if (enderecoOrigem == null || enderecoDestino == null
				|| veiculo == null || tipoDeRota == null) {
			throw new NullPointerException();
		} else {
			pontoDeOrigemDaRota = routeStopBuilder
					.paraAGeolocalizacao(enderecoOrigem.obterGeolocalizacao()).criarRouteStop();
			pontoDeDestinoDaRota = routeStopBuilder
					.paraAGeolocalizacao(enderecoDestino.obterGeolocalizacao()).criarRouteStop();
			this.tipoDeRota = tipoDeRota;
			this.vehicle = veiculo.obterVeiculo();
		}
	}

	@Override
	public RouteStop pontoDeOrigemDaRota() {
		return pontoDeOrigemDaRota;
	}

	@Override
	public RouteStop pontoDeDestinoDaRota() {
		return pontoDeDestinoDaRota;
	}

	@Override
	public RouteDetails detalhesDaRota() {
		routeDetails.setDescriptionType(1);
		routeDetails.setRouteType(this.tipoDeRota.getValor());
		routeDetails.setOptimizeRoute(true);
		return routeDetails;
	}

	@Override
	public TipoDeRota tipoDeRota() {
		return tipoDeRota;
	}

	@Override
	public Vehicle vehicle() {
		return vehicle;
	}

}
