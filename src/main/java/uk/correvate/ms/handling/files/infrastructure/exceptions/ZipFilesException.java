/*
 * %W% %E% Scotiabank Bank S.A
 *
 * Copyright (c) 2010-2020 Scotiabank Bank S.A, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Scotiabank
 * bank S.A, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Scotiabank.
 *
 * SCOTIABANK MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SCOTIABANK SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package uk.correvate.ms.handling.files.infrastructure.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class ZipFilesException extends RuntimeException {

	private static final long serialVersionUID = 5049577350617160022L;

	/**
	 * Constructor
	 *
	 * @param		message text with the exception description
	 * @param		cause   throwable with the trace of the exception
	 */
	public ZipFilesException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 *
	 * @param		message text with the exception description
	 */
	public ZipFilesException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param		message text with the exception description
	 * @param		code Custom error code
	 */
	public ZipFilesException(final String message, final int code) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param		cause throwable with the trace of the exception
	 */
	public ZipFilesException(final Throwable cause) {
		super(cause);
	}
}
