package com.cg.queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueue2 {

	public static void main(String[] args) {
		PriorityQueue<Student> p=new PriorityQueue<Student>();
		p.offer(new Student("manju",21));
		p.offer(new Student("gayathri",22));
		//p.offer(new Student("manju",21));
		for (Student st : p) {
			System.out.println("Name : "+st.name+" & Age : "+st.age);
		}
	}

}
