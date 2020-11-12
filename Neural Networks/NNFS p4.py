import numpy as np

inputs = [[1.0, 2.0, 3.0, 2.5],
          [2.0, 5.0, -1.0, 2.0],
          [-1.5, 2.7, 3.3, -0.8]]

weights = [[0.2, 0.8, -0.5, 1.0],
           [0.5, -0.91, 0.26, -0.5],
           [-0.26, -0.27, 0.17, 0.87]]

biases = [2.0, 3.0, 0.5]
# T - transpose, make rows become columns. use to match shapes when calculating dot product
# [0.2, 0.8, -0.5, 1.0] becomes
# [ 0.2]
# [ 0.8]
# [-0.5]
# [ 1.0]
# dot product would do (1*0.2 + 2*0.8 + 3*-0.5 + 2.5*1) + 2 for the first row and column

# these problems come from trying to get the dot products of two matrices
# because of the nature of the calculation required.
# in p3 i calculated the dot product of a matrix and vector which is easier
# (3,4) and (3,4) vs (3,4) and (4,)

# print(weights)
print(np.array(weights).T)
print("\n\n")
output = np.dot(inputs, np.array(weights).T) + biases
print(output)
