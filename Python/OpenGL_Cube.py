import pygame

# OpenGL.GL, the core GL library and extensions to it

import OpenGL.GL

# GLU is the OpenGL Utility Library.
# This is a set of functions to create texture mipmaps from a base image,
# map coordinates between screen and object space,
# and draw quadric surfaces and NURBs (Non-uniform rational B-spline) (not gonna pretend i know what this means...)
# (Non-uniform rational basis spline is a mathematical model commonly
# used in computer graphics for generating and representing curves and surfaces)

import OpenGL.GLU

# (x,y,z) coordinates of each vertex
# edges will be drawn between 2 vertices
# OpenGL uses a right-handed coordinate system system
# so +x = right
# +y = up
# +z = forward (depth) (walking forwards increases z axis from the perspective of the person walking)

# tuples tuple
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
# tuples tuple
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


def Cube():
    gl = OpenGL.GL
    # glBegin - announce that this code will determine the limits or boundaries of some 1d/2d/3d object
    # Begin GL geometry-definition mode, disable automatic error checking
    # ( define new shape )
    gl.glBegin(gl.GL_LINES)

    # for each pair of vertices
    for edge in edges:
        # for each vertex in pair
        for vertex in edge:
            print("calling glVertex3fv")
            # TODO need to understand glVertex3fv much better
            gl.glVertex3fv(vertices[vertex])

    # Finish GL geometry-definition mode, re-enable automatic error checking
    gl.glEnd()


def main():
    p = pygame
    glu = OpenGL.GLU
    gl = OpenGL.GL

    # initialize all imported pygame modules
    p.init()
    display = (800, 600)
    # TODO why use bitwise OR here? why does regular addition works as well?
    # p.FULLSCREEN
    pygame.display.set_mode(display, p.DOUBLEBUF | p.OPENGL)

    glu.gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)
    gl.glTranslatef(0.0, 0.0, -5)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

        gl.glRotatef(1, 3, 1, 1)
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT)
        Cube()
        pygame.display.flip()
        pygame.time.wait(10)


main()
