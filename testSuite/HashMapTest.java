package pa3.testSuite;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pa3.*;

class HashMapTest {
	@Test
	void setTest() {
		Hashmap map = new Hashmap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		System.out.println(node1.getId().hashCode());
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		System.out.println(node2.getId().hashCode());
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		System.out.println(node3.getId().hashCode());
		map.set(node1, 1);
		map.set(node2, 2);
		map.set(node1, 9);
		assertTrue(map.getValue(node1)==9);
	}

	@Test
	void toStringTest() {
		Hashmap map = new Hashmap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		System.out.println(node1.getId().hashCode());
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		System.out.println(node2.getId().hashCode());
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		System.out.println(node3.getId().hashCode());
		map.set(node1, 1);
		map.set(node2, 2);
		map.set(node3, 3);
		System.out.println(map.toString());
		assertTrue(true);
	}
	@Test
	void hasKeyTest() {
		Hashmap map = new Hashmap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		System.out.println(node1.getId().hashCode());
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		System.out.println(node2.getId().hashCode());
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		System.out.println(node3.getId().hashCode());
		GraphNode node4 = new GraphNode("a6725faf-3aac-414e-8d3a-58ab6adab2db", false);

		map.set(node1, 1);
		map.set(node2, 2);
		map.set(node3, 3);
		assertTrue(map.hasKey(node1)&&map.hasKey(node2)&&map.hasKey(node3)&&!map.hasKey(node4));
	}
	@Test
	void  deleteTest() {
		Hashmap map = new Hashmap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		System.out.println(node1.getId().hashCode());
		GraphNode node2 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		System.out.println(node2.getId().hashCode());
		GraphNode node3 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		System.out.println(node3.getId().hashCode());
		GraphNode node4 = new GraphNode("a6725faf-3aac-414e-8d3a-58ab6adab2db", false);

		map.set(node1, 1);
		map.set(node2, 2);
		map.set(node3, 3);
		map.set(node4, -1);
		assertTrue(!map.hasKey(node4));
	}

}
