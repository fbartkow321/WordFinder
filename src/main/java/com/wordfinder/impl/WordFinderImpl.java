package com.wordfinder.impl;

import java.util.List;

import com.wordfinder.api.Dictionary;
import com.wordfinder.api.WordFinder;
import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Default implementation of the {@link WordFinder} interface.
 */
public class WordFinderImpl implements WordFinder {

	public static final String ANY_LETTER_REGEX = "[a-zA-Z]*";

	private Dictionary dictionary = new TextFileDictionary();

	@Override
	public List<String> findWordsWithLettersInOrder(String lettersInOrder) throws WordFinderDictionaryException {
		String regexForLetters = convertLettersToRegex(lettersInOrder);
		return dictionary.getAllMatchingWords(regexForLetters);
	}

	@Override
	public List<String> findLargestWordsWithLettersInOrder(String lettersInOrder) throws WordFinderDictionaryException {
		String regexForLetters = convertLettersToRegex(lettersInOrder);
		return dictionary.getLargestMatchingWords(regexForLetters);
	}

	/**
	 * Given a String of letters, this will build a new regular expression String
	 * that can be used to find words containing the letters in their original
	 * order.
	 * 
	 * @param letters {@link String} of the letters that will be converted to
	 *                regular expression
	 * @return {@link String} of the regular expression that can be used to find
	 *         words containing the given letters in their original order
	 */
	protected String convertLettersToRegex(String letters) {
		StringBuilder regexBuilder = new StringBuilder(ANY_LETTER_REGEX);
		for (char c : letters.toCharArray()) {
			regexBuilder.append(c);
			regexBuilder.append(ANY_LETTER_REGEX);
		}
		return regexBuilder.toString();
	}

	@Override
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
}
