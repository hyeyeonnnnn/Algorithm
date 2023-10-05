# Algorithm 코딩테스트 풀이


# 에라토스테네스의 체
"소수가 되는 수의 배수를 지우면 남은 건 소수가 된다"라고 생각하는 알고리즘입니다.
소수가 무엇인지 찾을 필요가 없으며 2부터 자기 자신을 제외한 배수가 되는 것을 지우면 됩니다. 
1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
2. 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
자기 자신을 제외한 2의 배수를 모두 지운다.
남아 있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.자기 자신을 제외한 3의 배수를 모두 지운다.
남아 있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
자기 자신을 제외한 5의 배수를 모두 지운다.
위 과정을 반복한다.
그림의 경우 11^2 > 120이므로 11보다 작은 수의 배수들만 지워도 충분히 구할 수 있다.

120보다 작거나 같은 수 가운데 2, 3, 5, 7의 배수를 지우고 남은 수는 모두 소수이다.

 


[Java로 구현해보기]
에라토스테네스의 체를 Java로 구현해보겠습니다.
 

public class Solution {

	// 예제와 같이 120까지의 소수를 구하기 위해 120 선언.
	static boolean prime[] = new boolean[121];
    
    public static void main(String[] args) throws Exception{
		
        // 구하고자 하는 숫자 범위
        int N = 120;
        
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=N; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<=N; j+=i) prime[j] = true;                
            }        
        }    
        
        // 소수 출력
        for(int i=1; i<=N;i++){
        	if(!prime[i]) System.out.print(i+" ");        
        }
        
    }
}
 

위 방식대로 소수를 구해보면 i가 11*11이 되면 120보다 크기 때문에 종료됩니다.

그리고 소수를 출력하면 120까지의 소수를 구할 수 있습니다.

 

소수를 구하고자 하는 알고리즘 문제에서는 에라토스테네스의 체를 이용하시면 쉽게 구할 수 있습니다.

 

위 코드를 이용해서 4,000,000까지의 소수를 구한다면 아래와 같이 구할 수 있습니다.

 

public class Solution {

	// 예제와 같이 120까지의 소수를 구하기 위해 120 선언.
	static boolean prime[] = new boolean[4000001];
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
		
		// 구하고자 하는 숫자 범위
        int N = 4000000;
        
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=N; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<=N; j+=i) prime[j]=true;                
            }        
        }    
        
        // 소수 출력
        for(int i=1; i<=N;i++){
        	if(!prime[i]) prime_numbers.add(i);     
        }
        
        // 4000000까지 소수 개수
        System.out.println(prime_numbers.size());
        // 소수 확인 
        for(int i=1; i<=10; i++) {
        	System.out.println(prime_numbers.get(i));
        }
        
    }
}
