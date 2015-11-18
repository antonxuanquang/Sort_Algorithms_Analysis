import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Theme.QRadioButton;

public class Lab3Control implements ActionListener{

	Lab3View view;
	Lab3Model model;
	
	public Lab3Control(Lab3View view, Lab3Model model) {
		this.view = view;
		this.model = model;
		
		setUpListeners();
	}
	
	private void sort() {
		String sortType = getSelectedButtonText(view.groupSort);
		String dataFile = getSelectedButtonText(view.groupFile);
		String numberOfKeys = getSelectedButtonText(view.groupKeys);
		
		if (sortType != null && dataFile != null &&  numberOfKeys != null) {
			String [] array = null;
			if (dataFile.equals(view.rdbtnAscending.getText())) {
				array = model.ascendingArray;
			} else if (dataFile.equals(view.rdbtnDescending.getText())) {
				array = model.descendingArray;
			} else if (dataFile.equals(view.rdbtnRandom.getText())) {
				array = model.randomArray;
			}
			int number = 0;
			switch (numberOfKeys) {
				case "100": number = 100; break;
				case "1000": number = 1000; break;
				case "2000": number = 2000; break;
				case "5000": number = 5000; break;
				default: break;
			}
			switch (sortType) {
				case "Heap Sort": model.startHeapSort(array, number); break;
				case "Merge Sort": model.startMergeSort(array, number); break;
				case "Quick Sort": model.startQuickSort(array,number); break;
				default: break;
			}
		}
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
	
	
	private void loadFile() {
		if (!view.rdbtnAscending.isEnabled()) {
			model.loadFile(view.rdbtnAscending, model.ascendingArray);
		} else if (!view.rdbtnDescending.isEnabled()) {
			model.loadFile(view.rdbtnDescending, model.descendingArray);
		} else if (!view.rdbtnRandom.isEnabled()) {
			model.loadFile(view.rdbtnRandom, model.randomArray);
			view.btnLoadDataFiles.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(null, "Can not load more data file", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	

	private void setUpListeners() {
		view.btnLoadDataFiles.addActionListener(this);
		view.btnSort.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if (event == view.btnLoadDataFiles) loadFile();
		else if (event == view.btnSort) sort();
	}
	
	
}
