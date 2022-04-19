package cn.sticki.blog.pojo.vo;

import cn.sticki.blog.pojo.domain.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
public class UserVO {

	String username;

	String nickname;

	String avatarUrl;

	Timestamp registerTime;

	private String avatarPrefix() {
		return Config.avatarPrefix;
	}

	UserVO(User user) {
		this.username = user.getUsername();
		this.nickname = user.getNickname();
		this.avatarUrl = avatarPrefix() + user.getAvatar();
		this.registerTime = user.getRegisterTime();
	}

	public static UserVO userToVO(User user) {
		if (user == null) return null;
		else return new UserVO(user);
	}

}

@Component
class Config {

	@Getter
	public static String avatarPrefix;

	@Value("${resource.avatar}")
	public void setDatabase(String db) {
		avatarPrefix = db;
	}

}
