from itertools import permutations

permu = [''.join(p) for p in permutations('stack')]
permu = set(permu)

with open("permus.txt", "w") as output:
    output.write(str(values))
