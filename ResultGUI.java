import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class ResultGUI extends JFrame {
    private JPanel headPanel, infoPanel, headingPanel, bodyPanel, footerPanel;
    private JPanel infoRow1, infoRow2, testColumn, resultColumn, rangeColumn, interpretationColumn;
    private JLabel patientName, birthdate, patientAge, patientSex, collectionTime, doctorName;
    private JLabel mainHeader, subHeader, testHeader, resultHeader, rangeHeader, interpretationHeader;
    private JLabel testLabel, resultLabel, rangeLabel, interpretationLabel; 

    public ResultGUI(String pn, String pdob, String ps, String dn, ArrayList<FinalResult> finalResults) {
        this.setTitle("Clinical Chemistry Test Results");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 840);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        // Panels

        headPanel = new JPanel();
        headPanel.setBackground(Color.WHITE);
        headPanel.setPreferredSize(new Dimension(900, 110));

        infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setPreferredSize(new Dimension(900, 80));

        infoRow1 = new JPanel();
        infoRow1.setBackground(Color.WHITE);
        infoRow1.setPreferredSize(new Dimension(900, 30));

        infoRow2 = new JPanel();
        infoRow2.setBackground(Color.WHITE);
        infoRow2.setPreferredSize(new Dimension(900, 30));

        headingPanel = new JPanel();
        headingPanel.setBackground(Color.WHITE);
        headingPanel.setPreferredSize(new Dimension(900, 40));

        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setPreferredSize(new Dimension(900, 690));

        testColumn = new JPanel();
        testColumn.setPreferredSize(new Dimension(200, 600));
        testColumn.setLayout(new BoxLayout(testColumn, BoxLayout.Y_AXIS));
        testColumn.setBorder(new EmptyBorder(0, 8, 0, 0));

        resultColumn = new JPanel();
        resultColumn.setPreferredSize(new Dimension(100, 600));
        resultColumn.setLayout(new BoxLayout(resultColumn, BoxLayout.Y_AXIS));
        resultColumn.setBorder(new EmptyBorder(0, 8, 0, 0));

        rangeColumn = new JPanel();
        rangeColumn.setPreferredSize(new Dimension(250, 600));
        rangeColumn.setLayout(new BoxLayout(rangeColumn, BoxLayout.Y_AXIS));
        rangeColumn.setBorder(new EmptyBorder(0, 8, 0, 0));

        interpretationColumn = new JPanel();
        interpretationColumn.setPreferredSize(new Dimension(150, 600));
        interpretationColumn.setLayout(new BoxLayout(interpretationColumn, BoxLayout.Y_AXIS));
        interpretationColumn.setBorder(new EmptyBorder(0, 8, 0, 0));

        footerPanel = new JPanel();
        footerPanel.setBackground(new Color(50, 88, 168));
        footerPanel.setPreferredSize(new Dimension(900, 40));

        // Date Stuff

        DateTimeFormatter stringToDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");

        LocalDate birthDate = LocalDate.parse(pdob, stringToDate);
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = LocalDate.now();
        Period currentAge = Period.between(birthDate, currentDate);

        // Components

        ImageIcon logo = new ImageIcon("logo.png");
        mainHeader = new JLabel();
        mainHeader.setIcon(logo);

        patientName = new JLabel("Name:  " + pn + "    ");
        patientName.setFont(new Font("Consolas", Font.BOLD, 14));

        birthdate = new JLabel("    Birthdate:  " + birthDate.format(formatDate) + "    ");
        birthdate.setFont(new Font("Consolas", Font.BOLD, 14));

        patientAge = new JLabel("    Age:  " + currentAge.getYears() + "    ");
        patientAge.setFont(new Font("Consolas", Font.BOLD, 14));

        patientSex = new JLabel("    Sex:  " + ps);
        patientSex.setFont(new Font("Consolas", Font.BOLD, 14));

        collectionTime = new JLabel("Time of Collection:  " + currentDateTime.format(formatDateTime) + "    ");
        collectionTime.setFont(new Font("Consolas", Font.BOLD, 14));

        doctorName = new JLabel("    Requesting Physician:  " + dn);
        doctorName.setFont(new Font("Consolas", Font.BOLD, 14));

        subHeader = new JLabel("CLINICAL CHEMISTRY");
        subHeader.setFont(new Font("Tahoma", Font.BOLD, 18));

        testHeader = new JLabel("Test");
        testHeader.setMaximumSize(new Dimension(184, 18));
        testHeader.setFont(new Font("Tahoma", Font.BOLD, 14));

        resultHeader = new JLabel("Result");
        resultHeader.setMaximumSize(new Dimension(83, 18));
        resultHeader.setHorizontalAlignment(SwingConstants.CENTER);
        resultHeader.setOpaque(true);
        resultHeader.setFont(new Font("Tahoma", Font.BOLD, 14));

        rangeHeader = new JLabel("Range (Conventional Units)");
        rangeHeader.setMaximumSize(new Dimension(235, 18));
        rangeHeader.setHorizontalAlignment(SwingConstants.CENTER);
        rangeHeader.setOpaque(true);
        rangeHeader.setFont(new Font("Tahoma", Font.BOLD, 14));

        interpretationHeader = new JLabel("Interpretation");
        interpretationHeader.setMaximumSize(new Dimension(134, 18));
        interpretationHeader.setHorizontalAlignment(SwingConstants.CENTER);
        interpretationHeader.setOpaque(true);
        interpretationHeader.setFont(new Font("Tahoma", Font.BOLD, 14));

        // Adding stuff

        headPanel.add(mainHeader);

        infoRow1.add(patientName);
        infoRow1.add(birthdate);
        infoRow1.add(patientAge);
        infoRow1.add(patientSex);
        infoRow2.add(collectionTime);
        infoRow2.add(doctorName);

        infoPanel.add(infoRow1);
        infoPanel.add(infoRow2);

        headingPanel.add(subHeader);

        testColumn.add(Box.createRigidArea(new Dimension(0, 10)));
        testColumn.add(testHeader);
        testColumn.add(Box.createRigidArea(new Dimension(0, 10)));

        resultColumn.add(Box.createRigidArea(new Dimension(0, 10)));
        resultColumn.add(resultHeader);
        resultColumn.add(Box.createRigidArea(new Dimension(0, 10)));

        rangeColumn.add(Box.createRigidArea(new Dimension(0, 10)));
        rangeColumn.add(rangeHeader);
        rangeColumn.add(Box.createRigidArea(new Dimension(0, 10)));

        interpretationColumn.add(Box.createRigidArea(new Dimension(0, 10)));
        interpretationColumn.add(interpretationHeader);
        interpretationColumn.add(Box.createRigidArea(new Dimension(0, 10)));

        // Results

        for (FinalResult finalResult : finalResults) {
            testLabel = new JLabel(finalResult.getTestType());
            testLabel.setMaximumSize(new Dimension(184, 18));
            testLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

            resultLabel = new JLabel(finalResult.getTestResult());
            resultLabel.setMaximumSize(new Dimension(83, 18));
            resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultLabel.setOpaque(true);
            resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

            rangeLabel = new JLabel(finalResult.getTestRange());
            rangeLabel.setMaximumSize(new Dimension(235, 18));
            rangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rangeLabel.setOpaque(true);
            rangeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

            interpretationLabel = new JLabel(finalResult.getResultInterpretation());
            interpretationLabel.setMaximumSize(new Dimension(134, 18));
            interpretationLabel.setHorizontalAlignment(SwingConstants.CENTER);
            interpretationLabel.setOpaque(true);
            interpretationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

            testColumn.add(Box.createRigidArea(new Dimension(0, 10)));
            testColumn.add(testLabel);

            resultColumn.add(Box.createRigidArea(new Dimension(0, 10)));
            resultColumn.add(resultLabel);

            rangeColumn.add(Box.createRigidArea(new Dimension(0, 10)));
            rangeColumn.add(rangeLabel);

            interpretationColumn.add(Box.createRigidArea(new Dimension(0, 10)));
            interpretationColumn.add(interpretationLabel);
        }

        // More adding stuff

        bodyPanel.add(infoPanel);
        bodyPanel.add(headingPanel);
        bodyPanel.add(testColumn);
        bodyPanel.add(resultColumn);
        bodyPanel.add(rangeColumn);
        bodyPanel.add(interpretationColumn);

        this.add(headPanel, BorderLayout.NORTH);
        this.add(bodyPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
