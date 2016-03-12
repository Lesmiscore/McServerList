package com.nao20010128nao.McServerList.sites;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.nao20010128nao.McServerList.Server;

/**
 * A server list site.<br>
 * Shouldn't be used directly.
 *
 * @see com.nao20010128nao.McServerList.ServerAddressFetcher
 * */
public interface ServerListSite {
	/**
	 * Checks this class supports the URL.
	 * */
	public boolean matches(URL url);

	/**
	 * Checks there's more than one servers in a URL.
	 * */
	public boolean hasMultipleServers(URL url) throws IOException;

	/**
	 * Finds Minecraft multiplayer IP & port from a URL.
	 *
	 * @return A list that was found servers contains. Immutable.
	 * */
	public List<Server> getServers(URL url) throws IOException;
}
