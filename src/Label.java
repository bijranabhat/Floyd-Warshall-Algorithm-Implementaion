/* McKenzie Allaben and Bijay Ranabhat
 * Algorithmic Graph Theory 
 * Shortest path algorithms programming assignment
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Label
{
    private int distancematrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;
    private int predmatrix[][];
 
    public Label(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        predmatrix= new int[numberofvertices + 1][numberofvertices + 1]; 
        this.numberofvertices = numberofvertices;
    }
 
    public void floydwarshall(int adjacencymatrix[][])
    {
    	
    	for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
            	predmatrix[source][destination]=0;
            }
        }
    	
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
                if( distancematrix[source][destination] != INFINITY){
                	predmatrix[source][destination]= source;
                }
                
            }
        }
 
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
        	System.out.println("Iteration:" + intermediate);
        	System.out.println("Distance Matrix:");
            System.out.println("----------------------------------");

            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                	
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                         < distancematrix[source][destination])
                    {
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                            + distancematrix[intermediate][destination];
                        predmatrix[source][destination]= predmatrix[intermediate][destination];
                        }
                    
                   
                    System.out.print(distancematrix[source][destination] + "\t");
                    //System.out.print();
                }
                System.out.println();
            }
            System.out.println();
            
            System.out.println("Predecessor Matrix:");
            System.out.println("----------------------------------");

            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                	System.out.print(predmatrix[source][destination] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
 
        
    }
 
    public static void main(String... arg) throws FileNotFoundException
    {
        int adjacency_matrix[][];
       
        Scanner scan = new Scanner(new File("Network1.txt"));
        
        int numberofvertices = scan.nextInt();
        
        int[][] adjacency = new int[numberofvertices+1][numberofvertices+1];
 
        adjacency_matrix = new int[numberofvertices + 1][numberofvertices + 1];
        
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                adjacency_matrix[source][destination] = scan.nextInt();
                if (source == destination)
                {
                    adjacency_matrix[source][destination] = 0;
                    continue;
                }
                if (adjacency_matrix[source][destination] == 999)
                {
                    adjacency_matrix[source][destination] = INFINITY;
                }
            }
        }
        System.out.println("Floyd Warshall Algorithm");
        System.out.println("\n");
        Label floydwarshall = new Label(numberofvertices);
        floydwarshall.floydwarshall(adjacency_matrix);
        scan.close();
    }
}