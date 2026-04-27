class Solution(object):
    def minCostConnectPoints(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        import heapq

        n = len(points)
        if n <= 1:
            return 0

        # Prim's MST
        in_mst = [False] * n          # whether node is already in MST
        min_dist = [float('inf')] * n # best known edge cost to connect each node to MST
        min_dist[0] = 0               # start from node 0

        # (cost, node_index)
        pq = [(0, 0)]
        total_cost = 0
        added = 0

        while added < n:
            cost, i = heapq.heappop(pq)
            if in_mst[i]:
                continue

            # Add this node to MST
            in_mst[i] = True
            total_cost += cost
            added += 1

            # Update distances to the remaining nodes
            xi, yi = points[i]
            for j in range(n):
                if not in_mst[j]:
                    xj, yj = points[j]
                    new_cost = abs(xi - xj) + abs(yi - yj)
                    if new_cost < min_dist[j]:
                        min_dist[j] = new_cost
                        heapq.heappush(pq, (new_cost, j))

        return total_cost