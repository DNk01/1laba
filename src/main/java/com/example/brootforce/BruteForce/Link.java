package com.example.brootforce.BruteForce;


import java.util.List;

public class Link {

	//'-1'- пустое значение
	private int currentIndex = -1;
	private List<Character> symbols;
	private Link next;

	public Link(List<Character> symbols, Link link) {
		this.symbols = symbols;
		this.next = link;
	}

	//Переключатель
	public void next() {
		currentIndex++;
		if (currentIndex==symbols.size()) {
			currentIndex=0;
			if (next!=null) {
				next.next();
			}
		}
	}

	//Записываем сгенерированный пароль в generateKey
	public void getKey(StringBuilder generateKey) {
		if (next!=null) {
			next.getKey(generateKey);
		}
		if (currentIndex>-1) {
			generateKey.append(symbols.get(currentIndex));
		}
	}

}
