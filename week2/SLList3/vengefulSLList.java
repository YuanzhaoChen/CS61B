/**New class extends from exsiting class SLList3 */
public class vengefulSLList<Item> extends SLList3<Item>{
	public static void main(String[] args){
		SLList3<Character> L = new vengefulSLList<>();
        L.addFirst('a');
        L.addFirst('c');
        L.addLast('e');
        System.out.println("New list head:" + L.getFirst());
        System.out.println("Print entire list:");
        L.printList();
        System.out.println("Size of List:" + L.size());
	}

}