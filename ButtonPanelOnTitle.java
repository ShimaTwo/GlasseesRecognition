import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonPanel extends JPanel implements ActionListener {
    ToolMainFrame mainFrame;
    private JButton jbNext;
    private JButton jbBefore;
    private JButton jbCancel;
    // Constructor
    ButtonPanel(ToolMainFrame mainFrame) {
        // set main frame
        this.mainFrame = mainFrame;
        // initial each button and set action listener
        jbNext = new JButton("Next");
        jbNext.addActionListener(this);
        jbNext.setActionCommand("NextButton");
        jbBefore = new JButton("Prev");
        jbBefore.addActionListener(this);
        jbBefore.setEnabled(false);
        jbBefore.setActionCommand("BeforeButton");
        jbCancel = new JButton("Cancel");
        jbCancel.addActionListener(this);
        jbCancel.setActionCommand("CancelButton");
        // distribute buttons with flow layout
        this.setLayout(new FlowLayout());
        this.add(jbCancel);
        this.add(jbBefore);
        this.add(jbNext);
        // set panel background clear
        // this.setOpaque(false);
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        if (cmd.equals("NextButton")) {
            mainFrame.reloadPanel(1);
        } else if (cmd.equals("BeforeButton")) {
            mainFrame.reloadPanel(-1);
        }
    }
}