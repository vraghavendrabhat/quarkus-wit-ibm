package com.example;

/*
 * 
 *  design issues
 *  -----------------
 *  
 *  ==> code tangling / tight-coupling with cross-cutting concerns
 *  ==> code scattering / duplication
 *  
 *  soln : using 'proxy' design pattern
 * 
 */

class M1 {
	public void a() {
//		System.out.println("before : LOG");
		System.out.println("a()");
//		System.out.println("after : LOG");
	}
}

class M2 {
	public void x() {
		System.out.println("before : LOG");
		System.out.println("x()");
		System.out.println("after : LOG");
	}
}

// spring aop ==> dynamic proxies
class M1P extends M1 {

	public void a() {
		System.out.println("before : LOG"); //
		super.a();
		System.out.println("after : LOG");
	};

}

public class Proxy_Pattern_Ex {

	public static void main(String[] args) {

		M1P m1p = new M1P();
		m1p.a();

	}

}
