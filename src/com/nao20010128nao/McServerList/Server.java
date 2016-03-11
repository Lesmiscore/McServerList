package com.nao20010128nao.McServerList;

/**
 * A server.
 * */
public final class Server {
	/**
	 * The address of the server
	 * */
	public String ip;
	/**
	 * The port of the server
	 * */
	public int port;
	/**
	 * Used for check the server is for PE or not
	 * */
	public boolean isPE;

	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return ip + ":" + port;
	}
}
