package edu.csupomona.cs480.util;

/**
 * @author Sujeo
 *
 */
public final class IdGiver {

	private static int uniqueId = 0;

	public static synchronized int getUniqueId()
	{
	    return uniqueId++;
	}
}
