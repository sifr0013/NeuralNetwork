# NeuralNetwork

A project under the course [Artificial Intelligence - The Basics](https://www.umu.se/utbildning/kurser/artificiell-intelligens---grunderna/) at [Umeå University](http://www.umu.se/).

Simon Fredriksson [(sifr0013)](sifr0013@student.umu.se "Email")
Isak Gustafsson [(isgu0011)](isgu0011@student.umu.se "Email")

## Goal
The aim for the project is to implement the simplest form of a Neural Network - a perceptron.

The perceptron should be able to train into classifying facial expressions. And then be able to correctly classify a set of new facial expressions.

There are four different facial expressions.

The pictures that the perceptron should classify are provided as a 
.txt-file. Here is a link to an example of a collection of training[images](https://www8.cs.umu.se/kurser/5DV121/HT17/assignment2/training.txt "Collection of training images").

The numbers represent how dark a pixel is, where **0** is white and **31** is black.
 


## To do

- [x] Implement a class for holding an image.
- [x] Implement a working imageReader. Should be able to read both training and facit images.
- [x] Implement a neuron that can guess and be trained. Should work for each different expression.
    - [x] Implement the training algorithm.
    - [x] Implement the guessing algorithm.
- [x] Implement a chain of four different neurons (*one for each expression*) that should be able to determine what kind of
facial expression an image contains.
- [x] Create the main function for the perceptron (Face.java).
- [ ] Complete commenting
    - [ ] Faces (Isak/Simon)
    - [ ] Image (Simon)
    - [ ] ImageReader (Isak)
    - [ ] OutputNeuron (Isak)
    - [ ] NeuralNetwork (Simon)
- [ ] Clean up code (Remove comments and printouts)
- [ ] Ask tutor about optimisation (Can we achieve a higher accuracy?)
- [ ] Check off requirements provided by the teacher


## The provided Training Algorithm

1. Initialize the training set for which both input and output is known.
2. Order the samples in the traning set randomly.
3. For each sample in the traning set.
    - Execute the perceptron learning algorithm once with a small alpha (This way the weights of the network is tuned
    slightly towards the correct output).
4. Test if the network has reached satisfying performance.
    - Good performance = low average error
    - Performance test is made on **another set of data**, tests the generalization ability of the network.
5. If performance is not good enough, repeat from 2.
6. Training done.

### Personal thoughts on how to proceed (*in Swedish*)

- Bias vikten används för att man teoretiskt inte ska kunna få en matris fylld med ettor. Alltså att vikterna alla blir 1.
- Den neuron som ger ut en gissning som är närmast 1, är den gissning som vårt nätverk kommer att göra.
Alltså behöver vi göra så att vårt nätverk bestämmer över träningen och inte noderna själva.
- Aktivationnivån måste vara åtkomlig i nätverket.
- Om totala antalet rätt gissnigar som vårt nätverk gör är 25%, betyder det att det bara är slump, eftersom det är 1/4 chans att programmet
gissar rätt. Är vi runt 50% är det något som är knas också. Över 65% rätt svar är vad som krävs av vårt nätverk för att vi ska kunna få godkänt.
Alltså kan vi köra träningen tills vi når typ 70%, och sedan går vi direkt till testet. (Undviker vi overfitting då? Förmodligen).
- Error = 1 eller 0 - "aktiverings-nivån(utslaget noden ger)"
