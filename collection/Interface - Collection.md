# Collection

> java에서 제공하는 다양한 자료구조의 최상위 인터페이스로 이놈이 제공하는 기능 상속 관계에 있는 모든 자료구조에서 공통으로 제공하는 기능이니 반드시 숙지해야한다.

### 상태 확인 메서드

- `int size()` : 컬랙션의 현재 보유한 아이템의 개수를 반환
- `boolean isEmpty()` : 컬랙션이 비어있는지 확인
- `int hashCode()` : 컬랙션 객체의 고유 식별 번호를 반환

### 아이템 연산

- `boolean add(E e)` : e를 컬랙션에 추가
- `boolean remove(Object o)` : o를 컬랙션에서 삭제한다.
- `boolean contains(Object o)` : o가 컬랙션에 있는지 확인한다.
- `boolean clear()` : 컬랙션 초기화

### 집합 연산

- `boolean addAll(Collection<? extends E> c)` : 파괴메서드, 컬랙션 c의 모든 항목을 추가한다. 하위 구현체에 따라 중복을 허용할수도 하지 않을 수도 있다.
  
  ```java
  Collection<Integer> collection = new ArrayList<>();
  List<Integer> list = new ArrayList<>();
  fillCollection(list, 1, 6);
  fillCollection(collection, 1, 6);
  collection.addAll(list);
  String result = MessageFormat.format("[addAll(Collection<? extends E> c)] {0}", collection);
  System.out.println(result);
  ```

- `boolean removeAll(Collection<?> c)` : 파괴메서드, 컬랙션 c와 중복되는 모든 항목을 삭제한다. ⇒ 차집합
  
  ```java
  Collection<Integer> collection1 = new ArrayList<>();    // [1, 2, 3, 4, 5]
  Collection<Integer> collection2 = new ArrayList<>();    // [4, 5, 6, 7]
  fillCollection(collection1, 1, 6);
  fillCollection(collection2, 4, 8);
  collection1.removeAll(collection2);
  String resultRemoveAll = MessageFormat.format("[removeAll(Collection<?> c)] {0}", collection1);
  System.out.println(resultRemoveAll);
  ```

- `boolean retainAll(Collection<?> c)` : 파괴메서드, 컬랙션 c와 중복되는 모든 항목만 남긴다. ⇒ 교집합
  
  ```java
  Collection<Integer> collectionRetainAll1 = new ArrayList<>();
  Collection<Integer> collectionRetainAll2 = new ArrayList<>();
  fillCollection(collectionRetainAll1, 1, 11);
  fillCollection(collectionRetainAll2, 6, 16);
  collectionRetainAll1.removeAll(collectionRetainAll2);
  String resultRetainAll = MessageFormat.format("[retainAll(Collection<?> c)] {0}", collectionRetainAll1);
  System.out.println(resultRetainAll);
  ```

- `boolean removeIf(Predicate<? superE> filter)` : 파괴메서드, 컬랙션에서 조건을 만족하는 항목만 남기고 모두 삭제한다. filter를 만드는 방식과 람다식을 활용한 방법 2가지가 있다.
  
  ```java
  Collection<Integer> collectionRemoveIf = new ArrayList<>();
  fillCollection(collectionRemoveIf, 1, 11);     
  collectionRemoveIf.removeIf((n) -> n % 2 == 0);
  String resultOfRemoveIf= MessageFormat.format("[removeIf(Predicate<? super E> filter)] 짝수 제거 {0}", collectionRemoveIf.toString());
  System.out.println(resultOfRemoveIf);
  ```
  
  ```java
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
  ```

- `boolean containsAll(Collection<?> c)` : 컬랙션 c의 모든 항목이 포함관계있는 경우 true를 반환한다.
  
  ```java
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
  ```

### 형변환

- `<T> T[] toArray(T[] a)` : 컬랙션 제네릭 타입과 동일한 항목을 담은 배열을 반환한다. 파괴 메서드이자 비파괴 메서드이다.
  
  ```java
  // toArray(T[] a) : 제네릭의 자료형과 길이가 동일한 Array를 넣어주면 해당 Array에 컬랙션의 원소를 채워주는듯하다.
  Integer[] arr = new Integer[collection.size()];
  collection.toArray(arr);
  // Integer[] arr2 = collection.toArray(arr);    // 이렇게도 가능.
  ```

- `default Stream<E> stream()` : 컬랙션 제네릭 타입과 동일한 스트림을 반환한다.

- `Iterator<E> iterator()` : 컬랙션 제네릭 타입과 동일한 iterator를 반환한다.

- `default Spliterator<E> spliterator()` : 컬랙션 제네릭 타입과 동일한 spliterator를 반환한다.

### 전체 정리

- 컬랙션 자료형은 컬랙션 자료형끼리 모든 집합 연산이 가능하다.
- 컬랙션 연산의 경우 -All이 접미사로온다.

### 문제 형식 정리

1. 초기 길이가 10으로 선언된 collection의 size() 는 10이다. 참 거짓

2. 기본적인 삽입 삭제는 인덱스를 기준으로 이뤄진다. 참 거짓

3. 거짓, size()는 해당 컬랙션이 현재 보유하고있는 항목의 수로 주어진 정보로는 알수 없다.

4. 거짓, 그냥 항목 자체를 가지고 이뤄진다. 인덱스를 활용한 방식은 이후 구현체에서 오버로딩해 사용.
