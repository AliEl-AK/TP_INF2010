import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class SearchExecutionTime {

    @Test
    public void BSTAverageSearch(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);
        System.out.println(randomNumber);

        for (Integer input : inputArray){
            bst.add(input);
            System.out.println(input);
        }
        long startInsertionTime = System.nanoTime();

        bst.contains(randomNumber);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);
    }

    @Test
    public void BSTWorstSearch(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            bst.add(input);
        }

        long startInsertionTime = System.nanoTime();

        bst.contains(randomNumber);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);
    }

    @Test
    public void AvlAverageSearch(){
        AvlTree<Integer> avlTree = new AvlTree<>();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            avlTree.add(input);
        }
        long startInsertionTime = System.nanoTime();

        avlTree.contains(randomNumber);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);
    }

    @Test
    public void AVLWorstSearch(){
        AvlTree<Integer> avlTree = new AvlTree<>();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            avlTree.add(input);
        }

        long startInsertionTime = System.nanoTime();

        avlTree.contains(randomNumber);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);
    }

    @Test
    public void SplayAverageSearch(){
        SplayTree splayTree = new SplayTree();
        int insertion = 5;
        List<Integer> inputArray = averageCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            splayTree.insert(input);
        }
        long startInsertionTime = System.nanoTime();

        splayTree.search(randomNumber);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;

        System.out.println("Temps: " + executionTime + " nombre de noeud: " + insertion);
    }

    @Test
    public void SplayWorstSearch(){
        SplayTree splayTree = new SplayTree();
        int insertion = 5;
        List<Integer> inputArray = worstCaseArray(insertion);
        int randomNumber = chooseRandomNumber(inputArray);

        for (Integer input : inputArray){
            splayTree.insert(input);
        }

        long startInsertionTime = System.nanoTime();

        splayTree.search(randomNumber);
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
