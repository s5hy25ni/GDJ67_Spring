package com.min.edu.anno02;

/**
 * anno02 02_02 NickName 클래스를 멤버필드로 가지고 있는 POJO 클래스
 */
public class NickNameProp {
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "NickNameProp [nickName=" + nickName + "]";
	}
}
