public class FloodFill {
    private final int[][] matrix;
    private final int numRows;
    private final int numCols;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public FloodFill(int[][] matrix) {
        this.matrix = matrix;
        this.numRows = matrix.length;
        this.numCols = matrix[0].length;
    }

    public void floodFill(int startX, int startY, int newColor, boolean useStack) {
        int originalColor = matrix[startX][startY];

        Stack<int[]> stack = new Stack<>(numRows * numCols);
        Queue<int[]> queue = new Queue<>(numRows * numCols);

        if (useStack) {
            stack.push(new int[]{startX, startY});
        } else {
            queue.enqueue(new int[]{startX, startY});
        }

        while (!stack.isEmpty() || !queue.isEmpty()) {
            int[] current;

            if (useStack) {
                current = stack.pop();
            } else {
                current = queue.dequeue();
            }

            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= numRows || y < 0 || y >= numCols || matrix[x][y] != originalColor) {
                continue;
            }

            matrix[x][y] = newColor;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < numRows && newY >= 0 && newY < numCols && matrix[newX][newY] == originalColor) {
                    if (useStack) {
                        stack.push(new int[]{newX, newY});
                    } else {
                        queue.enqueue(new int[]{newX, newY});
                    }
                }
            }
        }
    }
    public void printMatrix() {
        for (int i = 0; i < numRows; i++) {
            System.out.print("[");
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j]);
                if (j < numCols - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
