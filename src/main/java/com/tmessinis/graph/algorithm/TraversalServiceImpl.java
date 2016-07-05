package com.tmessinis.graph.algorithm;

import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;

/**
 * Simple traversal of graph
 * 
 * @author tmessini
 */
public class TraversalServiceImpl implements TraversalService {

	private static String NO_SUCH_ROUTE = "NO SUCH ROUTE";

	@Override
	public Object findDistanceOfPath(Graph graph, String path) {
		String distance = NO_SUCH_ROUTE;
		/** check not set path */
		if (path == null) {
			return distance;
		}
		/** check not set path */
		if (path.length() == 0) {
			return distance;
		}
		/** traverse the graph if next edge exist */
		int distanceInt = 0;
		boolean pathNonExisting = false;
		for (int i = 0; i < path.length(); i++) {

			if (i + 1 < path.length()) {
				Node nodeCurrent = graph.getNode(path.substring(i, i + 1));
				if (i + 2 <= path.length()) {
					Node nodeNext = graph.getNode(path.substring(i + 1, i + 2));
					boolean nextNodeExists = false;
					if (nodeNext != nodeCurrent) {
						for (Edge edge : nodeCurrent.getEdges()) {
							if (nodeNext == edge.getEndingNode()) {
								distanceInt += edge.getDistance();
								nextNodeExists = true;
							}
						}
						if (nextNodeExists == false) {
							pathNonExisting = true;
						}
					} else {
						nextNodeExists = true;
						pathNonExisting = false;
					}
				}
			}
		}
		if (pathNonExisting) {
			return NO_SUCH_ROUTE;
		}
		return distanceInt;
	}
}
