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

package com.liferay.portalweb.portal.dbupgrade.sampledata6010.social.request;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SRq_AddPortletSummaryTest extends BaseTestCase {
	public void testSRq_AddPortletSummary() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/socialrequestsn1/home/");
		selenium.waitForVisible("link=Summary Test Page");
		selenium.click(RuntimeVariables.replace("link=Summary Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("More\u2026"),
			selenium.getText("//a[@id='_145_addApplication']"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More\u2026"));
		selenium.waitForElementPresent("//div[@title='Summary']/p/a");
		selenium.clickAt("//div[@title='Summary']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
	}
}