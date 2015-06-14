package br.com.maplink.calculadorvaloresrotas.model.endereco;

import br.com.maplink2.webservices.Address;
import br.com.maplink2.webservices.AddressLocation;

/**
 * 
 * @author luizleme
 *
 */
public interface IEndereco {

	
	Address obterEndereco();
	AddressLocation obterGeolocalizacao();
	double latitude();
	double longitude();
}
