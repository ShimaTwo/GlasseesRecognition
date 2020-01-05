import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


class ToolMainFrame extends JFrame {
    TitlePanel             jpTitlePanel;
    InputDataSelectPanel   jpInputDataSelect;
    LearningDataInputPanel jpLearningDataInput;
    ButtonPanel            jpButtonPanel;
    int panelCount;
    // Constructor
    ToolMainFrame() {
        this.setTitle("MOM Neural Network Trainer");
        this.setBounds(600, 500, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // init panel counter
        panelCount = 0;
        // make title panel
        jpTitlePanel        = new TitlePanel();
        jpInputDataSelect   = new InputDataSelectPanel();
        jpLearningDataInput = new LearningDataInputPanel();
        jpButtonPanel       = new ButtonPanel(this);
        getContentPane().add(jpTitlePanel, BorderLayout.CENTER);
        getContentPane().add(jpButtonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void reloadPanel(int transition) {
        panelCount = panelCount + transition;
        remeveCurrentPanel();
        if (panelCount == 0) {
            // title panel

        } else if (panelCount == 1) {
            // data input
            this.add(jpInputDataSelect);
            revalidate();
        } else if (panelCount == 2) {
            // learning parameta
        } else {
            // error
        }
    }

    // in fact, remove all panel
    private void remeveCurrentPanel() {
        this.remove(this.jpTitlePanel);
        this.remove(this.jpInputDataSelect);
        this.remove(this.jpLearningDataInput);
    }

    public void showTitlePanel() {

    }

    public void showInputDataSelectPanel() {

    }

    public void showLearningDataInputPanel() {
        
    }
}