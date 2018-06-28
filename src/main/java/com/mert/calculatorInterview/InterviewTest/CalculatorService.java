package com.mert.calculatorInterview.InterviewTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class CalculatorService {

	Calculator calc;
	Reader read;
	LinkedList<String> commandList = new LinkedList<>();

	public CalculatorService(String path) throws IOException, URISyntaxException {
		commandList = Reader.read(Paths.get(this.getClass().getClassLoader().getResource(path).toURI()));
		if (operationValidityCheck(commandList)) {
			calc = new Calculator(commandList);
		}
	}

	public int getResult() {
		return calc.getMainResult();
	}

	private boolean operationValidityCheck(LinkedList<String> commandList) {
		return commandList.peekLast().toLowerCase().contains("apply");
	}
}