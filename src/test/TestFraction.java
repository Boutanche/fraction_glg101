/**
 * TestFraction.java
 * CNAM MILLAU 2023
 * CAI-SI 03
 * Pas de copyright ni copyleft
 * @author BBE
 */
package test;

import fraction.Fraction;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de la classe Fraction
 * @author BBE
 */
public class TestFraction {

    /**
     * Tests fixtures
     */
    private final int[] NUMERATEUR_NEGATIF = {
            Integer.MIN_VALUE +1, -500000, -1
    };

    private final int[] NUMERATEUR_POSITIF = {
            1, 500000, Integer.MAX_VALUE
    };

    private final int[] DENOMINATEUR_NEGATIF = {
            Integer.MIN_VALUE +1, -500000, -1
    };

    private final int[] DENOMINATEUR_POSITIF = {
            1, 500000, Integer.MAX_VALUE
    };

    /*
     * Plan de tests pour constructeurs d'état :
     *
     *   ____________________________________________________________________
     *   | numérateur    | MIN_VALUE |  NUMER_NEGATIF  |  0  | NUMER_POSITIF |
     *   |---------------|-----------|-----------------|-----|---------------|
     *   | dénominateur  |-----------|-----------------|-----|---------------|
     *   |_______________|___________|_________________|_____|_______________|
     *   | MIN_VALUE     | IAE       |        IAE      | IAE |       IAE     |
     *   |_______________|___________|_________________|_____|_______________|
     *   | DENOM_NEGATIF | IAE       |        NN       |  Z0 |       PN      |
     *   |_______________|___________|_________________|_____|_______________|
     *   |      0        | AE        |        AE       |  AE |       AE      |
     *   |_______________|___________|_________________|_____|_______________|
     *   |      1        | IAE       |   FractionInt   |  Z0 |  FractionInt  |
     *   |_______________|___________|_________________|_____|_______________|
     *   | DENOM_POSITIF | IAE       |       NP        |  Z0 |               |
     *   |_______________|___________|_________________|_____|_______________|
     *
     *   IAE = IllegalArgumentException
     *   AE  = ArithmeticException
     *   FractionInt = cas d'une fraction avec dénominateur unité
     *   Z0 = Fraction nulle
     *   NN = numérateur < 0 et dénominateur < 0 => fraction positive
     *   PN = numérateur > 0 et dénominateur < 0 => report du signe
     *   PN = numérateur < 0 et dénominateur > 0 => affectation directe
     *   PP = numérateur > 0 et dénominateur > 0 => affectation directe
     */

    /* Fixture de test rationnel */
    List<Fraction> fixture = new ArrayList<>();

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("BeforeAll");
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("AfterAll");
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        System.out.println("BeforeEach");
        /*  0 */  fixture.add(new Fraction(0));                 //    0
        /*  1 */  fixture.add(new Fraction(-1));                //   -1/1
        /*  2 */  fixture.add(new Fraction(1));                 //    1/1
        /*  3 */  fixture.add(new Fraction(2));                 //    2/1
        /*  3 */  fixture.add(new Fraction(1, 2));              //    1/2
        /* TODO à compléter */
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        System.out.println("AfterEach");
        fixture.clear();
    }

    /**
     * Test method for {
     *     @link glg101.si03.mathematiques.Fraction#Fraction(int, int)
     * }.
     */
    @Test
    void testFractionIntIntEchec() {

        for (int numer : NUMERATEUR_NEGATIF) {
            assertThrows(ArithmeticException.class,                   // #AE#
                    ()->new Fraction(numer, 0));
            assertThrows(IllegalArgumentException.class,              // #IAE#
                    ()->new Fraction(numer, Integer.MIN_VALUE));
        }

        assertThrows(ArithmeticException.class,                        // #AE#
                ()->new Fraction(0, 0));

        assertThrows(IllegalArgumentException.class,                   // #IAE
                ()->new Fraction(0, Integer.MIN_VALUE));

        assertThrows(IllegalArgumentException.class,                   // #IAE#
                ()->new Fraction(Integer.MIN_VALUE, Integer.MIN_VALUE));

        for (int numer : NUMERATEUR_POSITIF) {
            assertThrows(ArithmeticException.class,                    // #AE#
                    ()->new Fraction(numer, 0));
            assertThrows(IllegalArgumentException.class,               // #IAE#
                    ()->new Fraction(numer, Integer.MIN_VALUE));
        }

    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#Fraction(int, int)}.
     */
    @Test
    void testFractionIntIntOk() {

        /* cas Z0 */
        Fraction zero = new Fraction(0, 1);
        assertEquals(0, zero.getNumerateur());
        assertEquals(1, zero.getDenominateur());

        /* cas NP et PP */
        for (int denom : DENOMINATEUR_POSITIF) {
            for (int numer : NUMERATEUR_NEGATIF) {  // cas #NP#
                Fraction nouvelle = new Fraction(numer, denom);
                assertEquals(numer, nouvelle.getNumerateur());
                assertEquals(denom, nouvelle.getDenominateur());
            }

            for (int numer : NUMERATEUR_POSITIF) { // cas #PP#
                Fraction nouvelle = new Fraction(numer, denom);
                assertEquals(numer, nouvelle.getNumerateur());
                assertEquals(denom, nouvelle.getDenominateur());
            }
        }

        /* cas #FractionInt# négatif */
        for (int numer : NUMERATEUR_NEGATIF) {
            Fraction nouvelle = new Fraction(numer, 1);
            assertEquals(numer, nouvelle.getNumerateur());
            assertEquals(1, nouvelle.getDenominateur());
        }

        /* cas #FractionInt# positif */
        for (int numer : NUMERATEUR_POSITIF) {
            Fraction nouvelle = new Fraction(numer, 1);
            assertEquals(numer, nouvelle.getNumerateur());
            assertEquals(1, nouvelle.getDenominateur());
        }

        /* cas #Z0# */
        for (int denom : DENOMINATEUR_NEGATIF) {
            Fraction nulle = new Fraction(0, denom);
            assertEquals(0, nulle.getNumerateur());
            assertEquals(1, nulle.getDenominateur());
        }

        /* cas #Z0# */
        for (int denom : DENOMINATEUR_POSITIF) {
            Fraction nulle = new Fraction(0, denom);
            assertEquals(0, nulle.getNumerateur());
            assertEquals(1, nulle.getDenominateur());
        }

        /* cas #NN# */
        for (int denom : DENOMINATEUR_NEGATIF) {
            for (int numer : NUMERATEUR_NEGATIF) {
                Fraction positive = new Fraction(numer, denom);
                assertEquals(Math.abs(numer), positive.getNumerateur());
                assertEquals(Math.abs(denom), positive.getDenominateur());
                assertTrue(positive.getDenominateur() > 0);
            }
        }

        /* cas #PN# */
        for (int numer : NUMERATEUR_POSITIF) {
            for (int denom : DENOMINATEUR_NEGATIF) {
                Fraction negative = new Fraction(numer, denom);
                assertEquals(-numer, negative.getNumerateur());
                assertEquals(-denom, negative.getDenominateur());
                assertTrue(negative.getDenominateur() > 0);
            }
        }

    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#Fraction(int)}.
     * pour les cas en échec (IllegalArgumentException si numérateur MIN_VALUE)
     */
    @Test
    void testFractionIntEchec() {
        /* cas #IAE# */
        assertThrows(IllegalArgumentException.class,
                ()->new Fraction(Integer.MIN_VALUE));
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#Fraction(int)}.
     * pour les cas sans échec
     */
    @Test
    void testFractionIntOk() {

        /* cas #Fraction Int#-B */
        for (int numer : NUMERATEUR_NEGATIF) {
            Fraction nouvelle = new Fraction(numer);
            assertEquals(numer, nouvelle.getNumerateur());
            assertEquals(1, nouvelle.getDenominateur());
        }

        for (int numer : NUMERATEUR_POSITIF) {
            Fraction nouvelle = new Fraction(numer);
            assertEquals(numer, nouvelle.getNumerateur());
            assertEquals(1, nouvelle.getDenominateur());
        }
        /* cas #Fraction Int#-E */

        /* cas #Z0# */
        Fraction zero = new Fraction(0);
        assertEquals(0, zero.getNumerateur());
        assertEquals(1, zero.getDenominateur());
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#intValue()}.
     */
    @Test
    void testIntValue() {
        System.out.println("test intValue");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#longValue()}.
     */
    @Test
    void testLongValue() {
        System.out.println("test longValue");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#floatValue()}.
     */
    @Test
    void testFloatValue() {
        System.out.println("test floatValue");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#doubleValue()}.
     */
    @Test
    void testDoubleValue() {
        System.out.println("test doubleValue");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#numerateur()}.
     */
    @Test
    void testGetNumerateur() {
        System.out.println("test numerateur");
        int[] numerateurFixture = {  // numérateur de fixture
                0, -1, 1, 2, 1
        };

        for (int noFraction = 0 ; noFraction < numerateurFixture.length ; noFraction++) {
            assertEquals(numerateurFixture[noFraction],
                    fixture.get(noFraction).getNumerateur());
        }
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#denominateur()}.
     */
    @Test
    void testGetDenominateur() {
        System.out.println("test denominateur");
        int[] denominateurFixture = {  // numérateur de fixture
                1, 1, 1, 1, 2
        };

        for (int noFraction = 0 ; noFraction < denominateurFixture.length ; noFraction++) {
            assertEquals(denominateurFixture[noFraction],
                    fixture.get(noFraction).getDenominateur());
        }
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#irreductible()}.
     */
    @Test
    void testIrreductible() {
        System.out.println("test irreductible");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#oppose()}.
     */
    @Test
    void testOppose() {
        System.out.println("test oppose");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#inverse()}.
     */
    @Test
    void testInverse() {
        System.out.println("test inverse");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#somme(glg101.si03.mathematiques.Fraction, glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testSomme() {
        System.out.println("test somme");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#difference(glg101.si03.mathematiques.Fraction, glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testDifference() {
        System.out.println("test difference");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#produit(glg101.si03.mathematiques.Fraction, glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testProduit() {
        System.out.println("test produit");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#quotient(glg101.si03.mathematiques.Fraction, glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testQuotient() {
        System.out.println("test quotient");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#isEquivalente(glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testIsEquivalente() {
        System.out.println("test isEquivalente");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#compareTo(glg101.si03.mathematiques.Fraction)}.
     */
    @Test
    void testCompareTo() {
        System.out.println("test compareTo");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.Fraction#toString()}.
     */
    @Test
    void testToString() {
        System.out.println("test toString");
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link java.lang.Object#hashCode()}.
     */
    @Test
    void testHashCode() {
        System.out.println("test hashCode");
        fail("Not yet implemented");
    }

    /**
     * Test method for {
     * @link java.lang.Object#equals(java.lang.Object)}.
     */
    @Test
    void testEquals() {
        System.out.println("test equals");
        fail("Not yet implemented");
    }
}
