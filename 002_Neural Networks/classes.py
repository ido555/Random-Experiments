import numpy as np


class ActivationReLU:
    def forward(self, inputs):
        self.output = np.maximum(0, inputs)  # always return number equal or higher than 0 and equal to input


class ActivationSoftmax:
    # Forward pass
    def forward(self, inputs):
        # Get unnormalized probabilities
        # using inputs - np.max to get rid of the largest number in the input data
        # to help with numbers exploding in size and with buffer overflow
        # due to the (awesome)magic of math which i dont fully understand right now, this wont change the output
        expValues = np.exp(inputs - np.max(inputs, axis=1, keepdims=True))

        # Normalize them for each sample
        probabilities = expValues / np.sum(expValues, axis=1, keepdims=True)
        self.output = probabilities


# so i get the same "random" numbers every run
np.random.seed(0)


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


# Common loss class TODO tons of research to better understand this
class Loss:
    # Calculates the data and regularization losses
    # given model output and ground truth values
    def calculate(self, output, y):
        # Calculate sample losses
        sample_losses = self.forward(output, y)
        # Calculate mean loss
        data_loss = np.mean(sample_losses)
        # Return loss
        return data_loss


# Cross-entropy loss TODO tons of research to better understand this
class LossCategoricalCrossentropy(Loss):
    # Forward pass
    def forward(self, y_pred, y_true):
        # Number of samples in a batch
        samples = len(y_pred)
        # Clip data to prevent division by 0
        # Clip both sides to not drag mean towards any value
        y_pred_clipped = np.clip(y_pred, 1e-7, 1 - 1e-7)
        # Probabilities for target values -
        # only if categorical labels
        if len(y_true.shape) == 1:
            correct_confidences = y_pred_clipped[
                range(samples),
                y_true
            ]
        # Mask values - only for one-hot encoded labels
        elif len(y_true.shape) == 2:
            correct_confidences = np.sum(
                y_pred_clipped * y_true,
                axis=1
            )
        # Losses
        negative_log_likelihoods = - np.log(correct_confidences)
        return negative_log_likelihoods
