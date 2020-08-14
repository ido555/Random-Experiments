# Length = 2 units
# Width = 2 units
# Height = 2 units
# Volume = 8 units
class Cube:
    # static variables
    vertices = ((1, -1, -1), (1, 1, -1), (-1, 1, -1), (-1, -1, -1),
                (1, -1, 1), (1, 1, 1), (-1, -1, 1), (-1, 1, 1))
    edges = ((0, 1), (0, 3), (0, 4), (2, 1),
             (2, 3), (2, 7), (6, 3), (6, 4),
             (6, 7), (5, 1), (5, 4), (5, 7))
    quads = ((0, 1, 2, 3), (3, 2, 7, 6), (6, 7, 5, 4),
             (4, 5, 1, 0), (1, 5, 7, 2), (4, 0, 3, 6))

    def __init__(self):
        self.newVertices = []

    def set_location(self, x, y, z):
        for vertex in self.vertices:
            old_x = Cube.vertices[vertex][0]
            old_y = Cube.vertices[vertex][1]
            old_z = Cube.vertices[vertex][2]
            oldVertex = Vertex(old_x, old_y, old_z)

            self.newVertices.append(Vertex(oldVertex.x + x, oldVertex.y + y, oldVertex.z + z))


class Vertex:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
