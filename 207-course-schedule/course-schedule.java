import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }

        int[] state = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adj, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1; // visiting

        for (int next : adj.get(node)) {
            if (state[next] == 1) {
                return true; // back edge -> cycle
            }
            if (state[next] == 0 && hasCycle(next, adj, state)) {
                return true;
            }
        }

        state[node] = 2; // visited
        return false;
    }
}