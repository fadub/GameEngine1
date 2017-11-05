package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Textures.ModelTexture;
import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop_tut7 {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		float[] vertices = { 
				-0.5f, 0.5f, 0,		// V0
				-0.5f, -0.5f, 0,	// V1
				0.5f, -0.5f, 0,		// V2
				0.5f, 0.5f, 0		// V3
		};
		
		int[] indices = {
				0,1,3,	// Top left triangle (V0, V1, V3)
				3,1,2	// Bottom right triangle (V3, V1, V2)
		};
		
		float[] textureCoords = {
				0,0,	// V0
				0,1,	// V1
				1,1,	// V2
				1,0		// V3
		};
		 
		RawModel model = loader.loadToVAO(vertices, indices, textureCoords);
		ModelTexture texture = new ModelTexture(loader.loadTexture("texture1"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		Entity entity = new Entity(texturedModel, new Vector3f(0, 0, -5), 0, 0, 0, 1);
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()) {
//			if(entity.getPosition().z < -2) {
//				entity.increasePosition(0, 0, 0.05f);
//				entity.increaseRotation(0, 0, (float)Math.random()*5);
//			}
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
