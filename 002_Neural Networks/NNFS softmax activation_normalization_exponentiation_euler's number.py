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


