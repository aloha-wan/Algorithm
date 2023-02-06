package Data_Structure;

import java.util.Scanner;
import java.util.Stack;

/**
 * 작  성  자 : Kim Do Wan
 * 일       자 : 2023. 2. 6.
 * 문제 제목 : 괄호의값
 * 문제 번호 : 2504
 * 문제 출처 : https://www.acmicpc.net/problem/2504
 * 
 * 문       제 : 4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.
 *           1.한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다.
 *           2.만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다.
 *           3.X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.
 *         예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다. 
 *         우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다.
 *         
 *           1.‘()’ 인 괄호열의 값은 2이다.
 *           2.‘[]’ 인 괄호열의 값은 3이다.
 *           3.‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
 *           4.‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
 *           5.올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
 *         예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자.  ‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로  ‘(()[[ ]])’의 괄호값은 2×11=22 이다. 
 *         그리고  ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.
 *         여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다. 
 *
 * 입       력 : 첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하이다.
 *
 * 출       력 : 첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. 
 *
 * 
 **/
public class Main_2504_괄호의값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.next();
		
		int mul = 1;
		int result = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < temp.length(); i++) {
			switch (temp.charAt(i)) {
			
			case '(':
				stack.push('(');
				mul *= 2;
				break;
				
			case '[':
				stack.push('[');
				mul *= 3;
				break;
				
			case ')':
				if(stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				
				if(temp.charAt(i - 1) == '(') result += mul;
				stack.pop();
				mul /= 2;
				break;
				
			case ']':
				if(stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				
				if(temp.charAt(i-1) == '[' ) result += mul;
				stack.pop();
				mul /= 3;
				break;
			}
		}
		
		System.out.println(!stack.isEmpty() ? 0 : result);
		
	}

}

