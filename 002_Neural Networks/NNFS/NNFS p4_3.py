import numpy as np

# so i get the same "random" numbers every run
np.random.seed(0)
# machine learning convention - naming the sample data variable as X
X = [[1.0, 2.0, 3.0, 2.5],
     [2.0, 5.0, -1.0, 2.0],
     [-1.5, 2.7, 3.3, -0.8]]


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


#print(0.10 * np.random.randn(4, 3))
# creating the network
layer1 = LayerDense(4,10)
layer2 = LayerDense(10,6)
layer3 = LayerDense(6,3)

# running the network
layer1.forward(X)
layer2.forward(layer1.output)
layer3.forward(layer2.output)
print(layer3.output)