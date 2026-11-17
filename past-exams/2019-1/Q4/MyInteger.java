public class MyInteger {

	public static int parseInt(String s) throws NumberFormatException {
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			//0--1--2--3--4--5--6--7--8--9
			//48-49-50-51-52-53-54-55-56-57
			if ((int) s.charAt(i) >= 48) {
				if ((int) s.charAt(i) <= 57) {
					num = num * 10 + ((int) s.charAt(i) - 48);
				} else {
					throw new NumberFormatException();
				}
			} else {
				throw new NumberFormatException();
			}

		}
		
		return num;
	}

}
