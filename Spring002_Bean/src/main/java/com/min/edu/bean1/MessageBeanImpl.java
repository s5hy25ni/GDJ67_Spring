package com.min.edu.bean1;

/**
 * 은닉화 되어 있는 멤버필드를 가지고 있다. 기능을 구현한 Override된 메소드를 가지고 있다.
 */
public class MessageBeanImpl implements IMessageBean {

	private String coffee;
	private String price;

	public MessageBeanImpl() {
		this.coffee = "케냐AA";
		this.price = "1000";
	}

	public MessageBeanImpl(String coffee, String price) {
		super();
		this.coffee = coffee;
		this.price = price;
	}

	@Override
	public void call() {
		System.out.printf("%s의 커피 가격은? %s 입니다. \n", coffee, price);
	}

}
