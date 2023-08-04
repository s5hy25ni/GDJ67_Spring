package com.min.edu.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.anno03.sub.NickName3;

/**
 * TODO anno03 03_02 NickNameProp3을 @Component를 통해서 bean으로 등록하고
 *
 */
@Component
public class NickNameProp3 {
	
	@Autowired
	private NickName3 nickName;

	public NickName3 getNickName() {
		return nickName;
	}

	public void setNickName(NickName3 nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "NickNameProp3 [nickName=" + nickName + "]";
	}
	
	
}
