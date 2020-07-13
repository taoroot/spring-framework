package org.springframework.demo.service.impl;

import org.springframework.demo.entity.Man;
import org.springframework.demo.service.IManService;
import org.springframework.stereotype.Service;

@Service("iManService")
public class ManServiceImpl implements IManService {
	@Override
	public Man getOne(String name) {
		Man man = new Man();
		man.setName(name);
		return man;
	}
}
