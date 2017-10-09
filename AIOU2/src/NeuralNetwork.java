import java.util.*;

/**
 * Created by Simon on 2017-10-04.
 */
public class NeuralNetwork
{
    private OutputNeuron Happy, Sad, Mischievous, Mad;
    private static final int RANDOMSEED = 1;
    private int trainSetSize, testSetSize;

    private ArrayList<Image> shuffledTrainingList, shuffledFacitList, shuffledTestList, shuffledTestFacitList, finalTestList;
    private ArrayList<OutputNeuron> oNList = new ArrayList<>();

    public NeuralNetwork(ImageReader imageReader, double learningRate, int arraySize)
    {
        Happy = new OutputNeuron(1,learningRate, arraySize);
        Sad = new OutputNeuron(2,learningRate, arraySize);
        Mischievous = new OutputNeuron(3,learningRate, arraySize);
        Mad = new OutputNeuron(4,learningRate, arraySize);

        oNList.add(Happy);
        oNList.add(Sad);
        oNList.add(Mischievous);
        oNList.add(Mad);

        shuffledTestFacitList = new ArrayList<>();
        shuffledTestList = new ArrayList<>();
        shuffledFacitList = new ArrayList<>();
        shuffledTrainingList = new ArrayList<>();

        finalTestList = imageReader.getTestPictues();

    }

    public void run(ImageReader iR)
    {
        //Phase 1
        double averageError=0;
        int counter = 0;
        do
        {
            createTrainAndTestGroups(iR);
            //System.out.println("Average Error = "+averageError);
            for (int i = 0; i < shuffledTrainingList.size(); i++)
            {
                if (shuffledFacitList.get(i).getFaceType()!=guess(shuffledTrainingList.get(i)))
                {
                    //System.out.println("Ska träna "+i);
                    trainOutputNeurons(shuffledTrainingList.get(i));
                }
            }

            double errorCounter = 0;

            //System.out.println("Storlek på kontrollgrupp"+shuffledTestList.size());
            for (int j = 0; j < shuffledTestList.size(); j++)
            {
                System.out.print("Facit: "+shuffledTestFacitList.get(j).getFaceType());
                System.out.println(" Gissning: "+guess(shuffledTestList.get(j)));
                if (shuffledTestFacitList.get(j).getFaceType()!=guess(shuffledTestList.get(j)))
                {
                    //System.out.println("Fel i jämförelse "+j);
                    errorCounter++;
                }
            }

            averageError = errorCounter/shuffledTestList.size();
            //System.out.println("Average Error = "+averageError);

            counter++;
            if (counter == 500)
            {
                System.out.println(""+averageError);
                counter = 0;
            }
        } while (averageError>0.3);


        //Phase 2
        for (int i = 0; i < finalTestList.size(); i++)
        {
            System.out.println(finalTestList.get(i).getImageName()+" "+guess(finalTestList.get(i)));
        }
    }

    private void trainOutputNeurons(Image trainImg)
    {
        for (OutputNeuron oN : oNList)
        {
            double outputError = calculateOutputError((oN.getExpectedFaceType() == trainImg.getFaceType() ? 1 : 0),oN.getActivationLevel(trainImg));
            oN.train(trainImg, outputError);
        }
    }

    /**
     * Private method for deciding which of the nodes has the largest activation level.
     * @return the number of the node with the largest activation level.
     */
    /*private int guess(Image img)
    {
        OutputNeuron oN = oNList.get(0);
        //System.out.println("Activation level of node "+0+": "+oN.getActivationLevel(img));

        for (int i = 1; i < oNList.size(); i++)
        {
            //System.out.println("Activation level of node "+i+": "+oNList.get(i).getActivationLevel(img));
            if (oN.getActivationLevel(img) < oNList.get(i).getActivationLevel(img))
            {

                oN = oNList.get(i);
            }
        }

        return oN.getExpectedFaceType();
    }*/

    private int guess(Image img)
    {
        HashMap<Double, Integer> activationLevels = new HashMap<>();

        for (OutputNeuron oN : oNList)
        {
            activationLevels.put(oN.getActivationLevel(img),oN.getExpectedFaceType());
        }

        double maxVal = Collections.max(activationLevels.keySet());
        return activationLevels.get(maxVal);
    }

    /**
     * Private method to calculate the guessing error. Be aware that this does not calculate the networks
     * average error.
     * @param targetVal
     * @param outputVal
     * @return
     */
    private double calculateOutputError(double targetVal, double outputVal)
    {
        return targetVal - outputVal;
    }

    /**
     * Divides the provided images and facit images in two sets. 2/3 for training, and 1/3 for testing the
     * average error. Also shuffles the two sets.
     * @param iR
     */
    private void createTrainAndTestGroups(ImageReader iR)
    {
        ArrayList<Image> trainingListToShuffle = iR.getTrainingPictures();
        ArrayList<Image> facitListToShuffle = iR.getFacitPictures();

        Collections.shuffle(trainingListToShuffle, new Random(RANDOMSEED));
        Collections.shuffle(facitListToShuffle, new Random(RANDOMSEED));

        shuffledFacitList.clear();
        shuffledTestFacitList.clear();
        shuffledTrainingList.clear();
        shuffledTestList.clear();

        for (int i = 0; i < trainingListToShuffle.size(); i++)
        {
            if (i < trainingListToShuffle.size()/3)
            {
                //System.out.println("Lägger till "+i+" till testbilder");
                shuffledTestList.add(trainingListToShuffle.get(i));
                shuffledTestFacitList.add(facitListToShuffle.get(i));
            }
            else
            {
                //System.out.println("Lägger till "+i+" till träningsbilder");
                shuffledTrainingList.add(trainingListToShuffle.get(i));
                shuffledFacitList.add(facitListToShuffle.get(i));
            }
        }
    }

    public ArrayList<Image> getShuffledTrainingList()
    {
        return shuffledTrainingList;
    }

    public ArrayList<Image> getShuffledFacitList()
    {
        return shuffledFacitList;
    }
}
