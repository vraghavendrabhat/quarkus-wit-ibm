package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class HumanBean {

	@Inject
	FoodBean foodBean;

	void live() {
	}
	
}
