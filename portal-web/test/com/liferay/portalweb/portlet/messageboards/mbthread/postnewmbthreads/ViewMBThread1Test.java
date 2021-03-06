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

package com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbthreads;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBThread1Test extends BaseTestCase {
	public void testViewMBThread1() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread1 Message Subject"),
			selenium.getText("//tr[5]/td[1]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[5]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[5]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//tr[5]/td[4]/a"));
		assertTrue(selenium.isVisible("//tr[5]/td[5]/a"));
		assertTrue(selenium.isPartialText("//tr[5]/td[6]/a", "By: Joe Bloggs"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//tr[5]/td[7]/span/ul/li/strong/a/span"));
		selenium.clickAt("//tr[5]/td[1]/a",
			RuntimeVariables.replace("MB Thread1 Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Thread1 Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("//a[@id='_19_TabsBack']"));
		assertEquals(RuntimeVariables.replace("Threads [ Previous | Next ]"),
			selenium.getText("//div[@class='thread-navigation']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("MB Thread1 Message Subject"),
			selenium.getText("//div[@class='subject']/a"));
		assertEquals(RuntimeVariables.replace("MB Thread1 Message Body"),
			selenium.getText("//div[@class='thread-body']"));
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
	}
}