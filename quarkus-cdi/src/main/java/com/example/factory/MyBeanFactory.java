package com.example.factory;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import io.quarkus.arc.DefaultBean;

@ApplicationScoped
public class MyBeanFactory {

	@Produces
	@DefaultBean
	Locale deaultLocale = Locale.getDefault();
	
	
	@Produces
    @Named("en_US")
    public Locale getEnUSLocale(){
        return  Locale.US;
    }

    @Produces
    @Named("es_ES")
    public Locale getEsEsLocale(){
        return new Locale("es","Es");
    }

}
