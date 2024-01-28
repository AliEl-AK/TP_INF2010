public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        curNode = super.add(value, curNode);

        updateHeight(curNode);
        return balance(curNode);
    }

    @Override
    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        curNode = super.remove(value, curNode);

        if (curNode != null) {
            updateHeight(curNode);
            curNode = balance(curNode);
        }

        return curNode;
    }

    private int balanceFactor(BinaryNode<T> node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    private int getHeight(BinaryNode<T> node) {
        return node == null ? 0 : node.height;
    }

    private void updateHeight(BinaryNode<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private BinaryNode<T> rotateRight(BinaryNode<T> node) {
        BinaryNode<T> leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }

    private BinaryNode<T> rotateLeft(BinaryNode<T> node) {
        BinaryNode<T> rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }

    protected BinaryNode<T> balance(BinaryNode<T> node) {
        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.right) < 0) node.right = rotateRight(node.right);
            node = rotateLeft(node);
        } else if (balanceFactor(node) < -1) {
            if (balanceFactor(node.left) > 0) node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }
        return node;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(BinaryNode<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
}
