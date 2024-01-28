import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Partie2Test {
    // Partie 2
    // TODO

    @Test
    public void BSTAverageInsertionTest(){
        BSTAverageInsertion(1000);
        BSTAverageInsertion(5000);
        BSTAverageInsertion(10000);
        BSTAverageInsertion(50000);
        BSTAverageInsertion(100000);
        BSTAverageInsertion(500000);

    }

    @Test
    public void BSTWorstInsertionTest(){
        BSTWorstInsertion(100);
        BSTWorstInsertion(500);
        BSTWorstInsertion(1000);
        BSTWorstInsertion(5000);
        BSTWorstInsertion(10000);
        //BSTWorstInsertion(50000);
        // BSTWorstInsertion(100000);
        //BSTWorstInsertion(500000);

    }

    @Test
    public void heapAverageInsertionTest(){
        heapAverageInsertion(1000);
        heapAverageInsertion(5000);
        heapAverageInsertion(10000);
        heapAverageInsertion(50000);
        heapAverageInsertion(100000);
        heapAverageInsertion(500000);

    }

    @Test
    public void heapWorstInsertionTest(){
        heapWorstInsertion(1000);
        heapWorstInsertion(5000);
        heapWorstInsertion(10000);
        heapWorstInsertion(50000);
        heapWorstInsertion(100000);
        heapWorstInsertion(500000);

    }

    @Test
    public void BStAverageDeleteTest(){
        BSTAverageDelete(1000);
        BSTAverageDelete(5000);
        BSTAverageDelete(10000);
        BSTAverageDelete(50000);
        BSTAverageDelete(100000);
        BSTAverageDelete(500000);
    }

    @Test
    public void BSTWorstDeleteTest(){
        BSTWorstDelete(100);
        BSTWorstDelete(500);
        BSTWorstDelete(1000);
        BSTWorstDelete(5000);
        BSTWorstDelete(10000);
        //BSTWorstDelete(50000);
    }

    @Test
    public void heapDeleteTest(){
        heapDelete(1000);
        heapDelete(5000);
        heapDelete(10000);
        heapDelete(50000);
        heapDelete(100000);
        heapDelete(500000);
    }

    @Test
    public void BSTFindMinAverageTest(){
        findMinBSTAverage(1000);
        findMinBSTAverage(5000);
        findMinBSTAverage(10000);
        findMinBSTAverage(50000);
        findMinBSTAverage(100000);
        findMinBSTAverage(500000);
    }

    @Test
    public void BSTFindMinWorstTest(){
        findMinBSTWorst(100);
        findMinBSTWorst(500);
        findMinBSTWorst(1000);
        findMinBSTWorst(5000);
        findMinBSTWorst(10000);
    }

    public void BSTAverageInsertion(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Set<Integer> input = averageCase(BSTSize);

        for (Integer data : input){
            bst.add(data);
        }

        int insertion = generateRandomNumber();
        long startInsertionTime = System.nanoTime();

        bst.add(insertion);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void BSTWorstInsertion(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> input = worstCaseArray(BSTSize);

        for (Integer data : input){
            bst.add(data);
        }

        int insertion = generateRandomNumber();

        long startInsertionTime = System.nanoTime();

        bst.add(insertion);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void heapAverageInsertion(int heapSize){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> input = averageCase(heapSize);

        pq.addAll(input);
        int insertion = generateRandomNumber();

        long startInsertionTime = System.nanoTime();

        pq.add(insertion);

        long endTime = System.nanoTime();
        double executionTime = (endTime - startInsertionTime);
        System.out.println( executionTime );
    }

    public void heapWorstInsertion(int heapSize){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> input = worstCaseArray(heapSize);

        pq.addAll(input);
        int insertion = 0;

        long startInsertionTime = System.nanoTime();

        pq.add(insertion);

        long endTime = System.nanoTime();
        double executionTime = (endTime - startInsertionTime);
        System.out.println( executionTime );
    }

    public void BSTAverageDelete(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Set<Integer> input = averageCase(BSTSize);

        Random ran = new Random();
        int ranNUmber = ran.nextInt(BSTSize-1);

        int index = 0;
        int remove = 0;

        for (Integer data : input){
            if (index == ranNUmber){
                remove = data;
            }
            bst.add(data);
            index++;
        }

        long startInsertionTime = System.nanoTime();

        bst.remove(remove);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void BSTWorstDelete(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> input = worstCaseArray(BSTSize);

        Random ran = new Random();
        int ranNUmber = ran.nextInt(BSTSize-1);

        int index = 0;
        int remove = 0;

        for (Integer data : input){
            if (index == ranNUmber){
                remove = data;
            }
            bst.add(data);
            index++;
        }

        long startInsertionTime = System.nanoTime();

        bst.remove(remove);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void heapDelete(int heapSize){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> input = averageCase(heapSize);

        pq.addAll(input);

        long startInsertionTime = System.nanoTime();

        pq.poll();

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void findMinBSTAverage(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Set<Integer> input = averageCase(BSTSize);

        for (Integer data : input){
            bst.add(data);
        }
        long startInsertionTime = System.nanoTime();

        bst.findMin(bst.root);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public void findMinBSTWorst(int BSTSize){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> input = worstCaseArray(BSTSize);

        for (Integer data : input){
            bst.add(data);
        }
        long startInsertionTime = System.nanoTime();

        bst.findMin(bst.root);

        long endTime = System.nanoTime();
        double executionTime = endTime - startInsertionTime;
        System.out.println(executionTime);
    }

    public Set<Integer> averageCase(int insertion){
        Random rand = new Random();
        Set<Integer> input = new LinkedHashSet<>();

        for(int i = 0; i < insertion; i++) {
            Integer next = rand.nextInt();
            input.add(next);
        }
        return input;
    }

    public List<Integer> worstCaseArray(int insertion){
        List<Integer> inputArr = new ArrayList<>();
        for(int i = 1; i < insertion; i++){
            inputArr.add(i);
        }
        return inputArr;
    }

    public int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt();
    }



}
