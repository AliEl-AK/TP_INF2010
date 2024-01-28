import java.util.*;

public class Interview {
    protected enum Type {
        MinHeap, MaxHeap, NotHeap
    }

    public Type part1Interview(BinaryNode<Integer> root) {
        if (root == null) return Type.NotHeap;

        int nodeCount = countNodes(root);
        boolean isMin = isMinHeap(root, Integer.MIN_VALUE);
        boolean isMax = isMaxHeap(root, Integer.MAX_VALUE);

        if (isCompleteTree(root, 0, nodeCount) && isMin) {
            return Type.MinHeap;
        } else if (isCompleteTree(root, 0, nodeCount) && isMax) {
            return Type.MaxHeap;
        } else {
            return Type.NotHeap;
        }
    }

    private boolean isCompleteTree(BinaryNode<Integer> node, int index, int nodeCount) {
        if (node == null) return true;
        if (index >= nodeCount) return false;

        return isCompleteTree(node.left, 2 * index + 1, nodeCount) &&
                isCompleteTree(node.right, 2 * index + 2, nodeCount);
    }

    private boolean isMinHeap(BinaryNode<Integer> node, int prevValue) {
        if (node == null) return true;
        if (node.value < prevValue) return false;
        return isMinHeap(node.left, node.value) && isMinHeap(node.right, node.value);
    }

    private boolean isMaxHeap(BinaryNode<Integer> node, int prevValue) {
        if (node == null) return true;
        if (node.value > prevValue) return false;
        return isMaxHeap(node.left, node.value) && isMaxHeap(node.right, node.value);
    }

    private int countNodes(BinaryNode<Integer> node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public Integer part2Interview(Integer[] arr, Integer k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());

        sortedEntries.sort((e1, e2) -> {
            int freqCompare = e2.getValue().compareTo(e1.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        });

        if (k < 1 || k > sortedEntries.size()) {
            return null;
        }
        return sortedEntries.get(k - 1).getKey();
    }

}
//Explication de la complexite :
// Partie 1 :
//La complexité est principalement déterminée par le nombre de nœuds dans l'arbre.
//Chaque nœud de l'arbre est visité une seule fois.
//Donc, la complexité totale est O(n), où n est le nombre de nœuds de l'arbre.
//
//Partie 2 :
//Cette partie recherche le K-ème élément le plus fréquent dans un tableau d'entiers.
//
//Elle commence par compter la fréquence de chaque élément dans le tableau, ce qui prend O(n) de temps, où n est la taille du tableau.
//
//Ensuite, elle trie ces éléments en fonction de leur fréquence, ce qui prend en moyenne O(n log n) de temps, où n est la taille du tableau.
//
//Enfin, elle extrait le k-ème élément du tableau trié, ce qui prend O(1) de temps.
//
//Donc, la complexité totale est généralement dominée par le tri, soit O(N log K),
// où N est la taille du tableau d'entiers et K est le nombre des éléments.
//
//


