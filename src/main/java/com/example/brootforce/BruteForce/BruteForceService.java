package com.example.brootforce.BruteForce;

import com.example.brootforce.SecretPassword.SecretPasswordService;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class BruteForceService {
	SecretPasswordService secretPasswordService = new SecretPasswordService();

	public String findPassword(){
		List<Character> symbols = getSymbols();
		CRC32 crc = new CRC32();
		//инициализируем цепочку символов
		Link link = initLinks(symbols, 12);

		//начинаем перебор ключей
		StringBuilder key = new StringBuilder();
		while(!secretPasswordService.getSecretPassword().equals(key.toString())) {
			assert link != null;
			link.next();
			key.setLength(0);
			link.getKey(key);
		}

		//цель достигнута
		System.out.println("Valid key="+key);
		return key.toString();
	}

	//инициализация цепочки старой доброй рекурсией
	private static Link initLinks(List<Character> symbols, int level) {
		if (level>0) {
			return new Link(symbols, initLinks(symbols, level-1));
		}
		return null;
	}

	private List<Character> getSymbols(){
		List<Character> symbols = new ArrayList<>();
		for (char c=33; c<=126; c++) symbols.add(c);
		return symbols;
	}
}