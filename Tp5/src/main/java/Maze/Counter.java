package Maze;

import java.util.ArrayList;

public class Counter {
    public static int totalNodesTraversed = 0;
    public static int stackedNodes = 0;
    public static int maxStackSize = 0;
    public static int indexList = 0;

    public static ArrayList<Integer> stackedNodesByIteration = new ArrayList<>();

    public static void printCounter() {
        System.out.println("Nodes traversees | Nodes ajoutees en moyenne par iteration | Taille max queue/stack");
        System.out.println(totalNodesTraversed + " " + averageAddedNode() + " " + maxStackSize);
    }

    public static void printAddedNodes(int indexList){
        System.out.println("Iteration " + indexList + ": Nodes ajoutees :" + stackedNodesByIteration.get(indexList));
        System.out.println("size de la stack :" + stackedNodes);
    }

    public static double averageAddedNode(){
        double average = 0;
        for (int i : stackedNodesByIteration){
            average += i;
        }

        return average/stackedNodesByIteration.size();
    }

    public static void reset() {
        totalNodesTraversed = 0;
        stackedNodes = 0;
        maxStackSize = 0;
        indexList = 0;
        stackedNodesByIteration.clear();
    }
}
