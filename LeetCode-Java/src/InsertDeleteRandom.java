import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteRandom {

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		obj.insert(1);
		obj.remove(2);
	    obj.insert(2);
		obj.getRandom();
		obj.remove(1);
	    obj.insert(2);
	    obj.getRandom();
	}
}

class RandomizedSet {

    private HashMap<Integer, Integer> indexByValue = new HashMap<>();
    private HashMap<Integer, Integer> valueByIndex = new HashMap<>();
    private int nextIndex = 0;
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexByValue.containsKey(val)) {
            return false;
        }
        indexByValue.put(val, nextIndex);
        valueByIndex.put(nextIndex, val);
        nextIndex++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = indexByValue.remove(val);
        if (index != null) {
            valueByIndex.remove(index);
            nextIndex--;
            // shift the last one into the empty slot if it wasn't last already
            if (index != nextIndex) {
                Integer lastValue = valueByIndex.remove(nextIndex);
                valueByIndex.put(index, lastValue);
                indexByValue.put(lastValue, index);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = random.nextInt(nextIndex);
        return valueByIndex.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


//class RandomizedSet {
//
//	HashMap<Integer, Integer> hashMap; // Key is val and value is index at which that val is stored in array
//	int arr[];
//	int lastIndex;
//	Random rd;
//
//	/** Initialize your data structure here. */
//	public RandomizedSet() {
//		hashMap = new HashMap<>();
//		arr = new int[100000000];
//		rd = new Random();
//		lastIndex = -1;
//	}
//
//	/**
//	 * Inserts a value to the set. Returns true if the set did not already contain
//	 * the specified element.
//	 */
//	public boolean insert(int val) {
//		if (hashMap.containsKey(val)) {
//			return false;
//		}
//		arr[++lastIndex] = val;
//		hashMap.put(val, lastIndex);
//		return true;
//	}
//
//	/**
//	 * Removes a value from the set. Returns true if the set contained the specified
//	 * element.
//	 */
//	public boolean remove(int val) {
//		if (hashMap.containsKey(val)) {
//			int index = hashMap.get(val);
//			arr[index] = arr[lastIndex--];
//			hashMap.put(arr[index], index);
//			hashMap.remove(val);
//			return true;
//		}
//		return false;
//	}
//
//	/** Get a random element from the set. */
//	public int getRandom() {
//		int index = rd.nextInt(hashMap.size());
//		int rNum = arr[index];
//		return rNum;
//	}
//}