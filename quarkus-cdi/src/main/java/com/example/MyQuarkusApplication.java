package com.example;

import javax.inject.Inject;

import com.example.service.TxrService;

public class MyQuarkusApplication implements io.quarkus.runtime.QuarkusApplication {

	@Inject
	TxrService txrService;

	@Inject
	HumanBean humanBean;

	@Inject
	AnimalBean animalBean;

	@Override
	public int run(String... args) throws Exception {

		humanBean.live();
		animalBean.live();

		return 0;
	}

}
