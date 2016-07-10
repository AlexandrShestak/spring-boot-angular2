package com.shestakam.service.impl;

import com.shestakam.service.intf.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	public String test() {
        return "Hello, World!";
    }

}
