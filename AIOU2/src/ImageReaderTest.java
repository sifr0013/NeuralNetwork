import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Simon on 2017-10-04.
 */
public class ImageReaderTest
{


    public static void main(String[] args)
    {
        File testFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/test-B.txt");
        File facitFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/facit-B.txt");
        File trainingFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/training-A.txt");

        try
        {
            ImageReader iR = new ImageReader(trainingFile, facitFile, testFile);
            ArrayList<Image> trainingArray = iR.getTrainingPictures();
            ArrayList<Image> facitArray = iR.getFacitPictures();
            ArrayList<Image> testArray = iR.getTestPictures();

            Image img;

            for (int j = 0; j < 200; j++)
            {
                img = trainingArray.get(j);
                img.printImage();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


    }
}
