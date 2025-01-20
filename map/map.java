package structure_practice.map;

import java.text.MessageFormat;
import java.util.*;

public class map {
    public static void main(String[] args) {
        /**
         * Set<K>    keySet()    done
         * Collection<V>    values()    done
         * Set<Map.Entry<K,V>>    entrySet()    done
         * default V    compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)    done
         * containsKey(Object key)   done
         * containsValue(Object value)    done
         * static <K,V> Map<K,V>    copyOf(Map<? extends K,? extends V> map)    done
         * static <K,V> Map.Entry<K,V>    entry(K k, V v)    done
         * default void    forEach(BiConsumer<? super K,? super V> action)    done
         * V    get(Object key)    done
         * default V    getOrDefault(Object key)    done
         * isEmpty()    done
         * V    put(K key, V value)    done
         * void    putAll(Map<? extends K,? extends V> m)    
         * default V     putIfAbsent(K key, V value)    done
         * V    remove(Object key)    done
         * default boolean    remove(Object key, Object value)    done
         * replace(K key, V value)    done
         * replace(K key, V oldValue, V newValue)    done
         * replaceAll(BiFunction<? super K,? super V,? extends V> function)
         * size()    done
         */

        /**
         * 쓸만한 발견 
         * values() => Collections 메서드를 사용할 수 있게됨
         * compute() => key값에 대한 value 업데이트를 편하게 할 수 있음
         * forEach() => map의 모든 entry를 돌면서 특정 기능을 수행 할 수 있음
         */

         Map<String, Integer> map = new HashMap();
         map.put("apple", 1);
         map.put("banana", 3);
         map.put("kerrot", 5);
         map.put("orange", 6);
         map.put("tomato", 4);

         /**
         * 메서드 명 : keySet()
         * 사용처 : Map의 키 값을 Set 자료형으로 변경할 때 사용한다.
         * 반환 결과 : Set<K>
         * 특이사항 :
         */
        Map<String, Integer> mapKeySet = Map.copyOf(map);
        Set<String> setKeySet = mapKeySet.keySet();
        String result1 = MessageFormat.format("[keySet()]: {0}", setKeySet.getClass());
        System.out.println(result1);
        


         /**
         * 메서드 명 : values()
         * 사용처 : map의 값들을 Collection으로 변경해서 사용하고 싶을떄 특히 Collections의 다양한 메서드를 사용가능해진다.
         * 반환 결과 :
         * 특이사항 :
         */
        Map<String, Integer> mapValues = Map.copyOf(map);
        Collection<Integer> collValues = mapValues.values();
        int maxValue = Collections.max(collValues);
        String messageValues = MessageFormat.format("[values()]: {0}", maxValue);
        System.out.println(messageValues);

         /**
         * 메서드 명 : Set<Map.Entry<K,V>>    entrySet()
         * 사용처 : key와 value를 한방에 돌릴때 사용용
         * 반환 결과 : Map.Entry<K, V>
         * 특이사항 : Map.Entry가 자료형 그 자체인듯하다. 오직 Map에서만 사용하기 때문에 그렇다고함함
         */
        Map<String, Integer> mapEntrySet = Map.copyOf(map);
        Set<Map.Entry<String, Integer>> setEntrySet = map.entrySet();
        StringBuilder sb = new StringBuilder();
        sb.append("[entrySet()]: \n");
        for( Map.Entry<String, Integer> entry : setEntrySet) {
            sb.append("key: " + entry.getKey() + " value: " + entry.getValue() + "\n");
        }
        System.out.println(sb.toString());
        

         /**
         * 메서드 명 : static <K,V> Map.Entry<K,V>    entry(K k, V v)
         * 사용처 :
         * 반환 결과 : 케빌류를 바로 Entry로 만들어준다.
         * 특이사항 : 그냥 키벨류를 Entry로 만드는 용도임임
         */
        Map<String, Integer> mapEntry = Map.copyOf(map);
        Map.Entry<String, Integer> entryEntry1 = Map.entry("apple", 1);
        Map.Entry<String, Integer> entryEntry2 = Map.entry("apple", 12);

        String resultEntry1 = MessageFormat.format("[entry(K k, V v)]: 유효한 키벨류인경우: {0}", entryEntry1);
        String resultEntry2 = MessageFormat.format("[entry(K k, V v)]: 유효하지 않은은 키벨류인경우: {0}", entryEntry2);
        System.out.println(resultEntry1);
        System.out.println(resultEntry2);



         /**
         * 메서드 명 : putIfAbsent(K key, V value)
         * 사용처 : 기존의 put은 key 상관없이 그냥 덮어쓰는 반면 해당 메서드는 key가 없거나 value가 null인경우 들어감
         * 반환 결과 :
         * 특이사항 :
         */
        // 없는 key인경우 => 들어감감
        // key가 있는데 값이 다른 경우 => 안들어감감
        // key가 있는데 value가 null 인경우우 => 들어감감
        // Map<String, Integer> mapPutIfAbsent = Map.copyOf(map); 이렇게 하면 불변이라 수정이 안됨
        Map<String, Integer> mapPutIfAbsent = new HashMap<>(map);
        mapPutIfAbsent.put("example", null);
        mapPutIfAbsent.putIfAbsent("newKey", 100);
        mapPutIfAbsent.putIfAbsent("apple", 100);
        mapPutIfAbsent.putIfAbsent("example", 100);
        System.out.println("raw map: " + map);
        System.out.println("[putIfAbsent(K key, V value)]:" + mapPutIfAbsent.toString());

         /**
         * 메서드 명 : replace(K key, V value)
         * 사용처 : key가 존재하기만하면 value를 특정 값으로 변경하고 싶을때
         * 반환 결과 : 변경된경우 변경전 value, 없는 key인경우 null을 반환환
         * 특이사항 :
         */
        Map<String, Integer> mapReplace1 = new HashMap<>(map);
        System.out.println(mapReplace1.replace("apple", 100));
        System.out.println(mapReplace1.replace("nonekey", 1));

         /**
         * 메서드 명 : replace(K key, V value)
         * 사용처 : 특정 key와 value 모두 만족하는 경우 변경하고싶을때때
         * 반환 결과 : 변경된 경우 : true, 변경되지 않은 경우 false
         * 특이사항 :
         */
        Map<String, Integer> mapReplace2 = new HashMap<>(map);
        System.out.println(mapReplace2.replace("apple", 1, 1000));
        System.out.println(mapReplace2.replace("apple", 10, 1000));


         /**
         * 메서드 명 : compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
         * 사용처 : value값을 특정 규칙에 따라 연산하며 업데이트 할 경우에 사용한다.
         * 반환 결과 :
         * 특이사항 : key값이 없으면 알아서 생성한다. 그리고 value값을 null 로 변경시켜 없앨 수 있다.
         */
        Map<String, Integer> mapComput = new HashMap<>();
        // key: compute 인놈을 없으면 만들고 10회 루프를 돌변서 value를 갱신한다.
        for(int i = 0; i < 10; i++) {
            mapComput.compute("compute", (String k, Integer oldValue) -> (oldValue == null)? 1: oldValue + 1);
        }
        System.out.println("[compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)]: " + mapComput);

         /**
         * 메서드 명 : default void    forEach(BiConsumer<? super K,? super V> action)
         * 사용처 : 현재 map의 모든 entry를 순회하면서 어떤 작업을 하고싶을때 사용, 굳이 entrySet해서 안돌아도된다.
         * 반환 결과 :
         * 특이사항 :
         */
        // 모든 value에 10을 더하라
        Map<String, Integer> mapForEach = new HashMap<>(map);
        mapForEach.forEach((K, V) -> {
            mapForEach.put(K, V + 10);
        });
        System.out.println(mapForEach);

    }
}
