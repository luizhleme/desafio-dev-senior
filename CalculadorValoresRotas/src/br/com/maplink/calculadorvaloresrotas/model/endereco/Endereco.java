package br.com.maplink.calculadorvaloresrotas.model.endereco;

import br.com.maplink.calculadorvaloresrotas.geocodificacao.Geocodificador;
import br.com.maplink.calculadorvaloresrotas.geocodificacao.MapLinkGeolocalizacao;

/**
 * 
 * @author luizleme
 *
 */
public final class Endereco {

	private Endereco() {
	}

	public static IEndereco valueOf(String cidade, String uf,
			String logradouro, String numero) {
		Geocodificador geocodificador = new MapLinkGeolocalizacao();
		return new EnderecoImplementacaoBasica(cidade, uf, logradouro, numero,
				geocodificador);
	}
}
