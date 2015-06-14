package br.com.maplink.calculadorvaloresrotas.geocodificacao;

import br.com.maplink.calculadorvaloresrotas.model.endereco.IEndereco;
import br.com.maplink2.webservices.AddressLocation;

/**
 * 
 * @author luizleme
 *
 */
public interface Geocodificador {
	
	AddressLocation obterGeolocalizacao(IEndereco endereco);

}
