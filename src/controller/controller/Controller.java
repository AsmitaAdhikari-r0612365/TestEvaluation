/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package controller.controller;

import model.db.TestService;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;

public class Controller {
	private TestService service;
	private CategoryDetailPane detail;
	private CategoryOverviewPane overview;
	private MessagePane msgPane;
	
	
	public Controller(){
		service = new TestService();
		detail = new CategoryDetailPane(overview, service);
	}


	public void setMsgPane(MessagePane msgPane) {
		this.msgPane = msgPane;
	}


	public MessagePane getMsgPane() {
		return msgPane;
	}
	
	
	
	
	
}
