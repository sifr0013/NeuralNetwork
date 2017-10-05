import java.util.ArrayList;

import static java.lang.Math.exp;

/**
 * Class for creating a neuron.
 * @author oi15ign, oi15sfn
 *
 */
public class Neuron
{
    private Image img;
    private int expectedFaceType;
    private ArrayList<Double> weightList;
    private double learningRate;
    private double error;
    private int trainingIteration = 0;
    private double biasWeight = 1.0;


    public Neuron(Image image, int expectedFaceType, double learningRate, int arraySize)
    {
        img = image;
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
    public int guess()
    {
        for (int i = 0; i < weightList.size(); i++)
        {

        }

    }

    public void train()
    {

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
