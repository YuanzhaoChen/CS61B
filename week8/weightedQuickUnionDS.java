public class weightedQuickUnionDS implements DisjointSets{
	int[]parent;
	int[]size;
	public weightedQuickUnionDS(int n){
		parent = new int[n];
		size = new int[n];
		for(int i=0;i<n;i++){
			parent[i] = i;
			size[i] = 1;
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
		int pBoss = find(p);
		int qBoss =  find(q);
		int pBossSize = size[pBoss];
		int qBossSize = size[qBoss];
		if(pBossSize>qBossSize){
			parent[qBoss] = pBoss;
			size[pBoss] += size[qBoss];
			size[qBoss] = 1;
		}else{
			parent[pBoss] = qBoss;
			size[qBoss] += size[pBoss];
			size[pBoss]  = 1;
		}
	}

}