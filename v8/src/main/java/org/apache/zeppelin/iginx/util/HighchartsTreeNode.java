package org.apache.zeppelin.iginx.util;

public class HighchartsTreeNode {
  private String id;
  private String name;
  private String parent;
  private int level;

  public HighchartsTreeNode(String id, String name, String parent, int level) {
    this.id = id;
    this.name = name;
    this.level = level;
    if (level == 1) {
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

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
