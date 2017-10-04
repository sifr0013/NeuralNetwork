import java.util.ArrayList;

/**
 * Class that represent the image.
 * @author oi15ign, oi15sfn
 *
 */
public class Image
{
    private String imageName;
    private ArrayList<Double> pixelArray = new ArrayList();
    private int faceType = 0;
    
    /**
     *
     * @param imageName
     * @param faceType
     */
    public Image(String imageName, int faceType)
    {
        this.imageName = imageName;
        this.faceType = faceType;
    }

    /**
     *
     * @param pixelArray
     */
    public void setImageArray(ArrayList<Double> pixelArray)
    {
        this.pixelArray = pixelArray;
    }

    /**
     *
     * @return
     */
    public String getImageName()
    {
        return imageName;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getImageArray()
    {
        return pixelArray;
    }

    /**
     *
     * @return
     */
    public int getFaceType()
    {
        return faceType;
    }

    /**
     *
     * @param faceType
     */
    public void setFaceType(int faceType)
    {
        this.faceType = faceType;
    }
}
