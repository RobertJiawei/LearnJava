package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int serialNumber = 1;
        for (String c : color) {
            for (String n : number) {
                hm.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        hm.put(serialNumber, "SK");
        list.add(serialNumber);
        hm.put(++serialNumber, "BK");
        list.add(serialNumber);
    }

    public PokerGame() {
        Collections.shuffle(list);

        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);
            if (i < 3) {
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else player3.add(serialNumber);
        }

        lookPoker("lord", lord);
        lookPoker("player1", player1);
        lookPoker("player2", player2);
        lookPoker("player3", player3);
    }

    public void lookPoker(String name, TreeSet<Integer> ts) {
        System.out.println(name + ": ");
        for (Integer serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker + " ");
        }
        System.out.println();
    }

    //    static {
//        String[] color = {"♠", "♣", "♥", "♦"};
//        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//
//        for (String s : color) {
//            for (String num : number) {
//                list.add(s + num);
//            }
//        }
//
//        list.add("BK");
//        list.add("SK");
//    }
//
//    public PokerGame() {
//        Collections.shuffle(list);
//
//        ArrayList<String> lord = new ArrayList<>();
//        ArrayList<String> player1 = new ArrayList<>();
//        ArrayList<String> player2 = new ArrayList<>();
//        ArrayList<String> player3 = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            String poker = list.get(i);
//            if (i < 3) {
//                lord.add(poker);
//                continue;
//            }
//            if (i % 3 == 0) {
//                player1.add(poker);
//            } else if (i % 3 == 1) {
//                player2.add(poker);
//            } else {
//                player3.add(poker);
//            }
//        }
//
//        lookPoker("remain", lord);
//        lookPoker("player1", player1);
//        lookPoker("player2", player2);
//        lookPoker("player3", player3);
//
//    }
//
//    public void lookPoker(String name, ArrayList<String> list) {
//        System.out.println(name + ": ");
//
//        for (String poker : list) {
//            System.out.print(poker + " ");
//        }
//        System.out.println();
//    }
}
