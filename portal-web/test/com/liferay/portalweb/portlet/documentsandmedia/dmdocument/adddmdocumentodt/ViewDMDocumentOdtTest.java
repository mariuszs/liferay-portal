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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmdocumentodt;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMDocumentOdtTest extends BaseTestCase {
	public void testViewDMDocumentOdt() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText(
				"//div[@class='document-library-breadcrumb']/ul/li/span/a"));
		assertEquals(RuntimeVariables.replace(
				"Access these files offline using Liferay Sync."),
			selenium.getText("//div[@id='_20_syncNotificationContent']/a"));
		assertTrue(selenium.isVisible("//span[@class='document-thumbnail']/img"));
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace("Download"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[1]/span[2]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[2]/span[2]"));
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[3]/span[2]"));
		assertEquals(RuntimeVariables.replace("Checkout"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[4]/span[2]"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[5]/span[2]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//span[@class='aui-toolbar-content']/button[6]/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText("//h2[@class='document-title']"));
		assertTrue(selenium.isVisible("//span[@class='document-thumbnail']/img"));
		assertTrue(selenium.isPartialText(
				"//span[@class='user-date']/span/span", "Uploaded by Joe Bloggs"));
		assertTrue(selenium.isVisible("//span[@class='lfr-asset-ratings']"));
		assertEquals(RuntimeVariables.replace(
				"No comments yet. Be the first. Subscribe to Comments"),
			selenium.getText(
				"//fieldset[@class='aui-fieldset add-comment ']/div"));
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText(
				"//fieldset[@class='aui-fieldset add-comment ']/div/a"));
		assertEquals(RuntimeVariables.replace("Subscribe to Comments"),
			selenium.getText("//span[@class='subscribe-link']/a/span"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("//h3[contains(@class,'version')]"));
		assertEquals(RuntimeVariables.replace("Last Updated by Joe Bloggs"),
			selenium.getText("//div[@class='lfr-asset-icon lfr-asset-author']"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-asset-icon lfr-asset-date']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (9.0k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
		assertEquals(RuntimeVariables.replace("Get URL or WebDAV URL."),
			selenium.getText("//span[@class='webdav-url']"));
		assertEquals(RuntimeVariables.replace(
				"Automatically Extracted Metadata"),
			selenium.getText(
				"//div[@id='documentLibraryAssetMetadataPanel']/div/div/span"));
		assertEquals(RuntimeVariables.replace("Date 2012-05-09T16:29:14.53"),
			selenium.getText(
				"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[1]"));
		assertEquals(RuntimeVariables.replace(
				"Content Type application/vnd.oasis.opendocument.text"),
			selenium.getText(
				"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace("Edit Time PT2M5S"),
			selenium.getText(
				"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Creation Date 2012-05-09T16:22:55.33"),
			selenium.getText(
				"//div[@id='documentLibraryAssetMetadataPanel']/div[2]/div[4]"));
		assertEquals(RuntimeVariables.replace("Version History"),
			selenium.getText(
				"//div[@id='documentLibraryVersionHistoryPanel']/div/div/span"));
		assertEquals(RuntimeVariables.replace("Version"),
			selenium.getText("//tr[1]/th[1]"));
		assertEquals(RuntimeVariables.replace("Date"),
			selenium.getText("//tr[1]/th[2]"));
		assertEquals(RuntimeVariables.replace("Size"),
			selenium.getText("//tr[1]/th[3]"));
		assertEquals(RuntimeVariables.replace("Status"),
			selenium.getText("//tr[1]/th[4]"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//tr[3]/td[1]"));
		assertTrue(selenium.isVisible("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("9.0k"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//tr[3]/td[4]"));
	}
}