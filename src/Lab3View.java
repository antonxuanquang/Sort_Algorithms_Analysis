import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Theme.QButton;
import Theme.QLabel;
import Theme.QRadioButton;
import Theme.QTextField;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Lab3View extends JFrame{
	
	Lab3Model model;
	Lab3Control control;
	
	public QTextField tfComparisons, tfSwaps;
	private QLabel lblNumberOfComparison, lblNumberOfSwaps, lblChooseSortingAlgorithms,
					lblChooseDataFiles,lblChooseNumberOf;
	public QRadioButton rdbtnHeapSort, rdbtnMergeSort, rdbtnQuickSort, rdbtnAscending,
					rdbtnDescending, rdbtnRandom, rdbtn100, rdbtn1000, rdbtn2000, rdbtn5000;
	public QButton btnSort, btnLoadDataFiles;
	
	public ButtonGroup groupSort, groupFile, groupKeys;

	
	public static void main (String args[]) {
		new Lab3View();
	}
	
	
	public Lab3View() {
		buildGUI();
		model = new Lab3Model();
		control = new Lab3Control(this, model);
		
		setVisible(true);
		setBounds(100, 100, 575, 304);
	}

	
	private void buildGUI() {
		getContentPane().setLayout(new MigLayout("", "[189.00px][172.00][140.00][]", "[10px][][][][][][][][]"));
		
		lblChooseSortingAlgorithms = new QLabel("Choose Sorting Algorithms:");
		getContentPane().add(lblChooseSortingAlgorithms, "cell 0 0");
		
		lblChooseDataFiles = new QLabel("Choose Data Files: ");
		getContentPane().add(lblChooseDataFiles, "cell 1 0");
		
		lblChooseNumberOf = new QLabel("Choose Number of Keys:");
		getContentPane().add(lblChooseNumberOf, "cell 2 0");
		
		rdbtnHeapSort = new QRadioButton("Heap Sort");
		getContentPane().add(rdbtnHeapSort, "cell 0 1");
		
		rdbtnAscending = new QRadioButton("");
		getContentPane().add(rdbtnAscending, "cell 1 1");
		rdbtnAscending.setEnabled(false);
		
		rdbtn100 = new QRadioButton("100");
		getContentPane().add(rdbtn100, "cell 2 1");
		
		rdbtnMergeSort = new QRadioButton("Merge Sort");
		getContentPane().add(rdbtnMergeSort, "cell 0 2");
		
		rdbtnDescending = new QRadioButton("");
		getContentPane().add(rdbtnDescending, "cell 1 2");
		rdbtnDescending.setEnabled(false);
		
		rdbtn1000 = new QRadioButton("1000");
		getContentPane().add(rdbtn1000, "cell 2 2");
		
		rdbtnQuickSort = new QRadioButton("Quick Sort");
		getContentPane().add(rdbtnQuickSort, "cell 0 3");
		
		rdbtnRandom = new QRadioButton("");
		getContentPane().add(rdbtnRandom, "cell 1 3");
		rdbtnRandom.setEnabled(false);
		
		rdbtn2000 = new QRadioButton("2000");
		getContentPane().add(rdbtn2000, "cell 2 3");
		
		rdbtn5000 = new QRadioButton("5000");
		getContentPane().add(rdbtn5000, "cell 2 4");
		
		groupSort = new ButtonGroup();
		groupSort.add(rdbtnHeapSort);
		groupSort.add(rdbtnMergeSort);
		groupSort.add(rdbtnQuickSort);
		
		groupFile = new ButtonGroup();
		groupFile.add(rdbtnAscending);
		groupFile.add(rdbtnDescending);
		groupFile.add(rdbtnRandom);
		
		groupKeys = new ButtonGroup();
		groupKeys.add(rdbtn100);
		groupKeys.add(rdbtn1000);
		groupKeys.add(rdbtn2000);
		groupKeys.add(rdbtn5000);
		
		btnLoadDataFiles = new QButton("Load Data Files");
		getContentPane().add(btnLoadDataFiles, "cell 0 5,sizegroupx button,sizegroupy button");
		
		btnSort = new QButton("Sort");
		getContentPane().add(btnSort, "cell 0 6,sizegroupx button,sizegroupy button");
		
		
		lblNumberOfComparison = new QLabel("Number of Comparisons:");
		getContentPane().add(lblNumberOfComparison, "cell 0 7,alignx leading");
		
		tfComparisons = new QTextField();
		getContentPane().add(tfComparisons, "cell 1 7,growx,aligny top");
		tfComparisons.setColumns(10);
		
		lblNumberOfSwaps = new QLabel("Number of Swaps:");
		getContentPane().add(lblNumberOfSwaps, "cell 0 8,alignx leading");
		
		tfSwaps = new QTextField();
		getContentPane().add(tfSwaps, "cell 1 8,growx");
		tfSwaps.setColumns(10);
	}
}
