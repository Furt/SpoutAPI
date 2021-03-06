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
package org.spout.api.event;

/**
 * Represents an {@link EventExecutor}'s registration. 
 */
public class ListenerRegistration {
	private final EventExecutor executor;
	private final Order orderSlot;
	private final Object owner;

	/**
	 * @param executor Listener this registration represents
	 * @param orderSlot Order position this registration is in
	 * @param owner object that created this registration
	 */
	public ListenerRegistration(final EventExecutor executor, final Order orderSlot, final Object owner) {
		this.executor = executor;
		this.orderSlot = orderSlot;
		this.owner = owner;
	}

	/**
	 * Gets the listener for this registration
	 *
	 * @return Registered Listener
	 */
	public EventExecutor getExecutor() {
		return executor;
	}

	/**
	 * Gets the {@link Object} for this registration
	 *
	 * @return Registered owner
	 */
	public Object getOwner() {
		return owner;
	}

	/**
	 * Gets the order slot for this registration
	 *
	 * @return Registered order
	 */
	public Order getOrder() {
		return orderSlot;
	}
}
