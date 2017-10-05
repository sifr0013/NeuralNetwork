import java.util.ArrayList;

import static java.lang.Math.exp;

/**
 * Class for creating a neuron.
 * @author oi15ign, oi15sfn
 *
 */
public class Neuron
{
    private int expectedFaceType;
    private ArrayList<Double> weightList;
    private double learningRate;
    private double error;
    private int trainingIteration = 0;
    private double biasWeight = 1.0;


    public Neuron(int expectedFaceType, double learningRate, int arraySize)
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
     * @return 0, if the Neuron does not recognize the face.
     * @return 1, if the Neuron does recognize the face.
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
