package ImagesView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagesView extends JFrame {

    private JTextField imageName = new JTextField(20);
    private JComboBox<String> comboBoxImageChoose = new JComboBox<>();
    private JLabel imageLabel = new JLabel("kk");

    public ImagesView() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(500,500);
        this.setMinimumSize(new Dimension(500,500));
        this.setTitle("Choose Logo");
        this.setLocationRelativeTo(null);  // to center the app


        JPanel wholePanel = new JPanel();
        wholePanel.setBackground(new Color(255, 255, 255));

        imageLabel.setPreferredSize(new Dimension(300, 350));
        wholePanel.add(imageLabel, BorderLayout.CENTER);

        JPanel controlsPanel = new JPanel(new BorderLayout());
        controlsPanel.setLayout(new GridBagLayout());
        controlsPanel.setBackground(new Color(255, 255, 255));

        wholePanel.add(controlsPanel, BorderLayout.SOUTH);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.ipadx = 20;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        controlsPanel.add(new JLabel("Input image name"), gbc);

        gbc. gridx++;
        controlsPanel.add(imageName, gbc);

        gbc.gridy++;
        controlsPanel.add(comboBoxImageChoose, gbc);


        this.add(wholePanel);
    }

    public String getImageNameText() {

        return imageName.getText();
    }

    public void setComboListener(ItemListener listener) {

        comboBoxImageChoose.addItemListener(listener);
    }

    public void setImage(File imageFile) {

        BufferedImage bi;
        try {

            bi = ImageIO.read(imageFile);
        } catch (IOException e) {

            e.printStackTrace();
            return;
        }

        ImageIcon imageIcon = new ImageIcon(bi);
        //imageLabel = new JLabel("", imageIcon, JLabel.CENTER);

        imageLabel.setText("");
        imageLabel.setIcon(imageIcon);
   }

    public void addTextFieldListener(DocumentListener listener) {

        imageName.getDocument().addDocumentListener(listener);
    }

    public void setComboBoxItems(String[] items) {

        comboBoxImageChoose.removeAllItems();

        for (String item : items) {

            comboBoxImageChoose.addItem(item);
        }
    }

    public String getSelectedItem() {

        return (String) comboBoxImageChoose.getSelectedItem();
    }

    public void setText(String text) {

        imageName.setText(text);
    }
}
