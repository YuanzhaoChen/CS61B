public class argsum{
    public static void main(String[] args){
        int N = args.length;
        int sum = 0;
        System.out.println("Number of arguments: "+N);
        for (int i=0;i<N;i++){
            sum += Integer.parseInt(args[i]);
        }
        System.out.println("Sum of integer: "+sum);
    }
}