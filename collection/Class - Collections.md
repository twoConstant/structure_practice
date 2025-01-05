# Collections

> Collection을 상속받는 자료형을 대상으로 여러 편의 스테틱 메서드를 제공하는 구체 클래스. 이진탐색, 정렬, max, min값 탐색과 같은 기능을이 있다.

### 목차

- [컬렉션 자료형 전용 메서드](#%EC%BB%AC%EB%A0%89%EC%85%98-%EC%9E%90%EB%A3%8C%ED%98%95-%EC%A0%84%EC%9A%A9-%EB%A9%94%EC%84%9C%EB%93%9C)
  - [`disjoint(Collection<?> c1, Collection<?> c2)`](#disjointcollection-c1-collection-c2)
  - [`frequency(Collection<?> c, Object o)`](#frequencycollection-c-object-o)
  - [`max(Collection<? extends T> coll), min 동일`](#maxcollection-extends-t-coll-min-%EB%8F%99%EC%9D%BC)
  - [`max(Collection<? extends T> coll, Comparator<? super T> comp), min 동일`](#maxcollection-extends-t-coll-comparator-super-t-comp-min-%EB%8F%99%EC%9D%BC)
- [리스트 자료형 전용 메서드](#%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%A3%8C%ED%98%95-%EC%A0%84%EC%9A%A9-%EB%A9%94%EC%84%9C%EB%93%9C)
  - [`binarySearch(List<? extends Comparable<? super T>> list, T key)`](#binarysearchlist-extends-comparable-super-t-list-t-key)
  - [`binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`](#binarysearchlist-extends-t-list-t-key-comparator-super-t-c)
  - [`copy(List<? super T> dest, List<? extends T> src)`](#copylist-super-t-dest-list-extends-t-src)
  - [`fill(List<? super T> list, T obj)`](#filllist-super-t-list-t-obj)
  - [`replaceAll(List<T> list, T oldVal, T newVal)`](#replacealllistt-list-t-oldval-t-newval)
  - [`reverse(List<?> list)`](#reverselist-list)
  - [`sort(List<T> list)`](#sortlistt-list)
  - [`sort(List<T> list, Comparator<? super T> c)`](#sortlistt-list-comparator-super-t-c)
  - [`shuffle(List<?> list)`](#shufflelist-list)
  - [`swap(List<?> list, int i, int j)`](#swaplist-list-int-i-int-j)

## 컬랙션 자료형 전용 메서드

### `disjoint(Collection<?> c1, Collection<?> c2)`

- 사용처 : 두 컬랙션의 항목에 중복이 있는지 판단시 사용

- 반환 결과 : boolean

- 특이사항
  
  - 중복이 없는 경우 true를 반환한다.
  - disJoint가 아니다. disjoint이다.

- 예시 코드
  
  ```java
  List<String> listDisjoint1 = Arrays.asList("1", "2", "3", "4");
  List<String> listDisjoint2 = Arrays.asList("1", "2", "3", "5");
  String resultMessageOfDisjoint = MessageFormat.format("[disjoint(Collection<?> c1, Collection<?> c2)] : {0}", Collections.disjoint(listDisjoint1, listDisjoint2));
  System.out.println(resultMessageOfDisjoint);
  ```

### `frequency(Collection<?> c, Object o)`

- 사용처 : 컬랙션 내의 targetItem의 개수를 알고싶을 때

- 반환 결과 : int

- 특이사항

- 예시 코드
  
  ```java
  List<Integer> listFrequency = Arrays.asList(1, 2, 3, 4, 5, 5, 5);
  int resultOfFrequency = Collections.frequency(listFrequency, 5);
  String resultMessageOfFrequency = MessageFormat.format("[frequency(Collection<?> c, Object o)] : {0}", resultOfFrequency);
  System.out.println(resultMessageOfFrequency);
  ```

### `max(Collection<? extends T> coll)`, min 동일

- 사용처 : 원시 타입이 담긴 리스트에서 가장 큰 항목을 찾고싶을 때

- 반환 결과 : T

- 특이사항 : String의 경우 사전순서를 기준으로 판단한다.

- 예시 코드
  
  ```java
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
  ```

### `max(Collection<? extends T> coll, Comparator<? super T> comp)`, min 동일

- 사용처 : 객체를 담고있는 컬랙션의 객체 내의 특정 속성을 기준으로 max 항목을 찾고싶을 때

- 반환 결과 : T

- 특이사항

- 예시 코드
  
  ```java
  Collection<String> collMaxComparator = Arrays.asList("abd", "bsalfag", "dflj", "dflkjfsaf", "kfja;df", "za");
  // 단순 max를 구하는 경우
  String maxStringPlain = Collections.max(collMaxComparator);
  // 문자열의 두 번째 char를 기준
  String maxStringSecChar = Collections.max(collMaxComparator, (a, b) -> a.charAt(1) - b.charAt(1));
  String resultMessageOfMax2 = MessageFormat.format("[max(Collection<? extends T> coll)] : {0}", maxStringPlain);
  String resultMessageOfMaxComparator = MessageFormat.format("[max(Collection<? extends T> coll, Comparator<? super T> comp)] : {0}", maxStringSecChar);
  System.out.println(resultMessageOfMax2);
  System.out.println(resultMessageOfMaxComparator);
  ```

## 리스트 자료형 전용 메서드

### `binarySearch(List<? extends Comparable<? super T>> list, T key)`

- 사용처 : 원시타입을 담는 리스트의 targetItem의 index를 탐색

- 반환 결과 : int
  
  - 탐색항목이 존재하는 경우 : index
  - 탐색항목이 없는경우 : targetItem이 있다면 들어갈 자리의 index * (-1)

- 특이사항
  
  - 반드시 정렬된 상태에서 수행해야한다.

- 예시 코드
  
  ```java
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
  ```

### `binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`

- 사용처 : 리스트의 요소로 객체가 들어가 있을 때, 객체의 특정 속성을 기준으로 이진 탐색을 수행할 경우 사용한다.

- 반환 결과 : int, 상동.

- 특이사항 :
  
  - 정렬시 Comparator와 이진 탐색시 Comparator의 기준이 동일해야한다.

- 예시 코드
  
  ```java
  // String의 길이를 기준으로 이진탐색 예시
  List<String> listBinarySearchComparator = Arrays.asList("apple", "banana", "cherry", "date");
  // 길이 기준 오름자순 정렬렬
  Collections.sort(listBinarySearchComparator, (a, b) -> a.length() - b.length());
  int resultOfBinarySearchComparator1 = Collections.binarySearch(listBinarySearchComparator, "banana", (a, b) -> a.length() - b.length());
  String resultMessageBinarySearch4 = MessageFormat.format("[Collections.binarySearch - using Comparator] 정렬0 key 존재0 : {0}", resultOfBinarySearchComparator1);
  System.out.println(resultMessageBinarySearch4);
  ```

### `copy(List<? super T> dest, List<? extends T> src)`

- 사용처 : 한 리스트에 다른 리스트의 값을 그대로 복사하고 싶을때 사용한다.

- 반환 결과 : void

- 특이사항
  
  - 카피본의 리스트(destination)의 길이가 원본(src)의 길이보다 크거나 같아야한다.
  - 복사본의 리스트 길이가 원본을 초과하는 리스트의 값은 유지된다.

- 예시 코드
  
  ```java
  List<Integer> listCopyScr = Arrays.asList(10, 10, 10, 10);
  List<Integer> listCopyDes = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  Collections.copy(listCopyDes, listCopyScr);
  String resultMessageOfCopy = MessageFormat.format("[copy(List<? super T> dest, List<? extends T> src)] : {0}", listCopyDes.toString());
  System.out.println(resultMessageOfCopy);
  ```

### `fill(List<? super T> list, T obj)`

- 사용처 : 리스트의 전체 값을 특정 값으로 변경시

- 반환 결과 : void

- 특이사항 :

- 예시 코드
  
  ```java
  List<Integer> listFill = Arrays.asList(1, 2, 3, 4, 5);
  Collections.fill(listFill, 1);
  String resultMessageOfFill = MessageFormat.format("[fill(List<? super T> list, T obj)] : {0}", listFill.toString());
  System.out.println(resultMessageOfFill);
  ```

### `replaceAll(List<T> list, T oldVal, T newVal)`

- 사용처 : 리스트의 특정 값을 모두 다른 값으로 변경할때 사용

- 반환 결과 : boolean

- 특이사항 :

- 예시 코드
  
  ```java
  List<Integer> listReplaceAll = Arrays.asList(1, 2, 3, 4, 5, 5, 5);
  Collections.replaceAll(listReplaceAll, 5, 10);
  String resultMessageOfReplaceAll = MessageFormat.format("[replaceAll(List<T> list, T oldVal, T newVal)] : {0}", listReplaceAll.toString());
  System.out.println(resultMessageOfReplaceAll);
  ```

### `reverse(List<?> list)`

- 사용처 : 기존의 리스트 순서를 거꾸러 뒤집을 때

- 반환 결과 : void

- 특이사항 : 오름차순 정렬을하는것이 아니다.

- 예시 코드
  
  ```java
  List<Integer> listReverse = new ArrayList<>();
  fillCollection(listReverse, 1, 100);
  Collections.shuffle(listReverse);
  Collections.reverse(listReverse);
  String resultMessageOfReverse = MessageFormat.format("[reverse(List<?> list)] : {0}", listReverse.toString());
  System.out.println(resultMessageOfReverse);
  ```

### `sort(List<T> list)`

- 사용처 : 원시 자료형을 담은 리스트를 오름차순 정렬하고싶을 때

- 반환 결과 : void

- 특이사항 : 오름차순 기준 정렬이다. String 자료형의 경우 사전순으로 정렬된다.

- 예시 코드
  
  ```java
  Collections.sort(listReverse);
  String resultMessageOfSort = MessageFormat.format("[sort(List<?> list)] : {0}", listReverse.toString());
  System.out.println(resultMessageOfSort);
  ```

### `sort(List<T> list, Comparator<? super T> c)`

- 사용처 : 여러 기준을 바탕으로 정렬을 하고싶은 경우 사용

- 반환 결과 : void

- 특이사항 :

- 예시 코드
  
  ```java
  Collections.sort(listReverse, (a, b) -> b - a);    // 내림차순 정렬
  String resultMessageOfSortReverseOrder = MessageFormat.format("[sort(List<T> list, Comparator<? super T> c)] : {0}", listReverse.toString());
  System.out.println(resultMessageOfSortReverseOrder);
  ```

### `shuffle(List<?> list)`

- 사용처 : 리스트 섞을 때

- 반환 결과 : void

- 특이사항 :

- 예시 코드
  
  ```java
  Collections.shuffle(list);
  ```

### `swap(List<?> list, int i, int j)`

- 사용처 : 리스트의 두 항목의 서로의 위치를 교환할 때

- 반환 결과 : void

- 특이사항 :

- 예시 코드
  
  ```java
  List<Integer> listSwap = new ArrayList<>();
  fillCollection(listSwap, 1, 10);
  Collections.swap(listSwap, 0, 9);
  String resultMessageOfSwap = MessageFormat.format("[swap(List<?> list, int i, int j)] : {0}", listSwap.toString());
  System.out.println(resultMessageOfSwap);
  ```
