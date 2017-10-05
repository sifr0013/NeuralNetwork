/**
 * Created by Simon on 2017-10-04.
 */
public class NeuralNetwork
{
    private Neuron Happy;
    private Neuron Sad;
    private Neuron Mischievous;
    private Neuron Mad;

    ImageReader iR;

    public NeuralNetwork(ImageReader imageReader, double learningRate, int arraySize)
    {
        iR = imageReader;
        Happy = new Neuron(1,learningRate, arraySize);
        Sad = new Neuron(2,learningRate, arraySize);
        Mischievous = new Neuron(3,learningRate, arraySize);
        Mad = new Neuron(4,learningRate, arraySize);

    }
}
