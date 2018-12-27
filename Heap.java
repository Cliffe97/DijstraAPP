package pa3;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
public class Heap {
	public GraphNode[] array;
	public int capacity;
	public int size;
	public Hashmap hashmap;
	
	public Heap(int capacity) {
		this.capacity = capacity;
		this.array = new GraphNode[capacity];
		this.size = 0;
		this.hashmap = new Hashmap(capacity);
	}
	/**
	 * O(n)
	 * @param g
	 */
	public void insert(GraphNode g) {
		this.size++;
		array[this.size-1] = g;
		hashmap.set(g, this.size-1);
		heapify(g);
		//reheaph if overflow
		if(this.size > this.capacity/2) {
			newHeap();
		}
	}
	/**
	 * O(logn)
	 * @return the node with highest priority
	 */
	public GraphNode extractMin() {
		if(this.size<1) {
			System.out.println("underFlow!");
			return null;
		}else {
			//get the min then start swapping
			GraphNode min = array[0];
			swap(0, this.size-1);
			this.size --;
			heapify(array[0]);
			// set value to -1 because deleted
			hashmap.set(min, -1);
			return min;
		}
	}
	/**
	 * O(logn)
	 * @param g
	 */
	public void heapify(GraphNode g) {
		int i = hashmap.getValue(g);
		if(i == -1) {
			System.out.println("Can't findnode");
		}else {
			//check for both
			heapifyDown(i);
			heapifyUp(i);
		}
	}
	/**
	 * O(logn)
	 * @param i
	 */
	public void heapifyUp(int i) {
		int parent = parent(i);
		//swap with parent
		while(i > 0 && array[i].priority<array[parent].priority) {
			swap(i, parent);
			i = parent;//traverse up
			parent = parent(i);
		}
	}
	/**
	 * O(logn)
	 * @param i
	 */
	public void heapifyDown(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		//find the smallest children
		if(l < this.size && array[l].priority < array[i].priority) {
			smallest = l;
		}else {
			smallest = i;
		}
		if(r < this.size && array[r].priority < array[smallest].priority) {
			smallest = r;
		}
		if(smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}
	}
	/**
	 * O(n)
	 */
	public void newHeap() {//if the heap is not big enough
		GraphNode[] newArray = new GraphNode[capacity*2];
		for(int i = 0; i < this.size; i ++) {
			newArray[i] = array[i];
		}
		this.array = newArray;
		this.capacity *= 2;
	}
	/**
	 * O(1)
	 * @param i
	 * @return
	 */
	public int parent(int i) {
		return ((i-1)/2);
	} 
	
	/**
	 * O(1)
	 * @param i
	 * @return
	 */
	public int left(int i) {
		return (2*i+1);
	}
	/**
	 * O(1)
	 * @param i
	 * @return
	 */
	public int right(int i) {
		return (2*i+2);
	}
	/**
	 * O(1)
	 * @param j
	 * @param k
	 */
	public void swap(int j, int k) {
		hashmap.set(array[j], k);//swap the value
		hashmap.set(array[k], j);
		GraphNode tmp = array[j];
		array[j] = array[k];//swap the index
		array[k] = tmp;
	}
	/**
	 * O(n)
	 */
	public String toString() {
		if(this.size == 0) {
			return "Heap is empty";
		}
		String result = "";
		for(int i = 0; i < this.size; i ++) {
			result += array[i].priority;
			result += " ";
		}
		return result;
	}
}
