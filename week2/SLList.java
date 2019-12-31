public class SLList{
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    public IntNode first; 
    public int size; /*keep size updated*/
    /**SLList constructor non emptylist*/ 
    public SLList(int x){
        first = new IntNode(x,null);
        size = 1;
    }
    /**SLList constructor for empty list */
    public SLList(){
        first = null;
        size = 0;
    }
    /**add x to the front of the list */
    public void addFirst(int  x){
        first =  new IntNode(x,first);
        size++;
    }
    /**add x to the last of the list */
    public void addLast(int x){
        IntNode last;
        last = first;
        while(last.next!=null){
            last = last.next;
        }
        last.next = new IntNode(x,null);
        size++;
    }
    /**size of the list */
    public int size(){
        return size;
    }
    /**helper function of printList( ) */
    private static void printIntNode(IntNode x){
        if(x.next == null){
            System.out.println(x.item);
        }else{
            System.out.print(x.item + " -> ");
            printIntNode(x.next);
        }
    }
    /**print entire list */
    public void printList(){
        printIntNode(first);
    }
    /**return the first item in the list */
    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args){
        SLList L = new SLList();
        L.addFirst(11);
        L.addFirst(12);
        L.addLast(1);
        System.out.println("New list head:" + L.getFirst());
        System.out.println("Print entire list:");
        L.printList();
        System.out.println("Size of List:" + L.size());
    }
}
