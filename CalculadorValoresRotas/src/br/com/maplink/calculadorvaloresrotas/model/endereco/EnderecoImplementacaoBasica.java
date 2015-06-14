package br.com.maplink.calculadorvaloresrotas.model.endereco;

import br.com.maplink.calculadorvaloresrotas.builder.AddressBuilder;
import br.com.maplink.calculadorvaloresrotas.geocodificacao.Geocodificador;
import br.com.maplink2.webservices.Address;
import br.com.maplink2.webservices.AddressLocation;

/**
 * 
 * @author luizleme
 *
 */
class EnderecoImplementacaoBasica implements IEndereco {

	private AddressBuilder addressBuilder;
	private Address address;
	private AddressLocation geolocalizacao;
	private Geocodificador geocodificador;

	public EnderecoImplementacaoBasica(String cidade, String uf,
			String logradouro, String numero, Geocodificador geocodificador) {
		this.addressBuilder = new AddressBuilder();
		this.geocodificador = geocodificador;
		init(cidade, uf, logradouro, numero);
	}

	private void init(String cidade, String uf, String logradouro, String numero) {
		if (cidade == null || uf == null || logradouro == null
				|| numero == null) {
			throw new NullPointerException();
		} else {
			address = addressBuilder.paraLogradouro(logradouro)
					.comNumero(numero).daCidadeDe(cidade).daUF(uf)
					.criarAddress();
		}
	}

	@Override
	public Address obterEndereco() {
		return address;
	}

	@Override
	public AddressLocation obterGeolocalizacao() {
		geolocalizacao = geocodificador.obterGeolocalizacao(this);
		return geolocalizacao;
	}

	@Override
	public double latitude() {
		return geolocalizacao.getPoint().getY();
	}

	@Override
	public double longitude() {
		return geolocalizacao.getPoint().getX();
	}
}
