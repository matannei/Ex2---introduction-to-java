//203834023 Matan Neiman

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Ex2_Test {
    static double[] po1={2,0,3, -1,0},
            po2 = {0.1,0,1, 0.1,3};

    static final double EPS = 0.0001;

    @Test
    void testF() {
        double fx0 = Ex2.f(po1, 0);
        double fx1 = Ex2.f(po1, 1);
        double fx2 = Ex2.f(po1, 2);
        assertEquals(fx0,2);
        assertEquals(fx1,4);
        assertEquals(fx2,6);
    }

    @Test
    void testRoot() {
        double x12 = Ex2.root(po1, 0, 10, EPS);
        assertEquals(x12, 3.1958, 0.001);
    }

    @Test
    void testDerivativeArrayDoubleArray() {
        double[] p = {1,2,3}; // 3X^2+2x+1
        double[] dp1 = {2,6}; // 6x+2
        double[] dp2 = Ex2.derivative(p);
        assertEquals(dp1[0], dp2[0],EPS);
        assertEquals(dp1[1], dp2[1],EPS);
        assertEquals(dp1.length, dp2.length);
    }
    @Test
    void testAdd() {
        double[] polAdd = Ex2.add(po1, po2);
       double[]add= {2.1,0,4,-0.9,3};//3x^4-0.9x^3+4x^2+2.1
        assertEquals(polAdd[0],add[0]);
        assertEquals(polAdd[1],add[1]);
        assertEquals(polAdd[2],add[2]);
        assertEquals(polAdd[3],add[3]);
        assertEquals(polAdd[4],add[4]);
        assertEquals(polAdd.length,add.length);
    }

    @Test
    void testMull() {
        double[] polMull = Ex2.mul(po1, po2);
        double[]Mull= {0.2,0,2.3,0.1,9,-0.7,8.9,-3};//-3x^7+8.9x^6-0.7x^5+9x^4+0.1x^3+2.3x^2+0.2
        assertEquals(polMull[0],Mull[0]);
        assertEquals(polMull[1],Mull[1]);
        assertEquals(polMull[2],Mull[2]);
        assertEquals(polMull[3],Mull[3]);
        assertEquals(polMull[4],Mull[4]);
        assertEquals(polMull[5],Mull[5]);
        assertEquals(polMull[6],Mull[6]);
        assertEquals(polMull[7],Mull[7]);
        assertEquals(polMull.length,Mull.length);
    }

    @Test
    void testPoly() {
        String p1 = Ex2.poly(po1);
        String poly= "-1.0x^3+3.0x^2+2.0";
        assertEquals(p1,poly);

    }


}

