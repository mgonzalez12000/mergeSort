
package mergeSort;

import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {

		LinkedList<Student> student = new LinkedList<>();
		
		Student pupil1 = new Student ("Tony Stark", 5.4);
		Student pupil2 = new Student ("Bruce Banner", 5.0);
		Student pupil3 = new Student ("Peter Parker", 4.3);
		Student pupil4 = new Student ("Groot", 2.8);
		
		student.add(pupil1);
		student.add(pupil2);
		student.add(pupil3);
		student.add(pupil4);
		
		System.out.println("Order before mergeSort:");

		for(int i = 0; i < student.size(); i++) {
			System.out.println(student.get(i));
		}
		
		System.out.println();
		System.out.println("Order after mergeSort:");
		student = Student.mergeSort(student);

		for(int i = 0; i < student.size(); i++) {
			System.out.println(student.get(i));
		}
	}
}
