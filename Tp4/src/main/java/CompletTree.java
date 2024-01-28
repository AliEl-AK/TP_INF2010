import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class CompletTree {
    // Partie 1

    public boolean isCompleteTree(Integer[] arr){
        // TODO
        if (arr.length == 0){
            return true;
        }

        int numberOfNode = 0;
        for(Integer node : arr){
            if(node != null){
                numberOfNode += 1;
            }
        }

        return numberOfNode >= arr.length;

    }

    public boolean isCompleteTree(BinaryNode<Integer> root){
        // TODO
        if (root == null){
            return true;
        }

        boolean isNodeNull = false;

        Queue<BinaryNode<Integer>> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode<Integer> currNode = q.poll();

            if(isNodeNull && currNode != null){
                return false;
            }

            if (currNode == null){
                isNodeNull = true;
                continue;
            }

            if(currNode.left != null){
                q.add(currNode.left);
            }

            if(currNode.left == null){
                q.add(null);
            }

            if(currNode.right != null){
                q.add(currNode.right);
            }

            if(currNode.right == null){
                q.add(null);
            }
        }
        return true;
    }

}
