package HomeWork151027;

// convert int (1..1000) to romans number

public class Roman {

	public String convert(int i) {
		
		int _i =  i;
		StringBuilder result = new StringBuilder();
		
		if (i < 1 || i > 1000)
			throw new IllegalArgumentException();
		
		if (1_000 == i) {
			return "M";
		}

		// units
		int lastDigit = _i % 10;
		if (0 != lastDigit) {
			result.append(convertDigit('I', 'V', 'X', lastDigit));
		}

		// dozens
		_i = _i / 10;
		lastDigit = _i % 10;
		if (0 != lastDigit) {
			result.insert(0, convertDigit('X', 'L', 'C', lastDigit));
		}

		// hundreds
		_i = _i / 10;
		lastDigit = _i % 10;
		if (0 != lastDigit) {
			result.insert(0, convertDigit('C', 'D', 'M', lastDigit));
		}

		return new String(result);
	}

	private StringBuilder convertDigit(char less, char equal, char more, int i) {
		if (1 == i) return new StringBuilder().append(less);
		if (2 == i) return new StringBuilder().append(less).append(less);
		if (3 == i) return new StringBuilder().append(less).append(less).append(less);
		if (4 == i) return new StringBuilder().append(less).append(equal);
		if (5 == i) return new StringBuilder().append(equal);
		if (6 == i) return new StringBuilder().append(equal).append(less);
		if (7 == i) return new StringBuilder().append(equal).append(less).append(less);
		if (8 == i) return new StringBuilder().append(equal).append(less).append(less).append(less);
		if (9 == i) return new StringBuilder().append(less).append(more);
		return new StringBuilder();
	}
}
