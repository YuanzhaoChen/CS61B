public class AList2<Item> {
    private Item[] item;
    private int size;
    public AList2() {
        item = (Item[]) new Object[100]; /* arbitrary initial size */
        size = 0;
    }
    public void addLast(Item x) {
        if (size == item.length) {
            Item[] newItem = (Item[]) new Object[size*2];
            //Item[] newItem = (Item[]) new Object[size*2];
            /*adding larger extra capicity reduces run time but consumes more memory*/
            System.arraycopy(item, 0, newItem, 0, item.length);
            item = newItem;
            item[size] = x;
            size++;
        } else {
            item[size] = x;
            size++;
        }
    }
    public Item getLast() {
        return item[size - 1];
    }
    public Item get(int x) {
        return item[x];
    }
    public int size() {
        return size;
    }
    public Item removeLast() {
        Item x = getLast();
        item[size-1] = null; //No loitering
        size--;
        return x;
    }
    public void printList() {
        int i = 0;
        while (i < size - 1) {
            System.out.print(item[i] + "->");
            i++;
        }
        System.out.println(item[i]);
    }
    public static void main(String[] args) {
        AList2<Integer> a = new AList2<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(10);
        a.printList();
        System.out.println("Last element: " + a.getLast());
        System.out.println("Remove last:" + a.removeLast());
        a.printList();
        for(int i = 0; i<1000000;i++){
        	a.addLast(i);
        }
    }
}