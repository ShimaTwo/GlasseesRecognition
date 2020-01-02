import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class TitlePanel extends JPanel {
    // Constructor
    TitleIconPanel   iconPanel;
    TitleButtonPanel buttonPanel;
    TitlePanel() {
        iconPanel = new TitleIconPanel();
        buttonPanel = new TitleButtonPanel();
        // add panels
        BorderLayout layout = new BorderLayout();
        setIconPanel(layout);
        setButtonPanel(layout);
    }

    public void setIconPanel(BorderLayout layout) {
        // set panels
        this.setLayout(layout);
        this.add(iconPanel, BorderLayout.CENTER);
    }

    public void setButtonPanel(BorderLayout layout) {
        this.setLayout(layout);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}

class TitleIconPanel extends JPanel {
    private ImageIcon iTitleImage;
    private JLabel jlTitleImage;
    // Constructor
    TitleIconPanel() {
        iTitleImage = new ImageIcon("./ImageDirectory/MOMTitleImage.png");
        jlTitleImage = new JLabel();
        if (iTitleImage!=null) {
            jlTitleImage.setIcon(iTitleImage);
            this.setLayout(new FlowLayout());
            this.add(jlTitleImage);
        } else  {
            // image did not exist
        }
    }

    public static ImageIcon resizeIcon(ImageIcon icon, int x, int y) {
        Image iResize = icon.getImage();
        BufferedImage resizedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(iResize, 0, 0, x, y, null);
        g2.dispose();
        ImageIcon iiResize = new ImageIcon();
        iiResize.setImage(resizedImage);
        return iiResize;
    }
}

class TitleButtonPanel extends JPanel implements ActionListener {
    private JButton jbNext;
    private JButton jbBefore;
    private JButton jbCancel;
    // Constructor
    TitleButtonPanel() {
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
        
    }
}