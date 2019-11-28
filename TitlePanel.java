import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class TitlePanel extends JPanel {
    // Constructor
    TitleIconPanel   iconPanel;
    TitleButtonPanel buttonPanel;
    TitlePanel() {
        iconPanel = new TitleIconPanel();
        buttonPanel = new TitleButtonPanel();
        setIconPanel();
        setButtonPanel();
    }

    public void setIconPanel() {
        // set panels
        this.setLayout(new BorderLayout());
        this.add(iconPanel, BorderLayout.CENTER);
    }

    public void setButtonPanel() {
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}

class TitleIconPanel extends JPanel {

}

class TitleButtonPanel extends JPanel implements ActionListener {
    JButton jbNext;
    JButton jbBefore;
    JButton jbCancel;
    // Constructor
    TitleButtonPanel() {
        // initial each button and set action listener
        jbNext = new JButton("Next");
        jbNext.addActionListener(this);
        jbNext.setActionCommand("NextButton");
        jbBefore = new JButton("Prev");
        jbBefore.addActionListener(this);
        jbBefore.setActionCommand("BeforeButton");
        jbCancel = new JButton("Cancel");
        jbCancel.addActionListener(this);
        jbCancel.setActionCommand("CancelButton");
        // distribute buttons with flow layout
        this.setLayout(new FlowLayout());
        this.add(jbCancel);
        this.add(jbBefore);
        this.add(jbNext);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}