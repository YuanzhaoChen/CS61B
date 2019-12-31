public class testDS{
	public static void main(String[] args){
		DisjointSets a = new weightedQuickUnionDS(6);

		a.connect(0,1);
	
		a.connect(1,2);
	
		a.connect(3,4);
		
		a.connect(1,3);

		if(a.isConnected(0,1)&&a.isConnected(0,2)&&a.isConnected(0,4)&&!a.isConnected(0,5)){
			System.out.println("Test pass!");
		}else{
			System.out.println("Not Passed!");
		}
	}
}