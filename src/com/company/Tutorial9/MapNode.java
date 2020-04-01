package com.company.Tutorial9;

public class MapNode<K, V> {

    private K key;
    private V value;
    private MapNode link;

    public MapNode() {
        key = null;
        value = null;
        link = null;
    }

    public MapNode(K key, V value, MapNode link) {
        this.key = key;
        this.value = value;
        this.link = link;
    }

    public void setKey(K key) { this.key = key; }
    public K getKey() { return key; }
    public void setValue(V value) { this.value = value; }
    public V getValue() { return value; }
    public void setLink(MapNode link) { this.link = link; }
    public MapNode getLink() { return link; }
    public String toString() { return key + ":" + value + " --> "; }
}
