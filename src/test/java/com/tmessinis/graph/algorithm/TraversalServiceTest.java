package com.tmessinis.graph.algorithm;

import com.tmessinis.graph.algorithm.TraversalService;
import com.tmessinis.graph.algorithm.TraversalServiceImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;

import static org.junit.Assert.*;
import org.junit.Test;


public class TraversalServiceTest {

    TraversalService traversalService = new TraversalServiceImpl();
    GraphFactory     graphFactory     = new GraphFactoryImpl();


    @Test
    public void testSimpleGraphTraversal() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(5, traversalService.findDistanceOfPath(graph, "AB"));
        assertEquals(2, traversalService.findDistanceOfPath(graph, "CE"));
        assertEquals(9, traversalService.findDistanceOfPath(graph, "ABC"));
    }


    @Test
    public void testSimpleGraphTraversalSameNode() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(0, traversalService.findDistanceOfPath(graph, "BB"));
    }


    @Test
    public void testSimpleGraphTraversalSameNodeNonExisting() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals("NO SUCH ROUTE", traversalService.findDistanceOfPath(graph, "AF"));
    }


    @Test
    public void testSimpleGraphTraversalABC() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(9, traversalService.findDistanceOfPath(graph, "ABC"));
    }


    @Test
    public void testSimpleGraphTraversalAD() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(5, traversalService.findDistanceOfPath(graph, "AD"));
    }


    @Test
    public void testSimpleGraphTraversalAAD() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(13, traversalService.findDistanceOfPath(graph, "AADC"));
    }


    @Test
    public void testSimpleGraphTraversalADC() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(13, traversalService.findDistanceOfPath(graph, "ADC"));
    }


    @Test
    public void testSimpleGraphTraversalAEBCD() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(22, traversalService.findDistanceOfPath(graph, "AEBCD"));
    }


    @Test
    public void testSimpleGraphTraversalAED() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals("NO SUCH ROUTE", traversalService.findDistanceOfPath(graph, "AED"));
    }

}
