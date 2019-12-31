/**This list can not only store int values but also some other types*/
public class SLList3<LochNess>{ /*LochNess here is a place holder */
    private class StufNode{
        public LochNess item;
        public StufNode next;
        public StufNode(LochNess i, StufNode n){
            item = i;
            next = n;
        }
    }
    private StufNode first;
    private int size; /*keep size updated*/
    /**SLList constructor non emptylist*/ 
    public SLList3(LochNess x){
        first = new StufNode(x,null);
        size = 1;
    } 
    /**SLList constructor for empty list */
    public SLList3(){
        first = null;
        size = 0;
    }
    /**Add x to the front of the list */
    public void addFirst(LochNess  x){
        first =  new StufNode(x,first);
        size++;
    }
    /**Add x to the last of the list */
    public void addLast(LochNess x){
        StufNode last;
        last = first;
        while(last.next!=null){
            last = last.next;
        }
        last.next = new StufNode(x,null);
        size++;
    }
    /**Size of the list */
    public int size(){
        return size;
    }
    /**Helper function of printList( ) */
    private void printIntNode(StufNode x){
        if(x.next == null){
            System.out.println(x.item);
        }else{
            System.out.print(x.item + " -> ");
            printIntNode(x.next);
        }
    }
    /**Print entire list */
    public void printList(){
        printIntNode(first);
    }
    /**Return the first item in the list */
    public LochNess getFirst(){
        return first.item;
    }
    public static void main(String[] args){
        /*When declaring or instantiating data structures, use the reference type:
        int: Integer
        char: Character
        bool: Boolean
        long: Long */
        SLList3<Character> L = new SLList3<>();
        L.addFirst('a');
        L.addFirst('c');
        L.addLast('e');
        System.out.println("New list head:" + L.getFirst());
        System.out.println("Print entire list:");
        L.printList();
        System.out.println("Size of List:" + L.size());
    }
}
