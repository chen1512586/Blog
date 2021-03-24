<<<<<<< HEAD
package com.cpf.demo.sys;

import java.util.Random;

public class ValidateCode {
    public static String createData() {
        return createData(6);
    }
    public static String createData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.sys;

import java.util.Random;

public class ValidateCode {
    public static String createData() {
        return createData(6);
    }
    public static String createData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}
=======
package com.cpf.demo.sys;

import java.util.Random;

public class ValidateCode {
    public static String createData() {
        return createData(6);
    }
    public static String createData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
