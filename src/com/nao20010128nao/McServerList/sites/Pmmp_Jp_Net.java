package com.nao20010128nao.McServerList.sites;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.nao20010128nao.McServerList.Server;

/**
 * Parser class for "pmmp.jp.net".
 */

public class Pmmp_Jp_Net implements ServerListSite {

	public Pmmp_Jp_Net() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean matches(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return url.getHost().equalsIgnoreCase("pmmp.jp.net");
	}

	@Override
	public boolean hasMultipleServers(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public List<Server> getServers(URL url) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		HttpURLConnection con = (HttpURLConnection) new URL("http://api.pmmp.jp.net/list").openConnection();
		con.setDoOutput(true);

		con.setRequestMethod("POST");
		con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)");
		Writer w = new OutputStreamWriter(con.getOutputStream());
		w.write("userID=100006289&app=2");
		w.flush();
		PMMP_Servers_List sl = new Gson().fromJson(new InputStreamReader(con.getInputStream(), "UTF-8"),
				PMMP_Servers_List.class);
		List<Server> result = new ArrayList<>();
		for (PMMP_Servers_List.ServerEntry se : sl.servers) {
			if (se.ip == null)
				continue;
			if (!se.ip.contains("."))
				continue;
			Server s = new Server();
			s.ip = se.ip;
			s.port = new Integer(se.port);
			s.isPE = true;
			result.add(s);
		}
		return result;
	}

	public class PMMP_Servers_List {
		public int status;
		public String userID;
		public ServerEntry[] servers;

		public class ServerEntry {
			public int ver, notify, no, status, playerMax, playerNow;
			public long _order;
			public String name, description, ip, port, icon, topImg, owner;
			public SitesEntry[] sites;
			public CategoriesEntry[] categories;

			public class SitesEntry {
				public String title, url;
				public int icon;
				public SchememesEntry[] schemes;

				public class SchememesEntry {
					public String title, icon, scheme;
					public boolean allowAndroid;
				}
			}

			public class CategoriesEntry {
				public int color, mark;
				public String text;
			}
		}
	}
}
