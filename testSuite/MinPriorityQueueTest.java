package pa3.testSuite;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pa3.*;
public class MinPriorityQueueTest {
	@Test
	void rebalanceTest() {
		MinPriorityQueue queue = new MinPriorityQueue(50);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		queue.insert(node1);
		queue.insert(node2);
		queue.insert(node3);
		queue.insert(node4);
		node1.priority = 20;
		queue.rebalance(node1);
		String expected = "3 10 15 20 ";
		assertTrue(queue.heap.toString().equals(expected));
	}
	@Test
	void isEmptyTest() {
		MinPriorityQueue queue = new MinPriorityQueue(50);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		node1.priority = 5;
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		node2.priority = 10;
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		node3.priority = 15;
		GraphNode node4 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0b", false);
		node4.priority = 3;
		queue.insert(node1);
		queue.insert(node2);
		queue.insert(node3);
		queue.insert(node4);
		queue.pullHighestPriorityElement();
		queue.pullHighestPriorityElement();
		queue.pullHighestPriorityElement();
		queue.pullHighestPriorityElement();
		assertTrue(queue.isEmpty());
	}
}
