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
    private int caseClass = 0;
    
    /**
     *
     * @param imageName
     * @param caseClass
     */
    public Image(String imageName, int caseClass)
    {
        this.imageName = imageName;
        this.caseClass = caseClass;
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
    public int getCaseClass()
    {
        return caseClass;
    }

    /**
     *
     * @param caseClass
     */
    public void setCaseClass(int caseClass)
    {
        this.caseClass = caseClass;
    }
}
