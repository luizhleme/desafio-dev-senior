package br.com.maplink.calculadorvaloresrotas.model.veiculo;

import br.com.maplink.calculadorvaloresrotas.builder.VehicleBuilder;
import br.com.maplink2.webservices.Vehicle;

/**
 * 
 * @author luizleme
 *
 */
class VeiculoImplementacaoBasica implements IVeiculo {

	private VehicleBuilder vehicleBuilder;
	private Vehicle vehicle;

	public VeiculoImplementacaoBasica(int volumeDoTanque, float mediaDeConsumo,
			double precoDoCombustivel, int velocidadeMedia,
			NumeroEixosPorTipoVeiculo eixos) {
		vehicleBuilder = new VehicleBuilder();

		init(volumeDoTanque, mediaDeConsumo, precoDoCombustivel,
				velocidadeMedia, eixos);
	}

	private void init(int volumeDoTanque, float mediaDeConsumo,
			double precoDoCombustivel, int velocidadeMedia,
			NumeroEixosPorTipoVeiculo eixos) {
		if (volumeDoTanque <= 0 || mediaDeConsumo <= 0
				|| precoDoCombustivel <= 0 || velocidadeMedia <= 0) {
			throw new IllegalArgumentException();
		} else {
			vehicle = vehicleBuilder.comCapacidadeDoTanqueDe(volumeDoTanque)
					.comMediaDeConsumoDe(mediaDeConsumo)
					.comPrecoDoCombustivelIgualA(precoDoCombustivel)
					.comVelocidadeMediaDe(velocidadeMedia)
					.comNumeroDeEixos(eixos).criarVehicle();
		}
	}

	@Override
	public Vehicle obterVeiculo() {
		return vehicle;
	}
}
