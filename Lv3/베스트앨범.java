/* 나의 풀이
- 라기엔 전체적인 알고리즘은 내가 생각했지만, 정확한 구현이 어려워서 chat gpt가 풀어준 문제였다. 나한텐 이게 구현이야...
1️⃣ HashMap map 에 (String 장르): (ArrayList 인덱스(고유번호)) 저장
2️⃣ map의 value인 ArrayList 정렬
  (1) plays 배열의 내림차순 정렬
  (2) 인덱스 오름차순 정렬
3️⃣ HashMap sumMap 에 (String 장르): (Intger map의 고유번호의 plays sum값) 저장
4️⃣ sumMap의 value인 Integer sum 값에 따라서 내림차순 정렬하여 List sortedGenres에 (String 장르) 저장
5️⃣ sortedGenres 값에 따라 key값 찾아서 장르마다 2개 이하의 인덱스 ArrayList result에 저장 (크기가 가변적이므로 int[] 혹은 Integer[]로 하지 않았음)
6️⃣ result를 int 배열 형태로 리턴
*/

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(i);
        }
        
        for(String key: map.keySet()) {
            map.get(key).sort((a, b) ->
                             {if(plays[a] != plays[b])
                                 return Integer.compare(plays[b], plays[a]);
                             else 
                                 return Integer.compare(a, b);}
                             );
        }
        
        HashMap<String, Integer> sumMap = new HashMap<>();
        for(String key: map.keySet()) {
            int tmp = 0;
            for(int index: map.get(key)) {
                tmp += plays[index];
            }
            sumMap.put(key, tmp);
        }
        
        List<String> sortedGenres = new ArrayList<>(sumMap.keySet());
        sortedGenres.sort((a, b) -> sumMap.get(b) - sumMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for(String genre: sortedGenres) {
            List<Integer> songs = map.get(genre);
            result.add(songs.get(0));
            if(songs.size() > 1) {
                result.add(songs.get(1));
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}



/* 배운 점
- 나는 정렬 문제에 취약한 것 같다. 도전부터 주춤하게 되는 그런 문제가 나한테는 정렬 문제이다. 이번 기회에 제대로 배우고 가고자 한다. 코드를 다시 보자.

- 배열을 정렬하는 방법
<ArrayList (List) ver.>

List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1));
// 방법 1. List.sort()
list.sort(Integer::compareTo); // 오름차순 정렬
list.sort(Comparator.reverseOrder()); // 내림차순 정렬
// 방법 2. 
Collections.sort(list); // 오름차순 정렬
Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

// 람다식을 이용하는 sort() (오름차순 ver)
// 방법 1. Integer.compare(x, y) => 안전하다고 함
- list.sort((x, y) -> Integer.compare(x, y));
-- 내부 동작
public static int compare(int x, int y) {
    return (x < y) ? -1 : ((x == y) ? 0 : 1);
}

// 방법 2. x - y
- list.sort((x, y) -> x - y); // Integer 범위를 넘으면 오버플로우 가능성 있음 (int 범위 내이면 계산속도는 빠르다고 함)


<int[], Integer[] ver.>

int[] arr = {5, 2, 8, 1};
// 방법 1. Arrays.sort()
Arrays.sort(arr); // 오름차순 정렬
Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬 -> Integer 배열로만 가능, int 배열은 불가능
==> int[] 배열 내림치순 정렬
// 방법 1-1. int형을 Integer로 변환 후에 정렬
Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new); // `int[]` → `Integer[]`
Arrays.sort(temp, Collections.reverseOrder()); // 내림차순 정렬
// 방법 1-2. stream 이용 (방법2)
arr = Arrays.stream(arr) // 배열을 스트림으로 변환
        .boxed() // `int` → `Integer`
        .sorted(Collections.reverseOrder()) // 내림차순 정렬
        .mapToInt(Integer::intValue) // 다시 `int[]`로 변환
        .toArray();
        
// 방법 2. stream 이용
arr = Arrays.stream(arr) // 배열을 스트림으로 변환
            .sorted() // 오름차순 정렬
            .toArray(); // 다시 배열로 변환


- 배열을 리스트로, 리스트를 배열로 바꾸는 방법

<Integer 배열 -> List>
List<Integer> list = Arrays.asList(arr);

<int 배열 -> List> // 혹은 수동변환 (add사용)
List<Intger> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

<List -> 배열>
List<Integer> list = ...;
// Intger 배열로
// 방법 1.
Intger[] arr = list.toArray(new Integer[0]);
// 방법 2.
Integer[] array = list.stream().toArray(Integer[]::new);

// int 배열로
int[] array = list.stream().mapToInt(i -> i).toArray();


*/
