/**
 * Fraction class
 * CNAM MILLAU 2023
 * CAI-SI 03
 * Pas de copyright ni copyleft
 * @author BBE
 */
package fraction;

/**
 * Nombres rationnels pour coder le corps des fractions (Q, +, x)
 * Avec les limitations liées au caractère fini des nombres flottants.
 * <p>
 *     Attentions :
 *     Les dépassements de capacité de l'arithmétique entière
 *     en complément à 2, 32 bits, seront de mise dans les opérations
 *     arithmétiques rationnelles.
 * </p>
 * @author BBE
 */
public class Fraction extends Number implements Comparable<Fraction> {

    /** Numéro de version d'état d'instance de compatibilité de serialisation */
    private static final long serialVersionUID = 1L;

    /** Numérateur porte le signe */
    private final int numerateur;

    /** Dénominateur strictement positif */
    private final int denominateur;

    /** Fraction irréductible de cette fraction */
    private final Fraction irreductible = null;

    /**
     * Constructeur de fraction
     * @param numerateur
     * @param denominateur
     */
    public Fraction(int numerateur, int denominateur) {
        // Vérifications des arguments
        if (denominateur == 0) {
            throw new IllegalArgumentException("Le dénominateur ne peut être nul");
        }
        // Vérifications des limites
        if (numerateur == Integer.MIN_VALUE || denominateur == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("MIN_VALUE non autorisé");
        }

        // "Fraction nulle" : Classe singleton
        if (numerateur == 0) {
            this.numerateur = 0;
            this.denominateur = 1;
        // Reporter le signe sur le numérateur
        } else if (denominateur < 0) {
            this.numerateur = -numerateur;
            this.denominateur = -denominateur;
        } else {
            this.numerateur = numerateur;
            this.denominateur = denominateur;
        }
        // Simplification de la fraction :
        setIrreductible(this.numerateur, this.denominateur);
    }

    /**
     * Convertisseur int --> Fraction aConvertir/1
     * @param aConvertir entier (numérateur)
     * @throws IllegalArgumentException si numerateur ou denominateur = à Integer.MIN_VALUE
     */
    public Fraction(int aConvertir) {
        this.numerateur = aConvertir;
        this.denominateur = 1;
    }

    /**
     * Retourne le numérateur
     * @return numerateur (int)
     */
    public int getNumerateur() {
        return this.numerateur;
    }

    /**
     * Retourne le dénominateur
     * @return denominateur (int)
     */
    public int getDenominateur() {
        return this.denominateur;
    }

    /**
     * Fraction irréductible identifiant la classe d'équivalence de this
     * <p>
     *     Une fraction est irréductible si son PGCD (numerateur, denominateur) est égal à 1.
     * </p>
     * @return Fraction irréductible (this si déjà irréductible)
     */
    public Fraction getIrreductible() { return this.irreductible;}

    /**
     * Retourne une fraction irreductible de la fraction
     */
    private Fraction setIrreductible(int numerateur, int denominateur) {
        int pgcd = ArithmetiqueEntiere.pgcd(numerateur, denominateur);
        return new Fraction(numerateur / pgcd, denominateur / pgcd);
    }

    /** @return oppose de cette fraction */
    public Fraction oppose() {
        return new Fraction(-this.numerateur, this.denominateur);
    }

    /**
     * Réciproque de this pour loi multiplicative si this non nulle
     * @return inverse de cette fraction
     * @throws ArithmeticException si this est nulle
     */
    public Fraction inverse() {
        if (this.numerateur == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        return new Fraction(this.denominateur, this.numerateur);
    }

    /**
     * Somme arithmétique de a et b (commutatif)
     * @param a opérande gauche à ajouter à b
     * @param b opérande droit à ajouter à a
     * @return la fraction somme irréductible
     */
    public static Fraction somme(Fraction a, Fraction b) {
        int numerateur = a.numerateur * b.denominateur + b.numerateur * a.denominateur;
        int denominateur = a.denominateur * b.denominateur;
        return new Fraction(numerateur, denominateur).setIrreductible(numerateur, denominateur);
    }

    /**
     * Différence arithmétique de a et b
     * @param a opérande gauche dont est soustrait b
     * @param b opérande droit à soustraire à a
     * @return la fraction a-b irréductible
     */
    public static Fraction difference(Fraction a, Fraction b) {
        int numerateur = a.numerateur * b.denominateur - b.numerateur * a.denominateur;
        int denominateur = a.denominateur * b.denominateur;
        return new Fraction(numerateur, denominateur).setIrreductible(numerateur, denominateur);
    }

    /**
     * Multiplication arithmétique de a et b  (commutatif)
     * @param a multiplicande
     * @param b multiplicateur
     * @return la fraction a x b irréductible
     */
    public static Fraction produit(Fraction a, Fraction b) {
        int numerateur = a.numerateur * b.numerateur;
        int denominateur = a.denominateur * b.denominateur;
        return new Fraction(numerateur, denominateur).setIrreductible(numerateur, denominateur);
    }

    /**
     * Multiplication arithmétique de a et b  (commutatif)
     * @param a dividende
     * @param b diviseur non nul
     * @return la fraction a / b irréductible si b non nul
     * @throws ArithmeticException si diviseur b est nul
     */
    public static Fraction quotient(Fraction a, Fraction b) {
        if (b.numerateur == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        int numerateur = a.numerateur * b.denominateur;
        int denominateur = a.denominateur * b.numerateur;
        return new Fraction(numerateur, denominateur).setIrreductible(numerateur, denominateur);
    }

    /**
     * Relation fondée sur classe d'équivalence d'une fraction irréductible :
     * this et autre sont équivalentes si elles sont dans la même classe
     * d'équivalence
     * @param autre rationnel à comparer avec this
     * @return true si this et autre sont équivalentes, false sinon
     */
    public boolean isEquivalente(Fraction autre) {
        if (this.equals(autre)) {
            return true;
        }
        if (autre == null) {
            return false;
        }
        if (getClass() != autre.getClass()) {
            return false;
        }
        if (denominateur != ((Fraction) autre).denominateur) {
            return false;
        }
        return numerateur == ((Fraction) autre).numerateur;
    }

    /**
     * non javadoc
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Fraction o) {
        int num = this.numerateur * o.denominateur;
        int den = this.denominateur * o.numerateur;
        return num - den;
    }

    /**
     * non javadoc
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Fraction other = (Fraction) obj;
        if (denominateur != other.denominateur) {
            return false;
        }
        if (numerateur != other.numerateur) {
            return false;
        }
        return true;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return "Fraction [numer=" + numerateur + ", denom=" + denominateur + "]";
    }

    /**
     * non javaDoc
     * @see java.lang.Number#intValue()
     */
    @Override
    public int intValue() {
        return 0;
    }

    /**
     * non javaDoc
     * @see java.lang.Number#longValue()
     */
    @Override
    public long longValue() {
        return 0;
    }

    /**
     * non javaDoc
     * @see java.lang.Number#floatValue()
     */
    @Override
    public float floatValue() {
        return 0;
    }

    /**
     * non javaDoc
     * @see java.lang.Number#doubleValue()
     */
    @Override
    public double doubleValue() {
        return 0;
    }
}
