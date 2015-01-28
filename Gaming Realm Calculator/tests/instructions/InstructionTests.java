package instructions;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InstructionTests {

	private IInstructionFactory bogStandardFactory;
	
	@Before
	public void initTests() {
		this.bogStandardFactory = new InstructionFactory();
	}
	
	@Test
	public void testIfCanMakeInstructions() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tests/testinstructions.txt"));
		IInstructionSet instructions = new InstructionSet(bogStandardFactory, br);
		
		List<Instruction> steps = instructions.getInstructions();
		assertTrue("add".equals(steps.get(0).getToken()));
		assertTrue("multiply".equals(steps.get(1).getToken()));
		assertEquals("apply", steps.get(2).getToken()); //cool didnt know you could do this :O
		
		assertEquals(2, steps.get(0).getNumber());
		assertEquals(3, steps.get(1).getNumber());
		assertEquals(3, steps.get(2).getNumber());
	}
	
	@Test
	public void testBlankInstructions() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tests/blankinstructions.txt"));
		IInstructionSet instructions = new InstructionSet(bogStandardFactory, br);
		
		assertTrue(instructions.getInstructions().size() == 0);
	}
}
