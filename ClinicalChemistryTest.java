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

                    String patName = gui.getPatientName();
                    String patDOB = gui.getDOB();
                    String patSex = gui.getPatientSex();
                    String docName = gui.getDocName();

                    ArrayList<Integer> selectedTestList = gui.getSelectedTests();
                    ArrayList<Double> sampleResultsList = gui.collectSampleResults();
                    ArrayList<FinalResult> finalResults = new ArrayList<>();

                    for (int i = 0; i < selectedTestList.size(); i++) {
                        int test = selectedTestList.get(i);

                        double sampleResult = sampleResultsList.get(i);
                        double minRange = testProcess.getMin(test);
                        double maxRange = testProcess.getMax(test);
                        
                        String interpretation = testProcess.interpretResult(sampleResult, minRange, maxRange);

                        String testName = testProcess.getTestName(test);
                        String range = testProcess.getRange(test);

                        FinalResult finalResult = new FinalResult(testName, String.valueOf(sampleResult), range, interpretation);
                        finalResults.add(finalResult);
                    }

                    new ResultGUI(patName, patDOB, patSex, docName, finalResults);

                    gui.getSubmitButton().setEnabled(false);

                });
            }
        });
    }
}
