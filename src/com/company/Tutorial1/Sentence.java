package com.company.Tutorial1;

public class Sentence {

    String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    private int getLength() {
        return sentence.length();
    }

    private int getVowelsCount() {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u') count++;
        }
        return count;
    }

    private int getWordCount() {
        String[] split = sentence.split(" ");
        return split.length;
    }

    public void show() {
        System.out.println("The sentence is : " + sentence);
        System.out.println("The length of the sentence : " + getLength());
        System.out.println("The number of vowels : " + getVowelsCount());
        System.out.println("The number of words : " + getWordCount());
    }
}
