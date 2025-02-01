public class grid_traveller {
    public static void main(String[] args) {
        int[][] grid = new int[10][10];
        // for (int i = 0; i < grid.length; i++) {
        // grid[0][i] = 1;
        // grid[i][0] = 1;
        // }
        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid[0].length; j++) {
        // System.out.print(grid[i][j] + " ");
        // }
        // System.out.println();
        // }
        int data = maximum_possible_routes(0, 0, grid, 9, 9);
        System.out.println("data = " + data);
    }

    static int maximum_possible_routes(int stepi, int stepj, int[][] grid, int ei, int ej) {

        // System.out.println("" + stepi + " " + stepj + " " + ei + " " + ej);
        // System.out.println();
        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid[0].length; j++) {
        // System.out.print(grid[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println();
        if (stepi == ei || stepj == ej) {
            grid[ei][ej] = 1;
            return 1;
        } else {

            int up = maximum_possible_routes(stepi, stepj, grid, ei - 1, ej);
            int down = maximum_possible_routes(stepi, stepj, grid, ei, ej - 1);
            grid[ei][ej] = up + down;
            // System.err.println("" + ei + "," + ej + " ei, ej > " + grid[ei][ej]);
            return grid[ei][ej];
        }

    }

}
