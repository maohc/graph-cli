package com.tmessinis.graph.algorithm;

import com.tmessinis.graph.constraint.ConstraintImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;

public interface PathFinderService {

	int findPathsBetweenNodes(Graph graph, Node startNode, Node endNode, ConstraintImpl constraint);
	
	int findPathsBetweenNodes(Graph graph, String path, ConstraintImpl constraint);

}
