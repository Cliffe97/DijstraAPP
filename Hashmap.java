package pa3;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
public class Hashmap {
	public Entry[] table;
	public int size;
	public int load;
	
	public Hashmap(int size) {
		table = new Entry[size];
		this.size = size;
		this.load = 0;
	}

	/**
	 * O(n)
	 * @param key
	 * @param value
	 */
	public void set(GraphNode key, int value) {
		//System.out.println("x");
		if(load>size/2) {
			rehash();
		}
		// use for loop to find a avaliable spot
		for(int i = 0; i < this.size; i++) {
			//int spot = hashFunction(Math.abs(key.getId().hashCode()), i, this.size);
			int hashcode = hashCode(key);
			int spot = hashFunction(hashcode, i, this.size);
			if(table[spot]== null) {
				table[spot] = new Entry(key,value);
				this.load++;
				break;
			}else if(table[spot].key.getId().equals(key.getId())) {
				table[spot].value = value;
				break;
			}
		}
	}
	

	/**
	 * @param g
	 * @return the key of corresponding node
	 * O(n)
	 */
	public int getValue(GraphNode g) {
		// use for loop to find a available spot
		for(int i = 0; i < this.size; i++) {
			int hashcode = hashCode(g);
			int spot = hashFunction(hashcode, i, this.size);
			//int spot = hashFunction(Math.abs(g.getId().hashCode()), i, this.size);
			if(table[spot] == null) {
				return -1;
			}else if(table[spot].key.getId().equals(g.getId())) {
				return table[spot].value;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param g
	 * @return true or false on having the key
	 * O(n)
	 */
	public boolean hasKey(GraphNode g) {
		// use for loop to find a avaliable spot
		for(int i = 0; i < this.size; i++) {
			int hashcode = hashCode(g);
			int spot = hashFunction(hashcode, i, this.size);
			//int spot = hashFunction(Math.abs(g.getId().hashCode()), i, this.size);
			if(table[spot] == null) {
				return false;
			}else if(table[spot].key.getId().equals(g.getId())&& table[spot].value == -1) {
				return false;
			}else if(table[spot].key.getId().equals(g.getId())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param id
	 * @param k
	 * @return an integer for index in hashmap
	 */
	public int hashFunction(int id, int k, int size) {
		return (int) ((id%size+k)%size);
	}
	/** 
	 * O(n)
	 */
	public void rehash() {
		Entry[] newTable = new Entry[this.size*2];
		int newLoad = 0;
		for(int i = 0; i < this.size; i++) {
			if(this.table[i]!=null) {
				// use for loop to find a avaliable spot
				for(int j = 0; j < this.size*2; j++) {
					int hashcode = hashCode(this.table[i].key);
					int spot = hashFunction(hashcode, j, this.size*2);
					//int spot = hashFunction(Math.abs(this.table[i].key.getId().hashCode()), j, this.size*2);
					if(newTable[spot] == null) {
						newTable[spot] = this.table[i];
						newLoad++;
						break;
					}
				}
			}
		}
		//update everything
		this.table = newTable;
		this.size *= 2;
		this.load = newLoad;
	}
	/**
	 * O(n)
	 */
	public String toString() {
		String output = "HashMap: \n";
		for(int i = 0; i < this.size; i++) {
			if(table[i]!=null) {
				output += "Index: "+ i + ", Key: "+ table[i] + ", Value: "+ table[i].value+", Priority: "+ table[i].key.priority+"\n";
			}
		}
		return output;
	}
	/**
	 * 
	 * @param g
	 * @return the hashcode of the node
	 * O(1)
	 */
	public int hashCode(GraphNode g) {
		int k = 0;
		String s1 = g.getId();
		for(int i = 0; i < s1.length(); i++) {// times 31 to make it more unique
			k = 31*k + s1.charAt(i);
		}
		//long newId = Long.parseLong(result);
		return Math.abs(k);
	}
	
}
