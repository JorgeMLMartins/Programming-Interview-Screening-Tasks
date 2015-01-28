package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import operators.IArithmetic;

public class OperatorSet implements IOperatorSet {

	private BufferedReader br;
	private Map<String, IArithmetic> operators;
	private IArithmeticFactory factory;
	
	public OperatorSet(IArithmeticFactory factory, BufferedReader br) throws IOException, ClassNotFoundException {
		this.br = br;
		this.operators = new HashMap<String, IArithmetic>();
		this.factory = factory;
		scanReader();
	}

	@Override
	public Map<String, IArithmetic> getOperators() {
		return this.operators;
	}
	
	private void scanReader() throws IOException, ClassNotFoundException {		
		String currentLine;
		 
		while ((currentLine = br.readLine()) != null) {
			String[] splitLine = currentLine.split("\\s+");
			//check if valid
			if (splitLine.length > 2) throw new IOException("File is formatted incorrectly. Please check");
			IArithmetic arithmetic = createArithmetic(splitLine[1]);
			this.operators.put(splitLine[0].trim(), arithmetic);
			
			//System.out.println(currentLine);
		}
	}
	
	private IArithmetic createArithmetic(String className) throws ClassNotFoundException {
		IArithmetic arithmetic = this.factory.newInstance(className);
		return arithmetic;
	}
}
