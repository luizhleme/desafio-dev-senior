package br.com.maplink.calculadorvaloresrotas;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink.calculadorvaloresrotas.impl.CalculadorValoreDeRotas;
import br.com.maplink.calculadorvaloresrotas.impl.ICalculadorValoreDeRotas;
import br.com.maplink.calculadorvaloresrotas.model.endereco.Endereco;
import br.com.maplink.calculadorvaloresrotas.model.endereco.Enderecos;
import br.com.maplink.calculadorvaloresrotas.model.endereco.IEndereco;
import br.com.maplink.calculadorvaloresrotas.model.rota.IRota.TipoDeRota;
import br.com.maplink.calculadorvaloresrotas.model.totais.IValoresTotaisRota;

/**
 * 
 * @author luizleme
 *
 */
public class Principal {

	public static void main(String[] args) throws RemoteException,
			ServiceException {
		IEndereco enderecoOrigem = Endereco.valueOf("São Paulo", "SP",
				"Avenida Paulista", "2046");

		IEndereco enderecoDestino = Endereco.valueOf("São Paulo", "SP",
				"Praça da Sé", "");
		
		Enderecos enderecos = new Enderecos(enderecoOrigem, enderecoDestino);

		ICalculadorValoreDeRotas calculador = CalculadorValoreDeRotas.valueOf(
				enderecos, TipoDeRota.ROTA_PADRAO_MAIS_RAPIDA);

		IValoresTotaisRota valoresTotaisRota = calculador.calcular();

		System.out.println("Custo Total de Combustivel: "
				+ valoresTotaisRota.custoDeCombustivel());
		System.out.println("Custo Total Considerando Pedágio: "
				+ valoresTotaisRota.custoTotalConsiderandoPedagio());
		System.out.println("Distancia Total: "
				+ valoresTotaisRota.distanciaTotal());
		System.out.println("Tempo Total:" + valoresTotaisRota.tempoTotal());
	}
}
