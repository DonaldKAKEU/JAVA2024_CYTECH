package TestTp8;

import java.util.ArrayList;
import java.util.List;

public class Suite {

    public Suite() {
    }

    public static int U(int n, int u0, int u1) {

        if (n == 0)
            return u0;
        if (n == 1)
            return u1;

        if (n % 2 == 0)
            return (U(n - 1, u0, u1) / U(n - 2, u0, u1)) - (U(n - 2, u0, u1) / U(n - 1, u0, u1));
        else
            return (U(n - 2, u0, u1) / U(n - 1, u0, u1)) - (U(n - 1, u0, u1) / U(n - 2, u0, u1));

        }


    public static int u(int n, int u0, int u1) {

        int un_1 = u(n - 1, u0, u1);
        int un_2 = u(n - 2, u0, u1);
        return (n % 2 == 0) ? un_1 / un_2 - un_2 / un_1 : un_2 / un_1
                - un_1 / un_2;

    }
}