import numpy as np
import math

# example outputs
layer_outputs = [4.8, 1.21, 2.385]

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
expValues = []
for output in layer_outputs:
    expValues.append(math.e ** output)  # ** - power operator in Python

print('exponentiated values:')
print(expValues)

# normalize values
normSum = sum(expValues)
normValues = []
for val in expValues:
    normValues.append(val / normSum)
print("normalized exponentiated values:")
print(normValues)
print('Sum of normalized values:', sum(normValues))
