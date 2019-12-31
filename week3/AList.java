public class AList {
    private int[] item;
    private int size;
    public AList() {
        item = new int[100]; /* arbitrary initial size */
        size = 0;
    }
    public void addLast(int x) {
        if (size == item.length) {
            /*adding larger extra capicity reduces run time but consumes more memory*/
            int[] newItem = new int[size*2];
            System.arraycopy(item, 0, newItem, 0, item.length);
            item = newItem;
            item[size] = x;
            size++;
        } else {
            item[size] = x;
            size++;
        }
    }
    public int getLast() {
        return item[size - 1];
    }
    public int get(int x) {
        return item[x];
    }
    public int size() {
        return size;
    }
    public int removeLast() {
        size--;
        return item[size];
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
        AList a = new AList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.printList();
        System.out.println("Last element: " + a.getLast());
        System.out.println("Remove last:" + a.removeLast());
        a.printList();
    }
}