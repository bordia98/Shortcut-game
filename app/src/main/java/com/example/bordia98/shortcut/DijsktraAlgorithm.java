package com.example.bordia98.shortcut;

/**
 * Created by bordia98 on 7/11/17.
 */

public class DijsktraAlgorithm {
    int[][] a;
    int v;

    DijsktraAlgorithm(int[][] a,int v){
        this.a=a;
        this.v=v;
    }

    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;
        for (int k = 0; k < v; k++)
            if (sptSet[k] == false && dist[k] <= min)
            {
                min = dist[k];
                min_index = k;
            }

        return min_index;
    }

    int Solution(int dist[], int n,int t)
    {
        return dist[t];

    }

    int dijkstra(int graph[][], int src,int t)
    {
        int dist[] = new int[v];
        Boolean sptSet[] = new Boolean[v];
        for (int i = 0; i < v; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < v-1; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int k = 0; k < v; k++)
                if (!sptSet[k] && graph[u][k]!=-1                                                                                                                                             && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][k] < dist[k])
                    dist[k] = dist[u] + graph[u][k];
        }
        return Solution(dist,src,t);
    }


}
