
public class Lab3Test {
	Lab3Model model;
	Lab3Control control;
	Lab3View view;
	
	public static void main (String[] args) {
		new Lab3Test();
	}
	
	public Lab3Test() {
		view = new Lab3View();
		model = view.model;
		
		model.loadFile(view.rdbtnAscending, model.ascendingArray);
//		model.loadFile(view.rdbtnDescending, model.descendingArray);
//		model.loadFile(view.rdbtnRandom, model.randomArray);
		
		model.startQuickSort(model.ascendingArray, 10);
//		model.startQuickSort(model.descendingArray, 10);
//		model.startQuickSort(model.randomArray, 3000);
		
//		model.startHeapSort(model.ascendingArray, 10);
//		model.startHeapSort(model.descendingArray, 10);
//		model.startHeapSort(model.randomArray, 5000);
		
//		model.startMergeSort(model.ascendingArray, 10);
//		model.startMergeSort(model.descendingArray, 10);
//		model.startMergeSort(model.randomArray, 5000);
		
		
//		System.out.println("# of comparison: " + comparisonCount);
//		System.out.println("# of swap: " + swapCount);
//		for (String item: sortArray) {
//			System.out.println(item);
//		}
	}
}
