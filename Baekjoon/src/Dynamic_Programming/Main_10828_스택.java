package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 작  성  자 : Kim Do Wan
 * 일       자 : 2023. 2. 17.
 * 문제 제목 : 스택_구현소스
 * 문제 번호 : 10828
 * 문제 출처 : https://www.acmicpc.net/problem/10828
 * 
 * 문       제 : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *          명령은 총 다섯 가지이다.
 *          push X: 정수 X를 스택에 넣는 연산이다.
 *          pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *          size: 스택에 들어있는 정수의 개수를 출력한다.
 *          empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 *          top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * 입       력 : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
 *          주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 * 출       력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 *
 * 
 **/
public class Main_10828_스택 {

	public static void main(String[] args) throws IOException {

		//Stack 객체 선언
		Stack<Integer> s = new Stack<Integer>();
		
		//BufferReader, BufferedWriter 객체선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//첫번� 줄에 명령의 수 N
		//readLine은 String 형태로 리턴하므로 형 변환이 필수.
		int n = Integer.parseInt(br.readLine());
		
		//명령의 수 N만큼 반복
		for(int i = 0; i < n; i++) {
			//명령은 push 14 형태이므로, " "으로 split
			// split(구분값) 구분값 기준으로 분리하여 저장.
			String[] ord = br.readLine().split(" ");
			
			//스위치문으로 명령문 마다 행위를 정의
			switch(ord[0]) {
			case "push" :
				//정수 ord[1]을 스택에 넣는 연산
				s.push(Integer.parseInt(ord[1]));
				break;
				
			case "pop" :
				//스택에서 가장 위에 있는 정수를 �馨� 그 수를 출력
				//단, 스택이 비어있는 경우에는 -1을 출력
				if(s.empty()) {
					//BuffereaWriter의 write 함수는 개행문자 포함하지 않고 있어 일일이 넣어주거나
					//bw.newLine(); 을 추가해 줄바꿈 해줘야 한다.
					bw.write("-1" + "\n");
				} else {
					bw.write(s.pop() + "\n");
				}
				break;
				
			case "size" :
				//스택에 들어있는 정수의 개수 출력
				bw.write(s.size() + "\n");
				
				break;
			case "empty" :
				//스택이 비어 있으면 1 출력
				if(s.empty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
				break;

			case "top" :
				//스택의 가장 위에 있는 정수를 출력
				if(s.empty()){
					bw.write("-1" + "\n");
				} else {
					bw.write(s.peek() + "\n");
				}
				break;
			}
			
		}
		//버퍼에 남아 있는 문자열을 출력해서 버퍼를 지움
		bw.flush();
		//스트림 닫아주기
		bw.close();
		
	}

}
