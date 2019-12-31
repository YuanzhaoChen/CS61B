public class ArrayDeque<T> {
    private T[] item;
    private int size;
    private double usageRatio;

    public ArrayDeque(T x){
        item = (T[]) new Object[8];
        item[0] = x;
        size = 1;
    }

    public ArrayDeque(){
        item = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T x){
        if(size == item.length){
            System.out.println("size is: "+size+" length is: "+item.length+" create more space to addfirst");
            T[] newItem = (T[]) new Object[size*2];
            System.arraycopy(item,0,newItem,1,item.length);
            newItem[0] = x;
            item = newItem;
            size++;
        }else {
            System.out.println("size is: "+size+" length is: "+item.length+" addfirst is save");
            T[] newItem = (T[]) new Object[item.length];
            System.arraycopy(item, 0, newItem, 1, size);
            newItem[0] = x;
            item = newItem;
            size++;
        }
        usageRatio = (double)size/item.length;
        System.out.println("Usage ratio is:"+usageRatio);
    }

    public void addLast(T x){
        if(size == item.length){
            System.out.println("size is: "+size+" length is: "+item.length+" create more space to addlast");
            T[] newItem = (T[])new Object[size*2];
            System.arraycopy(item,0,newItem,0,size);
            item = newItem;
        }else {
            System.out.println("size is: "+size+" length is: "+item.length+" addlast is save");
        }
        item[size] = x;
        size++;
        usageRatio = (double)size/item.length;
        System.out.println("Usage ratio is:"+usageRatio);
    }

    public boolean isEmpty(){
        if(size == 0){
            return false;
        }
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        System.out.println("Printing arraydeque.");
        for(int i=0;i<size;i++){
            System.out.print(item[i]+" ");
        }
        System.out.println();
    }

    public T removeFirst(){
        if(usageRatio<0.25){ //resize array as too many spaces are unused
            T[] newItem = (T[]) new Object[(int)(item.length/2)];
            System.arraycopy(item,0,newItem,0,size);
            item = newItem;
        }
        T result = item[0];
        T[] newItem =(T[]) new Object[item.length];
        System.arraycopy(item,1,newItem,0,size-1);
        item = newItem;
        size--;
        System.out.println("size is: "+size+" length is: "+item.length+" perform removeFirst");
        usageRatio = (double)size/item.length;
        return result;
    }

    public T removeLast(){
        if(usageRatio<0.25){ //resize array as too many spaces are unused
            T[] newItem = (T[]) new Object[(int)(item.length/2)];
            System.arraycopy(item,0,newItem,0,size);
            item = newItem;
        }
        T result = item[size-1];
        item[size-1] = null; //avoid loitering
        size--;
        System.out.println("size is: "+size+" length is: "+item.length+" perform removeLast");
        usageRatio = (double)size/item.length;
        return result;
    }
    public T get(int index){
        return item[index];
    }
}
