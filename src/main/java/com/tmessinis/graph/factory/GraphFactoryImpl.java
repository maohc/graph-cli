package com.tmessinis.graph.factory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;


/**
 * Factory for graphs comma seperated string 
 * 
 * Format:
 * [Node(1 character)][Node(1 character)][distance],....,[Node(1 character)][Node(1 character)][distance]
 * e.g. AB5,...,CD7
 * 
 * 
 * Not Valid Format of comma seperated input returns a null Graph Object (Null Object Pattern)
 * 
 */
public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph initGraph(String graphString) {
        Graph graph = new Graph();
        Set<String> edges = getEdges(graphString);

        /**
         * Iterate through the Edges to create the graph
         */
        Iterator<String> iter = edges.iterator();
        while (iter.hasNext()) {
            /** Get next edge e.g. AB5 */
            String edge = iter.next();

            /** Parse Strings startingNode=A, endingNode=B, distance = 5 */
            String startingNodeString = edge.substring(0, 1);
            String endingNodeString = edge.substring(1, 2);
            String distanceString = edge.substring(2);

            /** Populate nodes, edges */
            int distance = Integer.parseInt(distanceString);
            Node startingNode = graph.getNode(startingNodeString);
            Node endingNode = graph.getNode(endingNodeString);
            Edge edgeToBeAdded = new Edge(endingNode, distance);
            startingNode.addEdge(edgeToBeAdded);
        }
        return graph;
    }

    /**
     * Get set of edges from comma seperated string
     * @param graph
     * @return Set
     */
    private Set<String> getEdges(String graph) {
        Set<String> edgesValidated = new HashSet<>();
        String[] edgesString = graph.split(",");
        Set<String> edges = new HashSet<String>(java.util.Arrays.asList(edgesString));
        Iterator<String> iter = edges.iterator();
        int validationError = 0;
        while (iter.hasNext()) {
            /** First we trim String */
            String validatedEdge = iter.next().trim();
            /** We validate whether the string is in correct Format */
            if (checkIfValidEdge(validatedEdge)) {
                edgesValidated.add(validatedEdge);
            } else {
                validationError++;
            }
        }
        if (validationError > 0 )
        {
          System.err.println(" Input is not valid :" + graph);
          edgesValidated.clear();
        }
        
        return edgesValidated;
    }

    /**
     * Check whether the format of Edge is correct
     * 
     * @param edge
     * 
     * @return true/false
     * 
     */
    public boolean checkIfValidEdge(String edge) {
        if (edge.length() < 3) {
            return false;
        }
        if (!edge.substring(0, 1).matches("[a-zA-Z]+")) {
            return false;
        }
        if (!edge.substring(1, 2).matches("[a-zA-Z]+")) {
            return false;
        }
        if (!isInteger(edge.substring(2))) {
            return false;
        }        
        return true;
    }
    
    /**
     * Check whether String to Int is possible
     * @param subString
     * @return true/false
     */
    public boolean isInteger(String subString) {
        try { 
            Integer.parseInt(subString); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}
