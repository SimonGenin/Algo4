import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {

    private int[][] blocks;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null) throw new NullPointerException();
        this.blocks = blocks;
    }

    // board dimension N
    public int dimension() {
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        int count = 1;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (i == blocks.length - 1 && j == blocks.length - 1) {
                    if (blocks[i][j] != 0) return false;
                } else {
                    if (blocks[i][j] != count) return false;
                    count ++;
                }
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {

        // TODO : handle the problem
        int[][] b = blocks.clone();

        int ai = StdRandom.uniform(0, blocks.length);
        int aj = StdRandom.uniform(0, blocks.length);
        int bi = StdRandom.uniform(0, blocks.length);
        int bj = StdRandom.uniform(0, blocks.length);

        int temp = b[ai][aj];
        b[ai][aj] = b[bi][bj];
        b[bi][bj] = temp;

        return new Board(b);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return y != null && y instanceof Board && Arrays.deepEquals(blocks, ((Board) y).blocks);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> stack = new Stack<>();

        int[][] tab;

        // Right

        // Left

        // Bottom

        // Top


        return stack;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                sb.append(blocks[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // unit tests (not graded)
    public static void main(String[] args) {

        int[][] tab = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        Board board = new Board(tab);

        System.out.println(board.toString());

        int i  =0;
        while (i != 100) {
            i++;
            board.twin();
        }




    }

}
