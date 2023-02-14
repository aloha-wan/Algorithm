package Dynamic_Programming;

import java.util.*;

/**
 * 작  성  자 : Kim Do Wan
 * 일       자 : 2023. 2. 14.
 * 문제 제목 : 자두나무
 * 문제 번호 : 2240
 * 문제 출처 : https://www.acmicpc.net/problem/2240
 * 
 * 문       제 : 자두는 자두를 좋아한다. 그래서 집에 자두나무를 심어두고, 여기서 열리는 자두를 먹고는 한다. 하지만 자두는 키가 작아서 자두를 따먹지는 못하고, 자두가 떨어질 때까지 기다린 다음에 떨어지는 자두를 받아서 먹고는 한다. 
 *         자두를 잡을 때에는 자두가 허공에 있을 때 잡아야 하는데, 이는 자두가 말랑말랑하여 바닥에 떨어지면 못 먹을 정도로 뭉개지기 때문이다.
 *         매 초마다, 두 개의 나무 중 하나의 나무에서 열매가 떨어지게 된다. 만약 열매가 떨어지는 순간, 자두가 그 나무의 아래에 서 있으면 자두는 그 열매를 받아먹을 수 있다. 
 *         두 개의 나무는 그다지 멀리 떨어져 있지 않기 때문에, 자두는 하나의 나무 아래에 서 있다가 다른 나무 아래로 빠르게(1초보다 훨씬 짧은 시간에) 움직일 수 있다. 하지만 자두는 체력이 그다지 좋지 못해서 많이 움직일 수는 없다.
 *         자두는 T(1≤T≤1,000)초 동안 떨어지게 된다. 자두는 최대 W(1≤W≤30)번만 움직이고 싶어 한다. 매 초마다 어느 나무에서 자두가 떨어질지에 대한 정보가 주어졌을 때, 자두가 받을 수 있는 자두의 개수를 구해내는 프로그램을 작성하시오. 
 *         자두는 1번 자두나무 아래에 위치해 있다고 한다.
 *
 * 입       력 : 첫째 줄에 두 정수 T, W가 주어진다. 다음 T개의 줄에는 각 순간에 자두가 떨어지는 나무의 번호가 1 또는 2로 주어진다.
 *
 * 출       력 : 첫째 줄에 자두가 받을 수 있는 자두의 최대 개수를 출력한다.
 *
 * 
 **/
public class Main_2240_자두나무 {

    static int n;
    static int w;
    static int[][][] memo;
    static int[] arr;
    public static int dp(int index, int location, int count){ // 현재인덱스, 현재 위치, 이동횟수
        if(index == n || count==w+1){ //배열 사이즈를 벗어나지 못하게 base-case 설정
            return 0;
        }
        if(memo[index][location][count] != -1) return memo[index][location][count];

        int temp = 0;
        //해당 위치에 가만히 있기
        if(location == arr[index]) temp = Math.max(dp(index+1, location, count)+1, temp);
        else temp = Math.max(dp(index+1, location, count), temp);

        //2번 위치 -> 1번 위치
        if(location == 2){
            if(location == arr[index]) temp = Math.max(dp(index+1, 1, count+1)+1, temp);
            else temp = Math.max(dp(index+1, 1, count+1), temp);
        }

        //1번위치 -> 2번 위치
        if(location == 1){
            if(location == arr[index]) temp = Math.max(dp(index+1, 2, count+1)+1, temp);
            else temp = Math.max(dp(index+1, 2, count+1), temp);
        }
        memo[index][location][count] = temp;
        return memo[index][location][count];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 떨어지는 자두 갯수
        w = sc.nextInt(); // 움직일 수 있는 최대 횟수
        memo = new int[n][3][31];
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        for(int[][] a : memo){
            for(int[] b : a) Arrays.fill(b, -1);
        }

        int max = 0;
        max = Math.max(dp(0, 1, 0), max); 
        max = Math.max(dp(0,2,1),max); //2번나무에서 시작한다는 것은 1번나무에서 2번나무로 이동했다는 걸 뜻하므로 count를 1로 함
        System.out.println(max);

    }
}