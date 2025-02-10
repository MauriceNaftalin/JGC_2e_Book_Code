package org.jgcbook.chapter09.B_implementations;
// 11.2.1
import java.util.Set;
import java.util.HashSet;

    class Person {
        private final String name;
        public Person(String name) {
            this.name = name;
        }
        public boolean equals(Object o) {
            return o instanceof Person p && name.equals(p.name);
        }
    
	public static void main(String[] args)  {
		    Set<Person> people = new HashSet<>();
		    people.add(new Person("Alice"));
		    assert ! people.contains(new Person("Alice"));

	}
}