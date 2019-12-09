
public class SelectionSort {
		void selectionSort(int a[])
		{
			for (int i = 0; i < a.length-1; i++)
			{
				int first = i;
				for (int j = i+1; j < a.length; j++)
					if (a[j] < a[first])
						first = j;
				int temp = a[first];
				a[first] = a[i];
				a[i] = temp;
			}
		}
}