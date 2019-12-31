public class Doglauncher{
    public static void main(String[] args){
        Dog d1 = new Dog(10);
        Dog d2 = new Dog(20);
        d1.makeNoise();
        d2.makeNoise();
        Dog bigger = Dog.maxdog(d1,d2);
        //Dog bigger = d1.maxdog(d2);
        bigger.makeNoise();
        System.out.println(Dog.binomen);
    }

}