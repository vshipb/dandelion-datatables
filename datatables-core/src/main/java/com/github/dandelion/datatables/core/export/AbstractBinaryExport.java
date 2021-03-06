/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.core.export;

import java.io.OutputStream;

import com.github.dandelion.datatables.core.exception.ExportException;
import com.github.dandelion.datatables.core.html.HtmlTable;

/**
 * Contract for every binary export implementation.
 * 
 * @author Thibault Duchateau
 */
public abstract class AbstractBinaryExport {

	/**
	 * Initialize the implementation classes with all needed informations.
	 * Usually, only the HtmlTable is needed, because it already contains lots
	 * of information.
	 * 
	 * @param table
	 *            The HTML table containing all needed informations for the
	 *            export.
	 */
	public abstract void initExport(HtmlTable table);

	/**
	 * The main export method that is called by Dandelion-datatables in charge of
	 * writing in the output.
	 * 
	 * @param output
	 *            The stream to fill and which will override the default
	 *            response during export.
	 * @throws ExportException
	 *             if something goes wrong during export
	 */
	public abstract void processExport(OutputStream output) throws ExportException;
}