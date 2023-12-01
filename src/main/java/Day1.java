import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;


public class Day1 {

	static final Map<String, String> numbers = new LinkedHashMap<>(){{
		put("one", "1");
		put("1", "1");
		put("two", "2");
		put("2", "2");
		put("three", "3");
		put("3", "3");
		put("four", "4");
		put("4", "4");
		put("five", "5");
		put("5", "5");
		put("6", "6");
		put("six", "6");
		put("seven", "7");
		put("7", "7");
		put("eight", "8");
		put("8", "8");
		put("9", "9");
		put("nine", "9");
	}};

	void main(String[] args) throws IOException {
		if (args.length < 1 || !Files.exists(Path.of(args[0])))
			throw new RuntimeException("Please provide a path to data file!");

		Stream<String> lines = Files.lines(Path.of(args[0]));
		System.out.println(lines.mapToInt(this::extract).sum());

	}

	int extract(String line) {
		Map<Integer, String> result = new HashMap<>(10);

		for(String key : numbers.keySet()) {
			result.put(line.indexOf(key), numbers.get(key));
			result.put(line.lastIndexOf(key), numbers.get(key));
		}
		result.remove(-1);
		return Integer.parseInt(result.get(Collections.min(result.keySet())) + result.get(Collections.max(result.keySet())));
	}
}