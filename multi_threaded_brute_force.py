from itertools import permutations as pe
import multiprocessing

# TODO make this work multi-threaded
def main():
    threadPool = multiprocessing.Pool()

    # decipher "syollrdecean" by brute force

    permutations = [''.join(p) for p in pe('abcd')]

    # python uses latin-1 encoding in this case for optimization = 1 byte per char
    # "syollrdecean" should take up 479 Megabytes in ram

    # O(n!) - factorial time complexity

    with open("permus.txt", "w") as output:
        # up to 8 threads
        permutations = threadPool.map(calcPermus(permutations), range(8))
        for permutation in permutations():
            output.write(permutation)


def calcPermus(permutationsList):
    filteredPermutations = []
    for permu in permutationsList:
        firstThree = permu[:2]
        theRest = permu[2:]
        permu = firstThree + "\t" + theRest
        filteredPermutations.append(permu + "\n")
    return filteredPermutations


if __name__ == '__main__':
    main()
