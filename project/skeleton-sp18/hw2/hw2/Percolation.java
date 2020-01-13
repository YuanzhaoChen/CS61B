package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] sites;
    private WeightedQuickUnionUF set;
    private int openNum;
    private int N;
    /** Create N-by-N grid, with all sites initially blocked*/
    public Percolation(int N){
        this.N=N;
        if(N<=0){
            throw new IllegalArgumentException("N should be greater than 0");
        }
        sites=new  int[N][N];
        openNum=0;
        set=new WeightedQuickUnionUF(N*N);
        for(int i=0;i<N;i+=1){
            for(int j=0;j<N;j+=1){
                sites[i][j]=0;
            }
        }
    }
    /** Open the site (row, col) if it is not open already*/
    public void open(int row, int col){
        validRangeCheck(row,col);
        if(sites[row][col]==1){ //if it's already open then there's no need to open it again
            return;
        }
        sites[row][col]=1;
        openNum+=1;
        System.out.println("Open ["+row+","+col+"]");
        if(row-1>=0&&sites[row-1][col]==1){
            set.union(col+N*(row-1),col+row*N);
            System.out.println("connect ["+row+","+col+"] and "+"["+(row-1)+","+col+"]");
        }
        if(row+1<N&&sites[row+1][col]==1){
            set.union(col+N*(row+1),col+row*N);
            System.out.println("connect ["+row+","+col+"] and "+"["+(row+1)+","+col+"]");
        }
        if(col-1>=0&&sites[row][col-1]==1){
            set.union(col-1+N*row,col+row*N);
            System.out.println("connect ["+row+","+col+"] and "+"["+row+","+(col-1)+"]");
        }
        if(col+1<N&&sites[row][col+1]==1){
            set.union(col+1+N*row,col+row*N);
            System.out.println("connect ["+row+","+col+"] and "+"["+row+","+(col+1)+"]");
        }
    }
    /** Is the site (row, col) open?*/
    public boolean isOpen(int row, int col){
        validRangeCheck(row,col);
        return sites[row][col]==1;
    }
    /** Is the site (row, col) full?*/
    public boolean isFull(int row, int col){
        validRangeCheck(row,col);
        for(int i=0;i<N;i+=1){
            if(sites[0][i]==1&&sites[row][col]==1&&set.connected(i,col+row*N)){
                return true;
            }
        }
        return false;
    }
    /** Number of open sites*/
    public int numberOfOpenSites(){
        return openNum;
    }
    /* Does the system percolate?*/
    public boolean percolates(){
        for(int i=0;i<N;i+=1){
            if(isFull(N-1,i)){//System percolates if there is a full site in the bottom row.
                return true;
            }
        }
        return false;
    }
    /* Check whether row and column indices are integers between 0 and N−1*/
    private void validRangeCheck(int row,int col){
        if(row<0||row>=sites.length||col<0||col>=sites[0].length){
            throw new IndexOutOfBoundsException("Row and column indices are integers between 0 and N−1");
        }
    }

    public static void main(String[] args){

    }
}
