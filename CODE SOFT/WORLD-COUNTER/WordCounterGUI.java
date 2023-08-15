import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounterGUI {
    private JFrame frame;
    private JTextArea inputTextArea;
    private JButton countButton;
    private JLabel totalWordsLabel;
    private JLabel uniqueWordsLabel;
    private JTextArea wordFrequencyTextArea;

    public WordCounterGUI() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        inputTextArea = new JTextArea();
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(countButton);

        totalWordsLabel = new JLabel("Total Words: 0");
        uniqueWordsLabel = new JLabel("Unique Words: 0");

        wordFrequencyTextArea = new JTextArea();
        wordFrequencyTextArea.setEditable(false);
        JScrollPane wordFrequencyScrollPane = new JScrollPane(wordFrequencyTextArea);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(totalWordsLabel, BorderLayout.NORTH);
        resultPanel.add(uniqueWordsLabel, BorderLayout.CENTER);
        resultPanel.add(wordFrequencyScrollPane, BorderLayout.SOUTH);

        frame.add(inputScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(resultPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void countWords() {
        String input = inputTextArea.getText();

        if (input != null && !input.isEmpty()) {
            // Split the string into an array of words
            String[] words = input.split("[\\p{Punct}\\s]+");

            // Initialize a counter variable
            int wordCount = 0;

            // Initialize a map to store word frequencies
            Map<String, Integer> wordFrequency = new HashMap<>();

            for (String word : words) {
                // Increment the counter for each word encountered
                wordCount++;

                // Increment the frequency of the word
                int frequency = wordFrequency.getOrDefault(word, 0);
                wordFrequency.put(word, frequency + 1);
            }

            // Update the GUI with word count and frequency information
            totalWordsLabel.setText("Total Words: " + wordCount);
            uniqueWordsLabel.setText("Unique Words: " + wordFrequency.size());

            StringBuilder frequencyText = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                frequencyText.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            wordFrequencyTextArea.setText(frequencyText.toString());
        } else {
            JOptionPane.showMessageDialog(frame, "No input provided.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounterGUI();
            }
        });
    }
}
