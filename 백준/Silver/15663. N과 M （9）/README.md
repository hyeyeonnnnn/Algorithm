# [Silver II] N과 M (9) - 15663 

[문제 링크](https://www.acmicpc.net/problem/15663) 

### 성능 요약

메모리: 46040 KB, 시간: 436 ms

### 분류

백트래킹

### 제출 일자

2023년 11월 2일 12:15:33

### 문제 설명

<p>N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.</p>

<ul>
	<li>N개의 자연수 중에서 M개를 고른 수열</li>
</ul>

### 입력 

 <p>첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)</p>

<p>둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.</p>

<p>수열은 사전 순으로 증가하는 순서로 출력해야 한다.</p>


## HashSet vs LinkedHashSet vs TreeSet
근데 Set의 경우에는 중복이 허용이 안되고 순서가 없다

일단 넣고 출력을 해 보면 아무렇게나 막 나온다는 말이다







정의는

HashSet<변수 자료형> set명 = new HashSet<>();

이런 식으로 하면 된다



먼저 HashSet 형태의 set을 만들고 

add를 통해 알파벳들을 삽입을 했다



set은 순서가 없어서 list 처럼 출력 시 .get으로 출력이 안되는데

따라서 Iterator 객체를 만들어 줘서 순서를 만든 다음 그 이후에 출력을 해야 한다



Iterator는

Iterator<변수 자료형> Iterator명 = 가져올set명.iterator();



로 정의를 하고 iterator명으로 값을 가져오는데

while을 사용해서



 iterator명.hasNext()

다음 값이 있다면



iterator명.next() 

다음 값



이런 식으로 값을 가져올 수 있다

출력을 한번 해 보면







이런 식으로 add 한 순서와 상관없이

아무렇게나 출력이 되고

a를 여러개 넣었지만 출력되는 a는 하나뿐이다



왜냐면 중복을 허용하지 않기 때문에 여러개의 a를 넣어도 하나만 출력된다



다음은 set의 종류인데

HashSet, TreeSet, LinkedHashSet인데



HashSet은 중복이 안되고 순서가 없는 형태의 Set이고

TreeSet은 HashSet에서 값에 따라(a-z, 1-9) 순서를 만들어 주는 Set이고

LinkedHashSet은 add 한 순서에 따라 순서가 결정되는 Set이다



예제를 통해 보자면







TreeSet은 add를 어떻게 했던 간에

a-z 1-9 이런 식으로 값에 따라 순서를 만들어서 출력하게 된다







LinkedHashSet은 add 한 순서에 따라 출력이 된다



즉 Set은 기본적으로 중복이 안되고

종류에 따라 값에 따라 순서를 만들어 주는 TreeSet과

삽입 순서에 따라 순서를 만들어 주는 LinkedHashSet이 있다







마지막으로 Set 역시 일반 배열로 변환이 가능한데



변수 자료형 배열명[] = Set명.toArray(new 변수 자료형[Set명.size()]); 를 통해

Set을 가지고 일반 배열 형태로 만들어 줄 수 있다
