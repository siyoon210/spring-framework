package todoapp.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import todoapp.web.model.SiteProperties;

@ControllerAdvice
public class GlobalControllerAdvice {
	private SiteProperties site;
	
	public GlobalControllerAdvice(SiteProperties site) {
		this.site = site;
	}

	@ModelAttribute("site")
	public SiteProperties site() {
		return site;
	}
}
