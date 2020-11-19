from NNFS import classes, createData

# Create dataset
X, y = createData.spiral_data(samples=100, classes=3)

# 2 input features and 3 neurons
dense1 = classes.LayerDense(2, 3)
dense2 = classes.LayerDense(3, 3)

activation1 = classes.ActivationReLU()
activation2 = classes.ActivationSoftmax()

loss_function = classes.LossCategoricalCrossentropy()
# Perform a forward pass of training data through this layer
dense1.forward(X)
# Perform a forward pass through activation function
activation1.forward(dense1.output)

dense2.forward(activation1.output)
activation2.forward(dense2.output)

# first few samples:
print(activation2.output[: 5])

# Perform a forward pass through loss function
# take output of second layer, return loss
loss = loss_function.calculate(activation2.output, y)
print('loss:', loss)
