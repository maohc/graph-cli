package com.tmessinis.graph.command;

public interface CommandVisitor {

	public Object visit(DistanceOfPath graphTraversalDistance);

	public int visit(DistanceOfShortestPath shortestPathDistance);

	public int visit(TripsBetweenNodes tripsBetween);

}
