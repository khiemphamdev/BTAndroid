package clc65.phamgiakhiem.vidurecyclerview;

public class LandScape {
    String imageFile;
    String imageName;

    public LandScape(String imageFile, String imageName) {
        this.imageFile = imageFile;
        this.imageName = imageName;
    }
    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}