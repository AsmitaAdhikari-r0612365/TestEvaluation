package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Question {
	private Category category;
	private String question,feedback;
	private Set<String> statements;
	private List<String> juistStmt;

	public Question() {

	}

	public Question(String question, Category category, String feedback, Set<String> statements, List<String> juistStmt) {
		setQuestion(question);
		setCategory(category);
		setFeedback(feedback);
		setStatements(statements);
		setJuistStmt(juistStmt);
	}

	public void setStatements(Set<String> statements) {
		this.statements = statements;

	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getFeedback() {
		return feedback;
	}

	public Set<String> getStatements() {
		return statements;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getJuistStmt() {
		return juistStmt;
	}

	public void setJuistStmt(List<String> juistStmt) {
		this.juistStmt = juistStmt;
	}

	public String toString() {
		for (String string : statements) {
			return string;
		}
		return null;
	}
	
	

}
