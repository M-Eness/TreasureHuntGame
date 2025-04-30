package com.mycompany.treasurehuntgame;

import java.util.Random;

// Node ve harita oluşturulması yapıldı
class MapNode {

    int index;
    String type; // "treasure", "trap", "empty", "forward", "backward"
    MapNode next;
    MapNode prev; 

    public MapNode(int index, String type) {
        this.index = index;
        this.type = type;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "[" + index + ": " + type + "]";
    }
}
// MAP Sınıfı doubly linked list
class LinkedListMap {

    MapNode head;
    MapNode tail; 
    int size;
    Random rand = new Random();

    public LinkedListMap(int size, int level) {
        this.size = size;
        this.head = generateMap(size, level);
    }

    private MapNode generateMap(int size, int level) {
        MapNode dummy = new MapNode(0, randomType(level));
        MapNode current = dummy;
        for (int i = 1; i < size; i++) {
            MapNode newNode = new MapNode(i, randomType(level));
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        tail = current;
        return dummy;
    }

    private String randomType(int level) {
        String[] types;
        if (level == 1) {
            types = new String[]{"treasure", "trap", "empty"};
        } else if (level == 2) { 
            types = new String[]{"treasure", "trap", "empty", "forward", "backward"};
        }else{
            types = new String[]{"treasure", "trap", "empty", "forward", "backward"};
        }
        return types[rand.nextInt(types.length)];
    }

    public void displayMap() {
        MapNode current = head;
        while (current != null) {
            System.out.print(current + " <-> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public MapNode getNodeAt(int position) {
        MapNode current = head;
        int count = 0;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        return current;
    }
}