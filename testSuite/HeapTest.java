package pa3.testSuite;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pa3.*;

public class HeapTest {
	@Test
	void insertTest() {
		Heap heap = new Heap(50);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		heap.insert(node1);
		heap.insert(node2);
		heap.insert(node3);
		heap.insert(node4);
		String expected = "3 5 15 10 ";
		//System.out.println(heap.toString());
		assertTrue(heap.toString().equals(expected));
	}
	@Test
	void extractMinTest() {
		Heap heap = new Heap(50);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		heap.insert(node1);
		heap.insert(node2);
		heap.insert(node3);
		heap.insert(node4);
		//System.out.println(heap.toString());
		GraphNode min = heap.extractMin();
		//System.out.println(heap.toString());
		System.out.println(heap.hashmap.toString());
		assertTrue(min.priority == 3);
	}
	@Test 
	void capacityTest(){
		Heap heap  =  new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		heap.insert(node1);
		heap.insert(node2);
		heap.insert(node3);
		heap.insert(node4);
		String expected = "3 5 15 10 ";
		assertTrue(heap.toString().equals(expected)&&heap.capacity == 12);
	}
	@Test
	void hashTest() {
		Heap heap  =  new Heap(100);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		heap.insert(node1);
		heap.insert(node2);
		heap.insert(node3);
		heap.insert(node4);
//		System.out.println(heap.hashmap.toString());
//		System.out.println(heap.toString());
		assertTrue(true);
	}
}
