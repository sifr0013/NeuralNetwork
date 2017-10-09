import java.util.ArrayList;

import static java.lang.Math.exp;

/**
 * Class for creating a neuron.
 * @author oi15ign, oi15sfn
 *
 */
public class OutputNeuron
{
    private int expectedFaceType;
    private ArrayList<Double> weightList;
    private double learningRate;
    private double error;
    private double activationLevel;
    private int trainingIteration = 0;
    private double biasWeight = 1.0;


    public OutputNeuron(int expectedFaceType, double learningRate, int arraySize)
    {
        this.expectedFaceType = expectedFaceType;
        this.learningRate = learningRate;
        weightList = new ArrayList<>(arraySize);

        initializeWeightList();

    }

    private void initializeWeightList()
    {
        for (int i = 0; i < weightList.size(); i++)
        {
            weightList.add(i,Math.random());
        }
    }


    public void updateActivationLevel(Image img)
    {
        double sum = 0;
        for (int i = 0; i < weightList.size(); i++)
        {
            sum += weightList.get(i)*img.getPixelArray().get(i);
        }
        sum += biasWeight;
        activationFunction(sum);
    }

    public void train(Image trainImg, Image facitImg)
    {


    }

    public void test()
    {

    }

    public double getActivationLevel()
    {
        return activationLevel;
    }

    public int getExpectedFaceType()
    {
        return expectedFaceType;
    }

    /**
     * Private activation function. Sigmoid.
     * @param x
     */
    private double activationFunction(double x)
    {
        activationLevel = (1/(1+exp(-x)));
    }



}
