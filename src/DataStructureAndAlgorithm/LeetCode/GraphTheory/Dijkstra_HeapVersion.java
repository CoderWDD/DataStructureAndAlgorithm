package DataStructureAndAlgorithm.LeetCode.GraphTheory;
import java.util.*;
//原题链接：https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/
//备注：代码为超时代码，但具体思路没错。可以作为堆优化版本的迪杰斯特拉模板参考
public class Dijkstra_HeapVersion {
    class node{
        int a;//起点
        int b;//终点
        int w;//权重
        node (int a,int b,int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    final int Max_Value = 5000010;//表示无穷大
    final int len = 20010;
    List<node>[] list;
    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dist = new int[n + 1];//用dist[i]表示第i个结点到最后一个结点的距离
        boolean[] st = new boolean[n + 1];
        list = new ArrayList[n + 1];
        int j;
        for (int i = 0; i <= n; i++)list[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++){
            //无向图，建两条边
            j = edges[i][0];
            list[j].add(new node(edges[i][0],edges[i][1],edges[i][2]));//将每个相邻的点添加到链表中
            j = edges[i][1];
            list[j].add(new node(edges[i][1],edges[i][0],edges[i][2]));//将每个相邻的点添加到链表中
        }
        Dijkstra_HeapVersion(n,dist,st);
        int res = getPath(n,dist);
        return res;
    }
    int getPath(int n,int[] dist){

        Queue<List<node>> queue = new LinkedList<>();
        queue.offer(list[1]);
        int res = 0;
        //宽搜出所有的点---->超时
        while(!queue.isEmpty()){
            List<node> temp = queue.poll();
            node first = temp.get(0);
            for (node e: temp){
                if (dist[first.a] > dist[e.b]){
                    if (e.b == n){
                        res++;
                        continue;
                    }
                    queue.offer(list[e.b]);
                }
            }
        }
        return res;
    }

    void Dijkstra_HeapVersion(int n,int[] dist,boolean[] st){
        Arrays.fill(dist,Max_Value);
        dist[n] = 0;//dist[n]到自己的距离为0
        PriorityQueue<node> PQueue = new PriorityQueue<>(
                new Comparator<node>(){
                    public int compare(node a,node b){
                        return a.w - b.w;
                    }
                }
        );//优先队列
        PQueue.offer(new node(n,n,0));
        while(!PQueue.isEmpty()){
            node a = PQueue.poll();
            int t = a.b , distance = a.w;
            if (st[t] == true)continue;//结点已经被更新过，则直接进入下一个结点的循环
            st[t] = true;//如果结点还未被访问，则将状态设置为已经被访问
            for (node e : list[t]){
                if (dist[e.b] > distance + e.w){
                    dist[e.b] = distance + e.w;//更新点到终点的距离
                    PQueue.offer(new node(e.a,e.b,dist[e.b]));
                }
            }
        }
    }
}
