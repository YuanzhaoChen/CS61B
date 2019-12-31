public class QuickUnionDS implements DisjointSets{
	int[] parent;
	public QuickUnionDS(int n){
		parent = new int[n];
		for(int i=0;i<n;i++){
			parent[i] = i;
		}
	}
	private int find(int p){ //find the boss of the set
		while(p!=parent[p]){
			p=parent[p];
		}
		return p;
	}
	@Override
	public boolean isConnected(int p, int q){
		if(find(p)==find(q)){
			System.out.println("is connected");
			return true;
		}
		System.out.println("not connected");
		return false;

	}
	@Override
	public void connect(int p, int q){
		parent[find(p)] = find(q);
	}

}