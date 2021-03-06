/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sousaddpmmessagereplyattachment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_AddPMMessageReplyAttachmentTest extends BaseTestCase {
	public void testSOUs_AddPMMessageReplyAttachment()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/home");
		selenium.waitForVisible("//span[@class='notification-count']");
		selenium.clickAt("//span[@class='notification-count']",
			RuntimeVariables.replace("Notification Count"));
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace("Joe Bloggs sent you a message."),
			selenium.getText("//div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("//span[@class='dismiss-notifications']/a"));
		selenium.clickAt("//span[@class='dismiss-notifications']/a",
			RuntimeVariables.replace("Mark as Read"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//span[@class='notification-count']");
		selenium.clickAt("//span[@class='notification-count']",
			RuntimeVariables.replace("Notification Count"));
		assertFalse(selenium.isTextPresent("Joe Bloggs sent you a message."));
		selenium.waitForVisible("//nav/ul/li[contains(.,'Messages')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
			RuntimeVariables.replace("Messages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Messaging"),
			selenium.getText("//span[@class='portlet-title-default']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='author-sender']"));
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//div[@class='subject']"));
		assertEquals(RuntimeVariables.replace("Message Body"),
			selenium.getText("//div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		selenium.clickAt("//div[@class='subject']",
			RuntimeVariables.replace("Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Between Joe Bloggs And you"),
			selenium.getText(
				"//div[@class='aui-layout-content thread-info-content ']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("xPath=(//span[@class='name'])[2]"));
		assertTrue(selenium.isPartialText("//div[@class='body']", "Message Body"));
		assertTrue(selenium.isVisible("//textarea[@class='message-body']"));
		selenium.type("//textarea[@class='message-body']",
			RuntimeVariables.replace("Message Subject Reply"));
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_privatemessagingportlet_msgFile1']"));
		selenium.type("//input[@id='_1_WAR_privatemessagingportlet_msgFile1']",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\socialofficehome\\message\\sousaddpmmessagereplyattachment\\dependencies\\PM_Attachment.jpg"));
		selenium.clickAt("//input[@value='Send']",
			RuntimeVariables.replace("Send"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='author-sender']"));
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//div[@class='subject']"));
		assertEquals(RuntimeVariables.replace("Message Subject Reply"),
			selenium.getText("//div[@class='body']"));
	}
}