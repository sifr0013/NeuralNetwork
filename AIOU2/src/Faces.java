import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main class for implementing the neural network of the perceptron.
 * @author oi15ign, oi15sfn
 *
 */
public class Faces 
{
	public static void main(String[] args)
	{
		File testFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/test-B.txt");
		File facitFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/facit-A.txt");
		File trainingFile = new File("/Users/Simon/Documents/GitHub/NeuralNetwork/AIOU2/FaceTestFiles/training-A.txt");


		ImageReader iR = null;

		try {
			iR = new ImageReader(trainingFile, facitFile, testFile);
			NeuralNetwork nn = new NeuralNetwork(iR,0.10,400);
			nn.run(iR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

}
