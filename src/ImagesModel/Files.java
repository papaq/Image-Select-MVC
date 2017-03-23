package ImagesModel;

import java.io.File;
import java.util.*;

public class Files {

    private final String imagesDirectoryName = "\\rsrc";

    private String directoryPath;
    private HashMap<String, File> images;

    public Files() {

        directoryPath = System.getProperty("user.dir").concat(imagesDirectoryName);

        images = getAllImages();
    }

    private HashMap<String, File> getAllImages(){

        File directory = new File(directoryPath);

        // Get all files from the directory
        File[] fList = directory.listFiles();

        HashMap<String, File> imageNames = new HashMap<>();

        if (fList == null)
            return null;

        // Choose images
        for (File file : fList){
            if (file.getName().toLowerCase().matches(".+\\.(png|jpg|jpeg)"))
                imageNames.put(file.getName(), file);
        }

        return imageNames;
    }

    public String[] getImageNames() {

        Set<String> names = images.keySet();
        return names.toArray(new String[names.size()]);
    }

    public File getImageByName(String name) {

        return images.get(name);
    }

    public String[] getMatchingImagesNames(String substr) {

        ArrayList<String> matchingImagesNames = new ArrayList<>();

        for (String name : images.keySet()) {

            if (name.toLowerCase().contains(substr)) {

                matchingImagesNames.add(name);
            }
        }

        return matchingImagesNames.toArray(new String[matchingImagesNames.size()]);
    }
}
