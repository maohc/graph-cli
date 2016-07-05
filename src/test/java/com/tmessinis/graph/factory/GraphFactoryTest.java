package com.tmessinis.graph.factory;
import org.junit.Assert;
import org.junit.Test;

import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;

import junit.framework.TestCase;

public class GraphFactoryTest extends TestCase {

	GraphFactory graphFactory = new GraphFactoryImpl();

 
	@Test
	public void testGraphCreationShouldPass() {
		String graphDescription = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		Graph manuallyCreatedGraph = GraphFactoryUtil.createGraphForTest();
		Graph factoryCreatedGraph = graphFactory.initGraph(graphDescription);
		Assert.assertTrue(manuallyCreatedGraph.equals(factoryCreatedGraph));		
	}
	
 
    @Test
    public void testGraphCreationShouldPassDueToTrimming() {
        String graphDescription = "AB5, "
                + ""
                + ""
                + "BC4, CD8, DC8,     DE6, AD5,    CE2,    EB3, AE7";
        Graph manuallyCreatedGraph = GraphFactoryUtil.createGraphForTest();
        Graph factoryCreatedGraph = graphFactory.initGraph(graphDescription);
        Assert.assertTrue(manuallyCreatedGraph.equals(factoryCreatedGraph));
    }
 
    @Test
    public void testGraphCreationShoudFailOtherNode() {
        String graphDescription = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AR7  ";
        Graph manuallyCreatedGraph = GraphFactoryUtil.createGraphForTest();
        Graph factoryCreatedGraph = graphFactory.initGraph(graphDescription);
        Assert.assertFalse(manuallyCreatedGraph.equals(factoryCreatedGraph));
    }

 
    @Test
    public void testGraphCreationShouldFailOtherDistance() {
        String graphDescription = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE8  ";
        Graph manuallyCreatedGraph = GraphFactoryUtil.createGraphForTest();
        Graph factoryCreatedGraph = graphFactory.initGraph(graphDescription);
        Assert.assertFalse(manuallyCreatedGraph.equals(factoryCreatedGraph));
    }
    
    
    @Test
    public void testGraphCreationShouldFailInvalidFormat() {
        String graphDescription = "D5r6, AdD5";
        Graph factoryCreatedGraph = graphFactory.initGraph(graphDescription);
        Assert.assertEquals(factoryCreatedGraph, new Graph());
    }



}
