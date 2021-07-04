import * as THREE from 'three';
import {ElementRef, Injectable, NgZone, OnDestroy, OnInit} from '@angular/core';
import {OrbitControls} from 'three/examples/jsm/controls/OrbitControls';
import {GLTFLoader} from 'three/examples/jsm/loaders/GLTFLoader.js';

@Injectable({providedIn: 'root'})
export class EngineService implements OnDestroy, OnInit {
  private canvas: HTMLCanvasElement;
  private renderer: THREE.WebGLRenderer;
  private camera: THREE.PerspectiveCamera;
  private scene: THREE.Scene = new THREE.Scene();
  private loader = new GLTFLoader();
  private cube: THREE.Mesh;
  private frameId: number = null;

  public constructor(private ngZone: NgZone) {
  }

  public ngOnInit(): void {

  }

  public ngOnDestroy(): void {
    if (this.frameId != null) {
      cancelAnimationFrame(this.frameId);
    }
  }

  public test1() {
    this.loader.load("http://localhost:8080/waterbottle/glTF-Binary/WaterBottle.glb",
      (object) => {
        this.scene.add(object.scene)
      }, undefined, (err) => console.log(err));

    var loader = new THREE.FontLoader();

    loader.load( 'fonts/helvetiker_regular.typeface.json', (font) => {
      var geometry = new THREE.TextGeometry( 'Hello three.js!', {
        font: font,
        size: 80,
        height: 5,
        curveSegments: 12,
        bevelEnabled: true,
        bevelThickness: 10,
        bevelSize: 8,
        bevelOffset: 0,
        bevelSegments: 5
      } );
      var material = new THREE.MeshBasicMaterial({color : 0xffffff});
      var textMesh = new THREE.Mesh(geometry, textMat);
      this.scene.add(textMesh)
    } );
  }

  public createScene(canvas: ElementRef<HTMLCanvasElement>): void {
    // The first step is to get the reference of the canvas element from the HTML document
    this.canvas = canvas.nativeElement;
    this.renderer = new THREE.WebGLRenderer({
      canvas: this.canvas,
      alpha: true,    // transparent background
      antialias: true // smooth edges
    });
    this.renderer.setSize(window.innerWidth, window.innerHeight);

    // configure camera, controls and lightning
    this.camera = new THREE.PerspectiveCamera(
      45, window.innerWidth / window.innerHeight, 0.02, 10000
    );
    // camera
    this.camera.position.z = 10;
    this.scene.add(this.camera);
    const controls = new OrbitControls(this.camera, this.canvas);
    controls.target.set(0, 0, 0);
    controls.update();
    // background stuff
    this.scene.background = new THREE.Color( 0x000000 );
    this.scene.fog = new THREE.Fog( 0x000000, 250, 1400 );

    // lights

    var dirLight = new THREE.DirectionalLight( 0xffffff, 0.125 );
    dirLight.position.set( 0, 0, 1 ).normalize();
    this.scene.add( dirLight );

    var pointLight = new THREE.PointLight( 0xffffff, 1.5 );
    pointLight.position.set( 0, 100, 90 );
    this.scene.add( pointLight );

    // objects
    var axesHelper = new THREE.AxesHelper(1);
    this.scene.add(axesHelper);

    const geometry = new THREE.BoxGeometry(0.5, 0.5, 0.5);
    const material = new THREE.MeshBasicMaterial({color: 0x00ff00});
    this.cube = new THREE.Mesh(geometry, material);
    this.cube.position.set(2, 2, 3)
    this.scene.add(this.cube);
    var loader = new THREE.FontLoader();

    // for some reason the water bottle is tiny and near invisible...
    this.test1()
  }

  public animate(): void {
    // We have to run this outside angular zones,
    // because it could trigger heavy changeDetection cycles.
    this.ngZone.runOutsideAngular(() => {
      if (document.readyState !== 'loading') {
        this.render();
      } else {
        window.addEventListener('DOMContentLoaded', () => {
          this.render();
        });
      }

      window.addEventListener('resize', () => {
        this.resize();
      });
    });
  }

  public render(): void {
    this.frameId = requestAnimationFrame(() => {
      this.render();
    });

    this.cube.rotation.x += 0.01;
    this.cube.rotation.y += 0.01;
    this.renderer.render(this.scene, this.camera);
  }

  public resize(): void {
    const width = window.innerWidth;
    const height = window.innerHeight;

    this.camera.aspect = width / height;
    this.camera.updateProjectionMatrix();

    this.renderer.setSize(width, height);
  }
}
