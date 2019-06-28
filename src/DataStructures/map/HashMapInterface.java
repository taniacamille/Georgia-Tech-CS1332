package DataStructures.map;

import java.util.Set;
import java.util.List;

/**
 * Interface for a DataStructures.map.HashMap.
 * DO NOT EDIT THIS FILE!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public interface HashMapInterface<K, V> {
    int INITIAL_CAPACITY = 13;
    double MAX_LOAD_FACTOR = 0.67;

    /**
     * Adds the given key-value pair to the DataStructures.map.HashMap.
     * If an entry in the DataStructures.map.HashMap already has this key, replace the entry's
     * value with the new one passed in.
     *
     * In the case of a collision, use external chaining as your resolution
     * strategy. Add new entries to the front of an existing chain, but don't
     * forget to check the entire chain for duplicates first.
     *
     * Check to see if the backing array needs to be regrown BEFORE adding. For
     * example, if my DataStructures.map.HashMap has an array of length 5, with 3 elements in
     * it, I should regrow at the start of the next add operation since
     * (3 + 1) / 5 = 0.8 > 0.67 (even if it is a key that is already in the
     * hash DataStructures.map). This means you must account for the data pending insertion
     * when calculating the load factor.
     *
     * When regrowing, resize the length of the backing table to
     * 2 * old length + 1. You must use the resizeBackingTable method to do so.
     *
     * Return null if the key was not already in the DataStructures.map. If it was in the DataStructures.map,
     * return the old value associated with it.
     *
     * @param key key to add into the DataStructures.map.HashMap
     * @param value value to add into the DataStructures.map.HashMap
     * @throws IllegalArgumentException if key or value is null
     * @return null if the key was not already in the DataStructures.map.  If it was in the
     * DataStructures.map, return the old value associated with it
     */
    V put(K key, V value);

    /**
     * Removes the entry with a matching key from the DataStructures.map.HashMap.
     *
     * @param key the key to remove
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key does not exist
     * @return the value previously associated with the key
     */
    V remove(K key);

    /**
     * Gets the value associated with the given key.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key is not in the DataStructures.map
     * @return the value associated with the given key
     */
    V get(K key);

    /**
     * Returns whether or not the key is in the DataStructures.map.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @return whether or not the key is in the DataStructures.map
     */
    boolean containsKey(K key);

    /**
     * Clears the table and resets it to the default length.
     */
    void clear();

    /**
     * Returns the number of elements in the DataStructures.map.
     *
     * @return number of elements in the DataStructures.map.HashMap
     */
    int size();

    /**
     * Returns a Set view of the keys contained in this DataStructures.map.
     * Use {@code java.util.HashSet}.
     *
     * @return set of keys in this DataStructures.map
     */
    Set<K> keySet();

    /**
     * Returns a List view of the values contained in this DataStructures.map.
     * Use any class that implements the List interface
     * This includes {@code java.util.ArrayList} and
     * {@code java.util.LinkedList}.
     *
     * You should iterate over the table in order of increasing index, and
     * iterate over each chain from front to back. Add entries to the List in
     * the order in which they are traversed.
     *
     * @return list of values in this DataStructures.map
     */
    List<V> values();

    /**
     * Resize the backing table to {@code length}.
     *
     * Disregard the load factor for this method. So, if the passed in length is
     * smaller than the current capacity, and this new length cause the table's
     * load factor to exceed MAX_LOAD_FACTOR, you should still resize the table
     * to the specified length and leave it at that capacity.
     *
     * You should iterate over the old table in order of increasing index, and
     * iterate over each chain from front to back. Add entries to the new table
     * in the order in which they are traversed.
     *
     * Remember that you cannot just simply copy the entries over to the new
     * array.
     *
     * Also, since resizing the backing table is working with the non-duplicate
     * data already in the table, you shouldn't explicitly check for
     * duplicates.
     *
     * @param length new length of the backing table
     * @throws IllegalArgumentException if length is non-positive or less than
     * the number of items in the hash DataStructures.map.
     */
    void resizeBackingTable(int length);

    /**
     * DO NOT USE THIS METHOD IN YOUR CODE. IT IS FOR TESTING ONLY.
     *
     * @return the backing array of the data structure, not a copy.  INCLUDE
     * EMPTY SPACES
     */
    MapEntry<K, V>[] getTable();
}
