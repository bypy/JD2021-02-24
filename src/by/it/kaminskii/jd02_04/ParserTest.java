package by.it.kaminskii.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser=new Parser();
    }

    @Test
    public void addTest() throws CalcExeption {
        Var actualScalar = parser.calc("2+2+7+8");
        double actual = Double.parseDouble(actualScalar.toString());
        double  expected = 19.0;
        assertEquals(expected,actual,1e-5);
    }
    @Test
    public void expressionScalars() throws CalcExeption {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3,actual, 1e-5);

        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55,actual, 1e-5);

        actual = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        assertEquals(2.65,actual, 1e-5);
    }


    @Test
    public void expressionVectorsStepOne() throws CalcExeption {
        Vector vector = (Vector) parser.calc("V={1,2,3}+{4,5,6}");
        double[] actual = vector.getVector();
        double[] expected ={5,7,9};
        assertArrayEquals(expected,actual,1e-5);
    }
    @Test
    public void expressionVectorsStepTwo() throws CalcExeption {

        double actual = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
        assertEquals(40.15,actual,1e-5);
    }

    @After
    public void tearDown() throws Exception {


        }
    }
