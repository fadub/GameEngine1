package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position;
	private float pitch;
	private float yaw;
	private float roll;
	
	public Camera() {
		this.position = new Vector3f(0, 0, 0);
		this.pitch = 0;
		this.yaw = 0;
	}
	
	public Camera(Vector3f position, float pitch, float yaw) {
		this.position = position;
		this.pitch = pitch;
		this.yaw = yaw;
	}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			yaw -= 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_E)) {
			yaw += 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)) {
			position.y -= 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_X)) {
			position.y += 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_C)) {
			pitch -= 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_V)) {
			pitch += 1f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
}
