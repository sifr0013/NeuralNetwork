import java.util.*;

/**
 * Created by Simon on 2017-10-04.
 */
public class NeuralNetwork
{
    private OutputNeuron Happy, Sad, Mischievous, Mad;
    private static final int RANDOMSEED = 1;

    private ArrayList<Image> shuffledTrainingList, shuffledFacitList;

    public NeuralNetwork(ImageReader imageReader, double learningRate, int arraySize)
    {
        Happy = new OutputNeuron(1,learningRate, arraySize);
        Sad = new OutputNeuron(2,learningRate, arraySize);
        Mischievous = new OutputNeuron(3,learningRate, arraySize);
        Mad = new OutputNeuron(4,learningRate, arraySize);

        shuffleTrainingAndFacitLists(imageReader);

    }

    public void run()
    {


    }

    private double calculateError(double targetVal, double outputVal)
    {
        return targetVal - outputVal;
    }

    private void shuffleTrainingAndFacitLists(ImageReader iR)
    {
        shuffledTrainingList = iR.getTrainingPictures();
        Collections.shuffle(shuffledTrainingList,new Random(RANDOMSEED));

        shuffledFacitList = iR.getFacitPictures();
        Collections.shuffle(shuffledFacitList, new Random(RANDOMSEED));

    }

    public ArrayList<Image> getShuffledTrainingList() {
        return shuffledTrainingList;
    }

    public ArrayList<Image> getShuffledFacitList() {
        return shuffledFacitList;
    }
}
