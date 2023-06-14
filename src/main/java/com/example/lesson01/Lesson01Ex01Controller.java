package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller // Spring Bean
public class Lesson01Ex01Controller {

	// return String: HTML
	// http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1") // 주소 맵핑
	@ResponseBody // 리턴되는 값을 HTML Response body에 넣어 보낸다.
	public String ex01_1() {
		String text = "예제 1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// return Map: JSON String
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 50);
		// {"apple"=4...} => java의 Map
		// {"apple":4...} => javascript
		
		// Map을 리턴하면 JSON String 으로 나타난다.
		// => jackson 라이브러리가 동작되기 때문: Web starter에 들어있음(의존성 라이브러리)
		return map;
	}
}
