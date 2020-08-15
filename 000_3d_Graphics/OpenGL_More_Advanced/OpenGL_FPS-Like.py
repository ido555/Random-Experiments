import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *
import random
import OpenGL_More_Advanced.MyCube as MyCube
from cube_dimensions_tuples import edges, quads, colors


def render_cube(cube):
    glBegin(GL_LINES)
    for edge in edges:
        for vertex in edge:
            glVertex3fv(cube.new_vertices[vertex])
    glEnd()

    glBegin(GL_QUADS)
    for quad in quads:
        x = 0
        for vertex in quad:
            x += 1
            glColor3fv(colors[x])
            glVertex3fv(cube.new_vertices[vertex])
    glEnd()


def main():
    cubes = []
    for i in range(18):
        cubes.append(MyCube.Cube(random.randrange(-20, 20), random.randrange(-20, 20), random.randrange(-20, 20)))
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

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

        for cube in cubes:
            render_cube(cube)

        # update the contents of the entire display
        pygame.display.flip()
        # wait 16 ms between each before next frame is rendered - around 60 fps
        pygame.time.wait(16)


main()
