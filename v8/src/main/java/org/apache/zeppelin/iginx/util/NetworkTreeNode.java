package org.apache.zeppelin.iginx.util;

import java.util.List;

public class NetworkTreeNode {
  private String id;
  private String name;
  private String parent;
  private int depth;
  private List<Double> embedding;

  public NetworkTreeNode(String id, String name, String parent, int depth, List<Double> embedding) {
    this.id = id;
    this.name = name;
    this.parent = parent;
    this.depth = depth;
    this.embedding = embedding;
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

  public List<Double> getEmbedding() {
    return embedding;
  }

  public void setEmbedding(List<Double> embedding) {
    this.embedding = embedding;
  }
}
