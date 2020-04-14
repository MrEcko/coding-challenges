package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
class SearchInBinarySearchTreeTest extends Specification {
    @Shared
    private static SearchInBinarySearchTree solution = new SearchInBinarySearchTree()

    def "SearchInBinarySearchTree"() {
        given:
        SearchInBinarySearchTree.TreeNode input = new SearchInBinarySearchTree.TreeNode(4);
        input.left = new SearchInBinarySearchTree.TreeNode(2);
        input.right = new SearchInBinarySearchTree.TreeNode(7);
        input.left.left = new SearchInBinarySearchTree.TreeNode(1);
        input.left.right = new SearchInBinarySearchTree.TreeNode(3);

        expect:
        solution.searchBST(input, 2) == input.left
    }
}

