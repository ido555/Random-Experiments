import numpy as np
import math

# example outputs
layerOutputs = [4.8, 1.21, 2.385]

# Exponentiation serves multiple purposes. To calculate probabilities, we need non-negative values
# A negative probability (confidence) doesn't make sense
# an exponential value of any number is always non-negative

'''
The exponential function is a monotonic function (https://en.wikipedia.org/wiki/Monotonic_function).
so when applied to the neural network we won’t change the predicted class and we wont get a negative value.
this adds "stability" to the result as the normalized exponentiation is more about
the difference between numbers than their magnitudes(distance from 0)
'''

# e - mathematical constant
# constants are uppercased by convention

# For each value in a vector, calculate the exponential value
# with numpy (calculated faster!!)
expValues = np.exp(layerOutputs)
print('exponentiated values:')
print(expValues)

# normalize values
normValues = expValues / np.sum(expValues)
print("normalized exponentiated values:")
print(normValues)
print('Sum of normalized values:', np.sum(normValues))

# to train in batches make numpy accept layer outputs in batches:
# get unnormalized probabilities
# expValues = np.exp(layerOutputs)

# normalize for each sample
# probabilities = expValues / np.sum(expValues, axis=1, keepdims=True)
# what axis and keepDims do:
'''
using this for example
np.array(
[[4.8, 1.21, 2.385],
[8.9, -1.81, 0.2],
[1.41, 1.051, 0.026]])
'''


# sum with axis=None - 18.172 - sums everything together
# axis=0 - sums rows - [15.11 0.451 2.611]
# axis=1 - sums columns - [8.395  7.29  2.487]
# axis=1 and keepDims=True - [[8.395]  [7.29]  [2.487]]

# without numpy
# For each value in a vector, calculate the exponential value
# expValues = []
# for output in layerOutputs:
#    expValues.append(math.e ** output)  # ** - power operator in Python

# normalize values
# normSum = sum(expValues)
# normValues = []
# for val in expValues:
#     normValues.append(val / normSum)
# print("normalized exponentiated values:")
#
# print(normValues)
# print('Sum of normalized values:', sum(normValues))


# and finally, softmax activation summed up as a class
# remember softmax activation can be a source of exploding magnitudes in numbers
class ActivationSoftmax:
    # Forward pass
    def forward(self, inputs):
        # Get unnormalized probabilities
        # using inputs - np.max to get rid of the largest number in the input data
        # to help with numbers exploding in size and also with buffer overflow
        # due to the (awesome)magic of math which i dont fully understand this wont change the output
        SMexpValues = np.exp(inputs - np.max(inputs, axis=1, keepdims=True))

        # Normalize them for each sample
        probabilities = SMexpValues / np.sum(SMexpValues, axis=1, keepdims=True)
        self.output = probabilities
