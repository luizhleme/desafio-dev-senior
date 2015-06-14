package br.com.maplink.calculadorvaloresrotas.roteirizacao;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink.calculadorvaloresrotas.model.rota.IRota;
import br.com.maplink2.webservices.RouteProximityLocator;
import br.com.maplink2.webservices.RouteProximityOptions;
import br.com.maplink2.webservices.RouteStop;
import br.com.maplink2.webservices.RouteTotals;

/**
 * 
 * @author luizleme
 *
 */
public class MapLinkRota implements Roteirizacao {

	private static final String TOKEN = "c13iyCvmcC9mzwkLd0LCbCBHcXYD5mUA5m2jNGutNXK6NJc6NJt=";
	private IRota rota;
	private RouteStop[] rotas;
	private RouteProximityOptions routeProximityOptions;
	private RouteProximityLocator routeProximityLocator;

	public MapLinkRota(IRota rota) {
		this.rota = rota;
		rotas = new RouteStop[] { rota.pontoDeOrigemDaRota(),
				rota.pontoDeDestinoDaRota() };
		routeProximityOptions = new RouteProximityOptions();
		routeProximityOptions.setLanguage("portuguese");
		routeProximityOptions.setRouteDetails(rota.detalhesDaRota());
		routeProximityOptions.setVehicle(rota.vehicle());
		routeProximityLocator = new RouteProximityLocator();
	}
	
	public RouteTotals calcularValoresTotaisDaRota() throws RemoteException, ServiceException {
		RouteTotals getRouteProximityTotalsResponse = null;
		try {
			getRouteProximityTotalsResponse = routeProximityLocator
					.getRouteProximitySoap().getRouteProximityTotals(rotas,
							routeProximityOptions, TOKEN);
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage(), e.getCause());
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return getRouteProximityTotalsResponse;
	}
}
