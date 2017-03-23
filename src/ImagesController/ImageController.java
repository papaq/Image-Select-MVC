package ImagesController;

import ImagesModel.Files;
import ImagesView.ImagesView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class ImageController {

    private ImagesView theView;
    private Files theModel;

    public ImageController(ImagesView view, Files model) {

        theModel = model;
        theView = view;

        theView.setComboListener(new ComboBoxItemListener());
        theView.addTextFieldListener(new TextBoxDocumentListener());
        theView.setText(" ");
        theView.setText("");
    }

    private class ComboBoxItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                String selected = theView.getSelectedItem();
                File image = theModel.getImageByName(selected);
                theView.setImage(image);
            }
        }
    }

    private class TextBoxDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

            updateComboBox();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

            updateComboBox();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

            updateComboBox();
        }

        private void updateComboBox() {

            String inputStr = theView.getImageNameText();
            String[] items = theModel.getMatchingImagesNames(inputStr);

            if (items.length != 0) {

                theView.setComboBoxItems(items);
            }
            else {

                theView.removeImage();
                theView.clearComboBoxItems();
            }
        }
    }
}
