package com.tmessinis.graph.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
//import java.util.logging.Logger;

import com.tmessinis.graph.constraint.Constraint;
import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.PathStats;


/**
 * Find paths between the same node with Loops
 * 
 * @author tmessini
 */
public class PathFinderServiceWithLoopsImpl implements PathFinderServiceWithLoops {
    
    //private final static Logger LOGGER = Logger.getLogger(PathFinderServiceWithLoopsImpl.class.getName()); 

    private TraversalService service = new TraversalServiceImpl();
    private static final int ZERO    = 0;


    @Override
    public int findCircularPathsBetweenNodes(Graph graph, String startNode, String endNode, Constraint constraint,
            Stack<String> pathStack, Set<String> pathSet, int pathsCounter) {

        /** locally saved paths */
        Stack<String> inPathStack = pathStack;
        Set<String> inPathSet = pathSet;

        /** Add start to current path */
        inPathStack.push(graph.getNode(startNode).getName());
        inPathSet.add(graph.getNode(startNode).getName());

        if (startNode.equals(endNode)) {
            if (inPathStack.size() > 0 && inPathSet.size() > 0) {
                if (inPathStack.size() != 1) {
                    //LOGGER.info(inPathStack.toString());
                    pathsCounter++;
                }
            }
        }

        Set<Edge> edges = graph.getNode(startNode).getEdges();
        /** Iterate all the edges of a node */
        for (Edge edge : edges) {
            /** expect having constraints for looped paths exploration */
            if (constraint != null) {
                /** if constraint is valid */
                PathStats pathStats = new PathStats();
                String path = TraversalUtil.getPath(inPathStack);
                pathStats.setDistance((int) service.findDistanceOfPath(graph, path) + edge.getDistance());
                pathStats.setStops(inPathStack.size());
                if (constraint.evaluate(pathStats)) {
                    if (!inPathSet.contains(edge.getEndingNode()))
                        pathsCounter = findCircularPathsBetweenNodes(graph, edge.getEndingNode().getName(), endNode, constraint,
                                                                     inPathStack, inPathSet, pathsCounter);
                }
            }

        }
        inPathStack.pop();
        inPathSet.remove(startNode);
        return pathsCounter;
    }





    @Override
    public List<Integer> findPathsLengthCircularPathsBetweenNodes(Graph graph, String startNode, String endNode,
            Constraint constraint, Stack<String> pathStack, Set<String> pathSet, List<Integer> pathLength) {

        /** locally saved paths */
        Stack<String> inPathStack = pathStack;
        Set<String> inPathSet = pathSet;
        List<Integer> pathL= pathLength; 

        /** Add start to current path */
        inPathStack.push(graph.getNode(startNode).getName());
        inPathSet.add(graph.getNode(startNode).getName());

        if (startNode.equals(endNode)) {
            if (inPathStack.size() > 0 && inPathSet.size() > 0) {
                if (inPathStack.size() != 1) {
                    //LOGGER.info(inPathStack.toString());
                    pathL.add(inPathStack.size());
                }
            }
        }

        Set<Edge> edges = graph.getNode(startNode).getEdges();
        /** Iterate all the edges of a node */
        for (Edge edge : edges) {
            /** expect having constraints for looped paths exploration */
            if (constraint != null) {
                /** if constraint is valid */
                PathStats pathStats = new PathStats();
                String path = TraversalUtil.getPath(inPathStack);
                pathStats.setDistance((int) service.findDistanceOfPath(graph, path) + edge.getDistance());
                pathStats.setStops(inPathStack.size());
                if (constraint.evaluate(pathStats)) {
                    if (!inPathSet.contains(edge.getEndingNode()))
                        findPathsLengthCircularPathsBetweenNodes(graph, edge.getEndingNode().getName(), endNode, constraint,
                                                                     inPathStack, inPathSet, pathL);
                }
            }

        }
        inPathStack.pop();
        inPathSet.remove(startNode);
        return pathL;
    }
    
    @Override
    public int findPathsBetweenNodes(Graph graph, String startNode, String endNode, Constraint constraint) {
        return findCircularPathsBetweenNodes(graph, startNode, endNode, constraint, new Stack<String>(),
                                             new HashSet<String>(), ZERO);
    }
}
