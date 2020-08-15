# Length = 2 units
# Width = 2 units
# Height = 2 units
# Volume = 8 units
from cube_dimensions_tuples import vertices


class Cube:

    # create instance and set initial location in relation to world origin
    def __init__(self, x, y, z):
        self.new_vertices = []
        self.set_location(x, y, z)

    # set location in relation to world origin
    def set_location(self, x, y, z):
        # get dimensions of a 2x2x2
        for i in range(len(vertices)):
            old_x = vertices[i][0]
            old_y = vertices[i][1]
            old_z = vertices[i][2]
            # OpenGL does not like vertices as objects...
            # self.newVertices.append(Vertex(old_vertex.x + x, old_vertex.y + y, old_vertex.z + z))
            new_vert = (old_x + x, old_y + y, old_z + z)
            self.new_vertices.append(new_vert)


class Vertex:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
