import pygame
from pygame.locals import *
# OpenGL rendering libs
from OpenGL.GL import *
from OpenGL.GLU import *
#  vector and matrix manipulation lib thats faster than NumPy
import pyg
import random
import OpenGL_More_Advanced.MyCube as MyCube
from cube_dimensions_tuples import edges, quads, colors

display = (800.0, 600.0)
aspect_ratio = display[0]/display[1]
fov = 45
far_clip_plane = 50.0
close_clip_plane = 0.1

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

def mouse_look():
    # view looking at straight at horizon
    up_down_angle, left_right_angle = 0.0
    speed = 3.0
    mouse_speed = 0.0005

    # center mouse
    pygame.mouse.set_pos(display[0]/2 , display[1]/2 )

    mouse_x = pygame.mouse.get_pos()[0]
    mouse_y = pygame.mouse.get_pos()[1]
    # pygame.mouse.set_visible(False)



def main():
    cubes = []
    # generate cubes
    for i in range(18):
        rand_x = random.randrange(-20, 20)
        rand_y = random.randrange(-20, 20)
        rand_z = random.randrange(-20, 20)
        cubes.append(MyCube.Cube(rand_x, rand_y, rand_z))

    pygame.init()
    pygame.display.set_mode(display, DOUBLEBUF | OPENGL)
    gluPerspective(fov, aspect_ratio, close_clip_plane, far_clip_plane)

    # move backwards 20 units
    glTranslatef(0.0, 0.0, -20)

    # let the GPU check if the camera is behind, or in front of a triangle(s) and check if the
    # camera will notice if some triangles are not rendered ( and skip them if so ) ( big optimization!)
    # ( must invert vertices if using 3d modeler for this to work )
    glEnable(GL_CULL_FACE)
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        pressed = pygame.key.get_pressed()
        # movement speed is bound to fps right now....
        if pressed[pygame.K_ESCAPE]:
            pygame.quit()
            quit()
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
