package run;

import java.util.ArrayList;
import java.util.List;

class Person{
	private int age;
	Person(){
	}
	Person(int a){
		this.age = a;
	}
	public String toString() {
		return "나이" + age;
	}
}
class Company{
	private Person p;
	Company(){
	}
	Company(Person p ){
		this.p = p;
	}
	public String toString() {
		return "직원 : " + p;
	}
}
public class Test {

	public static void main(String[] args) {
		List<Person> l = new ArrayList<>();
		l.add(new Person(1));
		l.add(new Person(2));
		System.out.println(l);
		
		List<Company> l2 = new ArrayList<>();
		l2.add(new Company(new Person(100)));
		l2.add(new Company(new Person(200)));
		System.out.println(l2);
	}
}
