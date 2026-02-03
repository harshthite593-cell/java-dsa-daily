public class Binarysearch2d {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int[] ans = search(matrix, 20);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static int[] search(int[][] matrix, int target) {

        int rows = matrix.length;
        if (rows == 0) return new int[]{-1, -1};

        int cols = matrix[0].length;

        // only one row
        if (rows == 1) {
            return binarysearch(matrix, 0, 0, cols - 1, target);
        }

        int rstart = 0;
        int rend = rows - 1;
        int cmid = cols / 2;

        // reduce rows
        while (rstart < rend - 1) {
            int mid = rstart + (rend - rstart) / 2;

            if (matrix[mid][cmid] == target) {
                return new int[]{mid, cmid};
            }

            if (matrix[mid][cmid] < target) {
                rstart = mid;   // FIXED
            } else {
                rend = mid;
            }
        }

        // check middle column
        if (matrix[rstart][cmid] == target) return new int[]{rstart, cmid};
        if (matrix[rstart + 1][cmid] == target) return new int[]{rstart + 1, cmid};

        // search 4 parts

        // part 1
        if (target <= matrix[rstart][cmid - 1])
            return binarysearch(matrix, rstart, 0, cmid - 1, target);

        // part 2
        if (target >= matrix[rstart][cmid + 1] && target <= matrix[rstart][cols - 1])
            return binarysearch(matrix, rstart, cmid + 1, cols - 1, target);

        // part 3
        if (target <= matrix[rstart + 1][cmid - 1])
            return binarysearch(matrix, rstart + 1, 0, cmid - 1, target);

        // part 4
        return binarysearch(matrix, rstart + 1, cmid + 1, cols - 1, target);
    }

    // search inside one row
    static int[] binarysearch(int[][] matrix, int row, int cStart, int cEnd, int target) {

        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else if (matrix[row][mid] > target) {
                cEnd = mid - 1;
            } else {
                return new int[]{row, mid};
            }
        }
        return new int[]{-1, -1};
    }
}
