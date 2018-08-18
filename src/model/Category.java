/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package model;

public class Category {
	private String title, description;

	public Category(){	
		this.title = "";
		this.description = "";
	}
		
	public Category(String title, String description) {
		setTitle(title);
		setDescription(description);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return title;
	}
	


}
