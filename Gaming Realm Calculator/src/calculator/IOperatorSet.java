package calculator;

import java.util.Map;

import operators.IArithmetic;

public interface IOperatorSet {

	Map<String, IArithmetic> getOperators();
}
