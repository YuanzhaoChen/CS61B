public class LinkedListDeque<T> {
    /**helper function of LinkedListDequeue*/
    public class TNode<T>{
        public T item;
        public TNode<T> next;
        public TNode(T i, TNode n){
            item = i;
            next = n;
        }
    }
    private TNode sentinel;
    private int size;
    /**constructor for non-empty list*/
    public LinkedListDeque(T item){
        sentinel = new TNode(0,null);
        sentinel.next = new TNode(item,null);
        size = 1;
    }
    /**constructor for empty list*/
    public LinkedListDeque(){
        sentinel = new TNode(0,null);
        sentinel.next = null;
        size = 0;
    }
    /**Adds an item of type T to the front of the deque.*/
    public void addFirst(T item){
        sentinel.next = new TNode(item,sentinel.next);
        size++;
    }
    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        TNode last;
        last = sentinel.next;
        while(last.next != null){
            last = last.next;
        }
        last.next = new TNode(item,null);
        size++;
    }
    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if(sentinel.next == null){
            return true;
        }
        return false;
    }
    /**Returns the number of items in the deque.*/
    public int size(){
        return size;
    }
    public void printDeque(){
        TNode p = sentinel.next;
        while(p.next!=null){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println(p.item);

    }
    public T removeFirst(){
        T result;
        result = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return result;
    }
    public T removeLast(){
        TNode p = sentinel.next;
        T result;
        while(p.next != null){
            p = p.next;
        }
        result = (T) p.item;
        size--;
        return result;
    }
    public T get(int index){
        TNode p = sentinel.next;
        T result = null;
        for(int i=0; i<index; i++){
            if(i==index){
                result = (T) p.item;
                break;
            }
            p = p.next;
        }
        return result;
    }
}
