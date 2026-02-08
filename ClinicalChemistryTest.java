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

                        String testName = "";
                        String range = "";
                        switch (test) {
                            case 1:
                                testName = "Fasting Blood Sugar";
                                range = "74-100";
                                break;
                            case 2:
                                testName = "Random Blood Sugar";
                                range = "70-140";
                                break;
                            case 3:
                                testName = "Total Cholesterol";
                                range = "150-200";
                                break;
                            case 4:
                                testName = "HDL";
                                range = "M: 35-80, F: 42-88";
                                break;
                            case 5:
                                testName = "LDL";
                                range = "50-130";
                                break;
                            case 6:
                                testName = "Triglycerides";
                                range = "M: 60-165, F: 40-140";
                                break;
                            case 7:
                                testName = "Creatinine";
                                range = "M: 0.9-1.3, F: 0.6-1.2";
                                break;
                            case 8:
                                testName = "Uric Acid";
                                range = "M: 3.5-7.2, F: 2.6-6.0";
                                break;
                            case 9:
                                testName = "Blood Urea Nitrogen";
                                range = "6.0-20.0";
                                break;
                            case 10:
                                testName = "AST / SGOT";
                                range = "< 46";
                                break;
                            case 11:
                                testName = "ALT / SGPT";
                                range = "< 49";
                                break;
                            case 12:
                                testName = "Sodium";
                                range = "135.0-145.0";
                                break;
                            case 13:
                                testName = "Potassium";
                                range = "3.5-5.0";
                                break;
                            case 14:
                                testName = "Chloride";
                                range = "96.0-110.0";
                                break;
                            case 15:
                                testName = "Total Calcium";
                                range = "8.6-10.28";
                                break;
                            case 16:
                                testName = "Ionized Calcium";
                                range = "4.4-5.2";
                                break;
                        }

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
