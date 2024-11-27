package htw.berlin.wi.prog2.service.parsing;

import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {

        Map<Long, Integer> result = new java.util.HashMap<>(Map.of());
        //entfernt Satzzeichen & Split in Wörter
        String[] words = inputLine.replaceAll("[,.-]", " ").split("\\s+");
        //zählt Schlüsselwörter
        for (String word : words) {
            if (keywordsToIds.containsKey(word)) {
                Long id = keywordsToIds.get(word);
                result.put(id, result.getOrDefault(id, 0) + 1);
            }
        }
        return result;
    }
}
