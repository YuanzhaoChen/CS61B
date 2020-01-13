package hw2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;
import java.time.LocalTime;
public class PercolationStats {
    private Percolation[] percolations;
    private double mean;
    private double stddev;
    private int N;
    private int T;
    /** perform T independent experiments on an N-by-N grid*/
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N<=0||T<=0){
            throw new IllegalArgumentException("Both N and T should be greater than 0");
        }
        this.N=N;
        this.T=T;
        percolations=new Percolation[T];
        for(int t=0;t<T;t+=1){
            percolations[t]=pf.make(N);
        }
        simulation();
    }
    /** sample mean of percolation threshold*/
    public double mean(){
        return mean;
    }
    /** sample standard deviation of percolation threshold*/
    public double stddev(){
        return stddev;
    }
    /** low endpoint of 95% confidence interval*/
    public double confidenceLow(){
        return mean-1.96*stddev/Math.sqrt(T);
    }
    /** high endpoint of 95%*/
    public double confidenceHigh(){
        return mean+1.96*stddev/Math.sqrt(T);
    }
    /** Repeat experiment T times */
    public void simulation(){
        double[] x=new double[T];
        for(int t=0;t<T;t+=1){
            x[t]=simulateOnce(percolations[t]);
        }
        int sum=0;
        for(int t=0;t<T;t+=1){
            sum+=x[t];
        }
        mean=(double)sum/(double)T;
        stddev=0.0;
        for (int t=0;t<T;t+=1){
            stddev+=Math.pow(x[t]-mean,2);
        }
        stddev/=(double)(T-1);
    }

    public double simulateOnce(Percolation per){
        while(!per.percolates()){
            int row= StdRandom.uniform(0,N);
            int col= StdRandom.uniform(0,N);
            per.open(row,col);
        }
        double x=(double)per.numberOfOpenSites()/(double)(N*N);
        return x;
    }
}
