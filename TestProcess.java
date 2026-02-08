public class TestProcess {
    private String pSex, tName, tRange;
    private double min, max;

    public void setPatientSex(String s) {
        pSex = s;
    }

    public double getMin(int testID) {
        switch (testID) {
            case 1:
                min = 74;
                break;
            case 2:
                min = 70;
                break;
            case 3:
                min = 150;
                break;
            case 4:
                if (pSex.equalsIgnoreCase("Male")) {
                    min = 35;
                } else {
                    min = 42;
                }
                break;
            case 5:
                min = 50;
                break;
            case 6:
                if (pSex.equalsIgnoreCase("Male")) {
                    min = 60;
                } else {
                    min = 40;
                }
                break;
            case 7:
                if (pSex.equalsIgnoreCase("Male")) {
                    min = 0.9;
                } else {
                    min = 0.6;
                }
                break;
            case 8:
                if (pSex.equalsIgnoreCase("Male")) {
                    min = 3.5;
                } else {
                    min = 2.6;
                }
                break;
            case 9:
                min = 6;
                break;
            case 10:
                min = 0;
                break;
            case 11:
                min = 0;
                break;
            case 12:
                min = 135;
                break;
            case 13:
                min = 3.5;
                break;
            case 14:
                min = 96;
                break;
            case 15:
                min = 8.6;
                break;
            case 16:
                min = 4.4;
                break;
        }
        return min;
    }

    public double getMax(int testID) {
        switch (testID) {
            case 1:
                max = 100;
                break;
            case 2:
                max = 140;
                break;
            case 3:
                max = 200;
                break;
            case 4:
                if (pSex.equalsIgnoreCase("Male")) {
                    max = 80;
                } else {
                    max = 88;
                }
                break;
            case 5:
                max = 130;
                break;
            case 6:
                if (pSex.equalsIgnoreCase("Male")) {
                    max = 165;
                } else {
                    max = 140;
                }
                break;
            case 7:
                if (pSex.equalsIgnoreCase("Male")) {
                    max = 1.3;
                } else {
                    max = 1.2;
                }
                break;
            case 8:
                if (pSex.equalsIgnoreCase("Male")) {
                    max = 7.2;
                } else {
                    max = 6.0;
                }
                break;
            case 9:
                max = 20;
                break;
            case 10:
                max = 45;
                break;
            case 11:
                max = 48;
                break;
            case 12:
                max = 145;
                break;
            case 13:
                max = 5.0;
                break;
            case 14:
                max = 110;
                break;
            case 15:
                max = 10.28;
                break;
            case 16:
                max = 5.2;
                break;
        }
        return max;
    }

    public String interpretResult(double res, double min, double max) {
        if (res > max) {
            return "HIGH";
        } else if (res < min) {
            return "LOW";
        } else {
            return "NORMAL";
        }
    }

    public String getTestName(int testID) {
        switch (testID) {
            case 1:
                tName = "Fasting Blood Sugar";
                break;
            case 2:
                tName = "Random Blood Sugar";
                break;
            case 3:
                tName = "Total Cholesterol";
                break;
            case 4:
                tName = "HDL";
                break;
            case 5:
                tName = "LDL";
                break;
            case 6:
                tName = "Triglycerides";
                break;
            case 7:
                tName = "Creatinine";
                break;
            case 8:
                tName = "Uric Acid";
                break;
            case 9:
                tName = "Blood Urea Nitrogen";
                break;
            case 10:
                tName = "AST / SGOT";
                break;
            case 11:
                tName = "ALT / SGPT";
                break;
            case 12:
                tName = "Sodium";
                break;
            case 13:
                tName = "Potassium";
                break;
            case 14:
                tName = "Chloride";
                break;
            case 15:
                tName = "Total Calcium";
                break;
            case 16:
                tName = "Ionized Calcium";
                break;
        }
        return tName;
    }

    public String getRange(int testID) {
        switch (testID) {
            case 1:
                tRange = "74-100";
                break;
            case 2:
                tRange = "70-140";
                break;
            case 3:
                tRange = "150-200";
                break;
            case 4:
                tRange = "M: 35-80, F: 42-88";
                break;
            case 5:
                tRange = "50-130";
                break;
            case 6:
                tRange = "M: 60-165, F: 40-140";
                break;
            case 7:
                tRange = "M: 0.9-1.3, F: 0.6-1.2";
                break;
            case 8:
                tRange = "M: 3.5-7.2, F: 2.6-6.0";
                break;
            case 9:
                tRange = "6.0-20.0";
                break;
            case 10:
                tRange = "< 46";
                break;
            case 11:
                tRange = "< 49";
                break;
            case 12:
                tRange = "135.0-145.0";
                break;
            case 13:
                tRange = "3.5-5.0";
                break;
            case 14:
                tRange = "96.0-110.0";
                break;
            case 15:
                tRange = "8.6-10.28";
                break;
            case 16:
                tRange = "4.4-5.2";
                break;
        }
        return tRange;
    }
}
