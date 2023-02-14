package Dynamic_Programming;

import java.util.*;

/**
 * ��  ��  �� : Kim Do Wan
 * ��       �� : 2023. 2. 14.
 * ���� ���� : �ڵγ���
 * ���� ��ȣ : 2240
 * ���� ��ó : https://www.acmicpc.net/problem/2240
 * 
 * ��       �� : �ڵδ� �ڵθ� �����Ѵ�. �׷��� ���� �ڵγ����� �ɾ�ΰ�, ���⼭ ������ �ڵθ� �԰�� �Ѵ�. ������ �ڵδ� Ű�� �۾Ƽ� �ڵθ� �������� ���ϰ�, �ڵΰ� ������ ������ ��ٸ� ������ �������� �ڵθ� �޾Ƽ� �԰�� �Ѵ�. 
 *         �ڵθ� ���� ������ �ڵΰ� ����� ���� �� ��ƾ� �ϴµ�, �̴� �ڵΰ� ���������Ͽ� �ٴڿ� �������� �� ���� ������ �������� �����̴�.
 *         �� �ʸ���, �� ���� ���� �� �ϳ��� �������� ���Ű� �������� �ȴ�. ���� ���Ű� �������� ����, �ڵΰ� �� ������ �Ʒ��� �� ������ �ڵδ� �� ���Ÿ� �޾Ƹ��� �� �ִ�. 
 *         �� ���� ������ �״��� �ָ� ������ ���� �ʱ� ������, �ڵδ� �ϳ��� ���� �Ʒ��� �� �ִٰ� �ٸ� ���� �Ʒ��� ������(1�ʺ��� �ξ� ª�� �ð���) ������ �� �ִ�. ������ �ڵδ� ü���� �״��� ���� ���ؼ� ���� ������ ���� ����.
 *         �ڵδ� T(1��T��1,000)�� ���� �������� �ȴ�. �ڵδ� �ִ� W(1��W��30)���� �����̰� �;� �Ѵ�. �� �ʸ��� ��� �������� �ڵΰ� ���������� ���� ������ �־����� ��, �ڵΰ� ���� �� �ִ� �ڵ��� ������ ���س��� ���α׷��� �ۼ��Ͻÿ�. 
 *         �ڵδ� 1�� �ڵγ��� �Ʒ��� ��ġ�� �ִٰ� �Ѵ�.
 *
 * ��       �� : ù° �ٿ� �� ���� T, W�� �־�����. ���� T���� �ٿ��� �� ������ �ڵΰ� �������� ������ ��ȣ�� 1 �Ǵ� 2�� �־�����.
 *
 * ��       �� : ù° �ٿ� �ڵΰ� ���� �� �ִ� �ڵ��� �ִ� ������ ����Ѵ�.
 *
 * 
 **/
public class Main_2240_�ڵγ��� {

    static int n;
    static int w;
    static int[][][] memo;
    static int[] arr;
    public static int dp(int index, int location, int count){ // �����ε���, ���� ��ġ, �̵�Ƚ��
        if(index == n || count==w+1){ //�迭 ����� ����� ���ϰ� base-case ����
            return 0;
        }
        if(memo[index][location][count] != -1) return memo[index][location][count];

        int temp = 0;
        //�ش� ��ġ�� ������ �ֱ�
        if(location == arr[index]) temp = Math.max(dp(index+1, location, count)+1, temp);
        else temp = Math.max(dp(index+1, location, count), temp);

        //2�� ��ġ -> 1�� ��ġ
        if(location == 2){
            if(location == arr[index]) temp = Math.max(dp(index+1, 1, count+1)+1, temp);
            else temp = Math.max(dp(index+1, 1, count+1), temp);
        }

        //1����ġ -> 2�� ��ġ
        if(location == 1){
            if(location == arr[index]) temp = Math.max(dp(index+1, 2, count+1)+1, temp);
            else temp = Math.max(dp(index+1, 2, count+1), temp);
        }
        memo[index][location][count] = temp;
        return memo[index][location][count];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // �������� �ڵ� ����
        w = sc.nextInt(); // ������ �� �ִ� �ִ� Ƚ��
        memo = new int[n][3][31];
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        for(int[][] a : memo){
            for(int[] b : a) Arrays.fill(b, -1);
        }

        int max = 0;
        max = Math.max(dp(0, 1, 0), max); 
        max = Math.max(dp(0,2,1),max); //2���������� �����Ѵٴ� ���� 1���������� 2�������� �̵��ߴٴ� �� ���ϹǷ� count�� 1�� ��
        System.out.println(max);

    }
}