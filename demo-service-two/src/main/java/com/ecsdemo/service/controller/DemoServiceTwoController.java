/**
 * 
 */
package com.ecsdemo.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 91994
 *
 */
@RestController
@RequestMapping("/demotwo")
public class DemoServiceTwoController {

	private Logger log = LoggerFactory.getLogger(DemoServiceTwoController.class);
	
	@ResponseBody
	@GetMapping("/healthcheck")
	public ResponseEntity<Object> healthCheck() {
		log.info(" Demo Service Two Health check completed, all good");
		return new ResponseEntity<Object>("{\"status\":\"Demo Service Two Service is working\"}", HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<Object> pingService() {
		log.info(" Demo Service Two is pinged");
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}

}
