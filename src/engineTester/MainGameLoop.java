package engineTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Textures.ModelTexture;
import entities.Camera;
import entities.Entity;
import entities.Light;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		
		// dragons: set up textured model
		RawModel dragon_model = OBJLoader.loadObjModel("dragon", loader);
		ModelTexture dragon_texture = new ModelTexture(loader.loadTexture("white"));
		dragon_texture.setShineDamper(10);
		dragon_texture.setReflectivity(1);
		TexturedModel dragon_texturedModel = new TexturedModel(dragon_model, dragon_texture);
		
		// dragons: create entity list
		List<Entity> dragons = new ArrayList<Entity>();
		for(int i = 0; i < 20; i++) {
			Random random = new Random();
			float posX = (random.nextFloat() * 50 - 25);
			float posY = (random.nextFloat() * 50 - 25);
			float posZ = (random.nextFloat() * 50 - 25);
			float rotX = (random.nextFloat() * 50 - 25);
			float rotY = (random.nextFloat() * 50 - 25);
			float rotZ = (random.nextFloat() * 50 - 25);
			float scale = random.nextFloat() * (1 - 0.1f) + 0.1f;
			Entity dragon = new Entity(dragon_texturedModel, new Vector3f(posX, posY, posZ), rotX, rotY, rotZ, scale);
			dragons.add(dragon);
		}
		
		
		Light light = new Light(new Vector3f(0, -2, -15), new Vector3f(1, 1, 1));
		Camera camera = new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		while(!Display.isCloseRequested()) {
			camera.move();
			
			for(Entity dragon : dragons) {
				dragon.increaseRotation(0.5f, 0.5f, 0.5f);
				renderer.processEntity(dragon);
			}
			
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
