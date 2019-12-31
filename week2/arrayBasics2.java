public class arrayBasics2{
    public static void main(String[] args){
        int [][] pascalsTriangle = new int[4][];
        int[] rowZeros = pascalsTriangle[0];
        pascalsTriangle[0] = new int[]{1};
        pascalsTriangle[1] = new int[]{1,1};
        pascalsTriangle[2] = new int[]{1,2,1};
        pascalsTriangle[3] = new int[]{1,3,3,1};
        int[] rowTwo = pascalsTriangle[2];

    }
}