package test.sort;

import java.util.HashMap;
import java.util.Map;


public class Sequence {

	public long calcSteps(long n, int verbose, Map<Long, Long> counts) {
		long c = 0, sn = n;
		if (verbose > 2) System.out.println("Steps for n = " + n);
		while (n != 1) {
			if (counts != null && counts.containsKey(n)) {
				long cc = counts.get(n);
				if (verbose > 1) System.out.println("Cache hit for n = " + n + " -> " + cc);
				long ccc = c + cc;
				counts.put(sn, ccc);
				if (verbose > 1) System.out.println("Adding cache entry: " + sn + " -> " + ccc);
				return ccc;
			}

			n = (n%2 == 0) ? n / 2 : n * 3 + 1;
			if (verbose > 2) System.out.print(n + ", ");
			c++;
		}
		if (verbose > 2) System.out.println("count: " + c);
		if (counts != null) {
			counts.put(sn, c);
			if (verbose > 1) System.out.println("Adding cache entry: " + sn + " -> " + c);
		}
		return c;
	}

	public void printRecords(long n, int verbose, boolean useCache) {
		long start = System.currentTimeMillis();
		long max = -1;
		Map<Long, Long> counts = useCache ? new HashMap<Long, Long>(14000000) : null;
		if (useCache) {
			calcSteps(n, 3, counts);
			if (verbose >= 0) System.out.println("Cache is built: " + counts.size());
		}
		for (long i = 1; i < n; i++) {
			long c = calcSteps(i, verbose, counts);
			if (c > max) {
				if (verbose > 0) System.out.println(i + " -> " + c);
				max = c;
			}
		}
		long end = System.currentTimeMillis();
		if (verbose >= 0) System.out.println("Time: " + (end - start));
	}

	public static void main(String[] args) {
//		new Sequence().calcSteps(1, 3, null);
//		new Sequence().calcSteps(10, 3, null);
//		new Sequence().calcSteps(100, 3, null);
		Sequence s = new Sequence();
		s.printRecords(10000000, 0, true);
//		s.printRecords(10000000, 0, false);
	}

}
