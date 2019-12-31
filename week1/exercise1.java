public class exercise1{
    public static void drawTriangle(int N){
        for (int i=1;i<N+1;i++){
            for(int j=N-i;j>0;j--){
                System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args){
        drawTriangle(5);
    }
}