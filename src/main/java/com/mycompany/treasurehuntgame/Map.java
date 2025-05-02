package com.mycompany.treasurehuntgame;

import java.util.Random;

// Node ve harita oluşturulması yapıldı
class MapNode {

    int index;
    int jumpAmount;
    String type; // "treasure", "trap", "empty", "forward", "backward"
    MapNode next;
    MapNode prev;
    MapNode jump;

    public MapNode(int index, String type) {
        this.index = index;
        this.jumpAmount = 0;
        this.type = type;
        this.next = null;
        this.prev = null;
        this.jump = null;
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

    private void isSpecial(MapNode node) {
        if (node.type == "forward" || node.type == "backward") {
            Random random = new Random();
            node.jumpAmount = random.nextInt(7) + 1;
        }
    }

    private void generateMapAdvanced(MapNode head) {
        MapNode dummy = head;
        while (dummy != null) {
            if (dummy.type == "forward") {
                MapNode dummy2 = dummy;
                for (int i = 0; i < dummy.jumpAmount; i++) {
                    if (dummy2.next != null) {
                        dummy2 = dummy2.next;
                    }
                }
                dummy.jump = dummy2;
            }
            if (dummy.type == "backward") {
                MapNode dummy2 = dummy;
                for (int i = 0; i < dummy.jumpAmount; i++) {
                    if (dummy2.prev != null) {
                        dummy2 = dummy2.prev;
                    }
                }
                dummy.jump = dummy2;
            }
            dummy = dummy.next;
        }
    }

    private MapNode generateMap(int size, int level) {
        String random = randomType(level);
        int forward = 0;
        int backward = 0;

        while (random == "backward") {
            random = randomType(level);
        }
        MapNode head = new MapNode(0, random);
        isSpecial(head);

        if (random == "forward") {
            forward++;
        }

        MapNode current = head;
        for (int i = 1; i < size; i++) {
            String randomType = randomType(level);
            if (randomType == "forward") {
                forward++;
            } else if (randomType == "backward") {
                backward++;
            }
            while ((forward > 15 && randomType == "forward") || (backward > 10 && randomType == "backward")) {
                randomType = randomType(level);
            }

            MapNode newNode = new MapNode(i, randomType);
            isSpecial(newNode);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        tail = current;
        if (level > 1) {
            generateMapAdvanced(head);
        }
        return head;
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
