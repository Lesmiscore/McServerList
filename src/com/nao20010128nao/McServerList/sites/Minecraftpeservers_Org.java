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

public class Minecraftpeservers_Org implements ServerListSite {

	public Minecraftpeservers_Org() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean matches(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return url.getHost().equalsIgnoreCase("minecraftpeservers.org");
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
		if (url.getPath().replace("/", "").toLowerCase().startsWith("server")) {
			// Single server page
			Document page = Jsoup.connect(url.toString()).userAgent("Mozilla")
					.get();
			String ip = page
					.select("html > body > #single > div > #left > table > tbody > tr > td > span")
					.get(2).html();
			String[] spl = ip.split("\\:");
			if (spl.length == 2) {
				// IP & port
				Server s = new Server();
				s.ip = spl[0];
				s.port = new Integer(spl[1]);
				s.isPE = false;
				return Arrays.asList(s);
			} else {
				// IP only
				Server s = new Server();
				s.ip = spl[0];
				s.port = 19132;
				s.isPE = false;
				return Arrays.asList(s);
			}
		}
		if (url.getPath().replace("/", "").equals("")
				| url.getPath().replace("/", "").toLowerCase()
						.startsWith("index")) {
			List<Server> list = new ArrayList<>();
			Document page = Jsoup.connect(url.toString()).userAgent("Mozilla")
					.get();
			Elements elems = page
					.select("html > body > #main > div > table > tbody > tr > td > div > p");
			for (Element e : elems) {
				String ip = e.html().substring(29);
				String[] spl = ip.split("\\:");
				if (spl.length == 2) {
					// IP & port
					Server s = new Server();
					s.ip = spl[0];
					s.port = new Integer(spl[1]);
					s.isPE = false;
					list.add(s);
				} else {
					// IP only
					Server s = new Server();
					s.ip = spl[0];
					s.port = 19132;
					s.isPE = false;
					list.add(s);
				}
			}
			return list;
		}
		return null;
	}
}