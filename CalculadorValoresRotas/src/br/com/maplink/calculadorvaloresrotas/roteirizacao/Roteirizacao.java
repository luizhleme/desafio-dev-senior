package br.com.maplink.calculadorvaloresrotas.roteirizacao;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink2.webservices.RouteTotals;

/**
 * 
 * @author luizleme
 *
 */
public interface Roteirizacao{

	public RouteTotals calcularValoresTotaisDaRota() throws RemoteException,
			ServiceException;
}
