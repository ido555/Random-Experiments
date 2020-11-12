# creating a "layer" of "neurons"

inputs = [1.0, 2.0, 3.0, 2.5]

weights = [[0.2, 0.8, -0.5, 1.0],
           [0.5, -0.91, 0.26, -0.5],
           [-0.26, -0.27, 0.17, 0.87]]

biases = [2.0, 3.0, 0.5]

# output = [inputs[0] * weights1[0] + inputs[1] * weights1[1] + inputs[2] * weights1[2] + inputs[3] * weights1[3] +
# bias1, inputs[0] * weights2[0] + inputs[1] * weights2[1] + inputs[2] * weights2[2] + inputs[3] * weights2[3] +
# bias2, inputs[0] * weights3[0] + inputs[1] * weights3[1] + inputs[2] * weights3[2] + inputs[3] * weights3[3] +
# bias3] print(output)

# calculating and displaying the layer's output

''' python zip() example
a = ["a1", "b1", "c1"]
b = ["a2", "b2", "c2", "d2"]

#zip() returns a tuple. use tuple() to display the data.
print(tuple(zip(a, b))) 
prints: (('a1', 'a2'), ('b1', 'b2'), ('c1', 'c2'))

'''

layerOutputs = []
for neuronWeights, neuronBias in zip(weights, biases):
    # print("\n\n" + str(neuronWeights) + "\n" + str(neuronBias))
    neuronOutput = 0
    for neuronInput, weight in zip(inputs, neuronWeights):
        neuronOutput += neuronInput * weight
    neuronOutput += neuronBias
    layerOutputs.append(neuronOutput)

print(layerOutputs)
