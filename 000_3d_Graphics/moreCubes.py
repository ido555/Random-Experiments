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
        # clear color and depth masks (otherwise the cube would smear)
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

        # note that because im using a double buffer (DOUBLEBUF) these matrices contain an OLD and NEW value
        # for each value. - can be used to calculate collisions with "objects"
        # ( OLD = current value ) ( NEW = future value (if my code doesn't change it))

        # NOTE my understanding on these topics is not the best... couldn't find any sources to answer some of my
        # questions and i have no one to ask so ¯\_(ツ)_/¯
        # glGet - return the value or values of a selected parameter
        # GL_PROJECTION - "camera" attributes - field of view, focal length, fish eye lens, etc
        projMatrix = glGetDoublev(GL_PROJECTION_MATRIX)  # get  projection matrix

        # ModelView - "camera" position and pointing direction
        mvMatrix = glGetDoublev(GL_MODELVIEW_MATRIX)  # get model view matrix
        cameraX = mvMatrix[3][0]
        cameraY = mvMatrix[3][1]
        cameraZ = mvMatrix[3][2]
        cameraSomething = mvMatrix[3][3]
        print(cameraX , cameraY , cameraZ, cameraSomething)

        # a 3D vector is (x,y,z)
        # a homogeneous 3D vector is (x,y,z,w)
        # w = 1  = direction
        # w = 0  = position
        # examples:
        # x = NEW(direction?) OLD(direction?) NEW(position) OLD(position)
        # y = NEW OLD NEW OLD
        # z = NEW OLD NEW OLD
        # matrices used here are 4x4:
        # 0.0 0.0 0.0 0.0
        # 0.0 0.0 0.0 0.0
        # 0.0 0.0 0.0 0.0
        # 0.0 0.0 0.0 0.0

        # render the cube again
        cube()
        glTranslatef(-0.2, 0.0, 0)
        glRotatef(1, 0, -0.2, 0)

        # update the contents of the entire display
        pygame.display.flip()
        # wait 16 ms between each before next frame is rendered - around 60 fps
        pygame.time.wait(16)


main()
