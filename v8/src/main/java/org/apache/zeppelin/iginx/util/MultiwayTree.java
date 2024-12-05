package org.apache.zeppelin.iginx.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.commons.lang3.StringUtils;

public class MultiwayTree {
  public static final String ROOT_NODE_NAME = "";
  public static final String ROOT_NODE_PATH = "rootId";

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

  /**
   * 广度优先遍历树，转换为Highcharts节点数组
   *
   * @param root
   * @param nodeList
   */
  public int traverseToHighchartsTreeNodes(TreeNode root, List<HighchartsTreeNode> nodeList) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;

    while (!queue.isEmpty()) {
      int levelSize = queue.size(); // 当前层的节点数
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        nodeList.add(
            new HighchartsTreeNode(
                node.path, node.value, StringUtils.substringBeforeLast(node.path, "."), depth));
        for (TreeNode child : node.children) {
          queue.offer(child);
        }
      }
      depth++;
    }
    return depth;
  }

  public static MultiwayTree getMultiwayTree() {
    MultiwayTree tree = new MultiwayTree();
    tree.root = new TreeNode(ROOT_NODE_PATH, ROOT_NODE_NAME); // 初始化
    return tree;
  }

  public static void addTreeNodeFromString(MultiwayTree tree, String nodeString) {
    String[] nodes = nodeString.split("\\.");
    TreeNode newNode = tree.root;
    for (int i = 0; i < nodes.length; i++) {
      newNode =
          tree.insert(
              newNode, new TreeNode(StringUtils.join(newNode.path, ".", nodes[i]), nodes[i]));
    }
  }
}
