import numpy as np
import matplotlib.pyplot as plt
import nnfs
import createData

nnfs.init()  # helps sync code with video and prevent weird bugs


# seed(0) so i get the same "random" numbers every run
# np.random.seed(0)
# machine learning convention - naming the sample data variable as X
# X = [[1.0, 2.0, 3.0, 2.5],
#      [2.0, 5.0, -1.0, 2.0],
#      [-1.5, 2.7, 3.3, -0.8]]

# machine learning convention - y = number of dataset features

class LayerDense:
    def __init__(self, inputsAmnt, neuronsAmnt):
        # no need to transpose the weights since there are already controls over the shape ( the arguments )
        self.weights = 0.10 * np.random.randn(inputsAmnt, neuronsAmnt)
        # returns ndarray of zeros ( can very rarely create a dead network )
        # give zeros() a tuple. ( really confusing as to why )
        self.biases = np.zeros((1, neuronsAmnt))

    # forward() should accept either
    # 1. the sample data
    # 2. the previous layer's output
    def forward(self, inputs):
        self.output = np.dot(inputs, self.weights) + self.biases


class ActivationReLU:
    def forward(self, inputs):
        self.output = np.maximum(0, inputs)  # always return number equal or higher than 0


# create dataset
X, y = createData.spiral_data(200, 2)

# creating the network
# LayerDense(features, neurons)
layer1 = LayerDense(2, 5)
# layer2 = LayerDense(10, 10)

# running the network
layer1.forward(X)

activation1 = ActivationReLU()
activation1.forward(layer1.output)

print(activation1.output)
