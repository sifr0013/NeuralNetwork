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

    /**
     *
     * @return a value between 0 and 1
     */
    public double guess(Image img)
    {
        double sum = 0;
        for (int i = 0; i < weightList.size(); i++)
        {
            sum += weightList.get(i)*img.getPixelArray().get(i);
        }
        sum += biasWeight;
        return activationFunction(sum);

    }

    public void train(Image trainImg, Image facitImg)
    {
        if (expectedFaceType==facitImg.getFaceType())
        {
            if (guess(trainImg)==1)
            {

            }
        }

    }

    public void test()
    {

    }



    /**
     * Private activation function. Sigmoid.
     * @param x
     * @return
     */
    private double activationFunction(double x)
    {
        return (1/(1+exp(-x)));
    }



}
