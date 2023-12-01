import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	void testMain() throws IOException {
		String[] arguments = {"src/test/resources/day1.txt"};
		Day1 day1 = new Day1();
		day1.main(arguments);
		assertEquals("281", outputStream.toString().trim());
	}

	@Test
	void extract() {
		Day1 day1 = new Day1();
		String line = "xtwone3four";
		int result = day1.extract(line);
		assertEquals(24, result);
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
}