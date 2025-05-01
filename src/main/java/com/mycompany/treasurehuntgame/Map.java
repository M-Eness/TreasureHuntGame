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
        String random = randomType(level);
        int forward = 0;
        int backward = 0;

        while (random == "backward") {
            random = randomType(level);
        }
        MapNode dummy = new MapNode(0, random);
        if (random == "forward") {
            forward++;
        }

        MapNode current = dummy;
        for (int i = 1; i < size; i++) {
            String randomType = randomType(level);
            if (randomType == "forward") {
                forward++;
            } else if (randomType == "backward") {
                backward++;
            }
            while ((forward > 5 && randomType == "forward") || (backward > 5 && randomType == "backward")) {
                randomType = randomType(level);
            }

            MapNode newNode = new MapNode(i, randomType);
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
        } else {
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

    public MapNode getNodeAtFirst(int position) {
        MapNode current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        return current;
    }
}
