public class intSort implements thingsToBeSort<item>{
	@Override
	public void selectionSort(int[] x){
		for(int i = 0;i<x.length;i++){
			swapArray(x,i,findMin(i,x));
		}

	}
	/**return the position of the smallest element in the array from startPos*/
	private static int findMin(int startPos,int[] x){
		int result = startPos;
		for(int i= startPos;i<x.length;i++){
			if(x[i]<x[result]){
				result = i;
			}
		}
		return result;
	}	
	private static void swapArray(int[] x,int s1,int s2){
		assert(s1<x.length && s2<x.length);
		int tmp = x[s1];
		x[s1] = x[s2];
		x[s2] = tmp; 
	}
	public static void printArray(int[] x){
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
}