//203834023 Matan Neiman

public class Ex2 {

    public static double f(double[] poly, double x) {

        double value = 0;
        for (int j = 0; j < poly.length; j++) {

            value = value + (poly[j] * (Math.pow(x, j)));

        }

        return value;

    }

    public static String poly(double[] poly) {


        //we get double as poly i. convert double into char and insert to the string
        String string = new String();
        for (int i = poly.length - 1; i > 1; i--) {
            String x = "x^";
            if (poly[i] > 0) {
                char sign = '+';

                string = string + sign + Double.toString(poly[i]) + x + i;
            }
            if (poly[i] < 0) {

                string = string + Double.toString(poly[i]) + x + i;
            }
        }
        if (poly[1] > 0) {
            char sign = '+';
            string = string + sign + Double.toString(poly[1]) + "x";
        }
        if (poly[0] < 0) {

            string = string + Double.toString(poly[1]) + "x";
        }
        if (poly[0] > 0) {
            char sign = '+';
            string = string + sign + Double.toString(poly[0]);
        }
        if (poly[0] < 0) {

            string = string + Double.toString(poly[0]);
        }
        return string;
    }

    public static double root(double[] p, double x1, double x2, double eps) {
        double a = f(p, x1);
        double b = f(p, x2);
        double c = (x1 + x2) / 2;
        while (Math.abs(x1 - x2) / 2 > eps) {

            if (a * b > 0) {
                System.out.println("false");
            } else {
                if (a * f(p, c) < 0) {
                    x2 = c;
                }
                if (b * f(p, c) < 0) {
                    x1 = c;
                }
                c = (x1 + x2) / 2;

            }
        }
        return c;
    }

    public static double[] add(double[] p1, double[] p2) {

        int max = 0;
        if (p2.length >= p1.length) {
            max = p2.length;
        }
        if (p1.length > p2.length) {
            max = p1.length;
        }

        double[] add = new double[max];
        for (int i = 0; i < p2.length; i++) {

            add[i] = (p1[i] + p2[i]);

        }

        return add;
    }

    public static double[] mul(double[] p1, double[] p2) {

        double[] mul = new double[p1.length + p2.length-2];

        for (int i = 0; i < p1.length-1; i++) {
            for (int j = 0; j < p2.length; j++) {

                mul[i + j] += p1[i] * p2[j];
            }
        }

        return mul;

    }

    public static double[] derivative(double[] po) {

        double[] derivative = new double[po.length - 1];
        for (int i = po.length - 1; i > 0; i--) {

            derivative[i - 1] = i * po[i];

        }
        return derivative;
    }


    public static void main(String[] ar) {
        double eps = 0.01; // the epsilon to be used for the root approximation.
        double[] po1 = {2, 0, 3, -1, 0};
        double[] po2 = {0.1, 0, 1, 0.1, 3};
        String pp = poly(po1);
        System.out.println(pp);
        pp = poly(po2);
        System.out.println(pp);
        double x1 = 0, x2 = 10;
        double f2 = f(po1, x1);
        System.out.println(f2);
        f2 = f(po1, x2);
        System.out.println(f2);
        double x12 = root(po1, x1, x2, 0.01);
        System.out.println("f(" + x12 + ") = " + f(po1, x12));
        double[] p12 = add(po1, po2);
        pp = poly(p12);
        System.out.println(pp);
        p12 = mul(po1, po2);
        pp = poly(p12);
        System.out.println(pp);


//i wrote another main for me to check my progress. at the end I used the main from module that fits the unit tests better
   /* public static void main (String[]args) {

        double x =2;
        double[] po1={2,0,3, -1,0};
        double[] p1={5,4,3,2,1};
        double[] p2={1,2,3,4,5};
        double eps = 0.0001;
        double x1 =0;
        double x2=10;


        System.out.println("f("+x+") = "+f(po1,x));

        System.out.println( "f(x) = "+poly(po1));

        System.out.println( "root is: "+root(po1,x1,x2,eps));

        System.out.println("add = "+ Arrays.toString(add(p1,p2)));

        System.out.println("mul = "+poly(mul(p1,p2)));

        System.out.println("derivative = "+ poly(derivative(p1)));

    }*/


    }
}
