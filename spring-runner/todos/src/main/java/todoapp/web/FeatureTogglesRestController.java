package todoapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.model.FeatureTogglesProperties;

@RestController
public class FeatureTogglesRestController {
	private FeatureTogglesProperties feat;
	
	public FeatureTogglesRestController(FeatureTogglesProperties feat) {
		this.feat = feat;
	}
	
	@GetMapping("/api/feature-toggles")
	public FeatureTogglesProperties featToggles() {
		return feat;
	}
}
