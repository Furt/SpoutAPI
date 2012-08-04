package org.spout.api.collision;

import java.util.HashMap;
import java.util.Map;

/**
 * An easier to understand version of Bullet's CollisionFlags class.
 */
public enum CollisionFlags {
	//TODO Better naming than Bullet as well as heavy documentation
	CUSTOM_MATERIAL_CALLBACK(8),
	CHARACTER_OBJECT(16),
	KINEMATIC_OBJECT(2),
	NO_CONTACT_RESPONSE(4),
	STATIC_OBJECT(1);

	private final int id;
	private static final Map<Integer, CollisionFlags> idMap = new HashMap<Integer, CollisionFlags>();

	static {
		for (CollisionFlags flag : CollisionFlags.values()) {
			idMap.put(flag.getId(), flag);
		}
	}

	private CollisionFlags(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static CollisionFlags get(int id) {
		return idMap.get(id);
	}
}
