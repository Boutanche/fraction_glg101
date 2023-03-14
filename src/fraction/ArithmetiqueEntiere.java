/*
 * ArithmetiqueEntiere.java
 * CNAM MILLAU 2023
 * CAI-SI 03
 * Pas de copyright ni copyleft
 * @author BBE
 */
package fraction;

/**
 * Arithmetique entière
 * Classe utilitaire ("utility")
 * Outils d'arithmétique entière pour les fractions
 * pgcd, ppcm, simplification, ...
 * @author BBE
 */
public class ArithmetiqueEntiere {
    /**
     * Private constructor to prevent instantiation
     */
    private ArithmetiqueEntiere() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Plus Grand Commun Diviseur de 2 entiers (donc diviseur positif ou nul !)
     * <p>
     * Propriétés :
     * <ul>
     *     <li>quelque soient a,b entiers signés, pgcd(a, b) = pgcd(|a|, |b|)
     *     sauf MIN_VALUE</li>
     *     <li>quelque soit a entier naturel, pgcd(a, 0) = pgcd(0, a) =
     *     avec pgcd(0, 0) = 0 </li>
     *      <li>quelque soient a,b entiers naturels, pgcd(a, b) = pgcd(b, a)
     *      sauf MIN_VALUE</li>
     *      <li>quelque soient a,b entiers naturels pgcd(a ,b) = pgcd(b, a mod b) "Euclide"
     *      qui induit l'algorithme d'Euclide utilisé</li>
     * </ul>
     * @param a premier entier dont on veut le diviseur commun avec b
     * @param b deuxième entier dont on veut le diviseur commun avec a
     * @return <ul>
     *              <li>0 si a et b sont nul : pgcd(0,0) = 0 par convention</li>
     *              <li>pgcd si il existe</li>
     *         </ul>
     * @throws IllegalArgumentException si a ou b est Long.MIN_VALUE
     */
    public static long pgcd(long a, long b) {
        // TODO écrire l'algo en TDD
        return 1L;  // stub
    }

    /**
     * Plus Grand Commun Diviseur de 2 entiers (donc diviseur positif ou nul !)
     * <p>
     * Propriétés : <ul>
     *      <li>quelque soient a,b entiers signés, pgcd(a, b) = pgcd(|a|, |b|)
     *      sauf MIN_VALUE</li>
     *      <li>quelque soit a entier naturel, pgcd(a, 0) = pgcd(0, a) = a
     *      avec pgcd(0, 0) = 0 </li>
     *      <li>quelque soient a,b entiers naturels, pgcd(a, b) = pgcd(b, a)
     *      sauf MIN_VALUE</li>
     *      <li>quelque soient a,b entiers naturels pgcd(a ,b) = pgcd(b, a mod b) "Euclide"
     *      qui induit l'algorithme d'Euclide utilisé
     * </li>
     * </ul>
     * @param a premier entier dont on veut le diviseur commun avec b
     * @param b deuxième entier dont on veut le diviseur commun avec a
     * @return <ul><li>0 si a et b sont nul : pgcd(0,0) = 0 par convention</li>
     *             <li>pgcd si il existe</li>
     *         </ul>
     * @throws IllegalArgumentException si a ou b est Integer.MIN_VALUE
     */
    public static int pgcd(int a, int b) {
        // TODO écrire l'algo en TDD
        return 1;  // stub
    }

    /**
     * Plus Petit Commun Multiple positif ou nul de 2 entiers
     * <p>
     * Propriétés :
     * <ul>
     *      <li>qqsoient a,b entiers signés, ppcm(a, b) = ppcm(|a|, |b|)
     *      sauf MIN_VALUE</li>
     *      <li>ppcm(0, 0) = 0 </li>
     *      <li>qqsoient a,b entiers naturels, ppcm(a, b) = ppcm(b, a)
     *      sauf MIN_VALUE</li>
     *      <li>qqsoient a,b entiers naturels
     *      pgcd(a, b) * ppcm(a, b) = |a x b| "Euclide"
     *      qui induit l'algorithme utilisé
     *      </li>
     * </ul>
     * @param a premier entier dont on veut le + petit multiple commun avec b
     * @param b deuxième entier dont on veut le + petit multiple commun avec a
     * @return <ul>
     *              <li>0 si a et b sont nul : ppcm(0,0) = 0 par convention</li>
     *             <li>ppcm si il existe</li>
     *         </ul>
     * @throws IllegalArgumentException si a ou b est Long.MIN_VALUE
     */
    public static long ppcm(long a, long b) {
        // TODO écrire l'algo en TDD
        return 1L;  // stub
    }

    /**
     * Plus Petit Commun Multiple positif ou nul de 2 entiers
     * <p>
     * Propriétés :
     * <ul>
     *      <li>qqsoient a,b entiers signés, ppcm(a, b) = ppcm(|a|, |b|)
     *      sauf MIN_VALUE</li>
     *      <li>ppcm(0, 0) = 0 </li>
     *      <li>qqsoient a,b entiers naturels, ppcm(a, b) = ppcm(b, a)
     *      sauf MIN_VALUE</li>
     *      <li>qqsoient a,b entiers naturels
     *      pgcd(a, b) * ppcm(a, b) = |a x b| "Euclide"
     *      qui induit l'algorithme utilisé
     *      </li>
     * </ul>
     * @param a premier entier dont on veut le + petit multiple commun avec b
     * @param b deuxième entier dont on veut le + petit multiple commun avec a
     * @return <ul>
     *              <li>0 si a et b sont nul : ppcm(0,0) = 0 par convention</li>
     *             <li>ppcm si il existe</li>
     *         </ul>
     * @throws IllegalArgumentException si a ou b est Integer.MIN_VALUE
     */
    public static int ppcm(int a, int b) {
        // TODO écrire l'algo en TDD
        return 1;  // stub
    }
}
