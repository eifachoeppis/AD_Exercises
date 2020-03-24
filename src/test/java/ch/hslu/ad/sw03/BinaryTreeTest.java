package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeImplTest {

    @Test
    void addRootElementTest() {
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        String testee = "I am root";
        tree.add(testee);
        assertThat(tree.getRootNode().getData()).isEqualTo(testee);
    }

    @Test
    void addOneRightElementTest() {
        //arrange
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("A");
        //act
        tree.add("B");
        //assert
        assertThat(tree.getRootNode().getRight().getData()).isEqualTo("B");
    }

    @Test
    void addOneLeftElementTest() {
        //arrange
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("B");
        //act
        tree.add("A");
        //assert
        assertThat(tree.getRootNode().getLeft().getData()).isEqualTo("A");
    }

    @Test
    void addManyElementTest() {
        //arrange
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("D");
        //act
        tree.add("F");
        tree.add("A");
        tree.add("B");
        tree.add("E");
        //assert
        assertThat(tree.getRootNode().getLeft().getData()).isEqualTo("A");
        assertThat(tree.getRootNode().getRight().getData()).isEqualTo("F");
        assertThat(tree.getRootNode().getLeft().getRight().getData()).isEqualTo("B");
        assertThat(tree.getRootNode().getRight().getLeft().getData()).isEqualTo("E");
    }

    @Test
    void containsTest() {
        //arrange
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("C");
        tree.add("F");
        tree.add("A");
        tree.add("G");
        tree.add("E");
        tree.add("Q");
        //act & assert
        assertTrue(tree.contains("E"));
    }

    @Test
    void doesNotContainTest() {
        //arrange
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("C");
        tree.add("F");
        tree.add("A");
        tree.add("G");
        tree.add("E");
        tree.add("Q");
        //act & assert
        assertFalse(tree.contains("Z"));
    }

    @Test
    void inorder() {
        BinarySearchTreeImpl<String> tree = new BinarySearchTreeImpl<>();
        tree.add("C");
        tree.add("F");
        tree.add("A");
        tree.add("G");
        tree.add("E");
        tree.add("Q");
        assertThat(tree.inorder()).isEqualTo(Arrays.asList("A", "C", "E", "F", "G", "Q"));
    }
}