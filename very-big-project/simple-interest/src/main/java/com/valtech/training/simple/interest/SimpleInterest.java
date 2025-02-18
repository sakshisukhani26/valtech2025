package com.valtech.training.simple.interest;

import com.valtech.training.arithmetic.Operation;


public class SimpleInterest {

	public int compute(int pri,int rate,int time) {
		int product = Operation.MUL.perform(pri*rate,time);
		return Operation.DIV.perform(product,100);
	}
}
