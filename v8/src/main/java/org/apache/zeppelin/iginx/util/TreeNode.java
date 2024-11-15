package org.apache.zeppelin.iginx.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  String value;
  List<TreeNode> children;
  List<String> columns;

  public TreeNode(String value, List<String> columns) {
    this.value = value;
    this.children = new ArrayList<>();
    this.columns = columns;
  }

  public TreeNode(String value) {
    this.value = value;
    this.children = new ArrayList<>();
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public List<TreeNode> getChildren() {
    return children;
  }

  public void setChildren(List<TreeNode> children) {
    this.children = children;
  }

  public List<String> getColumns() {
    return columns;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }
}
