package DataStructureAndAlgorithm.Acwing.DP;

import java.util.*;
/*

    解题思路，先对所有的起点进行排序，然后由于所有的桥之间不能有交点，
因此，所有合法的方案中，从起点到终点的连线中不会有交点，又由于起点具有单调性，因此，
此时只需要保证终点也具有单调性，就不会有交点了，因此，可以转换为求解终点的最长单调子序列的长度问题
    注解：由于所有的边都是题目给定的，所以所有合法解的起点和终点的单调性都是一致的


最长上升子序列的状态定义：
    dp[i]：表示所有以nums[i]结尾的子序列中最长的上升子序列（即子问题是规模变小了的总问题，这也是可以用动态规划的前提）
    当nums[i] > nums[j] ：dp[i] = Math.max(dp[i],dp[j] + 1);
    否则：dp[i] = 1；
*/
class dp_1012{
    //自定义类型，方便排序
    public static class Edge implements Comparable<Edge>{
        int start;
        int end;
        Edge(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Edge temp){
            return this.start - temp.start;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start,end;
        Edge[] edge = new Edge[n + 1];
        int[] dp =new int[n + 1];
        //初始化第一个结点，防止sort时候报null异常
        //由于最长子序列是从下标为1的地方开始算的，所以对结果不会有影响
        edge[0] = new Edge(-1,-1);
        for (int i = 1; i <= n; i++){
            start = in.nextInt();
            end = in.nextInt();
            edge[i] = new Edge(start,end);
        }
        Arrays.sort(edge);
        dp[0] = 1;
        //最长上升子序列的求解模板
        int res = 0;
        for (int i = 1; i <= n; i++){
            dp[i] = 1;
            for (int j = 1; j < i; j++){
                if (edge[i].end > edge[j].end){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        System.out.print(res);
    }
}