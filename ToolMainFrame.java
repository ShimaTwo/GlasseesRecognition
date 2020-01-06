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
            showTitlePanel();
        } else if (panelCount == 1) {
            // data input
            showInputDataSelectPanel();
        } else if (panelCount == 2) {
            // learning parameta
        } else {
            // error
            System.exit(0);
        }
        repaintPanels();     
    }

    // in fact, remove all panel
    private void remeveCurrentPanel() {
        this.remove(this.jpTitlePanel);
        this.remove(this.jpInputDataSelect);
        this.remove(this.jpLearningDataInput);
    }

    public void showTitlePanel() {
        this.add(jpTitlePanel);
        jpButtonPanel.activateNextButton(true);
        jpButtonPanel.activatePreButton(false);
    }

    public void showInputDataSelectPanel() {
        this.add(jpInputDataSelect);
        jpButtonPanel.activateNextButton(true);
        jpButtonPanel.activatePreButton(true);        
    }

    public void showLearningDataInputPanel() {
        
    }

    public void repaintPanels() {
        this.revalidate();
        jpTitlePanel.revalidate();
        jpInputDataSelect.revalidate();
        jpLearningDataInput.revalidate();
        this.repaint();
        jpTitlePanel.repaint();
        jpInputDataSelect.repaint();
        jpLearningDataInput.repaint();
    }
}