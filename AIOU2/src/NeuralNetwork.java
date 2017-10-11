import java.io.*;
import java.util.*;

/**
 * Class for creating a Neural Network that will classify images between four different states.
 * @author oi15ign, oi15sfn
 *
 */
public class NeuralNetwork
{
    private OutputNeuron Happy, Sad, Mischievous, Mad;
    private static final int RANDOMSEED = 1;

    private ArrayList<Image> shuffledTrainingList, shuffledFacitList, shuffledTestList, shuffledTestFacitList, finalTestList;
    private ArrayList<OutputNeuron> oNList = new ArrayList<>();

    /**
     * Constructor for creating a NeuralNetwork
     * @param imageReader - an ImageReader to provide the array of images.
     * @param learningRate - the learning rate of the neural network.
     * @param arraySize - the size of the images.
     */
    public NeuralNetwork(ImageReader imageReader, double learningRate, int arraySize)
    {
        Happy = new OutputNeuron(1,learningRate, arraySize);
        Sad = new OutputNeuron(2,learningRate, arraySize);
        Mischievous = new OutputNeuron(3,learningRate, arraySize);
        Mad = new OutputNeuron(4,learningRate, arraySize);

        oNList.add(Happy);
        oNList.add(Sad);
        oNList.add(Mischievous);
        oNList.add(Mad);

        shuffledTestFacitList = new ArrayList<>();
        shuffledTestList = new ArrayList<>();
        shuffledFacitList = new ArrayList<>();
        shuffledTrainingList = new ArrayList<>();

        finalTestList = imageReader.getTestPictues();

    }

    /**
     * Public method for running the NeuralNetwork. Both trains and tests the network.
     * @param iR - the imagereader with the image arrays.
     */
    public void run(ImageReader iR)
    {
        //Phase 1
        double averageError;
        int counter = 0;
        do
        {
            createTrainAndTestGroups(iR);
            for (int i = 0; i < shuffledTrainingList.size(); i++)
            {
                if (shuffledFacitList.get(i).getFaceType()!=guess(shuffledTrainingList.get(i)))
                {
                    trainOutputNeurons(shuffledTrainingList.get(i),shuffledFacitList.get(i));
                }
            }

            double errorCounter = 0;

            for (int j = 0; j < shuffledTestList.size(); j++)
            {
                if (shuffledTestFacitList.get(j).getFaceType()!=guess(shuffledTestList.get(j)))
                {
                    errorCounter++;
                }
            }

            averageError = errorCounter/shuffledTestList.size();
            System.out.println("Average Error = "+averageError);

            counter++;

            if (counter == 10)
            {
                counter = 0;
            }
        } while (averageError>0.0152);


        //Phase 2
        try {
            File result = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/result.txt");
            FileOutputStream is = new FileOutputStream(result);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);

            for (int i = 0; i < finalTestList.size(); i++) {
                w.write(finalTestList.get(i).getImageName() + " " + guess(finalTestList.get(i))+'\n');
            }
            w.close();
        }
        catch (Exception e)
        {}
    }

    /**
     * Private method for training the OutputNeurons in the NeuralNetwork.
     * @param trainImg - the training image.
     * @param facitImg - the facit image.
     */
    private void trainOutputNeurons(Image trainImg, Image facitImg)
    {
        for (OutputNeuron oN : oNList)
        {
            double outputError = calculateOutputError((oN.getExpectedFaceType() == facitImg.getFaceType() ? 1 : 0),oN.getActivationLevel(trainImg));
            oN.train(trainImg, outputError);
        }
    }

    /**
     * Private method for guessing what kind of expression the image contains.
     * @param img - the image the NeuralNetwork should guess what it is.
     * @return - 1, if Happy
     *         - 2, if Sad
     *         - 3, if Mischievous
     *         - 4, if Mad
     */
    private int guess(Image img)
    {
        HashMap<Double, Integer> activationLevels = new HashMap<>();

        for (OutputNeuron oN : oNList)
        {
            activationLevels.put(oN.getActivationLevel(img),oN.getExpectedFaceType());
        }

        double maxVal = Collections.max(activationLevels.keySet());
        return activationLevels.get(maxVal);
    }

    /**
     * Private method to calculate the guessing error. Be aware that this does not calculate the networks
     * average error.
     * @param targetVal
     * @param outputVal
     * @return
     */
    private double calculateOutputError(double targetVal, double outputVal)
    {
        return targetVal - outputVal;
    }

    /**
     * Divides the provided images and facit images in two sets. 2/3 for training, and 1/3 for testing the
     * average error. Also shuffles the two sets.
     * @param iR
     */
    private void createTrainAndTestGroups(ImageReader iR)
    {
        ArrayList<Image> trainingListToShuffle = iR.getTrainingPictures();
        ArrayList<Image> facitListToShuffle = iR.getFacitPictures();

        Collections.shuffle(trainingListToShuffle, new Random(RANDOMSEED));
        Collections.shuffle(facitListToShuffle, new Random(RANDOMSEED));

        shuffledFacitList.clear();
        shuffledTestFacitList.clear();
        shuffledTrainingList.clear();
        shuffledTestList.clear();

        for (int i = 0; i < trainingListToShuffle.size(); i++)
        {
            if (i < trainingListToShuffle.size()/3)
            {
                shuffledTestList.add(trainingListToShuffle.get(i));
                shuffledTestFacitList.add(facitListToShuffle.get(i));
            }
            else
            {
                shuffledTrainingList.add(trainingListToShuffle.get(i));
                shuffledFacitList.add(facitListToShuffle.get(i));
            }
        }
    }

    /**
     * Public method for returning the shuffled training list of images. Mainly used for testing.
     * @return - the shuffled training list of images.
     */
    public ArrayList<Image> getShuffledTrainingList()
    {
        return shuffledTrainingList;
    }

    /**
     * Public method for returning the shuffled facit list of images. Mainly used for testing.
     * @return - the shuffled facit list of images.
     */
    public ArrayList<Image> getShuffledFacitList()
    {
        return shuffledFacitList;
    }
}
