package com.tmessinis.graph.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
//import java.util.logging.Logger;

import com.tmessinis.graph.contstraint.Constraint;
import com.tmessinis.graph.contstraint.ConstraintImpl;
import com.tmessinis.graph.contstraint.Operator;
import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;
import com.tmessinis.graph.element.PathStats;



/**
 * Find set of paths between starting and ending Node with Constraints.
 * 
 * @author tmessini
 */
public class PathFinderServiceImpl implements PathFinderService {
    
    
    //private final static Logger LOGGER = Logger.getLogger(PathFinderServiceImpl.class.getName()); 

    private static final int ZERO = 0;

    private PathFinderServiceWithLoops pathFinderServiceWithLoops = new PathFinderServiceWithLoopsImpl();


    /**
     * Path Finder Service
     */
    public PathFinderServiceImpl() {
        super();
    }


    /**
     * Recursive method to count all the paths between (2) nodes with/without constraints
     * 
     * @param graph
     * @param start
     * @param end
     */
    private int countPaths(Graph graph, String start, String end, Constraint constraint, int pathsCounter, Stack<String> path,
            Set<String> onPath, PathStats pathStats) {

        /** locally saved paths */
        Stack<String> pathInRecursion = path;
        Set<String> onPathInRecursion = onPath;

        /** Add start to current path */
        pathInRecursion.push(start);
        onPathInRecursion.add(start);

        /**
         * If path traversal has reached end node and there are no constraints
         */
        if (start.equals(end)) {
            if (path.size() != 1) {
                if (constraint != null && Operator.EQUAL.equals(constraint.getOperator())) {
                    if (path.size() == constraint.getcValue()) {
                        //LOGGER.info(path.toString());
                        pathsCounter++;
                    }
                } else {
                    //LOGGER.info(path.toString());
                    pathsCounter++;
                }

            } else {
                /** we are interested in circular paths */
                return pathFinderServiceWithLoops.findCircularPathsBetweenNodes(graph, graph.getNode(start).getName(),
                                                                                graph.getNode(end).getName(), constraint,
                                                                                new Stack<String>(), new HashSet<String>(), ZERO);
            }
        } else {
            Set<Edge> edges = graph.getNode(start).getEdges();
            for (Edge edge : edges) {
                if (!onPathInRecursion.contains(edge)) {
                    /**
                     * update path stats as the path is moving towards neighboor
                     */
                    pathStats.setDistance(edge.getDistance() + pathStats.getDistance());
                    pathStats.setStops(pathInRecursion.size());
                    /** we need to evaluate against constraints */
                    if (constraint != null) {
                        if (constraint.evaluate(pathStats)) {
                            pathsCounter = countPaths(graph, edge.getEndingNode().getName(), end, constraint, pathsCounter,
                                                      pathInRecursion, onPathInRecursion, pathStats);
                        }
                    } else {
                        pathsCounter = countPaths(graph, edge.getEndingNode().getName(), end, constraint, pathsCounter,
                                                  pathInRecursion, onPathInRecursion, pathStats);
                    }
                }
            }
        }
        pathInRecursion.pop();
        onPathInRecursion.remove(start);
        pathStats.reset();
        return pathsCounter;
    }


    @Override
    public int findPathsBetweenNodes(Graph graph, Node startNode, Node endNode, ConstraintImpl constraint) {
        int count = 0;
        if (constraint != null && Operator.EQUAL.equals(constraint.getOperator())) {
            List<Integer> paths = pathFinderServiceWithLoops
                    .findPathsLengthCircularPathsBetweenNodes(graph, startNode.getName(), endNode.getName(), constraint,
                                                              new Stack<String>(), new HashSet<String>(),
                                                              new ArrayList<Integer>());
            Iterator<Integer> pathIter = paths.iterator();
            while (pathIter.hasNext()) {
                Integer pathLength = pathIter.next();
                if (pathLength > constraint.getcValue())
                    count++;
            }
        } else {
            count = countPaths(graph, startNode.getName(), endNode.getName(), constraint, 0, new Stack<String>(),
                               new HashSet<String>(), new PathStats());
        }
        return count;
    }


    @Override
    public int findPathsBetweenNodes(Graph graph, String path, ConstraintImpl constraint) {
        String startNodeStr = path.substring(0, 1);
        Node startNode = graph.getNode(startNodeStr);
        String stopNodeStr = path.substring(1, 2);
        Node stopNode = graph.getNode(stopNodeStr);
        return findPathsBetweenNodes(graph, startNode, stopNode, constraint);
    }
}
