import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonPanelOnTitle extends JPanel implements ActionListener {
    // Constructor
    JButton jbNext;
    JButton jbBefore;
    ButtonPanelOnTitle() {
        // ボタン初期化
        jbNext = new JButton("次へ");
        jbNext.addActionListener(this);
        jbNext.setActionCommand("Next");
        jbBefore = new JButton("戻る");
        jbBefore.addActionListener(this);
        jbBefore.setActionCommand("Before");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}