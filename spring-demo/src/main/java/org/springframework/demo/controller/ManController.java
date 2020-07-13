package org.springframework.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.entity.Man;
import org.springframework.demo.service.IManService;
import org.springframework.stereotype.Component;

@Component
public class ManController {

	@Autowired
	private IManService iManService;

	public void getMan() {
		Man spring = iManService.getOne("spring");
		System.out.println(spring.toString() + " : " + spring.getName());
	}

	public void setiManService(IManService iManService) {
		this.iManService = iManService;
	}
}
