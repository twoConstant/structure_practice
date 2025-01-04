package structure_practice.collection;

import java.text.MessageFormat;
import java.util.*;

public class Collections_practice {
    public static void main(String[] args) {
        /**
         * binarySearch(List<? extends Comparable<? super T>> list, T key)   done
         * binarySearch(List<? extends T> list, T key, Comparator<? super T> c)  done
         * copy(List<? super T> dest, List<? extends T> src)   done
         * disjoint(Collection<?> c1, Collection<?> c2)    done
         * fill(List<? super T> list, T obj)    done
         * replaceAll(List<T> list, T oldVal, T newVal)    done
         * frequency(Collection<?> c, Object o)    done
         * max(Collection<? extends T> coll)    done
         * max(Collection<? extends T> coll, Comparator<? super T> comp)    done
         * min(Collection<? extends T> coll)    done
         * min(Collection<? extends T> coll, Comparator<? super T> comp)    done
         * reverse(List<?> list)    done
         * sort(List<T> list)    done
         * sort(List<T> list, Comparator<? super T> c)    done
         * shuffle(List<?> list)    done
         * swap(List<?> list, int i, int j)    done
         */

         // int binarySearch(List<? extends Comparable<? super T>> list, T key)
         /**
           * 반환 : int, indexOfKey(존재하는경우)
           * 특이사항 :
           * 1. List 자료형만 사용 가능하다.
           * 2. 반드시 정렬된 리스트여야 한다. 정렬되지 않은 경우 결과는 정의되지 않는다.
           * 3. 존재하지 않는 경우 -(삽입위치 + 1)을 반환한다. 삽입 인덱스 번호의 음수를 반환환
          **/
        List<Integer> listBinarySearch = new ArrayList<>();
        fillCollection(listBinarySearch, 1, 100);
        int resultOfBinarySearch1 = Collections.binarySearch(listBinarySearch, 2);    // 리스트 자료형만 가능하다.
        String resultMessageBinarySearch1 = MessageFormat.format("[Collections.binarySearch] 정렬o, key 존재o : {0}", resultOfBinarySearch1);
        System.out.println(resultMessageBinarySearch1);
        int resultOfBinarySearch2 = Collections.binarySearch(listBinarySearch, 200);    // 존재하지 않는 key
        String resultMessageBinarySearch2 = MessageFormat.format("[Collections.binarySearch] 정렬o, key 존재x : {0}", resultOfBinarySearch2);
        System.out.println(resultMessageBinarySearch2);
        Collections.shuffle(listBinarySearch);
        int resultOfBinarySearch3 = Collections.binarySearch(listBinarySearch, 5);   
        String resultMessageBinarySearch3 = MessageFormat.format("[Collections.binarySearch] 정렬x, key 존재0 : {0}", resultOfBinarySearch3);
        System.out.println(resultMessageBinarySearch3);

        // binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
        /**
          * 사용 경우:
          * - 리스트의 요소로 객체가 들어가 있을 때, 객체의 특정 속성을 기준으로 이진 탐색을 수행할 경우 사용한다.
          * - Comparator를 통해 비교 기준을 명시적으로 지정해야 한다.
         */
        // String의 길이를 기준으로 이진탐색 예시
        List<String> listBinarySearchComparator = Arrays.asList("apple", "banana", "cherry", "date");
        // 길이 기준 오름자순 정렬렬
        Collections.sort(listBinarySearchComparator, (a, b) -> a.length() - b.length());
        int resultOfBinarySearchComparator1 = Collections.binarySearch(listBinarySearchComparator, "banana", (a, b) -> a.length() - b.length());
        String resultMessageBinarySearch4 = MessageFormat.format("[Collections.binarySearch - using Comparator] 정렬0 key 존재0 : {0}", resultOfBinarySearchComparator1);
        System.out.println(resultMessageBinarySearch4);

        // copy(List<? super T> dest, List<? extends T> src)
        /**
         * 주의사항
         * - 카피본의 리스트(destination)의 길이가 원본(src)의 길이보다 크거나 같아야한다.
         * - 복사본의 리스트 길이가 원본을 초과하는 리스트의 값은 유지된다.
         */
        List<Integer> listCopyScr = Arrays.asList(10, 10, 10, 10);
        List<Integer> listCopyDes = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.copy(listCopyDes, listCopyScr);
        String resultMessageOfCopy = MessageFormat.format("[copy(List<? super T> dest, List<? extends T> src)] : {0}", listCopyDes.toString());
        System.out.println(resultMessageOfCopy);

        // disjoint(Collection<?> c1, Collection<?> c2)
        /**
         * 반환결과 : boolean, 여집합인경우 ture, 부분집합인경우 false를 반환환
         * 사용처 : 두 컬랙션의 중복되는 항목이 있는지 판단.
         * 주의사항
         * - disJoint아니다.
         */
        List<String> listDisjoint1 = Arrays.asList("1", "2", "3", "4");
        List<String> listDisjoint2 = Arrays.asList("1", "2", "3", "5");
        String resultMessageOfDisjoint = MessageFormat.format("[disjoint(Collection<?> c1, Collection<?> c2)] : {0}", Collections.disjoint(listDisjoint1, listDisjoint2));
        System.out.println(resultMessageOfDisjoint);

        // fill(List<? super T> list, T obj)
        /**
         * 사용처 : 기존의 리스트의 천체 값을 특정 값으로 초기화할때때
         */
        List<Integer> listFill = Arrays.asList(1, 2, 3, 4, 5);
        Collections.fill(listFill, 1);
        String resultMessageOfFill = MessageFormat.format("[fill(List<? super T> list, T obj)] : {0}", listFill.toString());
        System.out.println(resultMessageOfFill);

        // replaceAll(List<T> list, T oldVal, T newVal)
        /**
         * 사용처 : 기존의 리스트의 특정 값만 다른 값으로 변경할때때
         */
        List<Integer> listReplaceAll = Arrays.asList(1, 2, 3, 4, 5, 5, 5);
        Collections.replaceAll(listReplaceAll, 5, 10);
        String resultMessageOfReplaceAll = MessageFormat.format("[replaceAll(List<T> list, T oldVal, T newVal)] : {0}", listReplaceAll.toString());
        System.out.println(resultMessageOfReplaceAll);

        // frequency(Collection<?> c, Object o)
        /**
         * 반환결과 : int, 컬랙션 내의 Object의 개수를 반환
         * 사용처 : 컬랙션 내의 특정 항목의 개수를 알고싶을때
         */
        List<Integer> listFrequency = Arrays.asList(1, 2, 3, 4, 5, 5, 5);
        int resultOfFrequency = Collections.frequency(listFrequency, 5);
        String resultMessageOfFrequency = MessageFormat.format("[frequency(Collection<?> c, Object o)] : {0}", resultOfFrequency);
        System.out.println(resultMessageOfFrequency);

        // max(Collection<? extends T> coll)
        /**
         * 반환결과 : T
         * 사용처 : 컬랙션 내의 가장 큰 값을 알고싶은 경우
         * 특이사항
         * - 특정 기준 가장 큰 값을 가진 "요소"를 반환한다. 그래서 해당 컬랙션 타입으로 받아야한다.
         * - 문자열인경우 ASCII 기준으로 모든 Char의 식별별값의 합이 그 기준이 된다.
         */
        Collection<String> collMax = new ArrayList<>();
        collMax.add("a");
        collMax.add("bc");
        collMax.add("cd");
        collMax.add("da");
        collMax.add("A");
        // int maxValue = Collections.max(collMax);    // 이렇게 받으면 안됨
        String maxString = Collections.max(collMax);
        String resultMessageOfMax = MessageFormat.format("[max(Collection<? extends T> coll)] : {0}", maxString);
        System.out.println(resultMessageOfMax);

        // max(Collection<? extends T> coll, Comparator<? super T> comp)
        /*
         * 반환결과 : T
         * 사용처 : 컬랙션의 항목이 객체이고 해당 객체의 특정 항목을 기준으로 max값을 구하고싶을 때
         */
        Collection<String> collMaxComparator = Arrays.asList("abd", "bsalfag", "dflj", "dflkjfsaf", "kfja;df", "za");
        // 단순 max를 구하는 경우
        String maxStringPlain = Collections.max(collMaxComparator);
        // 문자열의 두두 번째 char를 기준
        String maxStringSecChar = Collections.max(collMaxComparator, (a, b) -> a.charAt(1) - b.charAt(1));
        String resultMessageOfMax2 = MessageFormat.format("[max(Collection<? extends T> coll)] : {0}", maxStringPlain);
        String resultMessageOfMaxComparator = MessageFormat.format("[max(Collection<? extends T> coll, Comparator<? super T> comp)] : {0}", maxStringSecChar);
        System.out.println(resultMessageOfMax2);
        System.out.println(resultMessageOfMaxComparator);

        // reverse(List<?> list), sort(List<?> list), sort(List<T> list, Comparator<? super T> c)
        /**
         * 사용처 : 현재 리스트의 배열 순서를 뒤집을때(내림차순 정렬 아니다!!), 오름차순 정렬할때때
         */
        List<Integer> listReverse = new ArrayList<>();
        fillCollection(listReverse, 1, 100);
        Collections.shuffle(listReverse);
        System.out.println("listReverse: " + listReverse.toString());

        Collections.reverse(listReverse);
        String resultMessageOfReverse = MessageFormat.format("[reverse(List<?> list)] : {0}", listReverse.toString());
        System.out.println(resultMessageOfReverse);

        Collections.sort(listReverse);
        String resultMessageOfSort = MessageFormat.format("[sort(List<?> list)] : {0}", listReverse.toString());
        System.out.println(resultMessageOfSort);

        Collections.sort(listReverse, (a, b) -> b - a);
        String resultMessageOfSortReverseOrder = MessageFormat.format("[sort(List<T> list, Comparator<? super T> c)] : {0}", listReverse.toString());
        System.out.println(resultMessageOfSortReverseOrder);

        // swap(List<?> list, int i, int j)
        /**
         * 사용처 : 두 항목의 위치를 변경할때
         */
        List<Integer> listSwap = new ArrayList<>();
        fillCollection(listSwap, 1, 10);
        Collections.swap(listSwap, 0, 9);
        String resultMessageOfSwap = MessageFormat.format("[swap(List<?> list, int i, int j)] : {0}", listSwap.toString());
        System.out.println(resultMessageOfSwap);

    }

    private static void fillCollection(Collection collection, int start, int end) {
        for(int i = start; i <= end; i++) {
            collection.add(i);
        }
    }
}
