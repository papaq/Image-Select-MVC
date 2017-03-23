import ImagesController.ImageController;
import ImagesModel.Files;
import ImagesView.ImagesView;

public class ImagesMain {

    public static void main(String[] args) {

        ImagesView theView = new ImagesView();
        Files theModel = new Files();
        ImageController theController = new ImageController(theView, theModel);

        theView.setVisible(true);
    }
}
