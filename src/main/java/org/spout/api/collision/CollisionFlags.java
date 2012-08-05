/*
 * This file is part of SpoutAPI.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
 * SpoutAPI is licensed under the SpoutDev License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.api.collision;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	private static final Map<Integer, CollisionFlags> rawMap = new HashMap<Integer, CollisionFlags>();

	static {
		for (CollisionFlags flag : CollisionFlags.values()) {
			rawMap.put(flag.getRawId(), flag);
		}
	}

	private CollisionFlags(int id) {
		this.id = id;
	}

	public int getRawId() {
		return id;
	}

	public static Set<CollisionFlags> getFlagsFromInt(int packed) {
		Set<CollisionFlags> flags = new HashSet<CollisionFlags>();
		for (CollisionFlags f: CollisionFlags.values()) {
			if ((packed & f.getRawId()) > 0) {
				flags.add(f);
			}
		}
		return flags;
	}

	public static int packFlagsIntoInt(Set<CollisionFlags> flags) {
		int packed = 0;
		if (flags == null || flags.isEmpty()) {
			return packed;
		}
		for (CollisionFlags f : flags) {
			packed |= f.getRawId();
		}
		return packed;
	}
}
