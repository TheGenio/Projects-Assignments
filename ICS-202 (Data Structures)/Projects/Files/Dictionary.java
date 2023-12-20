package LabProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class WordAlreadyExistsException extends Exception {
        public WordAlreadyExistsException() {
        }
    }
    class WordNotFoundException extends Exception {
    public WordNotFoundException() {
        super();
    }}





public class Dictionary {
    //main method to open a dictionary with choices
    public static void main(String[] args){

            System.out.println("Welcome to your dictionary intilizer");
            Scanner scanner = new Scanner(System.in);
            while(true){

                System.out.println("Would you like to load a file? (y/n): ");
                String choice = scanner.next();

                if(choice.equals("y")){
                    try {
                        System.out.println("Enter filename> ");
                        String fname = scanner.next();
                        File file = new File("/Users/genio/Desktop/231-ICS202-Labproject-description/" + fname);
                        Dictionary test = new Dictionary(file);

                    while (true){
                        System.out.println("What would you like to do? \n (1) Find a word into the dictionary \n (2) Add a word into the dictionary \n (3) Remove a word from the dictionary \n (4) search for similar words to a word in the dictionary \n (5) Save and exit");
                        choice = scanner.next();
                        //Swtich case for each of the choices
                        switch (choice) {
                            case "1":
                                System.out.println("check word> ");
                                String wordToFind = scanner.next();

                                if(test.findWord(wordToFind)){
                                    System.out.println("found word");
                                }else{
                                    System.out.println("word not found.");
                                }
                                break;

                            case "2":
                                try {
                                    System.out.println("add new word> ");
                                    String wordToAdd = scanner.next();
                                    test.addWord(wordToAdd);
                                    break;
                                }catch (WordAlreadyExistsException e) {
                                    System.out.println("Word already exists" + e.getMessage());
                                }
                                break;


                            case "3":
                                try {
                                    System.out.println("Enter the word to remove:");
                                    String wordToRemove = scanner.next();
                                    test.deleteWord(wordToRemove);
                                    break;
                                } catch (WordNotFoundException e){
                                    System.out.println("Word not found" + e.getMessage());
                                }
                                break;


                            case "4":
                                System.out.println("Enter the word to search for similar words:");
                                String wordToSearch = scanner.next();
                                System.out.println(Arrays.toString(test.findSimilar(wordToSearch)));
                                break;


                            case "5":
                                while (true) {
                                    System.out.println("Save Updated Dictionary (Y/N)> ");
                                    choice = scanner.next().toLowerCase();
                                    if (choice.equals("y")) {
                                        System.out.println("Enter filename> ");
                                        String filenameNEW = scanner.next();
                                        test.saveToFile(filenameNEW);
                                        break;
                                    } else if (choice.equals("n")) {
                                        System.out.println("Thank you for using the program");
                                        System.exit(0);
                                    } else {
                                        System.out.println("Enter correct choice");
                                    }
                                }


                                break;

                            default:
                                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                                break;
                        }

                    }
                    //try here
                    }catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }

                } else if (choice.equals("n")){
                    break;
                }else{
                    System.out.println("Invalid choice");
                }
                //end if

            }

    }


// 3 constructors for the dictonary. No words, one word, or file
    AVLTree<String> words;
    public Dictionary(){
        words = new AVLTree<>();
    };

    public Dictionary(String s){
        this();
        words.insertAVL(s);
    }

        public Dictionary(File file) {
        this();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!words.isInTree(word)) {
                    words.insertAVL(word);
                }
            }
            System.out.println("dictionary loaded successfully.");
        } catch (IOException e) {
            throw new RuntimeException("dictionary not loaded successfully " + file, e);
        }
    }

    //This method checks if the word is already in the dictionary, if it is it will throw an exception
    public void addWord(String s) throws WordAlreadyExistsException {
        if(words.isInTree(s)){
            throw new WordAlreadyExistsException();
        }else {
            words.insertAVL(s);
            System.out.println("word added successfully.");
        }
    }

    //this method checks if the word is in the dictionary or not
    public boolean findWord(String s) {
        return words.isInTree(s);
    }

    //This method checks if the word is in the dictionary, if it is it will delete it. If it isnt it will throw an exception
    public void deleteWord(String s) throws WordNotFoundException {
        if(!words.isInTree(s)){
            throw new WordNotFoundException();
        }else {
            words.deleteAVL(s);
            System.out.println("word deleted successfully");
        }
    }

    //this methods will find similar words to the word given
    public String[] findSimilar(String s) {
        String[] result = new String[26 * (s.length()+1)]; //create an array of strins for all possible out comes
        int index = 0;

        //check for missing letters. For example if the word is pointer. This method will find words like pinter and ponter etc.
        String[] miss = missingletter(s); //creates an array of all possible words with missing letters
            for (String combo : miss) { //for loop to check if the words actually exist in the dict
                    if (findWord(combo)) {
                        result[index++] = combo;
                    }
            }

        //check for different spellings. For example if the word is pointer. This will check for printer, puinter etc.
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.charAt(i) != c) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, c);
                    String candidate = sb.toString();
                    if (findWord(candidate)) {
                        result[index++] = candidate;
                    }
                }
            }
        }
        //check for extra letter at the end and begining. For example if the word is pointer. This will find words like pointers, pointerx etc
        for (char firstLetter = 'a'; firstLetter <= 'z'; firstLetter++) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(0, firstLetter);
            String candidate = sb.toString();
            if (findWord(candidate)) {
                result[index++] = candidate;
            }
        }
        for (char lastLetter = 'a'; lastLetter <= 'z'; lastLetter++) {
            StringBuilder sb = new StringBuilder(s+1);
            sb.setCharAt(s.length(), lastLetter);
            String candidate = sb.toString();
            if (findWord(candidate)) {
                result[index++] = candidate;
            }
        }

        return Arrays.copyOf(result, index);
}

    //helper method for findSimilar() method. This will return an array of strings with all possible missing letter combos
    public static String[] missingletter(String word) {
        String[] combos = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            StringBuilder comboBuilder = new StringBuilder();
            comboBuilder.append(word, 0, i).append(word, i + 1, word.length());
            combos[i] = comboBuilder.toString();
        }
        return combos;
    }

    //this method will save the dictonary to a new fiole
    public void saveToFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/genio/Desktop/231-ICS202-Labproject-description/" + filename ))) {
        writer.write(words.breadthFirst());
        System.out.println("Dictionary saved successfully ");
    } catch (IOException e) {
        System.out.println("Error saving dictionary to file: " + e.getMessage());
    }
    }


}




