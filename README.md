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

- [ ] Implement a class for holding an image.
- [ ] Implement a working imageReader. Should be able to read both training and facit images.
- [ ] Implement a neuron that can guess and be trained. Should work for each different expression.
- [ ] Implement a chain of four different neurons (*one for each expression*) that should be able to determine what kind of
facial expression an image contains.
- [ ] Create the main function for the perceptron.


## Ideas

