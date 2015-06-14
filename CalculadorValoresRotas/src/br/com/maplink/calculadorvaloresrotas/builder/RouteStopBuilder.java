package br.com.maplink.calculadorvaloresrotas.builder;

import br.com.maplink2.webservices.AddressLocation;
import br.com.maplink2.webservices.RouteStop;

/**
 * 
 * @author luizleme
 *
 */
public class RouteStopBuilder {

	private AddressLocation address;
	
	public RouteStopBuilder() {
	}
	
	public RouteStopBuilder paraAGeolocalizacao(AddressLocation address) {
		this.address = address;
		return this;
	}
	
	public RouteStop criarRouteStop() {
		return new RouteStop(null, address.getPoint());
	}
}
