package com.nao20010128nao.McServerList.sites;

import java.net.URL;
import java.util.List;

import com.nao20010128nao.McServerList.Server;

/**
 * A server list site.
 * */
public interface ServerListSite {
	public boolean matches(URL url);

	public boolean hasMultipleServers(URL url);

	public List<Server> getServers(URL url);
}
