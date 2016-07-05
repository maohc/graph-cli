package com.tmessinis.graph.algorithm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;


/**
 * Implementation of Dijkstra algorithm.
 * 
 * @author tmessini
 */
public class DijkstraServiceImpl implements DijkstraService {

    public int findShortestPathDistance(Graph graph, Node startNode, Node endNode) {

        /** To be visited Nodes */
        Set<Node> toBeVisited = new HashSet<Node>();
        /** Visited Nodes */
        Set<Node> visited = new HashSet<Node>();
        /** Collection of Nodes */
        Collection<Node> nodes = graph.getNodes();
        /** Distance of Nodes from Start Node */
        Map<String, Integer> distance = initializeDistance(nodes, new TreeMap<String, Integer>());

        /** Set toBeVisited to start node */
        setGraphTraversalStartingNode(startNode, toBeVisited, distance);

        /** Iterate for all the nonvisited nodes */
        Iterator<Node> nodeIterator = toBeVisited.iterator();
        while (nodeIterator.hasNext()) {

            /** Find nearest nonvisited */
            Node nearestNode = findNearestNonvisitedNode(toBeVisited, distance);
            if (nearestNode == null )
            {
                break;
            }

            /** Visit node */
            Node visitedNode = visitNode(nearestNode, visited, toBeVisited);

            /** Recalculate the shorted distance for all neighboors */
            recalculateShorterDistanceFromVisitedNodeNeighboors(visitedNode, visited, toBeVisited, distance);

            /** If target node is visited return the result */
            if (visited.contains(endNode)) {
                if (startNode == endNode) {
                    visited.remove(endNode);
                } else {
                    break;
                }
            }
        }
        /** return the shorted distance from starting node to target node */
        return distance.get(endNode.getName());

    }


    /**
     * @param visitedNode
     * @param visited
     * @param toBeVisited
     * @param distance
     */
    private static void recalculateShorterDistanceFromVisitedNodeNeighboors(Node visitedNode, Set<Node> visited,
            Set<Node> toBeVisited, Map<String, Integer> distance) {
        /** Check all neighboors */
        for (Edge edge : visitedNode.getEdges()) {
            if (!visited.contains(edge.getEndingNode())) {
                int recalculatedDistance = Integer.MAX_VALUE;
                if ((int) distance.get(visitedNode.getName()) == Integer.MAX_VALUE) {
                    recalculatedDistance = edge.getDistance();
                } else {
                    recalculatedDistance = distance.get(visitedNode.getName()) + edge.getDistance();
                }
                Integer storedDistance = distance.get(edge.getEndingNode().getName());
                if (recalculatedDistance < storedDistance) {
                    distance.put(edge.getEndingNode().getName(), recalculatedDistance);
                    toBeVisited.add(edge.getEndingNode());
                }
            }
        }
    }


    /**
     * Set Traversal starting node
     * 
     * @param startNode
     * @param toBevisited
     * @param distance
     */
    private static void setGraphTraversalStartingNode(Node startNode, Set<Node> toBevisited, Map<String, Integer> distance) {
        // distance.put(startNode.getName(), 0);
        toBevisited.add(startNode);
    }


    /**
     * Initialize distance
     * 
     * @param nodes
     * @param distance
     * @return distance
     */
    private static Map<String, Integer> initializeDistance(Collection<Node> nodes, Map<String, Integer> distance) {
        /** Set distance to maximum for all nodes */
        for (Node node : nodes) {
            distance.put(node.getName(), Integer.MAX_VALUE);
        }
        return distance;
    }


    /**
     * Find nearest node from nonvisited
     * 
     * @param toBeVisited
     * @param distance
     * @return Node
     */
    private static Node findNearestNonvisitedNode(Set<Node> toBeVisited, Map<String, Integer> distance) {
        
        Node nearestNode = null;
        /** Get an element */        
        if (!toBeVisited.isEmpty()){
            nearestNode = toBeVisited.iterator().next();
        }
        
        /**
         * Find the minimum distance of the unvisited nodes from starting node
         */
        int minDistance = Integer.MAX_VALUE;
        for (Node node : toBeVisited) {
            Integer distanceFromStartingNode = distance.get(node.getName());
            if (distanceFromStartingNode < minDistance) {
                nearestNode = node;
                minDistance = distanceFromStartingNode;
            }
        }
        return nearestNode;
    }


    /**
     * Visit Node Remove the node from unvisited and put into visited.
     * 
     * @param nearestNode
     * @param visited
     * @param toBeVisited
     */
    private static Node visitNode(Node node, Set<Node> visited, Set<Node> toBeVisited) {
        toBeVisited.remove(node);
        visited.add(node);
        return node;
    }


    /**
     * Find shortest distance for path described with a string of 2 character. return the shortest path distance.
     */
    @Override
    public int findShortestPathDistance(Graph graph, String path) {
        String startNodeStr = path.substring(0, 1);
        Node startNode = graph.getNode(startNodeStr);
        String stopNodeStr = path.substring(1, 2);
        Node stopNode = graph.getNode(stopNodeStr);
        return findShortestPathDistance(graph, startNode, stopNode);
    }
}
