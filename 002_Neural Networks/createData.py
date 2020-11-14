import numpy as np
import matplotlib.pyplot as plt


# https://cs231n.github.io/neural-networks-case-study/
# N = 100 # number of points per class
# D = 2 # dimensionality
# K = 3 # number of classes
# X = np.zeros((N*K,D)) # data matrix (each row = single example)
# y = np.zeros(N*K, dtype='uint8') # class labels
# for j in range(K):
#   ix = range(N*j,N*(j+1))
#   r = np.linspace(0.0,1,N) # radius
#   t = np.linspace(j*4,(j+1)*4,N) + np.random.randn(N)*0.2 # theta
#   X[ix] = np.c_[r*np.sin(t), r*np.cos(t)]
#   y[ix] = j
# # visualize the data:
# plt.scatter(X[:, 0], X[:, 1], c=y, s=40, cmap=plt.cm.Spectral)
# plt.show()

def spiral_data(points, classes):
    X = np.zeros((points * classes, 2))
    y = np.zeros(points * classes, dtype='uint8')
    for class_number in range(classes):
        ix = range(points * class_number, points * (class_number + 1))
        r = np.linspace(0.0, 1, points)  # radius
        t = np.linspace(class_number * 4, (class_number + 1) * 4, points) + np.random.randn(points) * 0.2
        X[ix] = np.c_[r * np.sin(t * 2.5), r * np.cos(t * 2.5)]
        y[ix] = class_number
    return X, y


# X, y = spiral_data(200, 3)

# plt.scatter(X[:, 0], X[:, 1])
# plt.show()
#
# plt.scatter(X[:, 0], X[:, 1], c=y, cmap="brg")
# plt.show()