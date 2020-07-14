package org.springframework.demomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demomvc.entity.Man;
import org.springframework.demomvc.service.IManService;
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
