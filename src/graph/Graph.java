package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {//无向图

    private int vertexCnt;//顶点个数
    private LinkedList<Integer> adjacencyList[]; //邻接表

    public Graph(int vertexCnt) {
        this.vertexCnt = vertexCnt;
        adjacencyList = new LinkedList[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }

    /**
     * 广度优先搜索
     * 只能找出一条最短径，而不是全部
     */
    public void breadthFirstSearch(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[vertexCnt];//存储是否被遍历过
        visited[s] = true;//起点已经被遍历过
        Queue<Integer> queue = new LinkedList<>();//存储已经被遍历，但相邻的顶点还没有被访遍历的顶点。
        queue.add(s);//起点的相信点还没有被遍历，先保存起来
        int pre[] = new int[vertexCnt];//存在搜索路径，即遍布当前顶点的前驱节顶点，初始值为-1
        for (int i = 0; i < vertexCnt; i++) {
            pre[i] = -1;
        }
        while (queue.size() != 0) {
            int vertex = queue.poll();//取出已遍布但相邻顶点未遍历的
            for (int i = 0; i < adjacencyList[vertex].size(); i++) {//遍布相邻顶点的列表
                int subVertex = adjacencyList[vertex].get(i);
                if (!visited[subVertex]) {//没有被遍历过
                    pre[subVertex] = vertex;
                    if (subVertex == t) {//找到最终结果了
                        print(pre, s, t);
                        for (int j = 0; j < pre.length; j++) {
                            System.out.printf(pre[j]+",");
                        }
                        return;
                    }
                    visited[subVertex] = true;
                    queue.add(subVertex);
                }
            }
        }
    }

    boolean found = false;//全局标志，表示是否找到最终的点
    /**
     * 深度优先搜索
     * 只能找出一条可达路径，而不是全部、最短
     */
    public void depthFirstSearch(int s, int t) {
        found = false;
        boolean[] visited = new boolean[vertexCnt];
        int[] pre = new int[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            pre[i] = -1;
        }
        recurDfs(s,t,visited,pre);
        print(pre, s, t);
    }

    private void recurDfs(int vertex, int t, boolean[] visited, int[] pre) {
        if (found) return;
        visited[vertex] = true;
        if (vertex == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adjacencyList[vertex].size(); i++) {
            int subVertex = adjacencyList[vertex].get(i);
            if (!visited[subVertex]) {
                pre[subVertex] = vertex;
                recurDfs(subVertex, t, visited, pre);
            }
        }
    }

    public void print(int[] pre, int s, int t) {//递归打印s->的路径
        if (pre[t] != -1 && t != s) {
            print(pre, s, pre[t]);
        }
        System.out.print(t + "->");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

//        graph.breadthFirstSearch(0,6);

        graph.depthFirstSearch(0,6);

        //？？？？？如何打印出所有的路径
    }

}
