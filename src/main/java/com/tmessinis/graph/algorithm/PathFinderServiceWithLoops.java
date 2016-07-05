package com.tmessinis.graph.algorithm;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.tmessinis.graph.contstraint.Constraint;
import com.tmessinis.graph.element.Graph;


public interface PathFinderServiceWithLoops {

    int findCircularPathsBetweenNodes(Graph graph, String startNode, String endNode, Constraint constraint, Stack<String> path,
            Set<String> pathSet, int pathsCounter);
    
    List<Integer> findPathsLengthCircularPathsBetweenNodes(Graph graph, String startNode, String endNode, Constraint constraint, Stack<String> path,
            Set<String> pathSet, List<Integer> pathLength);

    int findPathsBetweenNodes(Graph graph, String startNode, String endNode, Constraint constraint);

}
