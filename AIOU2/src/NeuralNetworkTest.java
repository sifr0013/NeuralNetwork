import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;

/**
 * Created by Simon on 2017-10-07.
 */
public class NeuralNetworkTest
{

    @Test
    public void trainingAndFacitNamesShouldEqual()
    {
        File testFile = new File("E:\\Users\\Simon\\Documents\\Skolan\\AI\\NeuralNetwork\\AIOU2\\FaceTestFiles\\test-B.txt");
        File facitFile = new File("E:\\Users\\Simon\\Documents\\Skolan\\AI\\NeuralNetwork\\AIOU2\\FaceTestFiles\\facit-A.txt");
        File trainingFile = new File("E:\\Users\\Simon\\Documents\\Skolan\\AI\\NeuralNetwork\\AIOU2\\FaceTestFiles\\training-A.txt");
        try
        {
            ImageReader iR = new ImageReader(trainingFile, facitFile, testFile);
            NeuralNetwork nn = new NeuralNetwork(iR,0.02,400);

            for (int i = 0; i < nn.getShuffledFacitList().size(); i++)
            {
                assertEquals(nn.getShuffledTrainingList().get(i).getImageName(),nn.getShuffledFacitList().get(i).getImageName());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }



    }





}
