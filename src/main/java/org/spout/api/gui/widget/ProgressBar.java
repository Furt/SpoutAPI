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
package org.spout.api.gui.widget;

import org.spout.api.gui.WidgetType;

public class ProgressBar extends AbstractWidget implements RangedWidget<Integer> {

	private int min, max, value;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public ProgressBar setRange(Integer min, Integer max) {
		if (min >= max) {
			throw new IllegalStateException("min must be smaller than max");
		}
		this.min = min;
		this.max = max;
		return this;
	}

	@Override
	public ProgressBar setValue(Integer value) {
		if (value < min || value > max) {
			throw new IllegalStateException("value must be inside the range");
		}
		this.value = value;
		return this;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public Integer getRangeMin() {
		return min;
	}

	@Override
	public Integer getRangeMax() {
		return max;
	}

	@Override
	public WidgetType getWidgetType() {
		return WidgetType.PROGRESSBAR;
	}

}
