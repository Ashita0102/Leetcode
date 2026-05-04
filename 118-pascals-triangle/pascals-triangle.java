import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build rows 2..numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Middle elements: sum of two above
            for (int j = 1; j < i; j++) {
                int val = prevRow.get(j - 1) + prevRow.get(j);
                row.add(val);
            }

            // Last element
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}