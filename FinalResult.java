public class FinalResult {
    private String testType;
    private String testResult;
    private String testRange;
    private String resultInterpretation;

    public FinalResult (String tt, String tRes, String tRan, String ri) {
        testType = tt;
        testResult = tRes;
        testRange = tRan;
        resultInterpretation = ri;
    }

    public String getTestType() {
        return testType;
    }
    public String getTestResult() {
        return testResult;
    }
    public String getTestRange() {
        return testRange;
    }
    public String getResultInterpretation() {
        return resultInterpretation;
    }
}
