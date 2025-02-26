package spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice{

	private Map<String, Integer> counters;
	
	public void any() {
		System.out.println("Initialising Counters....");
		counters = new HashMap<String,Integer>();
		
	}
	
	public void any1() {
		System.out.println("Counters = " + counters);
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Method = "+method.getName()+" with Args = "+Arrays.toString(args));
		String methodname = method.getName();
		if(counters.containsKey(methodname)) {
			counters.put(methodname, counters.get(methodname)+1);
		}else {
			counters.put(methodname, 1);
		}
	}
	
}
