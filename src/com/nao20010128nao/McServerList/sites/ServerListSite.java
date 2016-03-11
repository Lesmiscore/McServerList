package com.nao20010128nao.McServerList.sites;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.nao20010128nao.McServerList.Server;

/**
 * A server list site.
 * */
public interface ServerListSite {
	public boolean matches(URL url);

	public boolean hasMultipleServers(URL url) throws IOException;

	public List<Server> getServers(URL url) throws IOException;
}
