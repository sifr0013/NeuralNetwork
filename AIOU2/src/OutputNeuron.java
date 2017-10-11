import java.util.ArrayList;

/**
 * Class for creating an outputNeuron
 * @author oi15ign, oi15sfn
 */
public class OutputNeuron
{
    private int expectedFaceType;
    private ArrayList<Double> weightList;
    private double learningRate;
    private double biasWeight = 1.0;
    private int arraySize;

    /**
     * Public Constructor for the class OutputNeuron.
     *
     * @param expectedFaceType - The facetype wich the program guesses.
     * @param learningRate - Used to control how fast the program should learn.
     * @param arraySize - Used to control the size of an array
     */
    public OutputNeuron(int expectedFaceType, double learningRate, int arraySize)
    {
        this.expectedFaceType = expectedFaceType;
        this.learningRate = learningRate;
        weightList = new ArrayList<>();
        this.arraySize = arraySize;

        initializeWeightList();

    }

    /**
     * private method to initialize the weightlist
     */
    private void initializeWeightList()
    {
        for (int i = 0; i < arraySize; i++)
        {
            weightList.add(i,Math.random());
        }
    }

    /**
     * public method to get the activationlevel from an Image
     *
     * @param img - The image that we want to know the activationlevel from.
     * @return - The activationlevel
     */
    public double getActivationLevel(Image img)
    {
        double sum = 0;
        for (int i = 0; i < weightList.size(); i++)
        {
            sum += weightList.get(i)*img.getPixelArray().get(i);
        }
        sum += biasWeight;
        return activationFunction(sum);
    }

    /**
     * Public method to train the program by changing weights.
     *
     * @param trainImg - The image we should "train"
     * @param outputError - The error
     */
    public void train(Image trainImg, double outputError)
    {

        double updatedWeight;
        for (int i = 0; i < weightList.size(); i++)
        {
            updatedWeight = (weightList.get(i) + learningRate*outputError*trainImg.getPixelArray().get(i));
            weightList.set(i,updatedWeight);
        }
        biasWeight = biasWeight + learningRate*outputError;
    }

    /**
     * public method to get the expectedFacevalue
     *
     * @return - expected facetype
     */
    public int getExpectedFaceType()
    {
        return expectedFaceType;
    }

    /**
     * private method to calculate the activationlevel by using the sigmoid algorithm
     *
     * @param x - the pixelweightsum we want to calculate the activationlevel for.
     * @return - The activation level
     */
    private double activationFunction(double x)
    {
        return (1/(1+Math.exp(-x)));
    }
}
