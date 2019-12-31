import java.util.Arrays;
public class exercise4{
    public static void windowPosSum(int[] a, int n){
        int alen = a.length;
        for (int i=0;i<alen;i++){
            if(a[i]<0){ 
                //only if a[i] is positive valued
                continue;
            }
            for (int j=i+1;j<alen && j<i+n+1;j++){
                a[i] += a[j];
            }
        }
    }
    public static void main(String[] args){
        int[] numbers = new int[]{1, 2, -3, 4, 5, 4};
        int[] numbers2 = new int[]{1, -1, -1, 10, 5, -1};
        System.out.println("Input:" + Arrays.toString(numbers));
        windowPosSum(numbers, 3);
        System.out.println("Output:" + Arrays.toString(numbers)); 
        System.out.println("Input:" + Arrays.toString(numbers2));
        windowPosSum(numbers2, 2);
        System.out.println("Output:" + Arrays.toString(numbers2));

    }
}