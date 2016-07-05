package com.tmessinis.graph.command.factory;

public enum CommandType {  

    /** Distance of specific route */
    DISTANCE_OF_PATH("DISTANCE_OF_PATH"),
    
    /** Distance of shortest path between two nodes */
    DISTANCE_OF_SHORTEST_PATH("DISTANCE_OF_SHORTEST_PATH_BETWEEN_TWO_NODES"),
    
    /** Trips between nodes */
    TRIPS_BETWEEN_NODES("TRIPS_BETWEEN_NODES_WITH_CONSTRAINTS");
    
    /**
     * Command Type
     * 
     * @param description
     */
    CommandType(String description)
    {
        
    }
}
