package org.apache.zeppelin.iginx.util;

public class MultiwayTree {
  public static final String ROOT_NODE_NAME = "根节点";

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  TreeNode root;

  public TreeNode insert(TreeNode parenNode, TreeNode newNode) {
    TreeNode childNode = findNode(parenNode, newNode);
    if (childNode != null) {
      System.out.println("node already exists");
    } else {
      parenNode.children.add(newNode);
      return newNode;
    }
    return childNode;
  }

  // 查找节点操作
  private TreeNode findNode(TreeNode node, TreeNode nodeToFind) {
    if (node == null) {
      return null;
    }
    for (TreeNode child : node.children) {
      if (child.value.equals(nodeToFind.value)) {
        return child;
      }
    }
    return null;
  }

  public void traversePreorder(TreeNode node) {
    if (node != null) {
      System.out.print(node.value + " ");
      for (TreeNode child : node.children) {
        traversePreorder(child);
      }
    }
  }

  public static MultiwayTree getMultiwayTree() {
    MultiwayTree tree = new MultiwayTree();
    tree.root = new TreeNode(ROOT_NODE_NAME); // 初始化
    return tree;
  }

  public static void addTreeNodeFromString(MultiwayTree tree, String nodeString) {
    String[] nodes = nodeString.split("\\.");
    TreeNode newNode = tree.root;
    for (int i = 0; i < nodes.length; i++) {
      newNode = tree.insert(newNode, new TreeNode(nodes[i]));
    }
  }
}
