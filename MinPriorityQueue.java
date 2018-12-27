package pa3;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
public class MinPriorityQueue {
	public Heap heap;
	/**
	 * Min-Priority Queue constructor
	 * @param size
	 */
	public MinPriorityQueue(int size) {
		heap = new Heap(size);
	}
	
	public GraphNode pullHighestPriorityElement() {
		return heap.extractMin();
	}
	
	/**
	 * insert Operation
	 * @param g
	 * runtime: O(logn)
	 */
	public void insert(GraphNode g) {
		heap.insert(g);
	}
	/**
	 * O(logn)
	 * @param g
	 */
	public void rebalance(GraphNode g) {
//		int i =  heap.hashmap.getValue(g);
//		heap.heapifyDown(i);
//		heap.heapifyUp(i);
		heap.heapify(g);
	}
	
	public boolean isEmpty() {
		if(heap.size == 0) {
			return true;
		}
		return false;
	}
	
}
