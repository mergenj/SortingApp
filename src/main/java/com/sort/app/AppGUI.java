package com.sort.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Mergen
 */
public class AppGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private static App app;
	private JTextArea output;

	public AppGUI() {
		super("Sorting App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(1, 3));
		JPanel labelPanel = new JPanel (new GridLayout(1, 3));
		JPanel topPanel = new JPanel(new GridLayout(2, 3));
		labelPanel.add(new JLabel("Input"));
		labelPanel.add(new JLabel("Algorithm"));
		labelPanel.add(new JLabel());

		JTextField input = new JTextField(16);
		JComboBox<String> selection = new JComboBox<String>();
		JButton sort = new JButton("Sort");
		output = new JTextArea(5, 16);

		output.setEditable(false);

		selection.addItem("Bubble");
		selection.addItem("Quick");
		selection.addItem("Merge");
		selection.addItem("Selection");
		selection.addItem("Insertion");

		selection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectionIndex = selection.getSelectedIndex();
				ISort mAlgorithm = selectAlgorithm(selectionIndex);
				app.setAlgorithm(mAlgorithm);
			}
		});

		sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String rawInput = input.getText();
				if (App.validateInput(rawInput)) {
					int[] arrayToSort = App.stringToIntArray(rawInput);

					output.append(selection.getSelectedItem() + " sorted: ");
					final long startTime = System.currentTimeMillis();
					
					int[] sortedArray = app.getAlgorithm().sort(arrayToSort);
					output.append(Arrays.toString(sortedArray) + "\n");
					
					final long endTime = System.currentTimeMillis();
					output.append("Finished in " + (endTime - startTime)
							+ "ms.\n\n");
				} else {
					output.append("Invalid input" + "\n\n");
				}
			}
		});
		inputPanel.add(input);
		inputPanel.add(selection);
		inputPanel.add(sort);
		topPanel.add(labelPanel);
		topPanel.add(inputPanel);
		getContentPane().add(topPanel, BorderLayout.NORTH);
//		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(output, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		app = new App();
		app.setAlgorithm(new Bubble());
		new AppGUI();
	}

	public ISort selectAlgorithm(int value) {
		ISort algorithm = new Bubble();
		switch (value) {
		case 1:
			algorithm = new Bubble();
			break;
		case 2:
			algorithm = new Quick();
			break;
		case 3:
			algorithm = new Merge();
			break;
		case 4:
			algorithm = new Selection();
			break;
		case 5:
			algorithm = new Insertion();
			break;
		}

		return algorithm;
	}

}
