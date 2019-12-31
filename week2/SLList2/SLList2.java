/**Introduing SENTINEL NODE, so we can call addLast() 
 * immediately after an empty list is called.
 * 
 * Sentinel node is a special extra node that always 
 * sits at the very front of the list
 * to prevent the list from being null*/
public class SLList2{
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode sentienl;
    private int size; /*keep size updated*/
    /**SLList constructor non-empty list*/ 
    public SLList2(int x){
        sentienl = new IntNode(0,null); /*the value in sentinel can be anything*/
        sentienl.next = new IntNode(x,null);
        size = 1;
    }
    /**SLList constructor for empty list */
    public SLList2(){
        sentienl = new IntNode(0,null);
        size = 0;
    }
    /**add x to the front of the list */
    public void addFirst(int  x){
        sentienl.next =  new IntNode(x,sentienl.next);
        size++;
    }
    /**add x to the last of the list */
    public void addLast(int x){
        IntNode last;
        last = sentienl;
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
        /*we don't want to print value in sentinel node*/
        printIntNode(sentienl.next); 
    }
    /**return the first item in the list */
    public int getFirst(){
        return sentienl.next.item;
    }
    public static void main(String[] args){
        SLList2 L = new SLList2();
        //L.addFirst(11);
        //L.addFirst(12);
        L.addLast(1);
        System.out.println("New list head:" + L.getFirst());
        System.out.println("Print entire list:");
        L.printList();
        System.out.println("Size of List:" + L.size());
    }
}