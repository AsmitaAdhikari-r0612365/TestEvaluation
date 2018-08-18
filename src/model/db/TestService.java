package model.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.DomainException;
import model.Question;
import model.Test;

public class TestService {
	private ObservableList<Category> category;
	private ObservableList<Question> question;
	private List<Question> rightAnswers, wrongAnswers;
	private List<Test> test;

	public TestService() {
		category = FXCollections.observableArrayList();
		question = FXCollections.observableArrayList();
		test = new ArrayList<>();
		rightAnswers = new ArrayList<>();
		wrongAnswers = new ArrayList<>();

	}

	public void addCategory(Category cat) {
		if (category.contains(cat.getTitle()))
			throw new DomainException("This category already exists");
		else
			category.add(cat);
	}

	public void addQuestion(Question vraag) {
		if (question.contains(vraag.getQuestion()))
			throw new DomainException("This question already exists");
		else
			question.add(vraag);
	}

	public ObservableList<Category> getCategoryData() {
		addCategory(new Category("Design principles", "The SOLID design principles"));
		addCategory(new Category("Design patterns", "Design patterns in Java"));
		return category;
	}

	public ObservableList<Question> getQuestionData() {
		Set<String> patternStatements = new HashSet<>();
		Set<String> principleStatements = new HashSet<>();
		List<String> juistStmP = new ArrayList<>();
		juistStmP.add("Strategy");
		List<String> juistStm = new ArrayList<>();
		juistStm.add("OCP");

		patternStatements.add("Simple Factory");
		patternStatements.add("Singleton");
		patternStatements.add("Facade");
		patternStatements.add("Strategy");
		patternStatements.add("Observer");

		principleStatements.add("SRP");
		principleStatements.add("OCP");
		principleStatements.add("LSP");
		principleStatements.add("ISP");
		principleStatements.add("DIP");

		String feedback = "Voor elke patroon moet je kunnen aangeven in welke mate een principe van toepassing is.";

		addQuestion(new Question(
				"Welk patroon defineert een familie van algoritmes, kapselt ze en maakt ze verwisselbaar?",
				new Category("Design pattern", "Design patterns in Java"), feedback, patternStatements, juistStmP));

		addQuestion(new Question("Welk ontwerp principe is het minst van toepassing op het Strategy patroon?",
				new Category("Design principles", "The SOLID design principles"), feedback, principleStatements,
				juistStm));

		return question;
	}

	public ObservableList<String> getCatTitles() {
		ObservableList<String> titles = FXCollections.observableArrayList();
		for (Category cat : category) {
			titles.add(cat.getTitle());
		}
		return titles;
	}

	public Category getCategoryTitle(String categoryField) {
		for (Category cat : category) {
			if (cat.getTitle().equals(categoryField))
				return cat;
		}
		return null;
	}

	public Set<Question> getAllQuestions() {
		Set<Question> quest = new HashSet<>();
		for (Question que : question) {
			quest.add(que);
		}
		return quest;
	}

	public Question haalQuestion() {
		for (Question que : question) {
			return que;
		}
		return null;
	}

	public void saveAnswers(Question que, boolean isJuist) {
		if (isJuist) {
			rightAnswers.add(que);
		} else
			wrongAnswers.add(que);
	}

	public int getScores() {
		Question q = new Question();
		int total = 0;
		for (Test que : test) {
			while (q.getQuestion().equals(q.getJuistStmt())) {
				total += que.getScore();
			}
		}
		return total;
	}

	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

	public String showResult() {
		return "Your score: " + rightAnswers.size() + "/" + this.getQuestionData().size() + "\n" + this.showResultPerCat();
	}
	
	public String showResultPerCat(){
		String result = "";
		for (int i = 0; i < this.getQuestionData().size(); i++) {
			if(!result.equals(this.getQuestionData().get(i).getCategory())){
				result += "Category-> "+this.getQuestionData().get(i).getCategory()+":\n";
			}
		}
		return result;
	}

	public boolean isCorrectAnswer(String answer) {
		if (this.haalQuestion().getJuistStmt().contains(answer))
			return true;
		else
			return false;
	}

}
