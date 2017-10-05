import java.util.ArrayList;

/**
 * Class that represent the image.
 * @author oi15ign, oi15sfn
 *
 */
public class Image
{
    private String imageName;
    private ArrayList<Integer> pixelArray = new ArrayList();
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
    public void setImageArray(ArrayList<Integer> pixelArray)
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
    public ArrayList<Integer> getImageArray()
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

    /**
     *
     */
    public void printImage()
    {
        int counter = 0;
        System.out.println(imageName+" "+faceType);

        if (faceType==0)
        {
            for (int i = 0; i < 400; i++)
            {


                System.out.print(""+pixelArray.get(i)+" ");
                if (counter == 19)
                {
                    System.out.println();
                    counter = -1;
                }
                counter++;
            }
        }

        System.out.println();
        System.out.println();
    }
}
