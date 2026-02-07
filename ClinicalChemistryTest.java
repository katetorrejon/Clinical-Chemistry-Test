import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class ClinicalChemistryTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingGUI gui = new SwingGUI();

                // Attach processing logic to the button
                gui.getSubmitButton().addActionListener(e -> {
                    TestProcess testProcess = new TestProcess();
                    testProcess.setPatientSex(gui.getPatientSex());

                    int sampleResult = 20; // for testing purposes

                    ArrayList<Integer> selectedTestList = gui.getSelectedTests();
                    if (selectedTestList.isEmpty()) {
                        System.out.println("No tests selected.");
                    } else {
                        for (int test : selectedTestList) {
                            double minRange = testProcess.getMin(test);
                            double maxRange = testProcess.getMax(test);
                            String interpretation = testProcess.interpretResult(sampleResult, minRange, maxRange);
                            System.out.println("Test " + test + " -> " + interpretation);
                        }
                    }

                    // Optional: close GUI after processing
                    gui.dispose();
                });
            }
        });
    }
}
