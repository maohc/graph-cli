package com.tmessinis.graph.factory;

import com.tmessinis.graph.element.Edge;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.element.Node;


/**
 * Provides Util Functions for testing.
 * 
 * @author tmessini
 */
public class GraphFactoryUtil {

    /**
     * Manually create graph to test the graph factory Edges: "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
     * 
     * @return Graph
     */
    public static Graph createGraphForTest() {
        Graph manuallyCreatedGraph = new Graph();

        /** Creating Nodes */
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        /** Creating Edges */
        /** AB5 */
        Edge ab5 = new Edge(b, 5);
        /** AE7 */
        Edge ae7 = new Edge(e, 7);
        /** AD5 */
        Edge ad5 = new Edge(d, 5);

        /** BC4 */
        Edge bc4 = new Edge(c, 4);

        /** CD8 */
        Edge cd8 = new Edge(d, 8);
        /** CE2 */
        Edge ce2 = new Edge(e, 2);

        /** DC8 */
        Edge dc8 = new Edge(c, 8);
        /** DE6 */
        Edge de6 = new Edge(e, 6);

        /** EB3 */
        Edge eb3 = new Edge(b, 3);

        /** Adding Edges on Node A */
        a.addEdge(ab5);
        a.addEdge(ad5);
        a.addEdge(ae7);

        /** Adding Edges on Node B */
        b.addEdge(bc4);

        /** Adding Edges on Node C */
        c.addEdge(cd8);
        c.addEdge(ce2);

        /** Adding Edges on Node D */
        d.addEdge(dc8);
        d.addEdge(de6);

        /** Adding Edges on Node E */
        e.addEdge(eb3);

        manuallyCreatedGraph.addNode("A", a);
        manuallyCreatedGraph.addNode("B", b);
        manuallyCreatedGraph.addNode("C", c);
        manuallyCreatedGraph.addNode("D", d);
        manuallyCreatedGraph.addNode("E", e);

        return manuallyCreatedGraph;
    }

}
