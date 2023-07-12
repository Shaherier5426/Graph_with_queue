

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    private int[][] adjacencyMatrix;
    private int[] vertices;
    private boolean[] visited;
     int bf;
     int df;
    private StringBuilder string = new StringBuilder();
    private StringBuilder text = new StringBuilder();
    
    BufferedReader files = null;
    FileReader file = null;

    public Graph(String inFileName){

        try{
            file = new FileReader(inFileName);
            files = new BufferedReader(file);
            String s = new String();
            int i = 0;
            while((s = files.readLine()) != null){
                s = s.replaceAll("\t","");
                char[] k = s.toCharArray();
				if (i == 0){
					adjacencyMatrix = new int[k.length][k.length];
				}
                for(int j= 0;j < k.length; j++){
                    int b = Integer.parseInt(String.valueOf(k[j]));
                    adjacencyMatrix[i][j] = b; 
                }
                i++;
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    
        int number = adjacencyMatrix.length;
        vertices = new int[number];
        visited = new boolean[number];
        for (int i = 0; i < number ; i++){
            vertices[i] = i;
            visited[i] = false;
        }
        
    }
    

    public void  bfsTraversal(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
        
		queue.add(start);
		visited[start] = true;
       text.append(vertices[start]+" ---> ");

		while (!queue.isEmpty()) {
			int v = queue.poll();
			// visit node #v 
            visited[v] =true;
			bf = v;
			// loop through all neighbors of vertex v
            
			for (int u = 0; u < vertices.length; u++) {
                if(bf != end){
				if (adjacencyMatrix[v][u] == 1 && !visited[u]) {
					queue.add(u);
                    
					visited[u] = true;
                    bf = u;
                    if(bf == end){
                        while (!queue.isEmpty()) {
                            queue.poll();
                        }
                        text.append(vertices[u]);}
                else{
                    text.append(vertices[u]+" ---> ");
                }
				}
            }
            
			}
		}
	}


    public void  dfsTraversal(int start,int end) {
         
        df = start;
        if(df == end){
		string = string.append(vertices[start]);}
else{
    string = string.append(vertices[start]+" ---> ");
}
		visited[start] = true;
         df = start;

     
		for (int j = 0; j < vertices.length ; j++) {
            if(df!= end){
			if (adjacencyMatrix[start][j] == 1 && !visited[j] && start != end) {
                	// j is connected to start and j is unvisited
                dfsTraversal(j, end);

			}
		}
        else{
            return;
    }


    }
	}
public String getdfsResult(){
    return this.string.toString();
}
public void clearStringBuilder(){
    this.text.setLength(0);
    this.string.setLength(0);
    this.bf = 0;
    this.df = 0;
    int number = adjacencyMatrix.length;
        vertices = new int[number];
        visited = new boolean[number];
        for (int i = 0; i < number ; i++){
            vertices[i] = i;
            visited[i] = false;}
}
public String getbfsResult(){ return this.text.toString(); }
    public static void main(String[] args) {
       
        String inFileName = "C:\\Users\\MD\\Desktop\\DSA\\Graph\\src\\input.txt";
       String  query = "C:\\Users\\MD\\Desktop\\DSA\\Graph\\src\\query.txt";
        String outDF = "DF.txt";
        String outBF = "Bf.txt";

        Graph graph = new Graph(inFileName);
    
         graph.dfsTraversal(0,11);
         String b = graph.getdfsResult();
         System.out.println(b);
         graph.clearStringBuilder();
         graph.dfsTraversal(1,15);
         String c = graph.getdfsResult();
        System.out.println(c);
        
    }

}