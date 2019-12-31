import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;

public class ArrayMap<K,V> {
    private K keys[];
    private V values[];
    int size;
    public ArrayMap(){
        keys = (K[]) new Object[20];
        values =  (V[]) new Object[20];
        size = 0;
    }
    /**Return the index of the key if it exists */
    private int KeyIndex(K key){
        for(int i=0;i<size;i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    public boolean containsKey(K key){
        int index = KeyIndex(key);
        return index>-1;
    }
    public void put(K key,V value){
        int index = KeyIndex(key);
        if(index == -1){
            keys[size] = key;
            values[size] = value;
            size++;
        }else{
            values[index] = value;
        }
    }
    public V get(K key){
        int index = KeyIndex(key);
        return values[index];
    }
    public int size(){
         return size;
    }
    /**returns a list of keys in this map */
    public List<K> keys(){
        List<K> keyList = new ArrayList<>();
        for(int i=0;i<size;i++){
            keyList.add(keys[i]);
        }
        return keyList;
    }
    public static boolean isSorted(List<Integer> l){
        for(int i=1;i<l.size();i++){
            if(l.get(i-1)>l.get(i)){
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args){
        ArrayMap<String,Integer> a = new ArrayMap<>();
        a.put("horse",100);
        a.put("cat",50);
        a.put("dog",60);
        a.put("dog",10);
        List<String> aList = a.keys();
        List<Integer> t = new ArrayList<>();
        for(int i=0;i<10;i++){
            t.add(i);
        }
        t.add(0);
        System.out.println("sorted?"+isSorted(t));
        System.out.println("size of list: "+aList.size());
    }
}
