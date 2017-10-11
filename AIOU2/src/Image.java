import java.util.ArrayList;

/**
 * Class that represent the image.
 * @author oi15ign, oi15sfn
 */
public class Image
{
    private String imageName;
    private ArrayList<Double> pixelArray = new ArrayList();
    private int faceType = 0;

    /**
     * Constructor for creating an Image.
     * @param imageName - the id of the image in the form of a string.
     * @param faceType - the facetype of the image provided. Set to 0 if its a training image.
     */
    public Image(String imageName, int faceType)
    {
        this.imageName = imageName;
        this.faceType = faceType;
    }

    /**
     * Fill the pixelarray.
     * @param pixelArray - the array of pixels provided as Double.
     */
    public void setImageArray(ArrayList<Double> pixelArray)
    {
        this.pixelArray = pixelArray;
    }

    /**
     * Return the name of the image.
     * @return - the name of the image in the form of a string
     */
    public String getImageName()
    {
        return imageName;
    }

    /**
     * Return the images pixelarray.
     * @return - the array of pixels provided as Double.
     */
    public ArrayList<Double> getPixelArray()
    {
        return pixelArray;
    }

    /**
     * Return the facetype of the image.
     * @return - the facetype of the image in the form of an int.
     */
    public int getFaceType()
    {
        return faceType;
    }

    /**
     * Printout method for testing the Image and the ImageReader.
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
