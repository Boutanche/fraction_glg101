/**
 * TestArithmetiqueEntiere.java
 * CNAM MILLAU 2023
 * CAI-SI 03
 * Pas de copyright ni copyleft
 */
package test;

import fraction.ArithmetiqueEntiere;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * TestArithmetiqueEntiere
 * @author BBE
 */
public class TestArithmetiqueEntiere {
    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.ArithmetiqueEntiere#pgcd(long, long)}.
     */
    @Test
    void testPgcdLongLong() {
        Long a = 12L;
        Long b = 18L;
        Long expected = 6L;
        Long actual = ArithmetiqueEntiere.pgcd(a, b);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.ArithmetiqueEntiere#pgcd(int, int)}.
     */
    @Test
    void testPgcdIntInt(){
        Integer a = 12;
        Integer b = 18;
        Integer expected = 6;
        Integer actual = ArithmetiqueEntiere.pgcd(a, b);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.ArithmetiqueEntiere#ppcm(long, long)}.
     */
    @Test
    void testPpcmLongLong() {
        Long a = 12L;
        Long b = 18L;
        Long expected = 36L;
        Long actual = ArithmetiqueEntiere.ppcm(a, b);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test method for {
     * @link glg101.si03.mathematiques.ArithmetiqueEntiere#ppcm(int, int)}.
     */
    @Test
    void testPpcmIntInt() {
        Integer a = 12;
        Integer b = 18;
        Integer expected = 36;
        Integer actual = ArithmetiqueEntiere.ppcm(a, b);
        Assertions.assertEquals(expected, actual);
    }
}
