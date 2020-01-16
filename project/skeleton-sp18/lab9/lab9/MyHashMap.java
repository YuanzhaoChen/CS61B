package lab9;

import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Your name here
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 1;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private double loadFactor() {
        return (double) size / (double) buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return buckets[hash(key)].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        System.out.println("load factor is: "+loadFactor());
        if(loadFactor()>=MAX_LF){
            resizeBuckets(2*size);
            System.out.println("load factor after resizing: "+loadFactor());
        }
        int hc=hash(key);
        if(!buckets[hc].containsKey(key)){
            this.size+=1;
        }
        buckets[hc].put(key,value);

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }
    /*Resize buckets if the load factor exceeds MAX_LF*/
    private void resizeBuckets(int newSize){
        //Resizing buckets will also change existing hash code,
        //need to rearrange their position
        System.out.println("resizing buckets...");
        ArrayMap<K, V>[] newBuckets=new ArrayMap[newSize];
        ArrayMap<K,V> bigBucket=new ArrayMap<>();
        //store everything inside BigBucket, before moving forward
        for(int i=0;i<buckets.length;i+=1){
            Iterator<K> iter=buckets[i].keySet().iterator();
            while(iter.hasNext()){
                K tmpKey=iter.next();
                V tmpValue=buckets[i].get(tmpKey);
                bigBucket.put(tmpKey,tmpValue);
            }
        }
        //reconstruct this class,like a constructor
        this.buckets=newBuckets;
        clear();
        //since keys' hashcode changes after resizing, we have to rearrange them
        Iterator<K> iter=bigBucket.keySet().iterator();
        while(iter.hasNext()){
            K tmpKey=iter.next();
            V tmpValue=bigBucket.get(tmpKey);
            put(tmpKey,tmpValue);
        }
    }
    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
