import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class InputDataSelectPanel extends JPanel implements ActionListener {
    JButton jbAddButton;
    JButton jbRemoveButton;
    int nPanelNumber;
    ArrayList<DataPathSelectPanel> dataPanel;
    InputDataSelectPanel() {
        // add button
        jbAddButton = new JButton("データフォルダ追加...");
        jbAddButton.addActionListener(this);
        jbAddButton.setActionCommand("add");
        jbRemoveButton = new JButton("データフォルダ削除...");
        jbRemoveButton.addActionListener(this);
        jbRemoveButton.setActionCommand("remove");
        this.setLayout(new FlowLayout());        
        this.add(jbAddButton);
        this.add(jbRemoveButton);
        // data path select panel
        nPanelNumber = 0;
        dataPanel = new ArrayList<>();
        // two data source is necessary
        initDataPathPanel();
    }

    private void initDataPathPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dataPanel.add(new DataPathSelectPanel("眼鏡データ"));
        this.add(dataPanel.get(nPanelNumber));
        nPanelNumber++;
        dataPanel.add(new DataPathSelectPanel("外れデータ1"));
        this.add(dataPanel.get(nPanelNumber));
        nPanelNumber++;
        this.revalidate();
    }

    public void addDataPathSelectPanel() {
        if (nPanelNumber > 5) return;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dataPanel.add(new DataPathSelectPanel("外れデータ"+ String.valueOf(nPanelNumber)));
        this.add(dataPanel.get(nPanelNumber));
        nPanelNumber++;
        this.revalidate();
    }

    public void removeDataPathPanel() {
        if (nPanelNumber <= 2) return;
        this.remove(dataPanel.get(nPanelNumber-1));
        dataPanel.remove(nPanelNumber-1);
        nPanelNumber--;
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("add")) {
            addDataPathSelectPanel();
        }
        if (cmd.equals("remove")) {
            removeDataPathPanel();
        }
    }
}

class DataPathSelectPanel extends JPanel implements ActionListener {
    JLabel      jlDataLabel;
    JTextField  jtDataPathTextField;
    JButton     jbBrows;
    DataPathSelectPanel(String sDataLabel) {
        jlDataLabel = new JLabel(sDataLabel+":");
        jtDataPathTextField = new JTextField(40);
        jbBrows = new JButton("参照...");
        jbBrows.addActionListener(this);
        jbBrows.setActionCommand("brows");
        // range flow layout
        setLayout(new FlowLayout());
        this.add(jlDataLabel);
        this.add(jtDataPathTextField);
        this.add(jbBrows);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("brows")) {
            // permit directory only
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // select
            int selected = fileChooser.showOpenDialog(this);
            if (selected == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                jtDataPathTextField.setText(file.getAbsolutePath());
            }
        }
    }
}