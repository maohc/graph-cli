package com.tmessinis.graph.command;

import com.tmessinis.graph.algorithm.DijkstraService;
import com.tmessinis.graph.algorithm.DijkstraServiceImpl;
import com.tmessinis.graph.algorithm.PathFinderService;
import com.tmessinis.graph.algorithm.PathFinderServiceImpl;
import com.tmessinis.graph.algorithm.TraversalService;
import com.tmessinis.graph.algorithm.TraversalServiceImpl;
import com.tmessinis.graph.constraint.ConstraintImpl;
import com.tmessinis.graph.constraint.ConstraintdUtil;
import com.tmessinis.graph.constraint.factory.ConstraintFactory;
import com.tmessinis.graph.constraint.factory.ConstraintFactoryImpl;

public class CommandVisitorImpl implements CommandVisitor {

	DijkstraService dijkstraService = new DijkstraServiceImpl();
	PathFinderService pathFinderService = new PathFinderServiceImpl();
	TraversalService traversalService = new TraversalServiceImpl();
	ConstraintFactory constraintFactory = new ConstraintFactoryImpl();

	@Override
	public Object visit(DistanceOfPath graphTraversalDistance) {
		return traversalService.findDistanceOfPath(graphTraversalDistance.getGraph(),
				graphTraversalDistance.getCommand());
	}

	@Override
	public int visit(DistanceOfShortestPath shortestPathDistance) {
		/** Shortest Distance */
		return dijkstraService.findShortestPathDistance(shortestPathDistance.getGraph(),
				shortestPathDistance.getCommand());
	}

	@Override
	public int visit(TripsBetweenNodes tripsBetween) {
		/** Trips between */
		String command = tripsBetween.getCommand();
		int contraintIndex = ConstraintdUtil.getIndexOfConstraint(command);
		String constraintStr = command.substring(contraintIndex);
		ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintStr);
		String path = command.replace(constraintStr, "").trim();
		return pathFinderService.findPathsBetweenNodes(tripsBetween.getGraph(), path, constraint);
	}
}
