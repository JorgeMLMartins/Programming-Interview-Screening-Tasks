package calculator;

import operators.IArithmetic;

public class ArithmeticFactory implements IArithmeticFactory {

	@Override
	public IArithmetic newInstance(String className) throws ClassNotFoundException {
		Class<?> arithmeticClass = Class.forName("operators." + className.trim());
		IArithmetic arithmetic = null;
		try {
			arithmetic = (IArithmetic) arithmeticClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return arithmetic;
	}

}
