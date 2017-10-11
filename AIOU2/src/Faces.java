import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main class for implementing the neural network of the perceptron.
 * @author oi15ign, oi15sfn
 */
public class Faces 
{
	public static void main(String[] args)
	{
		File trainingFile = new File(args[0]);
        File facitFile = new File(args[1]);
        File testFile = new File(args[2]);

		ImageReader iR;

		try {
			iR = new ImageReader(trainingFile, facitFile, testFile);
			NeuralNetwork nn = new NeuralNetwork(iR,0.015,400);
			nn.run(iR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
