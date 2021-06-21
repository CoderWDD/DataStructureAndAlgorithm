package DataStructureAndAlgorithm.LeetCode.UnionFind;
//原题链接：https://leetcode-cn.com/problems/redundant-connection/solution/shi-jian-9462bing-cha-ji-javadai-ma-by-r-ev32/
public class RedundantConnection {
    //为了方便直接根据题目的数据范围，申请出最大空间
    int[] p = new int[1000 * 2];
    //找父节点并进行路径压缩
    int find(int x){
        while(x != p[x]){
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++){
            for (int j = 0; j < edges[0].length; j++){
                //把每个点的父节点设置为自己
                p[edges[i][j]] = edges[i][j];
            }
        }
        int pa,pb;
        for (int i = 0; i < edges.length; i++){
            pa = find(edges[i][0]);
            pb = find(edges[i][1]);
            //把pb的父节点设置为pa
            if (pa == pb){
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
            p[pb] = pa;
        }
        return res;
    }
}
