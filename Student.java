package mergeSort;

import java.util.LinkedList;

public class Student implements Comparable<Student>{
	private String name;
	private double gpa;
	//Constructor 
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public static int compareTo(Student student1, Student student2) {
		double grade1 = student1.gpa;
		double grade2 = student2.gpa;

		if(grade1 < grade2) {
			return 1;
		}

		if(grade1 > grade2) {
			return -1;
		}
		return 0;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "Name: " + name + ", GPA: " + gpa;
	}

	//mergeSort()
	public static LinkedList<Student> mergeSort(LinkedList<Student> list) {
		//Reorganizes two variables
		if(list.size() < 3) {
			int x = compareTo(list.get(0), list.get(1));
			if (x == -1) {
				LinkedList<Student> reordered = new LinkedList<Student>();
				reordered.add(list.get(1));
				reordered.add(list.get(0));
				list = reordered;
			}
			if(x == 1) {
				LinkedList<Student> reordered = new LinkedList<Student>();
				reordered.add(list.get(0));
				reordered.add(list.get(1));
				list = reordered;
			}
			return list;
		}

		//Splits the linkedList
		if(list.size() > 2) {
			LinkedList<Student> firstHalf = new LinkedList<Student>();
			LinkedList<Student> secondHalf = new LinkedList<Student>();

			for(int x = 0; x < list.size()/2; x++) {
				firstHalf.add(list.get(x));
			}

			for(int x = list.size()/2;x < list.size(); x++) {
				secondHalf.add(list.get(x));
			}
			firstHalf = mergeSort(firstHalf);
			secondHalf = mergeSort(secondHalf);

			merge(firstHalf, secondHalf, list);

		}
		return list;
	}

	public static void merge(LinkedList<Student> firstHalf, LinkedList<Student> secondHalf, LinkedList<Student> list) {
		int current1 = 0;
		int current2 = 0;
		list.clear();
		while(current1 < firstHalf.size() && current2 < secondHalf.size()) {
			if(firstHalf.get(current1).gpa < secondHalf.get(current2).gpa) {
				list.add(firstHalf.get(current1));
				current1++;
			}
			else{
				list.add(secondHalf.get(current2));
				current2++;
			}
		}
		while(current1 < firstHalf.size()) {
			list.add(firstHalf.get(current1));
			current1++;
		}
		while(current2 < secondHalf.size()) {
			list.add(secondHalf.get(current2));
			current2++;
		}
	}
}


