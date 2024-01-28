import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class InsertionExecutionTimeTest {
    @Test
    public void BSTAverageInsertion(){
       BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertions = 25600;
        List<Integer> inputArray = averageCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            bst.add(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions);
    }


    @Test
    public void BSTWorstInsertion(){

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertions = 12800;
        List<Integer> inputArray = worstCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            bst.add(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions);
    }

    @Test
    public void AVLAverageInsertion(){
        AvlTree<Integer> avlTRee = new AvlTree<>();
        int insertions = 12800;
        List<Integer> inputArray = averageCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            avlTRee.add(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions + "  AVL");
    }

    @Test
    public void AVLWorstInsertion(){
        AvlTree<Integer> avlTRee = new AvlTree<>();
        int insertions = 12800;
        List<Integer> inputArray = worstCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            avlTRee.add(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions + "  AVL");
    }

    @Test
    public void SplayAverageInsertion(){
        SplayTree splayTree = new SplayTree();
        int insertions = 6400;
        List<Integer> inputArray = averageCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            splayTree.insert(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions + "  Splay");
    }

    @Test
    public void SplayWorstInsertion(){
        SplayTree splayTree = new SplayTree();
        int insertions = 12800;
        List<Integer> inputArray = worstCaseArray(insertions);

        long startInsertionTime = System.nanoTime();

        for (Integer input : inputArray){
            splayTree.insert(input);
        }

        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre d'insertion: " + insertions + "  Splay");
    }

    private List<Integer> averageCaseArray(int insertions){
        Random ran = new Random();
        List<Integer> inputArray = new ArrayList<>();
        for (int i = 0; i < insertions; i++){
            inputArray.add(ran.nextInt());
        }
        return inputArray;
    }

    private List<Integer> worstCaseArray(int insertions){
        List<Integer> inputArray = new ArrayList<>();
        for (int i = 0; i < insertions; i++){
            inputArray.add(i);
        }
        return inputArray;
    }


}
