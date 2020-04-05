package com.wordfinder.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.wordfinder.api.WordFinder;
import com.wordfinder.exception.WordFinderDictionaryException;
import com.wordfinder.impl.TextFileDictionary;
import com.wordfinder.impl.WordFinderImpl;

/**
 * Houses the main method to kick off the whole thing.
 */
public class WordFinderRunner {

	public static final String EXIT = "exit";
	public static final String TEXT = "text";
	public static final String ALL = "all";
	public static final String LARGE = "large";
	public static final String SPACE = " ";
	public static final List<String> DICTIONARY_TYPES = Arrays.asList(TEXT);
	public static final List<String> SEARCH_TYPES = Arrays.asList(ALL, LARGE);

	/**
	 * Standard main method to kick off the process.
	 * 
	 * @param args Array of {@link String} objects passed in as arguments
	 */
	public static void main(String[] args) {
		WordFinder wordFinder = new WordFinderImpl();

		Scanner scanner = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("!!!Welcome to the Word Finder!!!");
		System.out.println("******************************************************");
		System.out.println();
		System.out.println(
				"The whole point of this program is to find words containing provided letters in the order the letters are provided, with any number of letters between each of the provided letters.");
		System.out.println(
				"If at any point you'd like to quit, type 'exit' for an input (except for when asking for letters).");
		System.out.println();

		StringBuilder acceptedDictionaryTypesBuilder = new StringBuilder();
		for (String acceptedDictionaryType : DICTIONARY_TYPES) {
			acceptedDictionaryTypesBuilder.append(acceptedDictionaryType);
			acceptedDictionaryTypesBuilder.append(SPACE);
		}
		String acceptedDictionaryTypes = acceptedDictionaryTypesBuilder.substring(0,
				acceptedDictionaryTypesBuilder.length() - 1);
		System.out.print(
				"Which dictionary would you like to use (options currently are - " + acceptedDictionaryTypes + "): ");
		String dictionaryType = scanner.next();
		System.out.println();
		while (!DICTIONARY_TYPES.contains(dictionaryType) && !EXIT.equals(dictionaryType)) {
			System.out.println("You've submitted " + dictionaryType + " as your dictionary type, which is invalid.");
			System.out.println("Which dictionary would you like to use (options currently are - "
					+ acceptedDictionaryTypes + "): ");
			dictionaryType = scanner.next();
		}

		if (EXIT.equals(dictionaryType)) {
			scanner.close();
			return;
		}

		if (TEXT.equals(dictionaryType)) {
			wordFinder.setDictionary(new TextFileDictionary());
		}

		System.out.print(
				"Would you like to find all of the words, or the largest words containing your letters (all or large): ");
		String allWordsOrLargestWords = scanner.next();
		while (!SEARCH_TYPES.contains(allWordsOrLargestWords) && !EXIT.equals(allWordsOrLargestWords)) {
			System.out.println("You've submitted " + allWordsOrLargestWords + ", which is invalid.");
			System.out.print(
					"Would you like to find all of the words, or the largest words containing your letters (all or large): ");
			allWordsOrLargestWords = scanner.next();
		}

		if (EXIT.equals(allWordsOrLargestWords)) {
			scanner.close();
			return;
		}

		List<String> words = null;
		System.out.println();
		if (ALL.equals(allWordsOrLargestWords)) {
			System.out.print("Which set of letters would you like to find all of the words for: ");
			String letters = scanner.next();
			try {
				words = wordFinder.findWordsWithLettersInOrder(letters);
			} catch (WordFinderDictionaryException e) {
				e.printStackTrace();
			} finally {
				scanner.close();
			}
		} else if (LARGE.equals(allWordsOrLargestWords)) {
			System.out.print("Which set of letters would you like to find the largest words for: ");
			String letters = scanner.next();
			try {
				words = wordFinder.findLargestWordsWithLettersInOrder(letters);
			} catch (WordFinderDictionaryException e) {
				e.printStackTrace();
			} finally {
				scanner.close();
			}
		}

		System.out.println();
		if (words.isEmpty()) {
			System.out.println("There are no words in our dictionaries that contain those letters in that order.");
		} else {
			System.out.println("Here are all of the words we could find that contain those letters in that order:");
			System.out.println();
			for (String word : words) {
				System.out.println(word);
			}
		}

		System.out.println();
		System.out.println("******************************************************");
		System.out.println("!!!Thank you for using the Word Finder!!!");
		System.out.println("******************************************************");
	}

}
