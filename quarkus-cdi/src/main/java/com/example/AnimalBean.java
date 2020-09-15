package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AnimalBean {

	@Inject
	FoodBean foodBean;

	void live() {
	}
}
