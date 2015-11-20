import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

import Theme.QRadioButton;

public class Lab3Model {

	String [] ascendingArray, descendingArray, randomArray, temp;
	int moveCount, comparisonCount;
	
	
	
	public Lab3Model() {
		ascendingArray = new String [5000];
		descendingArray = new String [5000];
		randomArray = new String [5000];
	}
	
	public void loadFile(QRadioButton radioButton, String [] array) {
		File file = getFile();
		
		if (file != null) {
			String fileName = file.getAbsolutePath();
			radioButton.setText(file.getName());
			radioButton.setEnabled(true);
			
			try {
				BufferedReader bf = new BufferedReader(new FileReader(fileName));
				String line;
				int count = 0;
				while ((line = bf.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(line);
					while (st.hasMoreTokens()) {
						array[count] = st.nextToken();
						count++;
					}
				}
				bf.close();
			} catch (IOException e) {}
		}
		
	}
	

	/**
	 * Use JFileChooser to get data file
	 * @return a file that user selected, null if did not select any file 
	 */
	private File getFile() {
		JFileChooser fc = new JFileChooser("C:\\Users\\Quang Nguyen\\OneDrive"
				+ "\\mon hoc\\Fall 2015\\CoSc 20803\\Sort_Algorithms_Analysis");
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		} else {
			return null;
		}
	}
	
	/**
	 * Copy a number of keys in an array in order to do sorting on it
	 * @param array the array from which keys are copied
	 * @param number number of keys about to copy
	 * @return a portion of the input array
	 */
	public String[] copy(String [] array, int number) {
		String[] result = Arrays.copyOfRange(array, 0, number);
		System.out.println(result.length);
		return result;
	}

	

	/**
	 * Invoke heap Sort
	 * @param array unsorted array/ input array
	 * @param number number of keys about to sort in the input array
	 */
	public void startHeapSort(String[] array, int number) {
		String [] sortArray = Arrays.copyOfRange(array, 0, number);
		comparisonCount = 0;
		moveCount = 0;
		
		heapSort(sortArray, sortArray.length - 1);
	}
	
	/**
	 * Heap Sort
	 * @param array unsorted array
	 * @param length length of input array
	 */
	private void heapSort(String[] array, int length) {
		for (int i = (length/2); i >= 0; i--) {
			heapify(array, i, length);
		}
		for (int i = (length-1); i >= 0; i--) {
			swap(array, 1, i+1);
			moveCount = moveCount + 3;
			heapify(array, 1, i);
		}
	}
	
	/**
	 * Rearrange data in heap fashion
	 */
	private void heapify(String[] array, int i, int length) {
		boolean notFinished = true;
		String temp = array[i];
		moveCount++;
		int j = 2*i;
		while ((j <= length) && notFinished) {
			if (j < length) {
				comparisonCount++;
				if (array[j].compareTo(array[j+1]) < 0) {
					j++;
				}
			}
			comparisonCount++;
			if (temp.compareTo(array[j]) >= 0) {
				notFinished = false;
			} else {
				
				array[j/2] = array[j];
				moveCount++;
				j = 2*j;
			}
		}
		array[j/2] = temp;
		moveCount++;
	}

	
	/**
	 * Invoke merge sort
	 * @param array 
	 * @param number
	 */
	public void startMergeSort(String[] array, int number) {
		String [] sortArray = Arrays.copyOfRange(array, 0, number);
		comparisonCount = 0;
		moveCount = 0;
		
		mergeSort(sortArray, 0, sortArray.length - 1);
	}

	private void mergeSort(String[] sortArray, int min, int max) {
		if (min < max) {
			int mid = (min + max) / 2;
			mergeSort(sortArray, min, mid);
			mergeSort(sortArray, mid + 1, max);
			merge(sortArray, min, mid, max);
		}
		
	}

	private void merge(String[] array, int first, int mid, int last) {
		String [] temp = new String[array.length];
		
		int first1 = first, last1 = mid;
		int first2 = mid + 1, last2 = last;
		int index = first1;
		
		while (first1 <= last1 && first2 <= last2) {
			comparisonCount++;
			moveCount++;
			if (array[first1].compareTo(array[first2]) < 0) {
				temp[index] = array[first1];
				first1++;
			} else {
				temp[index] = array[first2];
				first2++;
			}
			index++;
		}
		while (first1 <= last1) {
			temp[index] = array[first1];
			moveCount++;
			first1++;
			index++;
		}
		while (first2 <= last2) {
			temp[index] = array[first2];
			moveCount++;
			first2++;
			index++;
		}
		
		for (index = first; index <= last; index++) {
			array[index] = temp[index];
			moveCount++;
		}
	}

	

	
	/**
	 * Invoke quick sort
	 * @param array
	 * @param number
	 */
	public void startQuickSort(String[] array, int number) {
		String [] sortArray = Arrays.copyOfRange(array, 0, number);
		comparisonCount = 0;
		moveCount = 0;

		quickSort(sortArray, 0, sortArray.length - 1);
	}
	
	private void quickSort(String[] array, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right + 1;
			String temp = array[left];
			moveCount++;

			while (i < j) {
				i = i + 1;
				if (i <= right && (array[i].compareTo(temp) < 0)) {
					while (i <= right && (array[i].compareTo(temp) < 0)) {
						comparisonCount++;
						i = i + 1;
					}
				} else {
					comparisonCount++;
				}
				
				j = j - 1;
				if (j >= left && (array[j].compareTo(temp)) > 0) {
					while (j >= left && (array[j].compareTo(temp)) > 0) {
						comparisonCount++;
						j = j - 1;
					}
				} else {
					comparisonCount++;
				}
				
				if (i <= right) {
					swap(array, i, j);
					moveCount = moveCount + 3;
				}
			}
			if (i <= right) {
				swap(array, i, j);
				moveCount = moveCount + 3;
			}
			swap(array, j, left);
			moveCount = moveCount + 3;
			quickSort(array, left, j - 1);
			quickSort(array, j + 1, right);
		}
	}

	private void swap(String[] array, int i, int j) {
		String temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	

	
	/**
	 * Print out to the console items in a array
	 * @param sortArray
	 */
	private void printOut(String [] sortArray) {
		for (String item: sortArray) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Print out to the console number of comparisons and data movements
	 */
	private void printOutCount() {
		System.out.println(comparisonCount + " - # of comparison");
		System.out.println(moveCount + " - # of move");
	}
}
