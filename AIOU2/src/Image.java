import java.util.ArrayList;

/**
 * Class that represent the image.
 * @author oi15ign, oi15sfn
 *
 */
public class Image
{
    private String imageName;
    private ArrayList<Double> imageArray = new ArrayList();
    private int caseClass = 0;

    /**
     *
     * @param imageName
     * @param imageArray
     * @param caseClass
     */
    public Image(String imageName, ArrayList imageArray, int caseClass)
    {
        this.imageName = imageName;
        this.imageArray = imageArray;
        this.caseClass = caseClass;
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
        return imageArray;
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
