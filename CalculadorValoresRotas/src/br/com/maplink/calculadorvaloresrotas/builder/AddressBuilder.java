package br.com.maplink.calculadorvaloresrotas.builder;

import br.com.maplink2.webservices.Address;

/**
 * 
 * @author luizleme
 *
 */
public class AddressBuilder {
	
	private String logradouro;
	
	private String numero;
	
	private String cidade;
	
	private String uf;
	
	public AddressBuilder() {
		
	}
	
	public AddressBuilder paraLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	
	public AddressBuilder comNumero(String numero) {
		this.numero = numero;
		return this;
	}
	
	public AddressBuilder daCidadeDe(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public AddressBuilder daUF(String uf) {
		this.uf = uf;
		return this;
	}
	
	public Address criarAddress() {
		CityBuilder cityBuilder = new CityBuilder();
		Address address = new Address();
		
		cityBuilder.paraCidadeDe(cidade).doEstado(uf);
		
		address.setCity(cityBuilder.criarCity());
		address.setStreet(logradouro);
		address.setHouseNumber(numero);
		
		return address;
	}
}
