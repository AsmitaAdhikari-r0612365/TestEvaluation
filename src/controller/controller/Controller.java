package controller.controller;

import domain.TestService;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;

public class Controller {
	private TestService service;
	private CategoryDetailPane detail;
	private CategoryOverviewPane overview;
	
	
	public Controller(){
		service = new TestService();
		detail = new CategoryDetailPane(overview, service);
	}
	
}
