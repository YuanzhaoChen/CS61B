public class binarySearch {
	public static int binSearch(String[] sorts, String x, int lo, int hi){
		if(lo>hi) return -1;
		int m = (lo+hi)/2;
		int cmp = x.compareTo(sorts[m]);
		if(cmp<0) return binSearch(sorts,x,lo,m-1);
		else if(cmp>0) return binSearch(sorts,x,m+1,hi);
		else return m;

	}
	public static void main(String[] args){
		String[] sorts = {"an","apple","banana","hello","see ya","zZZ"};
		String x = "hello"; 
		System.out.println(binSearch(sorts,x,0,sorts.length));

	}
}