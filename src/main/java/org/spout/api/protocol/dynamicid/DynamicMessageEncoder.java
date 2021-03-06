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
package org.spout.api.protocol.dynamicid;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.spout.api.protocol.CommonHandler;
import org.spout.api.protocol.Message;
import org.spout.api.protocol.MessageCodec;
import org.spout.api.protocol.Protocol;
import org.spout.api.protocol.Session;

/**
 * Process dynamically registered messages before sending them to give extra usefulness
 */
public class DynamicMessageEncoder extends OneToOneEncoder {
	protected Object encode(ChannelHandlerContext ctx, Channel channel, Object o) throws Exception {
		if (o instanceof Message) {
			Session session = ctx.getPipeline().get(CommonHandler.class).getSession();
			if (session != null) {
				Protocol protocol = session.getProtocol();
				MessageCodec<?> codec = protocol.getCodecLookupService().find(((Message) o).getClass());
				if (codec != null && codec.isDynamic()) {
					return protocol.getWrappedMessage(false, (Message) o);
				}
			}
		}
		return o;
	}
}
