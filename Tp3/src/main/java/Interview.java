public class Interview {

    /**
     * Complexité Temporelle:
     * Pire Cas: O(n) - Dans le pire des cas, nous devrions parcourir le tableau entier pour trouver le non-doublon.
     * Cas Moyen: O(n) - En moyenne, le parcours reste linéaire.
     *
     * Complexité Spatiale:
     * Pire Cas et Cas Moyen: O(1) - Nous utilisons un espace constant quel que soit la taille de l'entrée.
     *
     * @param numbers Liste de nombres triés par ordre croissant contenant 1 non-doublon.
     * @return le nombre non-doublon.
     */
    public static Integer findNonDuplicateIterativeLinear(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        for (int i = 0; i < numbers.length; i += 2) {
            if (i == numbers.length - 1 || !numbers[i].equals(numbers[i + 1])) {
                return numbers[i];
            }
        }
        return null;
    }

    /**
     * Complexité Temporelle:
     * Pire Cas: O(log(n)) - Utilisation d'une approche de recherche binaire pour trouver le non-doublon.
     * Cas Moyen: O(log(n)) - L'approche reste logarithmique en moyenne.
     *
     * Complexité Spatiale:
     * Pire Cas et Cas Moyen: O(1) - Nous utilisons un espace constant.
     *
     * @param numbers Liste de nombres triés par ordre croissant contenant 1 doublon.
     * @return le nombre non-doublon.
     */
    public static Integer findNonDuplicateIterative(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (numbers[mid].equals(numbers[mid + 1])) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return numbers[start];
    }

    /**
     * Complexité Temporelle:
     * Pire Cas: O(log(n)) - Utilisation d'une approche de recherche binaire récursive.
     * Cas Moyen: O(log(n)) - L'approche reste logarithmique en moyenne.
     *
     * Complexité Spatiale:
     * Pire Cas: O(log(n)) - En raison de la pile d'appels récursifs.
     * Cas Moyen: O(log(n)) - La profondeur de l'appel récursif reste logarithmique.
     *
     * @param numbers Liste de nombres triés par ordre croissant contenant 1 non-doublon.
     * @return le nombre non-doublon.
     */
    public static Integer findNonDuplicateRecursive(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        return helperRecursif(numbers, 0, numbers.length - 1);
    }

    private static Integer helperRecursif(Integer[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }

        int mid = start + (end - start) / 2;
        if (mid % 2 == 1) {
            mid--;
        }

        if (numbers[mid].equals(numbers[mid + 1])) {
            return helperRecursif(numbers, mid + 2, end);
        } else {
            return helperRecursif(numbers, start, mid);
        }
    }
}
