import java.util.*;
import java.util.HashMap;

public final class Interview {
    public static Pair findMostCommonValidWord(String phrase, String[] stopwords) {
            // Convert the phrase and stopwords to lowercase to make the algorithm case-insensitive
            phrase = phrase.toLowerCase();
            List<String> lowercaseStopwords = Arrays.asList(Arrays.stream(stopwords)
                    .map(String::toLowerCase)
                    .toArray(String[]::new));

            // Split the phrase into words
            String[] words = phrase.split("\\s+");

            // Create a map to store the word frequency
            HashMap<String, Integer> wordFrequency = new HashMap<>();

            // Initialize variables to keep track of the most common word and its frequency
            String mostCommonWord = null;
            int maxFrequency = 0;

            // Check if the input phrase is empty
            if (phrase.isEmpty()) {
                return new Pair(null, null);
            }

            // Iterate through the words
            for (String word : words) {
                // Check if the word is a stop word (case-insensitive)
                if (!lowercaseStopwords.contains(word)) {
                    // Update the word frequency
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);

                    // Check if the current word has a higher frequency than the current most common word
                    if (wordFrequency.get(word) > maxFrequency ||
                            (wordFrequency.get(word) == maxFrequency && word.compareToIgnoreCase(mostCommonWord) < 0)) {
                        mostCommonWord = word;
                        maxFrequency = wordFrequency.get(word);
                    }
                }
            }

            // Check if there is a valid most common word
            if (mostCommonWord != null) {
                return new Pair(mostCommonWord, maxFrequency);
            } else {
                // If no valid word is found, return null
                return new Pair(null, null);
            }
        }
}

/** Expliquez votre complexité temporelle et spatiale à l'aide de commentaire dans le code
 *  n représente le nombre de charactère de `phrase` et m le nombre de charactère de `stopwords`
 *  Indiquez les équivalences telles que O(n + 1 + m + 1) => O(n+m) et O(2n+3m) => O(n+m) lorsque possible
 *
 ** TODO Justify Time Complexity  : Average Case O(n+m)
 ** TODO Justify Space Complexity : Worst Case O(n+m)
 *
 * @param phrase String containing a sequence of words separated by a space
 * @param stopwords String array containing all the stop words
 * @return Pair containing two elements, first being the most common word not in the stop words,
 * second being the number of occurences of this word
 */
/*Le code fourni réalise une analyse de la phrase d'entrée pour trouver le mot le plus courant qui n'est pas un mot stop (mots à ignorer).
Pour ce faire, le code divise d'abord la phrase en mots en la séparant selon les espaces, ce qui prend O(n) de temps, où n est le nombre de caractères dans la phrase.
Ensuite, le code itère sur chaque mot, le convertit en minuscules (pour assurer la sensibilité à la casse) et vérifie s'il est présent dans la liste des mots stop,
ce qui nécessite une opération de recherche qui prend O(m) de temps, où m est la somme des longueurs de tous les mots stop. Pour chaque mot non stop,
le code met à jour un dictionnaire (HashMap) contenant la fréquence de chaque mot, ce qui prend également O(n+m) de temps dans le pire des cas.
Enfin, le code détermine le mot le plus courant en parcourant le dictionnaire, ce qui prend O(n+m) de temps dans le pire des cas.
Par conséquent, la complexité temporelle totale du code est en moyenne O(n+m).


En ce qui concerne la complexité spatiale, le code utilise une structure de données supplémentaire, à savoir un dictionnaire pour stocker la fréquence des mots dans la phrase.
La taille de ce dictionnaire dépend du nombre de mots uniques dans la phrase, ce qui peut aller jusqu'à n+m dans le pire des cas (si chaque mot de la phrase est unique et n'est pas un mot stop).
Par conséquent, la complexité spatiale totale est également en O(n+m) dans le pire des cas.

 */