import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class ClinicalChemistryTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingGUI gui = new SwingGUI();

                gui.getSubmitButton().addActionListener(e -> {
                    TestProcess testProcess = new TestProcess();
                    testProcess.setPatientSex(gui.getPatientSex());

                    ArrayList<Integer> selectedTestList = gui.getSelectedTests();
                    ArrayList<Double> sampleResultsList = gui.collectSampleResults();

                    for (int i = 0; i < selectedTestList.size(); i++) {
                        int test = selectedTestList.get(i);
                        double sampleResult = sampleResultsList.get(i);

                        double minRange = testProcess.getMin(test);
                        double maxRange = testProcess.getMax(test);
                        String interpretation = testProcess.interpretResult(sampleResult, minRange, maxRange);

                        System.out.println("Test " + test + " -> " + interpretation);
                    }

                    gui.getSubmitButton().setEnabled(false);
                });

                
            }
        });
    }
}
