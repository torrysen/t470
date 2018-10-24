package comparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestComparator {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("mm-dd-yyyy");
		ArrayList<Person> people;
		people = new ArrayList<Person>();

		try {
			people.add(new Person("cccc", 92422, df.parse("12-12-2010")));
			people.add(new Person("aaaa", 34122, df.parse("1-12-2010")));
			people.add(new Person("aaaa", 24122, df.parse("1-12-2010")));
			people.add(new Person("aaaa", 64122, df.parse("1-12-2010")));
			people.add(new Person("aaaa", 64122, df.parse("5-12-2010")));
			people.add(new Person("aaaa", 64122, df.parse("6-12-2010")));
			people.add(new Person("aaaa", 84122, df.parse("1-12-2010")));
			people.add(new Person("bbbb", 24922, df.parse("12-2-2010")));

			// System.out.println("before");
			// for (Person p : people) {
			// System.out.println(p.toString());
			// }
			//
			Collections.sort(people, new Comparator<Person>() {
				@Override
				public int compare(Person p1, Person p2) {
					// TODO Auto-generated method stub
					int result = (p1.name).compareTo(p2.name);

					if (result == 0) {
						result = Integer.valueOf(p1.id).compareTo(p2.id);
					}

					// int intId = 0;
					// intId = Integer.valueOf(p1.id).compareTo(p2.id);
					// System.out.println("p1.name=" + p1.name + ", p2.name=" +
					// p2.name + ", intName=" + result);
					return result;
				}

			});

			System.out.println("after");
			for (Person p : people) {
				System.out.println(p.toString());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
