package org.springframework.demo.temp;

public class TempBean {

	public static TempBean staticFactory() {
		return new TempBean();
	}

	public TempBean factory() {
		return new TempBean();
	}
}
