import java.io.File;
import java.util.ArrayList;

/**
 * Class for loading an image.
 * @author oi15ign, oi15sfn
 *
 */
public class ImageReader
{
    private ArrayList<Image> trainingPictures;
    private ArrayList<Image> facitPictures;
    private ArrayList<Image> testPictues;

    public ImageReader(File trainingFile, File facitFile, File testFile)
    {

    }

    /**
     *
     * @return
     */
    public ArrayList<Image> getFacitPictures()
    {
        return facitPictures;
    }

    /**
     *
     * @return
     */
    public ArrayList<Image> getTestPictues()
    {
        return testPictues;
    }

    public ArrayList<Image> getTrainingPictures()
    {
        return trainingPictures;
    }
}
