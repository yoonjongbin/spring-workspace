package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneService;
import com.kh.api.service.PhoneServiceImpl;

//@RequestMapping("/api/*")
@RestController
public class PhoneController {
	
	@Autowired
	private PhoneService service;
	
	// http://localhost:8080/api/phone
	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트

		try {
			List<Phone> list = service.select();
			return new ResponseEntity(list, HttpStatus.OK); // 데이터와 함께 상태 코드도 같이 보낼 수 있다.
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	// http://localhost:8080/api/phone/ZF01
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {

		try {
			Phone phone = service.select(num);
			return new ResponseEntity(phone, HttpStatus.OK);
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		// HttpStatus. 하면 오류들을 고를수 있다.
//		return new ResponseEntity("error", HttpStatus.NO_CONTENT);
		
	}
	
	
	
	// http://localhost:8080/api/phone
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
//		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	
	
	// http://localhost:8080/api/phone
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		
		try {
			
			int result = service.update(phone);
			return new ResponseEntity(result, HttpStatus.OK);
			
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
//		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	// http://localhost:8080/api/phone/ZF02
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		
		try {
			int result = service.delete(num);
			return new ResponseEntity(result, HttpStatus.OK);
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
//		return new ResponseEntity(HttpStatus.OK);
	}
}
