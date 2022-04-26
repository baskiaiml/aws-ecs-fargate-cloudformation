/**
 * 
 */
package com.ecsdemo.service;

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
@RequestMapping("/demoone")
public class DemoServiceOneController {

	private Logger log = LoggerFactory.getLogger(DemoServiceOneController.class);
	
	@ResponseBody
	@GetMapping("/healthcheck")
	public ResponseEntity<Object> healthCheck() {
		log.info(" Demo Service One Health check completed, all good");
		return new ResponseEntity<Object>("{\"status\":\"Demo Service One Service is working\"}", HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<Object> pingService() {
		log.info(" Demo Service One is pinged");
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}

}
