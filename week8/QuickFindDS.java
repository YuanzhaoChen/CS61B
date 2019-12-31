public class QuickFindDS implements DisjointSets {
	private int[] id;

	public QuickFindDS(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i; // initially elements are disconnected
		}
	}

	@Override
	public void connect(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qid)
				id[i] = pid;
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		if (id[p] == id[q]) {
			System.out.println("is connected");
			return true;
		}
		System.out.println("not connected");
		return false;
	}
}