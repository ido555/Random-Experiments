import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *
import random
import OpenGL_More_Advanced.MyCube as MyCube


def main():

    def render_cube(cube):
        glBegin(GL_LINES)
        for edge in cube.edges:
            for vertex in edge:
                glVertex3fv(cube.newVertices[vertex])
        glEnd()

        glBegin(GL_QUADS)
        for quad in cube.quads:
            for vertex in quad:
                glVertex3fv(cube.newVertices[vertex])
        glEnd()



main()
