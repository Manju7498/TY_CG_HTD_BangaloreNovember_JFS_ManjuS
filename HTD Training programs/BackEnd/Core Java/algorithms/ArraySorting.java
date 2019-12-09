import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class ArraySorting {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of an array");
		int size=sc.nextInt();
		int a[]=new int[size];
		System.out.println("Enter elements of an array");
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("Elements  before sorting are :");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
//		System.out.println("");
//		System.out.println("Elements after merge sort : ");
//		MergeSort m=new MergeSort();
//		m.mergeSort(a, size);
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		}
		System.out.println("");
		System.out.println("Elements after bubble sort : ");
		BubbleSort b=new BubbleSort();
		Instant start=Instant.now();
		b.bubbleSort(a, size);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		Instant end=Instant.now();
		long duration=Duration.between(start, end).toNanos();
		double seconds=duration/1000;
		System.out.println("");
		System.out.println("Bubblesort time : "+seconds+ " seconds  ");
//		System.out.println("");
//		System.out.println("Elements after quick sort : ");
//		QuickSort q=new QuickSort();
//		q.quickSort(a,a[0],a[a.length-1]);
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		}
		System.out.println("");
		System.out.println("Elements after insertion sort : ");
		InsertionSort in=new InsertionSort();
		Instant start1=Instant.now();
		in.insertionSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		Instant end1=Instant.now();
		long duration1=Duration.between(start1, end1).toNanos();
		double seconds1=duration1/1000;
		System.out.println("");
		System.out.println("InsertionSort time : "+seconds1+ " seconds  ");
		System.out.println("");
		
		System.out.println("Elements after selection sort : ");
		SelectionSort s=new SelectionSort();
		Instant start2=Instant.now();
		s.selectionSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		Instant end2=Instant.now();
		long duration2=Duration.between(start2, end2).toNanos();
		double seconds2=duration2/1000;
		System.out.println("");
		System.out.println("Selectionsort time : "+seconds2+ " seconds  ");
		
//		System.out.println("");
//		System.out.println("Elements after heap sort : ");
//		HeapSort h=new HeapSort();
//		h.heap(a,a.length, a[0]);
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		}
//		
		
	}

}
