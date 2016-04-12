package test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		if (args.length != 1) {
			//System.err.print("Missing a required parameter, i.e. xyz");
			//return;
			args = new String[] {"xyz"};
		}
		String input = args[0];
		List<Integer> empty = Collections.emptyList();

		Permutations p = new Permutations();
		p.compute(input, empty, input.length());
	}

	public void compute(String input, List<Integer> indexes, int length) {
		if (indexes.size() == length) {
			printLine(input, indexes, length);
			return;
		}

		for (int i = 0; i < length; i++) {
			if (!indexes.contains(i)) {
				List<Integer> newIndexes = new ArrayList<Integer>();
				newIndexes.addAll(indexes);
				newIndexes.add(i);
				compute(input, newIndexes, length);
			}
		}
	}

	public void printLine(String input, List<Integer> indexes, int length) {
		for (int i : indexes) {
			System.out.print(input.charAt(i));
		}
		System.out.println();
	}
}
