# graph-cli

Build: mvn clean package

Usage: java -jar target/graph-1.0-SNAPSHOT.jar graph.txt commands.txt

# Description of Graph (graph.txt): 

Format: [Node1][Node2][Distance]

AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

# Graph commands (commands.txt):

DISTANCE_OF_PATH ABC

DISTANCE_OF_PATH AD

DISTANCE_OF_PATH ADC

DISTANCE_OF_PATH AEBCD

DISTANCE_OF_PATH AED

TRIPS_BETWEEN_NODES CC STOPS <= 3 (Number of trips between node c and node c with maximum stops 3 nodes) 

TRIPS_BETWEEN_NODES AC STOPS = 4 (Number of trips between node c and node c with 4 nodes stops) 

DISTANCE_OF_SHORTEST_PATH AC

DISTANCE_OF_SHORTEST_PATH BB 

TRIPS_BETWEEN_NODES CC DISTANCE < 30 (Number of trips between node c and node c with distance less than 30)

