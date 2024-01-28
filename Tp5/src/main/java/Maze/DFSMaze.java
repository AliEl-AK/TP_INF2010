package Maze;

import java.util.*;
import java.awt.*;
import java.util.stream.Collectors;

/**
 *Implement DFS algorithm to solve the maze.
 */
public class DFSMaze {


    private static boolean[][] dfsMarked;
    private static Point[][] dfsParent;
    private static Point entry;
    private static Point end;


    /**
     * This method finds the entry and out point in the maze.
     * Iterates through the maze and assigns the first exit tile as the entry point
     * and the second as the end point.
     * @param maze 2D table representing the maze
     */
    public static void findEntryAndEnd(ArrayList<ArrayList<Tile>> maze) {
        boolean entryFound = false;
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(i).size(); j++) {
                if (maze.get(i).get(j) == Tile.Exit) {
                    if (!entryFound) {
                        entry = new Point(i, j);
                        entryFound = true;
                    } else {
                        end = new Point(i, j);
                        return;
                    }
                }
            }
        }
        if (!entryFound || end == null) {
            entry = null;
            end = null;
        }
    }

    /**
     * Checks if the position (x, y) is valid within the maze.
     * A position is valid if it is within the maze's limits and is not a wall.
     * @param maze 2D table representing the maze
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @return true if the position is valid, false if out of bounds.
     */
    private static boolean isValid(ArrayList<ArrayList<Tile>> maze, int x, int y) {
        return x >= 0 && x < maze.size() && y >= 0 && y < maze.get(0).size() && maze.get(x).get(y) != Tile.Wall;
    }

    /**
     * Find all valid adjacent points to a point in the maze.
     * @param maze 2D table representing the maze
     * @param point The current position in the maze.
     * @return An ArrayList of adjacent points.
     */
    private static ArrayList<Point> findAdjacent(ArrayList<ArrayList<Tile>> maze, Point point) {
        ArrayList<Point> pointAdj = new ArrayList<>();
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] dir : directions) {
            int newX = point.x + dir[0];
            int newY = point.y + dir[1];
            if (isValid(maze, newX, newY)) {
                pointAdj.add(new Point(newX, newY));
            }
        }
        return pointAdj;
    }

    /**
     * DFS search from a point in the maze.
     * Marks visited cells and records the path traversed.
     * Uses a stack to manage the traversal and stops when it reaches the ending point.
     * @param maze 2D table representing the maze
     * @param v  starting point for the Depth fisrt search.
     */
    private static void dfs(ArrayList<ArrayList<Tile>> maze, Point v) {
        Stack<Point> stack = new Stack<>();
        stack.push(v);
        dfsMarked[v.x][v.y] = true;
        Counter.stackedNodesByIteration.add(stack.size() - Counter.stackedNodes);
        Counter.stackedNodes++; // On commence avec le point de départ dans la pile
        Counter.maxStackSize = Math.max(Counter.maxStackSize, Counter.stackedNodes);


        while (!stack.isEmpty()) {
            Point current = stack.pop();
            Counter.totalNodesTraversed++;

            if (current.equals(end)) {
                break;
            }
            for (Point w : findAdjacent(maze, current)) {
                if (!dfsMarked[w.x][w.y]) {
                    dfsMarked[w.x][w.y] = true;
                    dfsParent[w.x][w.y] = current;
                    stack.push(w);
                    Counter.maxStackSize = Math.max(Counter.maxStackSize, Counter.stackedNodes); // Mettre à jour le max si nécessaire
                }
            }


            Counter.stackedNodesByIteration.add(stack.size() - Counter.stackedNodes);
            Counter.printAddedNodes(Counter.indexList);
            Counter.indexList++;
            Counter.stackedNodes = stack.size();

        }
    }



    /**
     * Reconstructs the path from point v (usually the exit) to the entry point using the data stored during the DFS.
     * Returns the path as a stack, where the top of the stack is the start point and the bottom is the end point.
     * @param v The point to start retracing the path from.
     * @return A Stack representing the path from entry to v, or null if v is not reachable.
     */
    public static Stack<Point> dfsPathTo(Point v) {
        if (!dfsMarked[v.x][v.y]) return null;
        Stack<Point> path = new Stack<>();

        for (Point x = v; x != null && !x.equals(entry); x = dfsParent[x.x][x.y]){
            path.push(x);
            Counter.totalNodesTraversed++; // On compte aussi les nœuds lors de la reconstruction du chemin
        }

        path.push(entry);
        return path;
    }


    /**Returns the distance of the path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        Counter.reset();
        if (maze.isEmpty()) return null;

        dfsMarked = new boolean[maze.size()][maze.get(0).size()];
        dfsParent = new Point[maze.size()][maze.get(0).size()];
        findEntryAndEnd(maze);

        if (entry == null || end == null) return null;

        dfs(maze, entry);

        Stack<Point> path = dfsPathTo(end);
        if (path == null) return 0;

        Counter.printCounter();
        return path.size() - 1;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}