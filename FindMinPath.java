package pa3;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FindMinPath {
	public static void main(String[] args) {
		GraphWrapper gw = new GraphWrapper(true);
		// get the output
		String output = run(gw, gw.getHome());
		writeToFiles(output);
		System.out.println(output);
	}
	/**
	 * write out the answers to answer.txt file
	 * @param output
	 * O(n), where n is number of intersection
	 */
	public static void writeToFiles(String output) {
		try {
			PrintWriter printer = new PrintWriter("answers.txt","UTF-8");
			printer.print(output);
			printer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param gw
	 * @param home
	 * @return the output string
	 * O(E+N)where N is length of the shortest path
	 */
	public static String run(GraphWrapper gw, GraphNode home) {
		String output = "";
		Hashmap grey = new Hashmap(1000);
		MinPriorityQueue queue  = new MinPriorityQueue(1000);
		//boolean found = false;
		//System.out.println(home.toString());
		home.priority = 0;
		queue.insert(home);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.pullHighestPriorityElement();
			grey.set(curr, 0);//set the value to 0
			if(curr.isGoalNode()) {// if found goal node 
				int count = 0;
				String[] array = new String[1000];
				while(curr!=home) {// add every direction on the path to the array
					array[count] = curr.previousDirection;
					curr = curr.previousNode;
					count++;
				}// add to output
				for(int i = count-1; i >=0; i--) {
					output += array[i]+"\n";
				}
				//found = true;
				return output.substring(0, output.length()-1);
			}else {
				if(curr.hasNorth()) {//if has north node
					GraphNode neighbor = curr.getNorth();
					int x =  curr.priority + curr.getNorthWeight();
					if(!queue.heap.hashmap.hasKey(neighbor)&&!grey.hasKey(neighbor)) {// if not in the queue
						neighbor.priority = x;
						neighbor.previousNode = curr;
						neighbor.previousDirection = "North";
						queue.insert(neighbor);
					}else {//update the priority if found a shorter path
						if(neighbor.priority>x) {
							neighbor.priority = x;
							queue.rebalance(neighbor);
							neighbor.previousNode = curr;
							neighbor.previousDirection = "North";
						}
					}
				}
				if(curr.hasSouth()) {//if has south node
					GraphNode neighbor = curr.getSouth();
					int x =  curr.priority + curr.getSouthWeight();
					if(!queue.heap.hashmap.hasKey(neighbor)&&!grey.hasKey(neighbor)) {// if not in the queue
						neighbor.priority = x;
						neighbor.previousNode = curr;
						neighbor.previousDirection = "South";
						queue.insert(neighbor);
					}else {//update the priority if found a shorter path
						if(neighbor.priority>x) {
							neighbor.priority = x;
							queue.rebalance(neighbor);
							neighbor.previousNode = curr;
							neighbor.previousDirection = "South";
						}
					}
					
				}
				if(curr.hasWest()) {//if has west node
					GraphNode neighbor = curr.getWest();
					int x =  curr.priority + curr.getWestWeight();
					if(!queue.heap.hashmap.hasKey(neighbor)&&!grey.hasKey(neighbor)) {// if not in the queue
						neighbor.priority = x;
						neighbor.previousNode = curr;
						neighbor.previousDirection = "West";
						queue.insert(neighbor);
					}else {//update the priority if found a shorter path
						if(neighbor.priority>x) {
							neighbor.priority = x;
							queue.rebalance(neighbor);
							neighbor.previousNode = curr;
							neighbor.previousDirection = "West";
						}
					}
				}
				if(curr.hasEast()) {//if has east node
					GraphNode neighbor = curr.getEast();
					int x =  curr.priority + curr.getEastWeight();
					if(!queue.heap.hashmap.hasKey(neighbor)&&!grey.hasKey(neighbor)) {// if not in the queue
						neighbor.priority = x;
						neighbor.previousNode = curr;
						neighbor.previousDirection = "East";
						queue.insert(neighbor);
					}else {//update the priority if found a shorter path
						if(neighbor.priority>x) {
							neighbor.priority = x;
							queue.rebalance(neighbor);
							neighbor.previousNode = curr;
							neighbor.previousDirection = "East";
						}
					}
				}
			}
		}
		System.out.println("Such a path doesn't exist.");
		output = "Such a path doesn't exist.";
		return output;
	}
}
