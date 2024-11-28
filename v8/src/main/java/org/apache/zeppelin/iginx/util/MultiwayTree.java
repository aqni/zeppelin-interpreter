package org.apache.zeppelin.iginx.util;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class MultiwayTree {
  public static final String ROOT_NODE_NAME = "数据资产";
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
   * @param node
   * @param nodeList
   * @param level 从0开始，0代表虚拟根节点
   */
  public void traverseToHighchartsTreeNodes(
      TreeNode node, List<HighchartsTreeNode> nodeList, int level) {
    if (node != null) {
      nodeList.add(
          new HighchartsTreeNode(
              node.path, node.value, StringUtils.substringBeforeLast(node.path, "."), level++));
      for (TreeNode child : node.children) {
        traverseToHighchartsTreeNodes(child, nodeList, level);
      }
    }
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
