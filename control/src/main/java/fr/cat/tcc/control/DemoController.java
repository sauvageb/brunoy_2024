package fr.cat.tcc.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/version")
	public ResponseEntity<String> checkVersion() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("1.0.0");
	}

	@PostMapping("sayhello")
	public ResponseEntity<ResponseHello> sendHello(@RequestBody RequestHello dto) {

		if(dto.getFirstname().equalsIgnoreCase("Boris")) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
		
		ResponseHello myResponse = new ResponseHello();
		myResponse.setMessage("Hello " + dto.getFirstname());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(myResponse);
	}

}
