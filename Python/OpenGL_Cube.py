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
vertices = (
    # top 4 vertices
    (1, -1, -1),
    (1, 1, -1),
    (-1, 1, -1),
    (-1, -1, -1),

    # bottom 4 vertices
    (1, -1, 1),
    (1, 1, 1),
    (-1, -1, 1),
    (-1, 1, 1)
    )

edges = (
    (0,1),
    (0,3),
    (0,4),
    (2,1),
    (2,3),
    (2,7),
    (6,3),
    (6,4),
    (6,7),
    (5,1),
    (5,4),
    (5,7)
    )

# determine the limits or boundaries of

def Cube():
    glBegin(GL_LINES)
    for edge in edges:
        for vertex in edge:
            glVertex3fv(vertices[vertex])
    glEnd()