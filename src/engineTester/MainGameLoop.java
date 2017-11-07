package engineTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import models.RawModel;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		
		//********* TERRAIN TEXTURE STUFF *********
		
		TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy"));
		TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirt"));
		TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
		TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("path"));
		
		TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("myBlendMap"));
		
		//***************************************
		
		ModelData data;
		
		// object1: set up textured model
		data = OBJFileLoader.loadOBJ("lowPolyTree");
		RawModel object1_model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		ModelTexture object1_texture = new ModelTexture(loader.loadTexture("lowPolyTree"));
		object1_texture.setShineDamper(10);
		object1_texture.setReflectivity(1);
		TexturedModel object1_texturedModel = new TexturedModel(object1_model, object1_texture);
		
		// object1: create entity list
		List<Entity> object1s = new ArrayList<Entity>();
		for(int i = 0; i < 100; i++) {
			Random random = new Random();
			float posX = (random.nextFloat() * 400 + 20);
			float posY = 0;
			float posZ = (random.nextFloat() * 400 + 20);
			float rotX = 0;
			float rotY = (random.nextFloat() * 360 - 180);
			float rotZ = 0;
			float scale = random.nextFloat() * (1 - 0.3f) + 0.3f;
			Entity object1 = new Entity(object1_texturedModel, new Vector3f(posX, posY, posZ), rotX, rotY, rotZ, scale);
			object1s.add(object1);
		}
		
		// object2: set up textured model
		data = OBJFileLoader.loadOBJ("fern");
		RawModel object2_model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		ModelTexture object2_texture = new ModelTexture(loader.loadTexture("fern"));
		object2_texture.setShineDamper(10);
		object2_texture.setReflectivity(1);
		TexturedModel object2_texturedModel = new TexturedModel(object2_model, object2_texture);
		object2_texturedModel.getTexture().setHasTransparancy(true);
		object2_texturedModel.getTexture().setUseFakeLighting(true);
		
		// object2: create entity list
		List<Entity> object2s = new ArrayList<Entity>();
		for(int i = 0; i < 50; i++) {
			Random random = new Random();
			float posX = (random.nextFloat() * 400 + 20);
			float posY = 0;
			float posZ = (random.nextFloat() * 400 + 20);
			float rotX = 0;
			float rotY = (random.nextFloat() * 360 - 180);
			float rotZ = 0;
			float scale = random.nextFloat() * (1f - 0.5f) + 0.5f;
			Entity object2 = new Entity(object2_texturedModel, new Vector3f(posX, posY, posZ), rotX, rotY, rotZ, scale);
			object2s.add(object2);
		}
		
		// object3: set up textured model
		data = OBJFileLoader.loadOBJ("grass");
		RawModel object3_model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		ModelTexture object3_texture = new ModelTexture(loader.loadTexture("grass"));
		object3_texture.setShineDamper(10);
		object3_texture.setReflectivity(1);
		TexturedModel object3_texturedModel = new TexturedModel(object3_model, object3_texture);
		object3_texturedModel.getTexture().setHasTransparancy(true);
		object3_texturedModel.getTexture().setUseFakeLighting(true);
		
		// object3: create entity list
		List<Entity> object3s = new ArrayList<Entity>();
		for(int i = 0; i < 50; i++) {
			Random random = new Random();
			float posX = (random.nextFloat() * 400 + 20);
			float posY = 0;
			float posZ = (random.nextFloat() * 400 + 20);
			float rotX = 0;
			float rotY = (random.nextFloat() * 360 - 180);
			float rotZ = 0;
			float scale = random.nextFloat() * (2f - 1f) + 1f;
			Entity object3 = new Entity(object3_texturedModel, new Vector3f(posX, posY, posZ), rotX, rotY, rotZ, scale);
			object3s.add(object3);
		}
		
		// object4: set up textured model
		data = OBJFileLoader.loadOBJ("tree");
		RawModel object4_model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		ModelTexture object4_texture = new ModelTexture(loader.loadTexture("tree"));
		object4_texture.setShineDamper(10);
		object4_texture.setReflectivity(1);
		TexturedModel object4_texturedModel = new TexturedModel(object4_model, object4_texture);
		object4_texturedModel.getTexture().setHasTransparancy(true);
		object4_texturedModel.getTexture().setUseFakeLighting(true);
		
		// object4: create entity list
		List<Entity> object4s = new ArrayList<Entity>();
		for(int i = 0; i < 50; i++) {
			Random random = new Random();
			float posX = (random.nextFloat() * 400 + 20);
			float posY = 0;
			float posZ = (random.nextFloat() * 400 + 20);
			float rotX = 0;
			float rotY = (random.nextFloat() * 360 - 180);
			float rotZ = 0;
			float scale = random.nextFloat() * (10f - 5f) + 5f;
			Entity object4 = new Entity(object4_texturedModel, new Vector3f(posX, posY, posZ), rotX, rotY, rotZ, scale);
			object4s.add(object4);
		}
		
		ModelTexture terrainTexture = new ModelTexture(loader.loadTexture("grassTerrain"));
		Terrain terrain = new Terrain(0, 0, loader, texturePack, blendMap);
		
		Light light = new Light(new Vector3f(200, 200, 200), new Vector3f(0.8f, 1.4f, 2f));
		Camera camera = new Camera(new Vector3f(150, 6, 500), 0, 0);
		
		// player
		data = OBJFileLoader.loadOBJ("player");
		RawModel player_model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		ModelTexture player_texture = new ModelTexture(loader.loadTexture("player"));
		player_texture.setShineDamper(10);
		player_texture.setReflectivity(1);
		TexturedModel player_texturedModel = new TexturedModel(player_model, player_texture);
		player_texturedModel.getTexture().setHasTransparancy(true);
		player_texturedModel.getTexture().setUseFakeLighting(true);
		Player player = new Player(player_texturedModel, new Vector3f(150, 0, 470), 0, 0, 0, 1);
		
		MasterRenderer renderer = new MasterRenderer();
		while(!Display.isCloseRequested()) {
			camera.move();
			player.move();
			
			renderer.processEntity(player);
			
			renderer.processTerrain(terrain);
			
			for(Entity object1 : object1s) {
				renderer.processEntity(object1);
			}
			
			for(Entity object2 : object2s) {
				renderer.processEntity(object2);
			}
			
			for(Entity object3 : object3s) {
				renderer.processEntity(object3);
			}
			
			for(Entity object4 : object4s) {
				renderer.processEntity(object4);
			}
			
			
			
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
