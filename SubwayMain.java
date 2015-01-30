import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class SubwayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashSet<String>> transferMap= new HashMap<String, HashSet<String>>();
		String fileName = "/Applications/ListGraph/src/data.txt";
		int c=0;
	    try {
	      ////////////////////////////////////////////////////////////////
	      BufferedReader in = new BufferedReader(new FileReader(fileName));
	      String s;
	      boolean edgeOrVertex = true;
	      
	      ListGraph graph= new ListGraph();
	      while ((s = in.readLine()) != null) {
		    if(s.equals("")){//start to save edge information.
		    	edgeOrVertex = false;
		    	continue;
		    }
	    	if(edgeOrVertex){
	    		String token[];
	    		token = s.split(" ");//add Vertex
	    		graph.addNode(token[0], token[1], token[2]);
	    		
	    		if(transferMap.containsKey(token[1])){
	    			transferMap.get(token[1]).add(token[0]);
	    		}
	    		else{
	    			HashSet<String> set= new HashSet<String>();
	    			set.add(token[0]);
	    			transferMap.put(token[1],set);
	    		}
	    	}
	    	else{
	    		String token[];
	    		token = s.split(" ");//add Edge
	    		int t = Integer.parseInt(token[2]);
	    		graph.addEdge(token[0], token[1], t);
	    	}
	      }
	      in.close();
	      
	      Iterator<Entry<String, HashSet<String>>> it = transferMap.entrySet().iterator();
	      while (it.hasNext()) {
	          HashSet<String> aSet = (HashSet<String>)it.next().getValue();
	          if(aSet.size()>1){
	        	  Iterator<String> iterator = aSet.iterator(); 
	        	  while(iterator.hasNext()){
	        		  String aNum = (String) iterator.next();
	        		  Iterator<String> iterator2 = aSet.iterator();
	        		  while(iterator2.hasNext()){
	        			  String anotherNum = (String) iterator2.next();
	        			  if (aNum.equals(anotherNum))
	        				  continue;
	        			  graph.addEdge(aNum,anotherNum,5);
	        		  }
	        	  }
	          }
	      }
	      
	      ////////////////////////////////////////////////////////////////
	      String depart;//="응암";
	      String arrival;//"건대입구";
	      
	      Scanner input = new Scanner(System.in);
	      
	      System.out.println("Enter a depart station");
	      depart = input.nextLine();
	      
	      System.out.println("Enter a arrival station");
	      arrival=input.nextLine();
	      
	      StationNode departNode=graph.findNode(depart);
	      Dijkstra dijsktra = new Dijkstra(graph,departNode,arrival);
	      dijsktra.disjkstra();
	      
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }
	    
	   
	    	
	    		
	    	
	    
	    
	}
	
	

}
