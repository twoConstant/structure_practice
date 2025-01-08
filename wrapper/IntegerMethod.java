package structure_practice.wrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerMethod {
    public static void main(String[] args) {
        /**
         * Static Fields
         * static final int BYTES
         * static final int MAX_VALUE
         * static final int MIN_VALUE
         * static final int SIZE
         * static final Class<Integer> TYPE
         * 
         * 
         * Static Method
         * static int bitCount(int i)    done
         * static int compare(int x, int y)    done
         * static Integer decode(String nm)    done
         * static Integer getInteger(String nm)    done
         * static int parseInt(CharSequence s, int beginIndex, int endIndex, int radix)    done
         * static int parseInt(String s, int radix)    done
         * static int signum(int i)
         * static String toString(int i)
         * static String toString(int i, int radix)
         * static Integer valueOf(int i)
         * static Integer valueOf(String s)
         * static Integer valueOf(String s, int radix)
         * 
         * Instance Method
         * byte byteValue()
         * int compareTo(Integer anotherInteger)
         * double doubleValue()
         * float floatValue()
         * short shortValue()
         * int intValue()
         * long longValue()
         * boolean equals(Object obj)
         * String toString()
         * 
         */

         // Static Fields
         System.out.println("[Integer.BYTES]: " + Integer.BYTES);
         System.out.println("[Integer.MAX_VALUE] : " + Integer.MAX_VALUE);
         System.out.println("[Integer.MIN_VALUE] : " + Integer.MIN_VALUE);
         System.out.println("[Integer.SIZE] : " + Integer.SIZE);
         System.out.println("[Integer.TYPE] : " + Integer.TYPE);

         // 1. static int bitCount(int i) : int i 를 2진수로 표현했을때 1의 개수를 반환
         System.out.println("[static int bitCount(int i)]: " + Integer.bitCount(7)); 

         // 2. static int compare(int x, int y) : 0(동일), -1(b가 큼), 1(a가 큼)을 반환
         System.out.println("[static int compare(int x, int y)]: " + Integer.compare(10, 1)); 
         
        // 3. static Integer decode(String nm) : 숫자형태의 String을 정수로 변환, 다른 진법도 변환 가능하다.
        System.out.println("[static Integer decode(String nm)]: " + Integer.decode("123"));

        // 4. static Integer getInteger(String nm) : 시스템상 관리되는 key, value 자료형의 key값을 받아 value를 반환환

        // 5. static int parseInt(String s, int radix) : 다양한 진법으로 표현된 수를 분석해 대응하는 10진법의 int를 반환
        
        // 6. static int signum(int i) : 음수; 0; 양수 = -1; 0; 1을 반환한다.

        // 7. static String toString(int i, int radix) : int를 원하는 진법에 맞는 문자열로 변환해 반환한다.

        // 8. static Integer valueOf(int i), static Integer valueOf(String i) : Integer 자료형을 반환한다.

        //Instance Method
        // 1. int intValue(), -Value() : Integer 자료형을 해당 타입으로 변환한다.
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();








    }
}
