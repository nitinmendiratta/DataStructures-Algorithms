package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/fizz-buzz/
 */
public class E_0412_FizzBuzz {

	public List<String> fizzBuzz(int n) {
		List<String> resultList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15 == 0){
                resultList.add("FizzBuzz");
            }else if(i%3 == 0){
                 resultList.add("Fizz");
            }else if(i%5==0){
                resultList.add("Buzz");
            }else{
                resultList.add(""+i);
            }
        }
        return resultList;
	}
	public static void main(String[] args) {
		E_0412_FizzBuzz obj = new E_0412_FizzBuzz();
		System.out.println(obj.fizzBuzz(15));
	}
}
