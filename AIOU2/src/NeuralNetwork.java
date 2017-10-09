import java.util.*;

/**
 * Created by Simon on 2017-10-04.
 */
public class NeuralNetwork
{
    private OutputNeuron Happy, Sad, Mischievous, Mad;
    private static final int RANDOMSEED = 1;
    private int trainSetSize, testSetSize;

    private ArrayList<Image> shuffledTrainingList, shuffledFacitList, shuffledTestList, shuffledTestFacitList;
    private ArrayList<OutputNeuron> oNList = new ArrayList<>();

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

        createTrainAndTestGroups(imageReader);

    }

    public void run()
    {
        for (int i = 0; i < shuffledTrainingList.size(); i++)
        {


        }



    }

    public void train()
    {

    }

    /**
     * Private method for deciding which of the nodes has the largest activation level.
     * @return the number of the node with the largest activation level.
     */
    private int guess()
    {
        OutputNeuron oN = oNList.get(0);

        for (int i = 1; i < oNList.size(); i++)
        {
            if (oN.getActivationLevel() < oNList.get(i).getActivationLevel())
            {
                oN = oNList.get(i);
            }
        }

        return oN.getExpectedFaceType();
    }

    /**
     * Private method to calculate the guessing error. Be aware that this does not calculate the networks
     * average error.
     * @param targetVal
     * @param outputVal
     * @return
     */
    private double calculateError(double targetVal, double outputVal)
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

    public ArrayList<Image> getShuffledTrainingList()
    {
        return shuffledTrainingList;
    }

    public ArrayList<Image> getShuffledFacitList()
    {
        return shuffledFacitList;
    }
}
