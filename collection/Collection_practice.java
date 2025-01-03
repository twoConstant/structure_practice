package structure_practice.collection;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.Predicate;

public class Collection_practice {
    public static void main(String[] args) {
        // Interface Collection<E>
        

        // addAll(Collection<? extends E> c)
        // Template의 타입만 동일하다면 Collection 자료형은 다 들어간다.
        Collection<Integer> collection = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fillCollection(list, 1, 6);
        fillCollection(collection, 1, 6);
        collection.addAll(list);
        String result = MessageFormat.format("[addAll(Collection<? extends E> c)] {0}", collection);
        System.out.println(result);

        // removeAll(Collection<?> c) : 차집합
        Collection<Integer> collection1 = new ArrayList<>();    // [1, 2, 3, 4, 5]
        Collection<Integer> collection2 = new ArrayList<>();    // [4, 5, 6, 7]
        fillCollection(collection1, 1, 6);
        fillCollection(collection2, 4, 8);
        collection1.removeAll(collection2);
        String resultRemoveAll = MessageFormat.format("[removeAll(Collection<?> c)] {0}", collection1);
        System.out.println(resultRemoveAll);

        // removeIf(Predicate<? super E> filter) : 조건에 걸리는 원소 제거
        // 1. Predicate의 test 익명 함수를 오버라이드해 fillter를 생성
        // 해당 fillter를 removeIf의 매개변수로 넘겨주면 완료
        Collection<Integer> collectionRemoveIf = new ArrayList<>();
        fillCollection(collectionRemoveIf, 1, 11);
        Predicate<Integer> isEven = new Predicate<>() {
            @Override
            public boolean test(Integer n) {
                if(n % 2 == 0) {
                    return true;
                }
                return false;
            }
        };
        collectionRemoveIf.removeIf(isEven);    // 짝수를 제거거
        
        // removeIf 람다로 하는 방식
        collectionRemoveIf.removeIf((n) -> n % 2 == 0);
        String resultOfRemoveIf= MessageFormat.format("[removeIf(Predicate<? super E> filter)] 짝수 제거 {0}", collectionRemoveIf.toString());
        System.out.println(resultOfRemoveIf);
        

        // retainAll(Collection<?> c) : 교집합
        Collection<Integer> collectionRetainAll1 = new ArrayList<>();
        Collection<Integer> collectionRetainAll2 = new ArrayList<>();
        fillCollection(collectionRetainAll1, 1, 11);
        fillCollection(collectionRetainAll2, 6, 16);
        collectionRetainAll1.removeAll(collectionRetainAll2);
        String resultRetainAll = MessageFormat.format("[retainAll(Collection<?> c)] {0}", collectionRetainAll1);
        System.out.println(resultRetainAll);

        // toArray(T[] a) : 제네릭의 자료형과 길이가 동일한 Array를 넣어주면 해당 Array에 컬랙션의 원소를 채워주는듯하다.
        Integer[] arr = new Integer[collection.size()];
        collection.toArray(arr);
        // Integer[] arr2 = collection.toArray(arr);
        // System.out.println(Arrays.toString(arr));

        // iterator()
        Collection<Integer> collectionSet = new HashSet<>();
        fillCollection(collectionSet, 1, 5);
        Iterator<Integer> iterator = collectionSet.iterator();
        
        // contains(Object o)
        Collection<Integer> collection3 = new ArrayList<>();
        fillCollection(collection3, 1, 6);
        // System.out.println(collection3.contains(3));

        // containsAll(Collection<?> c)
        Collection<Integer> collection4 = new ArrayList<>();
        Collection<Integer> collection5 = new ArrayList<>();
        Collection<Integer> collection6 = new ArrayList<>();
        Collection<Integer> collection7 = new ArrayList<>();
        fillCollection(collection4, 1, 100);
        fillCollection(collection5, 10, 40);    // collection4의 부분집합
        fillCollection(collection6, 50, 200);   // 일부분 벗어남
        fillCollection(collection7, 200, 250);    // 완전히 벗어남
        String result1 = MessageFormat.format("[containsAll(Collection<?> c)] 부분집합 결과: {0}", collection4.containsAll(collection5));
        String result2 = MessageFormat.format("[containsAll(Collection<?> c)] 일부 벗어남남 결과: {0}", collection4.containsAll(collection6));
        String result3 = MessageFormat.format("[containsAll(Collection<?> c)] 완전히 벗어남남 결과: {0}", collection4.containsAll(collection7));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    private static void fillCollection(Collection collection, int start, int end) {
        for(int i = start; i < end; i++) {
            collection.add(i);
        }
    }

    // 메서드명 공통 규칙
    /**
     * 메서드명 공통 규칙
     * 복수형 : 단수형 + All, 매개변수는 항상 Collection 자료형을 받는다.
     * 
     * 컬렉션 자료형끼리는 합집합, 차집합, 교집합 모든 연산을 수행 할 수 있다.
     */
}
