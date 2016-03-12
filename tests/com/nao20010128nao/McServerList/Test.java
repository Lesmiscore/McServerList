package com.nao20010128nao.McServerList;

import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

public class Test extends TestCase {
	public Test() {
		super("Minecraft_Jp");
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void test_Minecraft_Jp() throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"https://minecraft.jp/"))) {
			System.out.println(s);
		}
	}

	public void test_Pe_Minecraft_Jp() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"https://pe.minecraft.jp/"))) {
			System.out.println(s);
		}
	}

	public void test_Minecraft_Jp_2() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"https://minecraft.jp/servers/play.minecraft.jp"))) {
			System.out.println(s);
		}
	}

	public void test_Pe_Minecraft_Jp_2() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"https://pe.minecraft.jp/servers/pe.tcrsnc.com:19130"))) {
			System.out.println(s);
		}
	}

	public void test_MinecraftServersList_Org() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"http://www.minecraft-servers-list.org/details/Minesaur/"))) {
			System.out.println(s);
		}
	}

	public void test_Minecraftservers_Org() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"http://minecraftservers.org/"))) {
			System.out.println(s);
		}
	}

	public void test_Minecraftpeservers_Org() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"http://minecraftpeservers.org/"))) {
			System.out.println(s);
		}
	}

	public void test_Minecraftservers_Org_2() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"http://minecraftservers.org/server/231017"))) {
			System.out.println(s);
		}
	}

	public void test_Minecraftpeservers_Org_2() throws IOException {
		for (Server s : ServerAddressFetcher.findServersInWebpage(new URL(
				"http://minecraftpeservers.org/server/720"))) {
			System.out.println(s);
		}
	}
}
