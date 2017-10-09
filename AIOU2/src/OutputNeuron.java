import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

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
    private double biasWeight = 1.0;
    private int arraySize;


    public OutputNeuron(int expectedFaceType, double learningRate, int arraySize)
    {
        this.expectedFaceType = expectedFaceType;
        this.learningRate = learningRate;
        weightList = new ArrayList<>();
        this.arraySize = arraySize;

        initializeWeightList();

    }

    private void initializeWeightList()
    {
        for (int i = 0; i < arraySize; i++)
        {
            weightList.add(i,Math.random());
        }
    }


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

    public void train(Image trainImg, double outputError)
    {

        double updatedWeight;
        for (int i = 0; i < weightList.size(); i++)
        {
            updatedWeight = (weightList.get(i) + learningRate*outputError*trainImg.getPixelArray().get(i));
            weightList.set(i,updatedWeight);

        }
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
        return (1/(1+Math.exp(-x)));
    }



}
