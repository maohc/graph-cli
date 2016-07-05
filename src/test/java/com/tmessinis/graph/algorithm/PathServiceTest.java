package com.tmessinis.graph.algorithm;

import static org.junit.Assert.*;
import org.junit.Test;

import com.tmessinis.graph.algorithm.PathFinderService;
import com.tmessinis.graph.algorithm.PathFinderServiceImpl;
import com.tmessinis.graph.algorithm.PathFinderServiceWithLoops;
import com.tmessinis.graph.algorithm.PathFinderServiceWithLoopsImpl;
import com.tmessinis.graph.constraint.Constraint;
import com.tmessinis.graph.constraint.ConstraintImpl;
import com.tmessinis.graph.constraint.factory.ConstraintFactory;
import com.tmessinis.graph.constraint.factory.ConstraintFactoryImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;


/*
Output: 
The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.

Test Input:
For the test input, the towns are named using the first few letters of the alphabet from A to E.  A route between two towns (A to B) with a distance of 5 is represented as AB5.
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

Expected Output:
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE
Output #6: 2
Output #7: 3
Output #8: 9
Output #9: 9
Output #10: 7
*/
public class PathServiceTest {

    PathFinderService pathFinderService = new PathFinderServiceImpl();
    PathFinderServiceWithLoops pathFinderServiceWithLoops = new PathFinderServiceWithLoopsImpl();
    GraphFactory      graphFactory      = new GraphFactoryImpl();
    ConstraintFactory constraintFactory = new ConstraintFactoryImpl();


    /**
     * Paths from A to C Expecting 4 paths 
     * [A, D, E, B, C] 
     * [A, D, C] 
     * [A, B, C] 
     * [A, E, B, C]
     */
    @Test
    public void testPathsBetweenACWithoutConstaints() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), null));
    }


    /**
     * Paths from A to C Expecting 4 paths 
     * [A, D, E, B, C] 
     * [A, D, C] 
     * [A, B, C] 
     * [A, E, B, C]
     */
    @Test
    public void testPathFinderServiceLocalVariablesWithoutConstraints() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), null));
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), null));
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), null));
    }


    /**
     * Paths from A to C with max-equal 3 stops. Constraints Expecting 3 paths: 
     * [A, D, C] 
     * [A, B, C] 
     * [A, E, B, C]
     */
    @Test
    public void testPathsBetweenACWith3MaxStops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 3";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(3, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), constraint));
    }


    /**
     * Paths from A to C with max-equal 4 stops. Constraints 
     * Expecting 4 paths: 
     * 
     * [A, D, E, B, C]
     * [A, D, C]
     * [A, B, C]
     * [A, E, B, C]
     * 
     */
    @Test
    public void testPathsBetweenACWith4MaxStops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 4";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), constraint));
    }


    /**
     * Paths from A to C with maximum 18 distance Expecting 4 paths: 
     * [A, D, E, B, C] (with 18 distance) 
     * [A, D, C] (with 13 distance) 
     * [A, B, C] (with 9 distance) 
     * [A, E, B, C] (with 14 distance)
     */
    @Test
    public void testPathsBetweenACWith18MaxDistance() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "DISTANCE <= 18";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(4, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), constraint));
    }
    
    
    /**
     * Paths from A to C with maximum 18 distance Expecting 4 paths: 
     * [A, D, E, B, C] (with 18 distance) 
     * [A, D, C] (with 13 distance) 
     * [A, B, C] (with 9 distance) 
     * [A, E, B, C] (with 14 distance)
     */
    @Test
    public void testPathsBetweenACWith18MaxDistanceLoops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "DISTANCE <= 18";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(5, pathFinderServiceWithLoops.findPathsBetweenNodes(graph, graph.getNode("A").getName(), graph.getNode("C").getName(), constraint));
    }


    /**
     * Paths from C to C with maximum 3 stops Expecting 2 paths: 
     * [C, D, C] (with 2 stops) 
     * [C, E, B, C] (with 3 stops)
     */
    @Test
    public void testPathsBetweenCCWith3MaxStops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 3";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(2, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("C"), graph.getNode("C"), constraint));

    }


    /**
     * Paths from B to B with maximum 3 stops Expecting 1 path1: 
     * [B, C, E, B] (with 3 stops)
     */
    @Test
    public void testPathsBetweenBBWith3MaxStops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 3";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(1, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("B"), graph.getNode("B"), constraint));
    }


    /**
     * Paths from B to B with maximum 3 stops Expecting 1 path1: 
     * [B, C, E, B] (with 3 stops) 
     * [B, C, D, E, B] (with 3 stops)
     */
    @Test
    public void testPathsBetweenBBWith4MaxStops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 4";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(2, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("B"), graph.getNode("B"), constraint));
    }
    
    
    /**
     * Paths from B to B with maximum 3 stops Expecting 1 path1: 
     * 
     * [B, C, E, B] (with 3 stops) 
     * [B, C, D, E, B] (with 3 stops)
     */
    @Test
    public void testPathsBetweenBBWith4MaxStopsLoops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS <= 4";
        Constraint constraint = (Constraint) constraintFactory.parseConstraint(constraintString);
        assertEquals(2, pathFinderServiceWithLoops.findPathsBetweenNodes(graph, graph.getNode("B").getName(), graph.getNode("B").getName(), constraint));
    }


    /**
     * Paths from C to C with maximum 30 distance Expecting 7 paths: 
     * [C, D, C](with 16 distance) 
     * [C, E, B, C] (with 9 distance) 
     * [C, E, B, C, D, C](with 25 distance) 
     * [C, D, C, E, B, C](with 25 distance) 
     * [C, D, E, B, C] (with 21 distance)
     * [C, E, B, C, E, B, C](18 distance) 
     * [C, E, B, C, E, B, C, E, B, C] (27 distance)
     */
    @Test
    public void testPathsBetweenCCWith30MaxDistance() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "DISTANCE < 30";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(7, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("C"), graph.getNode("C"), constraint));
    }


    /**
     * Paths from C to C with maximum 30 distance Expecting 3 paths: The number of trips starting at A and ending at C with
     * exactly 4 stops. 
     * [A, B, C, D, C] 
     * [A, D, C, D, C] 
     * [A, D, E, B, C]
     */
    @Test
    public void testPathsBetweenACWith4Stops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS = 4";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(3, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), constraint));
    }
    
    
    /**
     * Paths from C to C with 3 stops 
     * Expecting 1 paths: The number of trips starting at A and ending at C with exactly 3 stops. 
     * [A, E, B, C]
     */
    @Test
    public void testPathsBetweenACWith3Stops() {
        Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        String constraintString = "STOPS = 3";
        ConstraintImpl constraint = (ConstraintImpl) constraintFactory.parseConstraint(constraintString);
        assertEquals(1, pathFinderService.findPathsBetweenNodes(graph, graph.getNode("A"), graph.getNode("C"), constraint));
    }
    
}
