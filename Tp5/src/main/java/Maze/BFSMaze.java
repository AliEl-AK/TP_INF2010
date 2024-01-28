package Maze;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Implement BFS algorithm to solve the maze.
 */
public class BFSMaze {

    private static boolean[][] bfsMarked;
    private static Point[][] bfsParent;
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
     * does BFS from a starting point in the maze.
     * this method marks visited cells, tracks the traversal path,
     * records traversal statistics using the Counter class.
     * we used a queue to manage the order in which nodes are visited, exploring the maze level by level.
     * The search continues until it reaches the end point, where it will print the traversal statistics.
     *
     * @param maze 2D table representing the maze
     * @param "v" The starting point for the BFS, typically the maze entry.
     */
    private static void bfs(ArrayList<ArrayList<Tile>> maze, Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        bfsMarked[start.x][start.y] = true;
        Counter.stackedNodesByIteration.add(queue.size() - Counter.stackedNodes);
        Counter.stackedNodes++; // On commence avec le point de départ dans la pile
        Counter.maxStackSize = Math.max(Counter.maxStackSize, Counter.stackedNodes);

        while (!queue.isEmpty()) {
            Point current = queue.poll();


            if (current.equals(end)) {
                Counter.printCounter();
                return;
            }

            for (Point w : findAdjacent(maze, current)) {
                if (!bfsMarked[w.x][w.y]) {
                    bfsMarked[w.x][w.y] = true;
                    bfsParent[w.x][w.y] = current;
                    queue.add(w);
                }
            }

            // Update traversal statistics
            Counter.stackedNodesByIteration.add(queue.size() - Counter.stackedNodes);
            Counter.printAddedNodes(Counter.indexList);
            Counter.indexList++;
            Counter.stackedNodes = queue.size();
            Counter.totalNodesTraversed++;
            Counter.maxStackSize = Math.max(Counter.maxStackSize, queue.size());
        }
    }


    /**
     * Returns the path from the entry to the exit of the maze.
     * @param v The exit point of the maze.
     * @return A Stack of points representing the path from the entry to the exit of the maze.
     */
    public static Stack<Point> bfsPathTo(Point v){
        if( !bfsMarked[v.x][v.y] ) return null;
        Stack<Point> path = new Stack<>();
        for(Point x = v; x != entry; x = bfsParent[x.x][x.y])
            path.push(x);
        path.add(entry);
        return path;
    }

    /**
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        Counter.reset();

        if(maze.isEmpty()) { return null; }

        bfsMarked = new boolean[maze.size()][maze.get(0).size()];
        bfsParent = new Point[maze.size()][maze.get(0).size()];
        findEntryAndEnd(maze);

        if(entry == null || end == null){ return null; }

        bfs(maze, entry);

        Stack<Point> path = bfsPathTo(end);

        if(path == null) { return 0; }
        return path.size() - 1;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}