 // this function is executed on each animation frame
function animate() {

	controls.update();

	 planet2.rotation.y -= 0.0085;
	 planet3.rotation.y += 0.0095;
	 planet4.rotation.y -= 0.0115;
	 planet5.rotation.y -= 0.0065;
	 planet6.rotation.y -= 0.0095;
	 planet7.rotation.y -= 0.0085;
	 planet8.rotation.y -= 0.0055;
	 planet9.rotation.y -= 0.0095;
	 planet10.rotation.y -= 0.0055;
	 
     // render
     renderer.render(scene, camera);

     // request new frame
     requestAnimationFrame(function () {
         animate();
     });

}

// renderer
var canvasContainer = document.getElementById("canvas");
var renderer = new THREE.WebGLRenderer({ alpha: true, antialias: true });
renderer.setSize(canvasContainer.offsetWidth, canvasContainer.offsetHeight);
renderer.setClearColor( 0xffffff, 0);

canvasContainer.appendChild(renderer.domElement);

// camera
var camera = new THREE.PerspectiveCamera(45, (canvasContainer.offsetWidth) / canvasContainer.offsetHeight, 1, 5000);
//var camera = new THREE.OrthographicCamera( window.innerWidth / - 2, window.innerWidth / 2, window.innerHeight / 2, window.innerHeight / - 2, 1, 5000);
camera.position.z = 1370;

// scene
var scene = new THREE.Scene();

// light
var directionalLight = new THREE.DirectionalLight( {color: 0xffffff}, 1.2 );
directionalLight.castShadow = true;
directionalLight.shadowCameraRight =  10;
directionalLight.shadowCameraLeft = -10;
directionalLight.shadowCameraTop =  10;
directionalLight.shadowCameraBottom = -10;
directionalLight.shadowBias = -0.0001;
directionalLight.shadowCameraFar = 3500;
directionalLight.position.set( -7, 1, 2 );
scene.add(directionalLight);

function getPlaneta (texturaURL, escala) {
	var p = new THREE.Object3D();
	var jsonLoader = new THREE.JSONLoader();
	jsonLoader.load(
	     'models/planeta.json', function (geometry, materials) {
	    	 var planet;
	    	 var planetMat = new THREE.MeshLambertMaterial({color: 0xffffff});
	         
	         planet = new THREE.Mesh(geometry, planetMat);
	         planet.geometry.scale(escala,escala,escala);
	         
	         var loader = new THREE.TextureLoader();
	         loader.load(texturaURL, function (texture) {
	        	planet.material.map = texture; 
	            //planet.material.needsUpdate = true;
	            p.add(planet);
	            
	         });
	     }
	);
	return p;
}

// load models
//var planet1 = getPlaneta('textures/sunmap.jpg', 300000);
var planet2 = getPlaneta('textures/mercurymap.jpg', 10);
var planet3 = getPlaneta('textures/venusmap.jpg', 26);
var planet4 = getPlaneta('textures/earthmap.jpg', 27);
var planet5 = getPlaneta('textures/marsmap.jpg', 14);
var planet6 = getPlaneta('textures/jupitermap.jpg', 300);
var planet7 = getPlaneta('textures/saturnmap.jpg', 250);
var planet8 = getPlaneta('textures/uranusmap.jpg', 110);
var planet9 = getPlaneta('textures/neptunemap.jpg', 106);
var planet10 = getPlaneta('textures/plutomap.jpg', 5);

scene.add(planet2);
planet2.position.x -= 1350;
scene.add(planet3);
planet3.position.x -= 1150;
scene.add(planet4);
planet4.position.x -= 950;
scene.add(planet5);
planet5.position.x -= 750;
scene.add(planet6);
planet6.position.x -= 300;
scene.add(planet7);
planet7.position.x += 350;
scene.add(planet8);
planet8.position.x += 850;
scene.add(planet9);
planet9.position.x += 1150;
scene.add(planet10);
planet10.position.x += 1350;

var controls;
controls = new THREE.OrbitControls( camera, renderer.domElement  );
controls.autoRotate = true;
//controls.addEventListener( 'change', renderer );

 // start animation
 animate();
