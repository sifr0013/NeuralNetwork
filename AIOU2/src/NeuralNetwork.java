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
        Happy = new Neuron(imageReader,1,learningRate, arraySize);
        Sad = new Neuron(imageReader,2,learningRate, arraySize);
        Mischievous = new Neuron(imageReader,3,learningRate, arraySize);
        Mad = new Neuron(imageReader,4,learningRate, arraySize);

    }
}
