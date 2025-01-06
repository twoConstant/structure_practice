package structure_practice.array;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Arrays_practice {
    public static void main(String[] args) {
        /**
         * asList(T...a)
         * 번외, int[]를 list<Integer>로 변경하는 방법
         * binarySearch(Object[] a, Object key)    done
         * copyOf(T[] original, int newLength)    done
         * copyOfRange(T[] original, int from, int to)    done
         * deepEquals(Object[] a1, Object[] a2)    done
         * equals(Object[] a, Object[] a2)    done
         * fill(Object[] a, Object val)
         * fill(Object[] a, int fromIndex, int toIndex, Object val)
         * mismatch(Object[] a, Object[] b)
         * parallelPrefix(T[] array, BinaryOperator<T> op)    done
         * parallelSort(T[] a)    done
         * setAll(T[] array, IntFunction<? extends T> generator)
         * sort(Object[] a)
         * sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
         * sort(T[] a, Comparator<? super T> c)
         * spliterator(T[] array)
         * stream(T[] array)
         *  shuffle이 없네;;
         */
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        /**
         * 메서드 명 : asList(T...a)
         * 사용처 : array 자료형을 Collection 자료형으로 감싸기 위해 사용
         * 반환 결과 : List<T>
         * 특이사항
         * - asList의 반환 결과는 util.ArrayList가 아닌 util.Arrays.ArrayList로 다른놈이다. 그냥 배열의 특성을 그대로 다 가지고있다.
         * - 매개변수로 바로 arr 자료형 전달 가능.
          */
        Integer[] arrInteger = {1, 2, 3, 4, 5};
        List<Integer> listAsList1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> listAsList2 = Arrays.asList(arrInteger);
        List<Integer> listAsList3 = new ArrayList<>(Arrays.asList(arrInteger));    // 사실상 그냥 util.ArrayList의 생성자 활용
//        listAsList1.add(1);    // UnsupportedOperationException 에러 발생
//        listAsList2.add(1);    // UnsupportedOperationException 에러 발생
        listAsList3.add(1);

        /**
         * 번외, int[]를 list<Integer>로 변경하는 방법 : 그냥 넣으면 된다;;
         * 1. 그냥 List에 넣는 방법
         * 2. stream을 통해 Integer[]로 변경, 리스트로 변경하는 방법법
         */
        int[] arrint = {1, 2, 3, 4, 5};
        // 방법 1
        List<Integer> listInteger = new ArrayList<>();
        // for(int i = 0; i < arrint.length; i++) {
        //     listInteger.add(arrint[i]);
        // }
        // 방법 2
        List<Integer> listInteger2 = Arrays.stream(arrint)
                    .boxed()    // => Integer[]
                    .collect(Collectors.toList());    // => list 잘료형으로 변경


        /**
         * 메서드 명 : binarySearch(Object[] a, Object key)
         * 사용처 : 특정 항목의 위치를 탐색할 때 
         * 반환 결과 : int index
         * 특이사항 :
         */
        int[] arrIntBinarySearch = Arrays.copyOf(arr, 100);
        Arrays.sort(arrIntBinarySearch);    // 이진 탐색전 정렬은 필수! 
        System.out.println(Arrays.toString(arr));
        int keyExist = 23;
        int keyNone = 101;
        int indexOfKeyExist = Arrays.binarySearch(arrIntBinarySearch, keyExist);
        int indexOfKeyNone = Arrays.binarySearch(arrIntBinarySearch, keyNone);
        String resultMessageOfBinarySearch1 = MessageFormat.format("[binarySearch(Object[] a, Object key)] key 존재 : {0}", indexOfKeyExist);
        String resultMessageOfBinarySearch2 = MessageFormat.format("[binarySearch(Object[] a, Object key)] key 존재 x : {0}", indexOfKeyNone);
        System.out.println(resultMessageOfBinarySearch1);
        System.out.println(resultMessageOfBinarySearch2);
        
        /**
         * 메서드 명 : 번외 arr셔플하기기
         * 사용처 :
         * 반환 결과 :
         * 특이사항 :
         */
        int[] arrIntShuffle = Arrays.copyOf(arr, 100);
        // List<Integer> 자료형으로 변경
        List<Integer> arr1 = Arrays.stream(arrIntShuffle).boxed().collect(Collectors.toList());
        Collections.shuffle(arr1);
        // 다시 arr로 변경
        int[] arrShuffled = arr1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arrShuffled));
        



        /**
         * 메서드 명 : copyOf(T[] original, int newLength)
         * 사용처 : 특정 배열의 처음부터 일정 개수의 배열을 깊은 복사 하고 싶을 때 
         * 반환 결과 : T[]
         * 특이사항 : 깊은 복사가 일어난다.
         */
        int[] arrCopyOf = Arrays.copyOf(arr, 10);
        // 복사본 변경
        Arrays.fill(arrCopyOf, 1);
        System.out.println("원본: " + Arrays.toString(arr));
        String resultMessageOfCopyOf = MessageFormat.format("[copyOf(T[] original, int newLength)] : {0}", Arrays.toString(arrCopyOf));
        System.out.println(resultMessageOfCopyOf);

        /**
         * 메서드 명 : copyOfRange(T[] original, int from, int to)
         * 사용처 : 배열의 특정 부분은 선택적으로 복사하고 싶을 때 사용 
         * 반환 결과 : T[]
         * 특이사항 : 
         * - 깊은 복사가 이뤄진다.
         * - 마지막 인덱스의 원소는 들어가지 않는다.
         */
        int[] arrCopyOfRange = Arrays.copyOfRange(arr, 10, 20);    // 10인덱스 ~ 19번 인덱스까지 복사
        String resultMessageOfCopyOfRange = MessageFormat.format("[arrCopyOfRange] : {0}", Arrays.toString(arrCopyOfRange));
        System.out.println(resultMessageOfCopyOfRange);

         /**
         * 메서드 명 : deepEquals(Object[] a1, Object[] a2), equals(Object[] a, Object[] a2)
         * 사용처 : 다차원 배열의 동등성 비교, 일차원 배열의 동등성 비교교
         * 반환 결과 : bool
         * 특이사항 :
         */

         /**
         * 메서드 명 : mismatch(Object[] a, Object[] b)
         * 사용처 : 두 배열의 첫 다른 항목의 인덱스 반환
         * 반환 결과 : int
         * 특이사항 : 차이가 없는경우 -1반환
         */
        

         /**
         * 메서드 명 : parallelPrefix(T[] array, BinaryOperator<T> op)
         * 사용처 : 배열에 누적 연산으로 업데이트 하고 싶을때 사용한다.
         * 반환 결과 : void
         * 특이사항 :
         */
        int[] arrParallePrefixe = Arrays.copyOfRange(arr, 0, 11);
        Arrays.parallelPrefix(arrParallePrefixe, (a, b) -> a + b);
        System.out.println(Arrays.toString(arrParallePrefixe));

        /**
         * 메서드 명 : parallelSort(T[] array)
         * 사용처 : 정렬시 사용
         * 반환 결과 : void
         * 특이사항 : 분할 정복을 활용한 알고리즘으로 배열의 길이가  8,192개 이상상일 경우 sort보다 유리
         * - 근데 java에서 알아서 배열의 길이에 따라 최적화를 수행해 주지만 병렬작업으로 인한 오버헤드 발생 가능성이있다.
         */
        int[] arrParallelSort = Arrays.copyOf(arr, arr.length);
        Arrays.parallelSort(arrParallelSort);


    }

}
