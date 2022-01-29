package com.ramalapure.dp.visitor;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private final int value;
    private final Color color;
    private final int depth;

    protected Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private final ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

interface TreeVis {
    int getResult();

    void visitNode(TreeNode node);

    void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor implements TreeVis {
    int totalPrice = Integer.MIN_VALUE;

    public int getResult() {
        return totalPrice;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        totalPrice += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor implements TreeVis {
    long totalPrice = 1;
    private static final int MODULO = 1000000007;

    public int getResult() {
        return (int) totalPrice;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED)) totalPrice = (totalPrice * node.getValue()) % MODULO;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) totalPrice = (totalPrice * leaf.getValue()) % MODULO;
    }
}

class FancyVisitor implements TreeVis {
    int sumNonLeafs = 0;
    int sumGreenLeafs = 0;

    public int getResult() {
        return Math.abs(sumNonLeafs - sumGreenLeafs);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) sumNonLeafs += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) sumGreenLeafs += leaf.getValue();
    }
}

public class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    private static int[] nodeValues;
    private static Color[] nodeColors;
    private static final Map<Integer, Set<Integer>> nodesMap = new HashMap<>();

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();
        nodeValues = new int[numberOfNodes];
        for (int index = 0; index < numberOfNodes; index++) {
            nodeValues[index] = in.nextInt();
        }

        nodeColors = new Color[numberOfNodes];
        for (int index = 0; index < numberOfNodes; index++) {
            nodeColors[index] = (in.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Tree rootNode;
        if (numberOfNodes == 1) {
            rootNode = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
        } else {
            for (int index = 0; index < (numberOfNodes - 1); index++) {
                int u = in.nextInt();
                int v = in.nextInt();
                Set<Integer> uEdges = nodesMap.get(u);
                if (uEdges == null) uEdges = new HashSet<>();
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if (vEdges == null) vEdges = new HashSet<>();
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }

            rootNode = new TreeNode(nodeValues[0], nodeColors[0], 0);
            Set<Integer> rootEdges = nodesMap.get(1);
            rootEdges.forEach(nodeIdentifier -> {
                nodesMap.get(nodeIdentifier).remove(1);
                createEdge(rootNode, nodeIdentifier);
            });
        }

        return rootNode;
    }

    private static void createEdge(Tree parentNode, Integer nodeIdentifier) {

        Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
        boolean hasChild = nodeEdges != null && !nodeEdges.isEmpty();

        if (hasChild) {
            TreeNode node = new TreeNode(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(node);
            for (Integer neighborNodeIdentifier : nodeEdges) {
                nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(leaf);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        for (int i : new int[]{res1, res2, res3}) log.log(Level.INFO, () -> String.valueOf(i));
    }
}
