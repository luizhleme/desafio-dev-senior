package br.com.maplink.calculadorvaloresrotas.builder;

import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo.NumeroEixosPorTipoVeiculo;
import br.com.maplink2.webservices.Vehicle;

/**
 * 
 * @author luizleme
 *
 */
public class VehicleBuilder {

	private int capacidadeDoTanque;

	private float mediaDeConsumo;

	private double precoDoCombustivel;

	private int velocidadeMedia;

	private int numeroDeEixos;

	public VehicleBuilder() {
	}

	public VehicleBuilder comCapacidadeDoTanqueDe(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
		return this;
	}

	public VehicleBuilder comMediaDeConsumoDe(float mediaDeConsumo) {
		this.mediaDeConsumo = mediaDeConsumo;
		return this;
	}

	public VehicleBuilder comPrecoDoCombustivelIgualA(double precoDoCombustivel) {
		this.precoDoCombustivel = precoDoCombustivel;
		return this;
	}

	public VehicleBuilder comVelocidadeMediaDe(int velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
		return this;
	}

	public VehicleBuilder comNumeroDeEixos(
			NumeroEixosPorTipoVeiculo numeroEixosPorTipoVeiculo) {
		this.numeroDeEixos = numeroEixosPorTipoVeiculo.getValor();
		return this;
	}

	public Vehicle criarVehicle() {
		return new Vehicle(capacidadeDoTanque, mediaDeConsumo,
				precoDoCombustivel, velocidadeMedia, numeroDeEixos);
	}

}
