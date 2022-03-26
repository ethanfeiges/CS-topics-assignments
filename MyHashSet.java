
// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
import java.util.*;
public class MyHashSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    
    // Constructs an empty set.
    // Time: O(1)
    // Space O(1)
    public MyHashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Adds the given element to this set
    // Time: O(num of collisions) (Worst case)
    // Space: O(1)
    public void add(int value) {
      if(contains(value)){
        return;
      }
    	int h = hashFunction(value);
      if(elementData[h] == null){
        elementData[h] = new HashEntry(value, null);
        size++;
        return;
      }
      HashEntry cur = elementData[h];
      while(cur.next != null){
        cur = cur.next;
      }
      cur.next = new HashEntry(value, null);
      size++;
      
      if(loadFactor() >= .75){
        rehash();
      }
      }
     
    
    // Removes all elements from the set.
    // Time: O(1)
    // Space: O(elementData.length)
    public void clear() {
    	elementData = new HashEntry[elementData.length];
      size = 0;
    }
    
    // Returns true if the given value is found in this set.
    // Time: O(num of collisions)
    // Space: O(1)
    public boolean contains(int value) {
      
    	int h = hashFunction(value);
      HashEntry current = elementData[h];
      while(current != null){
        if(current.data == value){
          return true;
        }
        current = current.next;
      }
      return false;
    }
    
    // Returns true if there are no elements in this queue.
    // Time: O(1)
    // Space: O(1)
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    // Time: O(num of collisions)
    // Space: O(1)
    public void remove(int value) {
    	int h = hashFunction(value);
      if(elementData[h] != null && elementData[h].data == value){
        elementData[h] = elementData[h].next;
        size--;
      }
      else{
        HashEntry cur = elementData[h];
        while(cur != null && cur.next != null){
          if(cur.next.data == value){
            cur.next = cur.next.next;
            size--;
            return;
          }
          cur = cur.next;
        }
      }
     

      
    }
    
    // Returns the number of elements in the queue.
    // Time: O(1)
    // Space: O(1)
    public int size() {
    	return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    // Time: O(N)
    // Space: O(N)
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    // Time: O(1)
    // Space O(1)
    private int hashFunction(int value) {
    	
    	return (Math.abs(value)) % elementData.length;
    }
  
    // Time: O(1)
    // Space: O(1)
    private double loadFactor() {
    	
    	return (double)size/elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    // Time: O(N)
    // Space: O(element.length * 2);
    private void rehash() {
    	HashEntry[] old = elementData;
      int oldSize = this.size;
      elementData = new HashEntry[2*old.length];
      for(HashEntry entry: old){
        HashEntry cur = entry;
        while(cur != null){
          add(cur.data);
          cur = cur.next;
        }
        
      }
      this.size = oldSize;
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }
}
