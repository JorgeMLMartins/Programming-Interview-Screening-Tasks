package calculator;

import operators.IArithmetic;

public interface IArithmeticFactory {

	IArithmetic newInstance(String className) throws ClassNotFoundException;
}
