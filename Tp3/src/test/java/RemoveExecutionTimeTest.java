import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RemoveExecutionTimeTest {
    @Test
    public void BSTAverageRemove(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            bst.add(input);
        }

        long startInsertionTime = System.nanoTime();
        bst.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

    }

    @Test
    public void BSTWorstRemove(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            bst.add(input);
        }

        long startInsertionTime = System.nanoTime();
        bst.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

    }

    @Test
    public void AVLAverageRemove(){
        AvlTree<Integer> avlTree = new AvlTree<>();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            avlTree.add(input);
        }

        long startInsertionTime = System.nanoTime();
        avlTree.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

    }

    @Test
    public void AVLWorstRemove(){
        AvlTree<Integer> avlTree = new AvlTree<>();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            avlTree.add(input);
        }

        long startInsertionTime = System.nanoTime();
        avlTree.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

    }

    @Test
    public void SplayAverageRemove(){
        SplayTree splayTree = new SplayTree();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            splayTree.insert(input);
        }

        long startInsertionTime = System.nanoTime();
        splayTree.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

    }

    @Test
    public void SplayWorstRemove(){
        SplayTree splayTree = new SplayTree();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            splayTree.insert(input);
        }

        long startInsertionTime = System.nanoTime();
        splayTree.remove(randomNumber);
        long endTime = System.nanoTime();

        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);

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

    private Integer chooseRandomNumber(List<Integer> inputArray){
        Random ran = new Random();
        int index = ran.nextInt(inputArray.size());
        return inputArray.get(index);
    }
}
