
//import.java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Assignment4 {

    private static String inFileName;
    private static String query;
    private static String outDF;
    private static String outBF;

    public static void main(String[] args) {

        inFileName = args[0];
        query = args[1];
        outDF = args[2];
        outBF = args[3];

        BufferedReader files = null;
        FileReader file = null;
        FileWriter Wbfs = null;
        FileWriter Wdfs = null;
        BufferedWriter buff = null;
        BufferedWriter buff2 = null;
        Graph graph = new Graph(inFileName);


        try {
            file = new FileReader(query);
            files = new BufferedReader(file);
            Wdfs = new FileWriter(outDF);
             buff = new BufferedWriter(Wdfs);
            Wbfs = new FileWriter(outBF);
             buff2 = new BufferedWriter(Wbfs);
            String s = new String();

        buff.write("Depth_First_Search");
        buff.append("\n");
        buff2.write("Breath_First_Search");
        buff2.append("\n");

        while ((s = files.readLine()) != null) {
        String f[] = s.split("\t");

        int start = Integer.parseInt(f[0]);
        int end = Integer.parseInt(f[1]);

        graph.dfsTraversal(start,end);
        String b = graph.getdfsResult();
        buff.append("Path for "+"["+s+ "]").append("\n");
        buff.append(b). append("\n");
        graph.clearStringBuilder(); 
        graph.bfsTraversal(start,end);
        String c = graph.getbfsResult();
        buff2.append("Path for "+"["+s+ "]").append("\n");
        buff2.append(c).append("\n");  
        graph.clearStringBuilder(); 
            }

        buff.close();
        buff2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}