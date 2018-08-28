Bijay Ranabhat
README FILE 
Algorithmic Graph Theory

Floyd Warshall Algorihtm 

PROGRAM INPUT: 
*****************************************************************
This program is ideally run in the open source program, Eclipse-Java version.

The program reads in a txt file containing the graph network. The first line of the txt file specifies the number of vertices in the network and the adjacency matrix of the network is listed below. 

Note: In order to account for paths with a length of zero, 999 was used as a placeholder in the adjacency matrix to indicate that there was no path between two vertices. 

The network is read in as a two-dimensional array. 

In order to change the input of the program, the code "Network1.txt" in the Label.java class, must be changed to the title of your txt file before running the program: 

public static void main(String... arg) throws FileNotFoundException
    {
        int adjacency_matrix[][];
       
        Scanner scan = new Scanner(new File("Network1.txt"));
*****************************************************************



Reading the console output: 
*****************************************************************
Each iteration is printed with the current state of the distance matrix and the predecessor matrix that are each updated as the algorithm continues to traverse through the rows of the distance matrix. 

The source vertex is labeled as vertex 1. The other vertices in the given networks are then labeled as 2, 3, 4, 5, etc. 

In the distance matrix, 999 represents the value of infinity. 

The last iteration completed, shows the optimum distance matrix and predecessor matrix for the network.
*****************************************************************


Negative Cycles: 
*****************************************************************
This Floyd Warshall program terminates even when faced with a negative cycle, which can be seen when Network3.txt is run through the program.    
*****************************************************************









