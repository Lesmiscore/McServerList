package com.nao20010128nao.McServerList.sites;

import java.net.URL;
import java.util.List;

import com.nao20010128nao.McServerList.Server;

/**
 * Parser class for "pmmp.jp.net".<br>
 * Not implemented: website is not working now
 * */

@Deprecated
public class Pmmp_Jp_Net implements ServerListSite {

	public Pmmp_Jp_Net() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean matches(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean hasMultipleServers(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public List<Server> getServers(URL url) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
