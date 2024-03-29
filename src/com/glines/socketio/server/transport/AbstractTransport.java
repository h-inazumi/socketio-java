/**
 * The MIT License
 * Copyright (c) 2010 Tad Glines
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.glines.socketio.server.transport;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import com.glines.socketio.server.Transport;

public abstract class AbstractTransport implements Transport {
	protected String extractSessionId(HttpServletRequest request) {
    	String path = request.getPathInfo();
    	if (path != null && path.length() > 0 && !"/".equals(path)) {
	    	if (path.startsWith("/")) path = path.substring(1);
	    	String[] parts = path.split("/");
	    	if (parts.length >= 2) {
	    		return parts[1] == null ? null : (parts[1].length() == 0 ? null : parts[1]);
	    	}
    	}
    	return null;
	}

	@Override
	public void init(ServletConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}
}
