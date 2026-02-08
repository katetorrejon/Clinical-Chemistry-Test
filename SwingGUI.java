import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.awt.*;

public class SwingGUI extends JFrame {
    private JButton submitInfo;
    private JPanel header, body, leftMargin, rightMargin, footer;
    private JPanel profilePanel, selectPanel, column1, column2, column3, column4, confirmPanel;
    private JLabel heading, subheading, nameLabel, dobLabel, docLabel, sexLabel;
    private JTextField name, dob, doc;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox fbs, rbs, totalChol, hdl, ldl, triglycerides, creatinine, uricAcid, bun, ast_sgot, alt_sgpt, sodium, potassium, chloride, totalCal, ionizedCal;
    private ArrayList<Integer> selection = new ArrayList<>();
    private ArrayList<Double> sampleResults = new ArrayList<>();

    public SwingGUI() {
        this.setTitle("Clinical Chemistry Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        // Panels
        header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setPreferredSize(new Dimension(900, 110));

        footer = new JPanel();
        footer.setBackground(new Color(50, 88, 168));
        footer.setPreferredSize(new Dimension(700, 40));

        leftMargin = new JPanel();
        leftMargin.setBackground(Color.WHITE);
        leftMargin.setPreferredSize(new Dimension(50, 600));

        rightMargin = new JPanel();
        rightMargin.setBackground(Color.WHITE);
        rightMargin.setPreferredSize(new Dimension(50, 600));

        body = new JPanel(); 
        body.setBackground(Color.WHITE);
        body.setPreferredSize(new Dimension(800, 440)); 

        profilePanel = new JPanel();
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setPreferredSize(new Dimension(800, 80));

        selectPanel = new JPanel();
        selectPanel.setBackground(Color.WHITE);
        selectPanel.setPreferredSize(new Dimension(760, 40));

        column1 = new JPanel();
        column1.setPreferredSize(new Dimension(180, 220));
        column1.setLayout(new BoxLayout(column1, BoxLayout.Y_AXIS));
        column1.setBorder(new EmptyBorder(0, 8, 0, 0));

        column2 = new JPanel();
        column2.setPreferredSize(new Dimension(180, 220));
        column2.setLayout(new BoxLayout(column2, BoxLayout.Y_AXIS));
        column2.setBorder(new EmptyBorder(0, 8, 0, 0));

        column3 = new JPanel();
        column3.setPreferredSize(new Dimension(180, 220));
        column3.setLayout(new BoxLayout(column3, BoxLayout.Y_AXIS));
        column3.setBorder(new EmptyBorder(0, 8, 0, 0));

        column4 = new JPanel();
        column4.setPreferredSize(new Dimension(180, 220));
        column4.setLayout(new BoxLayout(column4, BoxLayout.Y_AXIS));
        column4.setBorder(new EmptyBorder(0, 8, 0, 0));

        confirmPanel = new JPanel();
        confirmPanel.setBackground(Color.WHITE);
        confirmPanel.setPreferredSize(new Dimension(800, 70));

        // Components

        ImageIcon logo = new ImageIcon("logo.png");
        heading = new JLabel();
        heading.setIcon(logo);

        nameLabel = new JLabel("Full Name:   ");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        name = new JTextField();
        name.setPreferredSize(new Dimension(300, 25));

        dobLabel = new JLabel("       Date of Birth (YYYY-MM-DD):   ");
        dobLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dob = new JTextField();
        dob.setPreferredSize(new Dimension(120, 25));

        docLabel = new JLabel("     Name of Requesting Physician:   ");
        docLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        doc = new JTextField();
        doc.setPreferredSize(new Dimension(300, 25));

        sexLabel = new JLabel("Sex:   ");
        sexLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        maleButton = new JRadioButton(" Male  ");
        maleButton.setBackground(Color.WHITE);
        maleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        maleButton.setFocusable(false);

        femaleButton = new JRadioButton(" Female  ");
        femaleButton.setBackground(Color.WHITE);
        femaleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        femaleButton.setFocusable(false);

        ButtonGroup sex = new ButtonGroup();
        sex.add(maleButton);
        sex.add(femaleButton);

        subheading = new JLabel("Select test/tests to conduct:");
        subheading.setFont(new Font("Tahoma", Font.BOLD, 14));

        fbs = new JCheckBox("Fasting Blood Sugar"); fbs.setFocusable(false);
        rbs = new JCheckBox("Random Blood Sugar"); rbs.setFocusable(false);
        totalChol = new JCheckBox("Total Cholesterol"); totalChol.setFocusable(false);
        hdl = new JCheckBox("HDL"); hdl.setFocusable(false);
        ldl = new JCheckBox("LDL"); ldl.setFocusable(false);
        triglycerides = new JCheckBox("Triglycerides"); triglycerides.setFocusable(false);
        creatinine = new JCheckBox("Creatinine"); creatinine.setFocusable(false);
        uricAcid = new JCheckBox("Uric Acid"); uricAcid.setFocusable(false);
        bun = new JCheckBox("Blood Urea Nitrogen"); bun.setFocusable(false);
        ast_sgot = new JCheckBox("AST / SGOT"); ast_sgot.setFocusable(false);
        alt_sgpt = new JCheckBox("ALT / SGPT"); alt_sgpt.setFocusable(false);
        sodium = new JCheckBox("Sodium"); sodium.setFocusable(false);
        potassium = new JCheckBox("Potassium"); potassium.setFocusable(false);
        chloride = new JCheckBox("Chloride"); chloride.setFocusable(false);
        totalCal = new JCheckBox("Total Calcium"); totalCal.setFocusable(false);
        ionizedCal = new JCheckBox("Ionized Calcium"); ionizedCal.setFocusable(false);

        submitInfo = new JButton("Get Results");
        submitInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
        submitInfo.setBackground(Color.LIGHT_GRAY);
        submitInfo.setFocusable(false);

        // Adding stuff

        header.add(heading);

        profilePanel.add(nameLabel);
        profilePanel.add(name);
        profilePanel.add(dobLabel);
        profilePanel.add(dob);
        profilePanel.add(sexLabel);
        profilePanel.add(maleButton);
        profilePanel.add(femaleButton);
        profilePanel.add(docLabel);
        profilePanel.add(doc);

        selectPanel.setLayout(new BorderLayout());
        selectPanel.add(subheading, BorderLayout.WEST);

        column1.add(Box.createRigidArea(new Dimension(0, 10)));
        column1.add(fbs);
        column1.add(Box.createRigidArea(new Dimension(0, 10)));
        column1.add(rbs);
        column1.add(Box.createRigidArea(new Dimension(0, 10)));
        column1.add(totalChol);
        column1.add(Box.createRigidArea(new Dimension(0, 10)));
        column1.add(hdl);

        column2.add(Box.createRigidArea(new Dimension(0, 10)));
        column2.add(ldl);
        column2.add(Box.createRigidArea(new Dimension(0, 10)));
        column2.add(triglycerides);
        column2.add(Box.createRigidArea(new Dimension(0, 10)));
        column2.add(creatinine);
        column2.add(Box.createRigidArea(new Dimension(0, 10)));
        column2.add(uricAcid);
        
        column3.add(Box.createRigidArea(new Dimension(0, 10)));
        column3.add(bun);
        column3.add(Box.createRigidArea(new Dimension(0, 10)));
        column3.add(ast_sgot);
        column3.add(Box.createRigidArea(new Dimension(0, 10)));
        column3.add(alt_sgpt);
        column3.add(Box.createRigidArea(new Dimension(0, 10)));
        column3.add(sodium);

        column4.add(Box.createRigidArea(new Dimension(0, 10)));
        column4.add(potassium);
        column4.add(Box.createRigidArea(new Dimension(0, 10)));
        column4.add(chloride);
        column4.add(Box.createRigidArea(new Dimension(0, 10)));
        column4.add(totalCal);
        column4.add(Box.createRigidArea(new Dimension(0, 10)));
        column4.add(ionizedCal);

        confirmPanel.add(submitInfo);

        body.add(profilePanel);
        body.add(selectPanel);
        body.add(column1);
        body.add(column2);
        body.add(column3);
        body.add(column4);
        body.add(confirmPanel);

        this.add(header, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(leftMargin, BorderLayout.WEST);
        this.add(rightMargin, BorderLayout.EAST);
        this.add(body, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public JButton getSubmitButton() { 
        return submitInfo; }

    public String getPatientName() { 
        return name.getText(); 
    }
    public String getDOB() { 
        return dob.getText(); 
    }
    public String getPatientSex() {
        if (maleButton.isSelected()) 
            return "Male";
        if (femaleButton.isSelected()) 
            return "Female";
        return "Unknown";
    }
    public String getDocName() { 
        return doc.getText(); 
    }

    public ArrayList<Integer> getSelectedTests() {
        if (fbs.isSelected()) {
            selection.add(1);
        }
        if (rbs.isSelected()) {
            selection.add(2);
        }
        if (totalChol.isSelected()) {
            selection.add(3);
        }
        if (hdl.isSelected()) {
            selection.add(4);
        }
        if (ldl.isSelected()) {
            selection.add(5);
        }
        if (triglycerides.isSelected()) {
            selection.add(6);
        }
        if (creatinine.isSelected()) {
            selection.add(7);
        }
        if (uricAcid.isSelected()) {
            selection.add(8);
        }
        if (bun.isSelected()) {
            selection.add(9);
        }
        if (ast_sgot.isSelected()) {
            selection.add(10);
        }
        if (alt_sgpt.isSelected()) {
            selection.add(11);
        }
        if (sodium.isSelected()) {
            selection.add(12);
        }
        if (potassium.isSelected()) {
            selection.add(13);
        }
        if (chloride.isSelected()) {
            selection.add(14);
        }
        if (totalCal.isSelected()) {
            selection.add(15);
        }
        if (ionizedCal.isSelected()) {
            selection.add(16);
        }
        return selection;
    }

    public ArrayList<Double> collectSampleResults() {
        for (int test : selection) {
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

            String input = JOptionPane.showInputDialog(this, "Enter a sample result for " + testName + " (Range: " + range + "):    ","Input", JOptionPane.QUESTION_MESSAGE);
            double resultValue = Double.parseDouble(input);
            sampleResults.add(resultValue);

        }
        return sampleResults;
    }

}
