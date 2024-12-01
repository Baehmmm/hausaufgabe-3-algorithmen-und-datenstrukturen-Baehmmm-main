package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class TypoTolerantInputParser implements ExtendableInputParser {

    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> result = new HashMap<>();

        // Split the input string into words (consider punctuation and whitespace)
        String[] words = inputLine.split("\\s+|,|\\.");

        for (String word : words) {
            // Clean the word by trimming and removing unwanted characters
            String cleanedWord = word.trim();

            // Check if the cleaned word is in the keywords map
            if (keywordsToIds.containsKey(cleanedWord)) {
                Long id = keywordsToIds.get(cleanedWord);
                // Increment the count for the corresponding ID
                result.put(id, result.getOrDefault(id, 0) + 1);
            }
        }

        return result;
    }
}
