package com.tmessinis.graph.algorithm;

import com.tmessinis.graph.algorithm.DijkstraService;
import com.tmessinis.graph.algorithm.DijkstraServiceImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author tmessini
 */
public class DijkstraServiceTest {

    DijkstraService dijkstraService = new DijkstraServiceImpl();
    GraphFactory    graphFactory    = new GraphFactoryImpl();


    @Test
    public void testNonLoopingScenarioAD() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(5, dijkstraService.findShortestPathDistance(graph, graph.getNode("A"), graph.getNode("D")));
    }


    @Test
    public void testNonLoopingScenarioAE() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(7, dijkstraService.findShortestPathDistance(graph, graph.getNode("A"), graph.getNode("E")));
    }


    @Test
    public void testNonLoopingScenarioBC() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(4, dijkstraService.findShortestPathDistance(graph, graph.getNode("B"), graph.getNode("C")));
    }


    @Test
    public void testLoopingScenarioBB() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(9, dijkstraService.findShortestPathDistance(graph, graph.getNode("B"), graph.getNode("B")));
    }


    @Test
    public void testLoopingScenarioCC() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(9, dijkstraService.findShortestPathDistance(graph, graph.getNode("C"), graph.getNode("C")));
    }


    @Test
    public void testLoopingScenarioDD() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(16, dijkstraService.findShortestPathDistance(graph, graph.getNode("D"), graph.getNode("D")));
    }


    @Test
    public void testLoopingScenarioBC() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(4, dijkstraService.findShortestPathDistance(graph, graph.getNode("B"), graph.getNode("C")));
    }

}
