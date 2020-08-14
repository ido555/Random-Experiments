import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *
from random import *
from cube_dimensions_tuples import *


def cube():
    glBegin(GL_QUADS)
    for quad in quads:
        x = 0
        for vertex in quad:
            x += 1
            glColor3f(0.4, 0.8, 0.4)
            glVertex3fv(vertices[vertex])
    glEnd()

    glBegin(GL_LINES)
    for edge in edges:
        for vertex in edge:
            glVertex3fv(vertices[vertex])
    glEnd()


def main():
    pygame.init()
    display = (800, 600)
    pygame.display.set_mode(display, DOUBLEBUF | OPENGL)
    gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)
    glTranslatef(0.0, 0.0, -12)
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        pressed = pygame.key.get_pressed()
        # movement speed is bound to fps right now....
        if pressed[pygame.K_w]:
            glTranslatef(0.0, 0.0, 0.2)
        if pressed[pygame.K_s]:
            glTranslatef(0.0, 0.0, -0.2)
        if pressed[pygame.K_a]:
            glTranslatef(0.2, 0.0, 0)
        if pressed[pygame.K_d]:
            glTranslatef(-0.2, 0.0, 0)
        if pressed[pygame.K_e]:
            glRotatef(1, 0, 0.2, 0)
        if pressed[pygame.K_q]:
            glRotatef(1, 0, -0.2, 0)

        # rotate view ( not the cube )
        # gl.glRotatef(1, 3, 1, 1)

        # clear color and depth masks (otherwise the cube would smear)
        # TODO find out what depth_buffer is
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

        # render the cube again
        cube()
        glTranslatef(-0.2, 0.0, 0)
        glRotatef(1, 0, -0.2, 0)
        # update the contents of the entire display
        pygame.display.flip()

        # wait 16 ms between each before next frame is rendered - around 60 fps
        pygame.time.wait(16)


main()
