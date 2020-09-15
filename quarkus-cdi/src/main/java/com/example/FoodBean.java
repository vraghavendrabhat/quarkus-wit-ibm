package com.example;

import javax.enterprise.context.Dependent;

@Dependent
public class FoodBean {

	public FoodBean() {
		System.out.println("FoodBean instantiated..");
	}

}
