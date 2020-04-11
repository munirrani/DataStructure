package com.company.Lab4;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Lab4 {

    public Lab4() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
    }

    private void Q1() {
        Random random = new Random();
        int randomNumber;
        int[] array = new int[10];

        LinkedList<Integer> backLinkedList = new LinkedList<Integer>();
        LinkedList<Integer> frontLinkedList = new LinkedList<Integer>();
        LinkedList<Integer> sortedLinkedList = new LinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            randomNumber = random.nextInt(101);
            array[i] = randomNumber;
            frontLinkedList.addFrontNode(randomNumber);
            backLinkedList.addNode(randomNumber);
            sortedLinkedList.addSortNode(randomNumber);
        }
        System.out.print("The numbers are: ");
        for (int arr : array) System.out.print(arr + " ");
        System.out.println();
        System.out.println();

        System.out.println("Insert random numbers at the back of linked list");
        backLinkedList.showList();
        System.out.println();
        System.out.println("Insert random numbers at the front of linked list");;
        frontLinkedList.showList();
        System.out.println();

        System.out.println("Insert the random numbers in a sorted linked list");
        sortedLinkedList.showList();
    }

    private void Q2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        LinkedList<Character> characterLinkedList = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            characterLinkedList.addNode(word.charAt(i));
        }
        System.out.print("The original list: ");
        characterLinkedList.showList();

        System.out.println("Split the list into two");

        LinkedList<Character> firstHalf = characterLinkedList.splitList(1);
        System.out.print("First List: ");
        firstHalf.showList();
        LinkedList<Character> secondHalf = characterLinkedList.splitList(2);
        System.out.print("Second List: ");
        secondHalf.showList();

        System.out.println("Split the list by alternating the nodes");

        LinkedList<Character> firstAlternateSplit = characterLinkedList.alternateSplit(1);
        System.out.print("First list: ");
        firstAlternateSplit.showList();
        LinkedList<Character> secondAlternateSplit = characterLinkedList.alternateSplit(2);
        System.out.print("Second list: ");
        secondAlternateSplit.showList();

        LinkedList<Character> alternateSplitMerge = characterLinkedList.mergeList(firstAlternateSplit, secondAlternateSplit);
        System.out.println("Merge the First List and Second List by alternating the nodes");
        alternateSplitMerge.showList();

        System.out.println("Reverse the list. Recursive method in LinkedList");
        characterLinkedList.reverseList(null);
        System.out.println("Reverse the list. Recursive method in tester class");
        reverseList(characterLinkedList, null);
    }

    private void Q3() {
        Course programming = new Course("WXX101", "Programming", 5, 'B');
        Course networking = new Course("WXX201", "Networking", 4, 'C');
        Course operatingSystem = new Course("WXX301", "Operating System", 3, 'A');
        LinkedList<Course> courseLinkedList = new LinkedList<>();
        courseLinkedList.addNode(programming);
        courseLinkedList.addNode(networking);
        courseLinkedList.addNode(operatingSystem);

        System.out.print("The list consist of");
        courseLinkedList.showList();
        int point = 0;
        int credit = 0;
        for (int i = 0; i < courseLinkedList.length(); i++) {
            point += courseLinkedList.get(i).getCreditHours() * courseLinkedList.get(i).getPoint();
            credit += courseLinkedList.get(i).getCreditHours();
        }
        double GPA = point/(credit * 1.0);
        System.out.println("Total point is " + point);
        System.out.println("Total credit is " + credit);
        System.out.println("Grade point average is " + String.format("%.2f", GPA));
    }

    private void Q4() {
        StarList starList = new StarList();
    }

    private void Q5() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addNode("ARS");
        linkedList.addNode("CHE");
        linkedList.addNode("LEI");
        linkedList.addNode("MAN");
        linkedList.addNode("LIV");
        linkedList.addNode("TOT");
        System.out.print("The list contains of ");
        linkedList.showList();
        System.out.println("Remove all the word that contains of the A character using iterator");

        Iterator<String> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            String it = iterator.next();
            if (it.contains("A")) {
                iterator.remove();
            }
        }
        System.out.print("The updated list contains ");
        linkedList.showList();
    }

    private void Q6() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        Random random = new Random();
        int randomNumber;
        System.out.print("The random numbers are : ");
        for (int i = 0; i < 10; i++) {
            randomNumber = random.nextInt(101);
            System.out.print(randomNumber + " ");
            doubleLinkedList.add(randomNumber);
        }
        System.out.println();
        System.out.println("Insert the random numbers into a doubly linked list");
        doubleLinkedList.showList();
        System.out.println("Remove a number from the third position");
        doubleLinkedList.removeAtIndex(2);
        doubleLinkedList.showList();
        System.out.println("Replace the number in seventh position with 999");
        doubleLinkedList.set(6, 999);
        doubleLinkedList.showList();
        System.out.println("Remove all even number from the doubly linked list");
        int number;
        for (int i = 0; i < doubleLinkedList.length(); i++) {
            number = (int) doubleLinkedList.get(i).getData();
            if (number % 2 == 0) {
                doubleLinkedList.removeAtIndex(i);
                i--;
            }
        }
        doubleLinkedList.showList();
    }

    private void Q7() {
        System.out.print("Enter a sentence : ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println();
        String[] words = sentence.split(" ");
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
        for (String word : words) {
            circularLinkedList.addCircularNode(word);
        }
        System.out.println("The words in the circular linked list");
        circularLinkedList.showCircularList();
        System.out.println("After delete a word");
        circularLinkedList.deleteCircularNode();
        circularLinkedList.showCircularList();
        System.out.println("The second item in the list is " + circularLinkedList.getCircularItem(1));
    }

    private void Q8() {
        Music music1 = new Music("Music 1", "music1.mp3");
        Music music2 = new Music("Music 2", "music2.mp3");
        Music music3 = new Music("Music 3", "music3.mp3");
        Music music4 = new Music("Music 4", "music4.mp3");
        CircularLinkedList<Music> musicCircularLinkedList = new CircularLinkedList<>();
        musicCircularLinkedList.addCircularNode(music1);
        musicCircularLinkedList.addCircularNode(music2);
        musicCircularLinkedList.addCircularNode(music3);
        musicCircularLinkedList.addCircularNode(music4);
        Iterator<Music> musicIterator = musicCircularLinkedList.circularLinkedListIterator();

        System.out.println("My Music Playlist");
        Scanner scanner = new Scanner(System.in);
        int input;
        int musicIndex = 0;
        while (true) {
            musicCircularLinkedList.showCircularList();
            System.out.print("1 Play Music | 2 Forward | 3 Backward | 4 Stop | -1 Exit : ");
            input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("Play Music : " + musicCircularLinkedList.getCircularItem(musicIndex));
                    playMusic(musicIterator.next().getFileName());
                    break;
                case 2:
                    if (musicIndex == 3) {
                        musicIndex = 0;
                    } else {
                        musicIndex++;
                    }
                    if (mediaPlayer != null) mediaPlayer.stop();
                    System.out.println("Forward One Position - Play Music : " + musicCircularLinkedList.getCircularItem(musicIndex));
                    playMusic(musicIterator.next().getFileName());
                    break;
                case 3:
                    if (musicIndex == 0) {
                        musicIndex = 3;
                    } else {
                        musicIndex--;
                    }
                    if(mediaPlayer != null) mediaPlayer.stop();
                    System.out.println("Backward One Position - Play Music : " + musicCircularLinkedList.getCircularItem(musicIndex));
                    playMusic(musicCircularLinkedList.getCircularItem(musicIndex).getFileName());
                    break;
                case 4:
                    stopMusic();
                    break;
                default:
                    break;
            }

            if (input == -1) {
                System.out.println("Exit Music Player");
                System.exit(0);
                break;
            }
        }
    }

    JFXPanel panel;
    String paths;
    Media hit;
    MediaPlayer mediaPlayer;

    private void playMusic(String song) {
        panel = new JFXPanel();
        paths = Paths.get(song).toUri().toString();
        hit = new Media(paths);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    private void stopMusic() {
        mediaPlayer.stop();
    }

    public static void reverseList(LinkedList<Character> linkedList, ListNode node) {
        ListNode head = linkedList.getHead();
        if (head.getLink() != null) {
            ListNode newNode = new ListNode(head.getData(), node);
            linkedList.setHead(linkedList.getHead().getLink());
            reverseList(linkedList, newNode);
        } else {
            linkedList.setHead(new ListNode(head.getData(), node)); // last node
            linkedList.showList();
        }
    }
}
