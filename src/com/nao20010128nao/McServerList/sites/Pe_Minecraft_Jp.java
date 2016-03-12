package com.nao20010128nao.McServerList.sites;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nao20010128nao.McServerList.Server;

/**
 * Parser class for "pe.minecraft.jp"
 * */
public class Pe_Minecraft_Jp implements ServerListSite {

	public Pe_Minecraft_Jp() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean matches(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return url.getHost().equalsIgnoreCase("pe.minecraft.jp");
	}

	@Override
	public boolean hasMultipleServers(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		if (url.getPath().replace("/", "").equals("")
				| url.getPath().replace("/", "").toLowerCase()
						.startsWith("index")) {
			return true;
		}
		if (url.getPath().replace("/", "").toLowerCase().startsWith("server")) {
			return false;
		}
		return false;
	}

	@Override
	public List<Server> getServers(URL url) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		if (url.getPath().replace("/", "").equals("")
				| url.getPath().replace("/", "").toLowerCase()
						.startsWith("serversscorepage")) {
			List<Server> list = new ArrayList<>();
			Document page = Jsoup.connect(url.toString()).userAgent("Mozilla")
					.get();
			Elements elems = page
					.select("html > body > #wrap > #content > table > tbody > tr > td.address");
			for (Element e : elems) {
				String ip = e.html();
				if (ip.equals("(非公開)")) {
					// Server is private
					continue;
				}
				list.add(Server.makeServerFromString(ip, true));
			}
			return list;
		}
		if (url.getPath().replace("/", "").toLowerCase().startsWith("servers")) {
			// Single server page
			String ip = url.getPath().substring(9);
			if (!ip.contains(".")) {
				// Server is private
				return null;
			}
			return Arrays.asList(Server.makeServerFromString(ip, true));
		}
		return null;
	}
}
