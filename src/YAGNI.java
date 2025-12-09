
// YAGNI principle stands for = You Ain't Gonna Need It

interface ImageResizer {
    void resize(Image image);
}

interface LocalStorage {
    void save(Image image);
}

class Image {
}

class ImageUploader{
    private final ImageResizer resizer;
    private final LocalStorage storage;

    public ImageUploader(ImageResizer resizer, LocalStorage storage) {
        this.resizer = resizer;
        this.storage = storage;
    }
    public void uploadImage(Image image) {
        resizer.resize(image);
        storage.save(image);
    }
}



public class YAGNI {
    
}
