package br.com.maplink.calculadorvaloresrotas.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink.calculadorvaloresrotas.model.totais.IValoresTotaisRota;

/**
 * 
 * @author luizleme
 *
 */
public interface ICalculadorValoreDeRotas {

	IValoresTotaisRota calcular()
			throws RemoteException, ServiceException;
}
