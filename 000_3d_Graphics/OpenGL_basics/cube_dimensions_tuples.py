# (x,y,z) coordinates of each vertex
# edges will be drawn between 2 vertices
# OpenGL uses a right-handed coordinate system system
# so +x = right
# +y = up
# +z = forward (depth) (walking forwards increases z axis from the perspective of the person walking)

vertices = (

    # right bottom far vertex - 0
    (1, -1, -1),
    # right top far vertex - 1
    (1, 1, -1),

    # left top far vertex - 2
    (-1, 1, -1),
    # left bottom far vertex - 3
    (-1, -1, -1),

    # right bottom close vertex - 4
    (1, -1, 1),
    # right top close vertex - 5
    (1, 1, 1),

    # left bottom close vertex - 6
    (-1, -1, 1),
    # left top close vertex - 7
    (-1, 1, 1)
)
# (originVertex, destinationVertex)
# (0,1) = starts from (1, -1, -1) ends at (1, 1, -1)
edges = (
    # right bottom far -- right top far
    (0, 1),
    # right bottom far -- left bottom far
    (0, 3),
    # right bottom far -- right bottom close
    (0, 4),

    # left top far -- right top far
    (2, 1),
    # left top far  -- left bottom far
    (2, 3),
    # left top far  -- left top close
    (2, 7),

    # left bottom close -- left bottom far
    (6, 3),
    # left bottom close -- right bottom close
    (6, 4),
    # left bottom close -- left top close
    (6, 7),

    # right top close -- right top far
    (5, 1),
    # right top close -- right bottom close
    (5, 4),
    # right top close -- left top close
    (5, 7)
)

quads = (
    (0, 1, 2, 3),
    (3, 2, 7, 6),
    (6, 7, 5, 4),
    (4, 5, 1, 0),
    (1, 5, 7, 2),
    (4, 0, 3, 6)
)

colors = (
    (0, 1, 0),
    (1, 0, 0),
    (1, 1, 1),
    (1, 1, 1),
    (0, 1, 1),
    (0, 1, 0),
    (0, 0, 1),
    (0, 1, 0),
    (0, 1, 0),
    (0, 0, 1),
    (1, 1, 1),
    (1, 1, 1),
)
