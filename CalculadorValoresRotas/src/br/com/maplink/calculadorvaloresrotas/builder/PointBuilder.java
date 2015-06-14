package br.com.maplink.calculadorvaloresrotas.builder;

import br.com.maplink2.webservices.Point;

/**
 * 
 * @author luizleme
 *
 */
public class PointBuilder {

	private double latitude;

	private double longitude;

	public PointBuilder() {
	}
	
	public PointBuilder comLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}
	
	public PointBuilder comLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}
	
	public Point criarPoint() {
		return new Point(longitude, latitude);
	}
}
