public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f,IntList r){
        first = f;
        rest = r;
    }
    public int size(){
        int size = 0;
        IntList l = this; 
        while(l != null){
            l = l.rest;
            size++;
        }
        return size;
    }
    public static void main(String[] args){
        IntList l = new IntList(100,null);
        l = new IntList(101,l);
        l = new IntList(102,l);
        System.out.println("size of Intlist: " + l.size( ));
    }
}