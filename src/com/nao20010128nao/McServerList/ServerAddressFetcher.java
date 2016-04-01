package com.nao20010128nao.McServerList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nao20010128nao.McServerList.sites.MinecraftMp_Com;
import com.nao20010128nao.McServerList.sites.MinecraftServersList_Org;
import com.nao20010128nao.McServerList.sites.Minecraft_Jp;
import com.nao20010128nao.McServerList.sites.Minecraftpeservers_Org;
import com.nao20010128nao.McServerList.sites.MinecraftpocketServers_Com;
import com.nao20010128nao.McServerList.sites.Minecraftservers_Org;
import com.nao20010128nao.McServerList.sites.Pe_Minecraft_Jp;
import com.nao20010128nao.McServerList.sites.Pmmp_Jp_Net;
import com.nao20010128nao.McServerList.sites.ServerListSite;

/**
 * Finds Minecraft multiplayer IP & port from website. Cannot be instantinated.
 */
public class ServerAddressFetcher {
	static Set<ServerListSite> services = new HashSet<>();
	static {
		services.add(new Minecraft_Jp());
		services.add(new Minecraftpeservers_Org());
		services.add(new Minecraftservers_Org());
		services.add(new MinecraftServersList_Org());
		services.add(new Pe_Minecraft_Jp());
		services.add(new MinecraftpocketServers_Com());
		services.add(new MinecraftMp_Com());
		services.add(new Pmmp_Jp_Net());
	}

	private ServerAddressFetcher() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * Finds Minecraft multiplayer IP & port from a website.
	 *
	 * @param url
	 *            An URL that is for server's detail or servers list
	 * @return A list that was found servers contains. Immutable.
	 */
	public static List<Server> findServersInWebpage(URL url) throws IOException {
		Set<ServerListSite> service = new HashSet<>();
		for (ServerListSite serv : services) {
			if (serv.matches(url)) {
				service.add(serv);
				break;
			}
		}
		if (service.size() == 0) {
			throw new IllegalArgumentException("This website is not supported: " + url);
		}
		for (ServerListSite serv : services) {
			List<Server> servers = serv.getServers(url);
			return Collections.unmodifiableList(new ArrayList<>(servers));
		}
		throw new IllegalArgumentException("Unsupported webpage: " + url);
	}

	/**
	 * Add a website for finding servers.
	 *
	 * @param service
	 *            An instance of ServerListSite class.
	 */
	public static void addService(ServerListSite service) {
		services.add(service);
	}
}
