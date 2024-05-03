package fr.cat.tcc.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class CheckerController {

	@PostMapping("/siret")
	public ResponseEntity<GenericResponse<String>> checkSiret(@RequestBody SiretValidationRequest dto) {

		try {
			Double.parseDouble(dto.getSiret());

		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new GenericResponse<String>("Format numérique invalide", null));
		}

		int sum = 0;
		boolean isEven = false;
		// Calcul en partant du dernier nombre du SIRET
		// En partant des unités, comme le calcul binaire
		for (int position = dto.getSiret().length()-1; position >= 0 ; position--) {
			int value = Integer.parseInt(dto.getSiret().substring(position, position+1));
			if(isEven) {
				int addValue = value * 2;
				sum += addValue >= 10 ? addValue -9 : addValue;
			}else {
				sum += value;
			}
			isEven = !isEven;
		}
		boolean isValid = sum % 10 == 0;

		if (isValid) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new GenericResponse<String>("Valid SIRET", null));
		}
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new GenericResponse<String>("Invalid SIRET", null));
	}
	

}
