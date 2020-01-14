/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.ui.habmin.internal.services.designer;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Chris Jackson
 * @since 1.5.0
 *
 */
@XmlRootElement(name="comment")
public class DesignerCommentBean {
	public String text;
	public Boolean pinned;
	public Integer w;
	public Integer h;
}