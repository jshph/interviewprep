public class Bases {
	public static void main(String args[]) {
		bases(12585);
	}

	public static void bases(int base_Str) {
		_bases("", base_Str + "");
	}

	public static void _bases(String stem, String rem) {
		if (rem.length() == 1) {
		for (int i = 0; i < Character.getNumericValue(rem.charAt(0)); i++)
			System.out.println(stem + i);
		} else {
			for (int i = 0; i < Character.getNumericValue(rem.charAt(0)); i++)
				_bases(stem + i, rem.substring(1));
		}
	}
}