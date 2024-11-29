package org.apache.zeppelin.iginx.util;

public class HighchartsTreeNode {
  private String id;
  private String name;
  private String parent;
  private int depth;

  public HighchartsTreeNode(String id, String name, String parent, int depth) {
    this.id = id;
    this.name = name;
    this.depth = depth;
    if (depth == 0) {
      this.parent = "undefined";
    } else {
      this.parent = parent;
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }
}
