/**
 * Created by Simon on 2017-10-04.
 */
public class NeuralNetwork
{
    private OutputNeuron Happy;
    private OutputNeuron Sad;
    private OutputNeuron Mischievous;
    private OutputNeuron Mad;

    ImageReader iR;

    public NeuralNetwork(ImageReader imageReader, double learningRate, int arraySize)
    {
        iR = imageReader;
        Happy = new OutputNeuron(1,learningRate, arraySize);
        Sad = new OutputNeuron(2,learningRate, arraySize);
        Mischievous = new OutputNeuron(3,learningRate, arraySize);
        Mad = new OutputNeuron(4,learningRate, arraySize);

    }
}
