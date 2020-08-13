import pygame

# OpenGL.GL, the core GL library and extensions to it

import OpenGL.GL

# GLU is the OpenGL Utility Library.
# This is a set of functions to create texture mipmaps from a base image,
# map coordinates between screen and object space,
# and draw quadric surfaces and NURBs (Non-uniform rational B-spline) (not gonna pretend i know what that means...)
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
    # and handle this code as line-drawing code
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
    # | - OR bitwise operator -- used to separate constants
    # double buffering provides two complete color buffers for use in drawing. One buffer is displayed
    # while the other buffer is being drawn into. When the drawing is complete, the two buffers are swapped
    # so that the one that was being viewed is now used for drawing
    pygame.display.set_mode(display, p.DOUBLEBUF | p.OPENGL)

    # set perspective  with  glu.gluPerspective(fovDegrees, aspectRatio, near, far)
    # fovDegrees - field of view in degrees
    # aspectRatio - ratio between planes (1.333)
    # near -  distance from the viewer to the near clipping plane - see attached images
    # far -  distance from the viewer to the far clipping plane - see attached images
    glu.gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)

    # move the view 5 units back on the z axis
    # otherwise the view would be in the middle of the cube
    gl.glTranslatef(0.0, 0.0, -5)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        pressed = pygame.key.get_pressed()
        # movement speed is bound to fps right now....
        if pressed[pygame.K_w]:
            gl.glTranslatef(0.0, 0.0, -0.2)
        if pressed[pygame.K_s]:
            gl.glTranslatef(0.0, 0.0, 0.2)
        if pressed[pygame.K_a]:
            gl.glTranslatef(0.2, 0.0, 0)
        if pressed[pygame.K_d]:
             gl.glTranslatef(-0.2, 0.0, 0)


        # rotate view ( not the cube )
        gl.glRotatef(1, 3, 1, 1)
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT)

        # render the cube again
        Cube()
        # update the contents of the entire display
        pygame.display.flip()

        # wait 16 ms between each frame is rendered - around 60 fps
        pygame.time.wait(16)


main()
