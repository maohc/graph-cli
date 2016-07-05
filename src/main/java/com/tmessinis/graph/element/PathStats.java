package com.tmessinis.graph.element;

/**
 * Auxiliary object to save the path stats.
 * 
 * @author tmessini
 */
public class PathStats {

	private int distance;

	private int stops;

	public PathStats() {
		super();
		this.stops = 0;
		this.distance = 0;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	/**
	 * Reset stats when a path is abandoned.
	 */
	public void reset() {
		this.distance = 0;
		this.stops = 0;
	}

}
