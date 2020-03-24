package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    private Node<T> root;
    private int count;

    Node<T> getRootNode(){
        return this.root;
    }

    @Override
    public boolean contains(T element) {
        if (element == null){
            throw new IllegalArgumentException("Element must not be null");
        }

        SearchResult result = this.search(element);
        return result.node != null;
    }

    @Override
    public void add(T element) {
        if (element == null){
            throw new IllegalArgumentException("Element must not be null");
        }

        SearchResult result = this.search(element);
        if (result.parent == null){
            this.root = new Node<>(element);
            this.count++;
        } else if (result.node == null){
            if (element.compareTo(result.parent.getData()) > 0){
                result.parent.setRight(new Node<>(element));
            }
            else{
                result.parent.setLeft(new Node<>(element));
            }
            this.count++;
        }
    }

    @Override
    public void remove(T element) {
        if (element == null){
            throw new IllegalArgumentException("Element must not be null");
        }

        SearchResult result = this.search(element);
        if (result.node != null){
            if (result.parent != null){
                if (result.parent.getLeft().equals(result.node)) {
                    result.parent.setLeft(null);
                } else{
                    result.parent.setRight(null);
                }
            } else{
                this.root = null;
            }

            this.count--;
        }
    }

    public List<T> inorder(){
        List<T> nodes = new ArrayList<>();
        this.inOrder(nodes, this.root);
        return nodes;
    }

    private void inOrder(List<T> nodes, Node<T> node){
        if (node.getLeft() != null){
            this.inOrder(nodes, node.getLeft());
        }
        nodes.add(node.getData());
        if (node.getRight() != null){
            this.inOrder(nodes, node.getRight());
        }
    }

    public int getCount(){
        return this.count;
    }

    private SearchResult search(T element){
        if (root == null){
            return new SearchResult(null, null);
        }
        Node<T> parentNode = null;
        Node<T> nextNode = root;

        do {
            int compareResult = element.compareTo(nextNode.getData());
            if (compareResult == 0){
                return new SearchResult(parentNode, nextNode);
            } else if (compareResult > 0){
                parentNode = nextNode;
                nextNode = nextNode.getRight();
            } else {
                parentNode = nextNode;
                nextNode = nextNode.getLeft();
            }
        } while (nextNode != null);

        return new SearchResult(parentNode, null);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class SearchResult{
        private Node<T> parent;
        private Node<T> node;

        private SearchResult(Node<T> parent, Node<T> node){
            this.parent = parent;
            this.node = node;
        }
    }
}
