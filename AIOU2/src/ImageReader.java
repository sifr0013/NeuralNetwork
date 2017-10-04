import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for loading an image.
 * @author oi15ign, oi15sfn
 *
 */
public class ImageReader
{
    private ArrayList<Image> trainingPictures = new ArrayList<>();
    private ArrayList<Image> facitPictures = new ArrayList<>();
    private ArrayList<Image> testPictues = new ArrayList<>();

    /**
     *
     * @param trainingFile
     * @param facitFile
     * @param testFile
     * @throws FileNotFoundException
     */
    public ImageReader(File trainingFile, File facitFile, File testFile) throws FileNotFoundException
    {
        loader(trainingFile, trainingPictures);
        loader(facitFile, facitPictures);
        loader(testFile, testPictues);
    }

    /**
     *
     * @param file
     * @param arrayList
     * @throws FileNotFoundException
     */
    private void loader(File file, ArrayList<Image> arrayList) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(file);
        String commentString;
        ArrayList<Integer> imageArray;
        String imageName;
        int faceType;

        while (scanner.hasNextLine())
        {
            //Setting the faceType to 0 as the faceType and type of File is unknown.
            faceType = 0;

            commentString = scanner.nextLine();

            System.out.println(commentString);
            if (!commentString.contains("#") && commentString.contains("Image"))
            {
                System.out.println("Går in i loop");
                imageName = commentString;
                imageArray = new ArrayList<>();

                //If the file doesn't have a double after the Image##-line, it means that
                //the file is a facit file. This means that the imageName-string currently
                //contains both the imagename and the facetype, this means we have to divide it.
                if (!scanner.hasNextDouble())
                {
                    String parts[] = imageName.split(" ");
                    imageName = parts[0];
                    faceType = Integer.parseInt(parts[1]);
                }
                else
                {
                    for (int i = 0; i < 400; i++)
                    {
                        imageArray.add(scanner.nextInt());
                    }
                }


                Image img = new Image(imageName, faceType);
                img.setImageArray(imageArray);

                arrayList.add(img);
                
            }
        }
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
