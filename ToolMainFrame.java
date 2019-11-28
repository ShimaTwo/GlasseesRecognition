import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


class ToolMainFrame extends JFrame {
    TitlePanel             jpTitlePanel;
    InputDataSelectPanel   jpInputDataSelect;
    LearningDataInputPanel jpLearningDataInput;
    // Constructor
    ToolMainFrame() {
        this.setTitle("MOM Neural Network Trainer");
        this.setBounds(600, 500, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // make title panel
        jpTitlePanel = new TitlePanel();
        getContentPane().add(jpTitlePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}