package structure_practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        /**
         * 배열에서 중복 제거 후 리스트 반환
            정수 배열 int[] arr가 주어질 때, 배열에서 중복을 제거하고 중복 없는 요소들로 이루어진 리스트를 반환하시오.
            입력: {1, 2, 2, 3, 4, 4, 5}
            출력: [1, 2, 3, 4, 5]
         */
        int[] arrP1 = {1, 2, 2, 3, 4, 4, 5};
        // 1. Integer[] -> set 자료형으로 형변환
        Set<Integer> setP1 =Arrays.stream(arrP1).boxed().collect(Collectors.toSet());
        // 2. Set 자료형을 다시 int[]로 형변환
        int[] arrResultP1 = setP1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("[Practice1]: " + Arrays.toString(arrResultP1));


        /**
         * 2. 리스트를 배열로 변환한 후 오름차순 정렬
            문자열 리스트 List<String> list가 주어질 때, 이를 배열로 변환한 후 오름차순 정렬된 배열을 반환하시오.
            입력: ["banana", "apple", "orange"]
            출력: ["apple", "banana", "orange"]
         */
        // List<String> -> String[]으로 변환
        List<String> listP2 = new ArrayList<>(Arrays.asList("banana", "apple", "orange"));
        String[] arrP2 = new String[listP2.size()];
        listP2.toArray(arrP2);
        // 사전순으로 오름차순 정렬
        Arrays.sort(arrP2);
        System.out.println("[Practice2]: " + Arrays.toString(arrP2));

        // stream을 이용한 풀이
        String[] arrStringP2 = listP2.stream().sorted().toArray(String[]::new);


        /**
         * 3. 배열과 리스트의 교집합 구하기
            두 데이터 구조, 정수 배열 int[] arr와 리스트 List<Integer> list가 주어질 때, 두 데이터 구조의 교집합을 리스트로 반환하시오.
            입력: arr = {1, 2, 3, 4}, list = [3, 4, 5, 6]
            출력: [3, 4]
         */
        int[] arrP3 = {1, 2,3, 4};
        List<Integer> listP3 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        // int[] -> Integer[]
        // 교집합 collection.RetainALl()
        listP3.retainAll(Arrays.stream(arrP3).boxed().toList());
        System.out.println("[Practice3]: " + listP3.toString());

        /*
         * 4. 2차원 배열을 리스트로 변환
            정수 2차원 배열 int[][] arr가 주어질 때, 배열의 모든 요소를 단일 리스트로 변환하시오.
            입력: {{1, 2}, {3, 4}, {5}}
            출력: [1, 2, 3, 4, 5]
         */
        // 순회를 돌면서 addAll을한다.
        int[][] arrP4 = {{1, 2}, {3, 4}, {5}};
        List<Integer> listP4 = new ArrayList<>();
        for(int[] arrP41 : arrP4) {
            for(Integer num : arrP41) {
                listP4.add(num);
            }
        }
        System.out.println("[Practice4]: " + listP4.toString());

        /**
         * 5. 리스트의 중간에 배열 삽입
            정수 리스트 List<Integer> list와 정수 배열 int[] arr가 주어질 때, 배열의 모든 요소를 리스트의 중간에 삽입하시오.
            입력: list = [1, 2, 6, 7], arr = {3, 4, 5}
            출력: [1, 2, 3, 4, 5, 6, 7]
         */
        // addAll(int index, Collection<? extends E> c) index 2에 삽입
        int[] arrP5 = {3, 4, 5};
        List<Integer> listP5 = new ArrayList<>(Arrays.asList(1, 2, 6, 7));
        // int[] arr -> List<Integer>
        List<Integer> listArrP5 = Arrays.stream(arrP5).boxed().toList();
        listP5.addAll(2, listArrP5);
        System.out.println("[Practice5]: " + listP5.toString());

        /**
         * 6. 배열의 모든 짝수 요소를 리스트로 변환
            정수 배열 int[] arr가 주어질 때, 배열에서 짝수만 추출하여 리스트로 반환하시오.
            입력: {1, 2, 3, 4, 5, 6}
            출력: [2, 4, 6]
         */
        // int[] -> List<Integer>
        // int[] arrP6 = {1, 2, 3, 4, 5, 6};
        // List<Integer> listArrP6 = Arrays.stream(arrP6).boxed().toList();
        // //removeIf(Predicate<? super E> filter)
        // listArrP6.removeIf((a) -> a % 2 == 1);
        // System.out.println("[Practice]: " + listArrP6.toString());

        /**
         * 7. 리스트의 모든 문자열을 배열로 변환 후 문자열 연결
            문자열 리스트 List<String> list가 주어질 때, 이를 배열로 변환한 뒤, 배열의 모든 문자열을 연결한 하나의 문자열을 반환하시오.
            입력: ["Java", "is", "fun"]
            출력: "Javaisfun"
         */
        // List<String> -> String[]
        List<String> listP7 = new ArrayList<>(Arrays.asList("Java", "is", "fun"));
        String[] arrStringP7 = listP7.stream().toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        for(String str : arrStringP7 ) {
            sb.append(str);
        }
        System.out.println("[Practice7]: " + sb.toString());
    }
}
