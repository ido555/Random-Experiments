# Length = 2 units
# Width = 2 units
# Height = 2 units
# Volume = 8 units
class Cube:

    # class variables
    vertices = ((1, -1, -1), (1, 1, -1), (-1, 1, -1), (-1, -1, -1),
                (1, -1, 1), (1, 1, 1), (-1, -1, 1), (-1, 1, 1))
    edges = ((0, 1), (0, 3), (0, 4), (2, 1),
             (2, 3), (2, 7), (6, 3), (6, 4),
             (6, 7), (5, 1), (5, 4), (5, 7))
    quads = ((0, 1, 2, 3), (3, 2, 7, 6), (6, 7, 5, 4),
             (4, 5, 1, 0), (1, 5, 7, 2), (4, 0, 3, 6))

    # create instance and set initial location in relation to world origin
    def __init__(self, x, y, z):
        self.newVertices = []
        self.set_location(x, y, z)

    # set location in relation to world origin
    def set_location(self, x, y, z):
        # get dimensions of a 2x2x2
        for vertex in self.vertices:
            old_x = Cube.vertices[vertex][0]
            old_y = Cube.vertices[vertex][1]
            old_z = Cube.vertices[vertex][2]
            old_vertex = Vertex(old_x, old_y, old_z)
            # move the whole cube without distorting its shape
            self.newVertices.append(Vertex(old_vertex.x + x, old_vertex.y + y, old_vertex.z + z))


class Vertex:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
