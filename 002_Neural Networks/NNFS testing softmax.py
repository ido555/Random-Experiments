import createData
import classes

X, y = createData.spiral_data(100, 3)

activation1 = classes.ActivationReLU()
activation2 = classes.ActivationSoftmax()

# 2 inputs 3 neurons
layer1 = classes.LayerDense(2,3)
layer2 = classes.LayerDense(3,3)


layer1.forward(X)
activation1.forward(layer1.output)

# layer 2 accepts non normalized values unfit for classification purposes
# and using Softmax as the activation layer, outputs a probability distribution
layer2.forward(activation1.output)
activation2.forward(layer2.output)

# print “confidence scores” from each neuron from the last layer
# this network is entirely random at the moment
print(activation2.output[:5])

"""
the distribution of predictions is almost equal as each sample has ~33%
predictions for each class. This results from the random initialization of weights (a draw
from the normal distribution, not every random initialization will result in this)
"""