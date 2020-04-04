package com.wordfinder.api;

import java.util.List;

import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Interface for all dictionaries, be them text file dictionaries, or perhaps
 * databases in the future.
 */
public interface Dictionary {

	/**
	 * Get every single word in the dictionary as a List of Strings.
	 * 
	 * @return {@link List} of {@link String} objects for every single word in the
	 *         dictionary.
	 * @throws WordFinderDictionaryException when there is an issue retrieving all
	 *                                       words
	 */
	List<String> getAllWords() throws WordFinderDictionaryException;

}
