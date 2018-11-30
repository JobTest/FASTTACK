package com.cts.fasttack.common.core.util;

/**
 * 
 * @author d.ishchenko
 *
 */

public class ObjectUtil {

	@SuppressWarnings("unchecked")
	public static <T> T uncheckedCast(Object obj) {
		return (T) obj;
	}

}
