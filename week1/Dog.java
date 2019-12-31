public class Dog {
    public int weightInPounds; // instance variable
    public static String binomen = "Canis familiaris";

    /** one integer constructor for dog */
    public Dog(int w) {
        weightInPounds = w;
    }

    public void makeNoise() { // non-static method
        if (weightInPounds < 5) {
            System.out.println("yip");
        } else if (weightInPounds < 10) {
            System.out.println("arooo");
        } else {
            System.out.println("Woooo");
        }
    }

    public static Dog maxdog(Dog d1, Dog d2) { // static function
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        } else {
            return d2;
        }
    }

    public Dog maxdog(Dog d2) {
        if (this.weightInPounds > d2.weightInPounds) {
            return this;
        } else {
            return d2;
        }
    }

}