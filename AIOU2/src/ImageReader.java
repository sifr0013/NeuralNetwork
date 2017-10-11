import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for loading an image.
 * @author oi15ign, oi15sfn
 */
public class ImageReader
{
    private ArrayList<Image> trainingPictures = new ArrayList<>();
    private ArrayList<Image> facitPictures = new ArrayList<>();
    private ArrayList<Image> testPictures = new ArrayList<>();

    /**
     * Public ImageReader - Used to load the training-, facit- and testfile.
     *
     * @param trainingFile - The file that is used for the trainingpart of the program.
     * @param facitFile - The file that contains the correct answers, used to compare to the programs guesses.
     * @param testFile - The testfile that is used to test our program after the training has completed.
     * @throws FileNotFoundException - Throws an exception if a file is not found.
     */
    public ImageReader(File trainingFile, File facitFile, File testFile) throws FileNotFoundException
    {
        loader(trainingFile, trainingPictures);
        loader(facitFile, facitPictures);
        loader(testFile, testPictures);
    }

    /**
     * Private method loader - Used to read the input file and storing its´ content into an ArrayList.
     *
     * @param file - The file we want to read.
     * @param arrayList - The specified arrayList that we want to fill with the files' elements.
     * @throws FileNotFoundException - Throws an exception if a file is not found.
     */
    private void loader(File file, ArrayList<Image> arrayList) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(file);
        String commentString;
        ArrayList<Double> imageArray;
        String imageName;
        int faceType;

        while (scanner.hasNextLine())
        {
            //Setting the faceType to 0 as the faceType and type of File is unknown.
            faceType = 0;

            commentString = scanner.nextLine();

            if (!commentString.contains("#") && commentString.contains("Image"))
            {
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
                        imageArray.add(scanner.nextDouble());
                    }
                }

                Image img = new Image(imageName, faceType);
                img.setImageArray(imageArray);

                arrayList.add(img);
            }
        }
    }

    /**
     * Public function getFacitPictures - Used to get the facitPictures.
     * @return - facitPictures
     */
    public ArrayList<Image> getFacitPictures()
    {
        return facitPictures;
    }

    /**
     * Public function getTestPictures - Used to get the testPictures.
     *
     * @return - testPictures
     */
    public ArrayList<Image> getTestPictues()
    {
        return testPictures;
    }

    /**
     * Public function getTrainingPictures - Used to get the TrainingPictures.
     *
     * @return - trainingPictures
     */
    public ArrayList<Image> getTrainingPictures()
    {
        return trainingPictures;
    }
}
