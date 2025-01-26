package chapter09.F_contracts;
// 11.6.1
import java.util.Set;
import java.util.HashSet;

    class Person {
        private String name;
        public Person(String name) {
            this.name = name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int hashCode() {
            return name.hashCode();
        }
        public boolean equals(Object o) {
            return o instanceof Person p && name.equals(p.name);
        }
    
	public static void main(String[] args)  {
		    Set<Person> people = new HashSet<>();
		    Person alice = new Person("Alice");
		    people.add(alice);
		    alice.setName("Bob");
		    assert ! people.contains(new Person("Alice"));
		    assert ! people.contains(new Person("Bob"));
	}
}