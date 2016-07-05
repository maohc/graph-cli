package com.tmessinis.graph.algorithm;

import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;

public interface DijkstraService {

	public int findShortestPathDistance(Graph graph, Node startNode, Node endNode);

	public int findShortestPathDistance(Graph graph, String path);

}
