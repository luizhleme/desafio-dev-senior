package br.com.maplink.calculadorvaloresrotas.geocodificacao;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink.calculadorvaloresrotas.model.endereco.IEndereco;
import br.com.maplink2.webservices.AddressFinderLocator;
import br.com.maplink2.webservices.AddressInfo;
import br.com.maplink2.webservices.AddressLocation;
import br.com.maplink2.webservices.AddressOptions;
import br.com.maplink2.webservices.ResultRange;

/**
 * 
 * @author luizleme
 *
 */
public class MapLinkGeolocalizacao implements Geocodificador {

	private static final String TOKEN = "c13iyCvmcC9mzwkLd0LCbCBHcXYD5mUA5m2jNGutNXK6NJc6NJt=";

	private AddressOptions addressOptions;

	private ResultRange resultRange;

	public MapLinkGeolocalizacao() {
		resultRange = new ResultRange();
		resultRange.setPageIndex(1);
		resultRange.setRecordsPerPage(10);

		addressOptions = new AddressOptions();
		addressOptions.setUsePhonetic(true);
		addressOptions.setSearchType(2);
		addressOptions.setResultRange(resultRange);
	}

	@Override
	public AddressLocation obterGeolocalizacao(IEndereco endereco) {
		AddressFinderLocator addressFinderLocator = new AddressFinderLocator();
		AddressInfo findAddressResponse = null;
		AddressLocation localizacao = new AddressLocation();

		try {
			findAddressResponse = addressFinderLocator.getAddressFinderSoap()
					.findAddress(endereco.obterEndereco(), addressOptions,
							TOKEN);
		} catch (RemoteException e) {
		} catch (ServiceException e) {
			throw new RuntimeException();
		}

		AddressLocation[] addressLocations = findAddressResponse
				.getAddressLocation();

		for (AddressLocation addressLocation : addressLocations) {
			localizacao = addressLocation;
		}
		return localizacao;
	}
}
