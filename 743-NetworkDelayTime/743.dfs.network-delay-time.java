/*
 * [744] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (36.41%)
 * Total Accepted:    10.4K
 * Total Submissions: 28.5K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * 
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K.  How long will it take for all
 * nodes to receive the signal?  If it is impossible, return -1.
 * 
 * 
 * Note:
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1  and 1 .
 * 
 * 
 */
class Solution {
    private int[] dist;
    // using depth first search
    public int networkDelayTime(int[][] times, int N, int K) {
	Map<Integer, ArrayList<int[]>> graph = new HashMap<Integer, ArrayList<int[]>>();
	for(int[] link: times){
		if(!graph.containsKey(link[0]))
			graph.put(link[0], new ArrayList<int[]>());
		graph.get(link[0]).add(new int[]{link[1], link[2]});
	}

	// sort by travel times
	for(int key: graph.keySet())
		Collections.sort(graph.get(key), (linka, linkb)->linka[1] - linkb[1]);

	dist = new int[N];
	Arrays.fill(dist, Integer.MAX_VALUE);

	broadcast(graph, K, 0);
	int maxTime = 0;
	for(int temp: dist){
		if(temp == Integer.MAX_VALUE) return -1;
		maxTime = Math.max(maxTime, temp);
	}
	return maxTime;
    }

    private void broadcast(Map<Integer, ArrayList<int[]>> graph, int node, int elapsed){
	if(elapsed >= dist[node - 1]) return;
	dist[node - 1] = elapsed;
	if(graph.containsKey(node)){
		for(int[] link: graph.get(node)){
			broadcast(graph, link[0], link[1] + elapsed);
		}
	}
    }
}
