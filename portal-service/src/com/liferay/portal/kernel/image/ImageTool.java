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

package com.liferay.portal.kernel.image;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.concurrent.Future;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public interface ImageTool {

	public static final String TYPE_BMP = "bmp";

	public static final String TYPE_GIF = "gif";

	public static final String TYPE_JPEG = "jpg";

	public static final String TYPE_NOT_AVAILABLE = "na";

	public static final String TYPE_PNG = "png";

	public static final String TYPE_TIFF = "tiff";

	public Future<RenderedImage> convertCMYKtoRGB(byte[] bytes, String type);

	public BufferedImage convertImageType(BufferedImage sourceImage, int type);

	public void encodeGIF(RenderedImage renderedImage, OutputStream os)
		throws IOException;

	public void encodeWBMP(RenderedImage renderedImage, OutputStream os)
		throws IOException;

	public BufferedImage getBufferedImage(RenderedImage renderedImage);

	public byte[] getBytes(RenderedImage renderedImage, String contentType)
		throws IOException;

	public ImageBag read(byte[] bytes) throws IOException;

	public ImageBag read(File file) throws IOException;

	public ImageBag read(InputStream inputStream) throws IOException;

	public RenderedImage scale(RenderedImage renderedImage, int width);

	public RenderedImage scale(
		RenderedImage renderedImage, int maxHeight, int maxWidth);

	public abstract void write(
			RenderedImage renderedImage, String contentType, OutputStream os)
		throws IOException;

}