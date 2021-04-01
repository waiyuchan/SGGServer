package com.unconme.sgg.entity;

import java.util.List;

import javax.persistence.Id;
import org.springframework.lang.Nullable;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

//Data娉ㄨВ���ㄥ��寤�get set�规�
@Data
//Table娉ㄨВ���ㄥ缓琛�锛����颁负琛ㄥ��
@Table(name="user")
public class User {
	@Id
	@Column(name="uid", type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
	private Integer uid;
	
	@Column(name="open_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String openId;
	
	@Column(name="nickname",type = MySqlTypeConstant.VARCHAR, isNull=false)
	private String nickname;
	
	@Column(name="email",type = MySqlTypeConstant.VARCHAR, isNull=false)
	private String email;
	
	@Column(name="phone",type = MySqlTypeConstant.VARCHAR, isNull=false)
	private String phone;
	
	@Column(name="avatar",type = MySqlTypeConstant.VARCHAR)
	private String avatar;
	
	@Column(name="country",type = MySqlTypeConstant.VARCHAR, isNull=false)
	private String country;
	
	@Column(name="city",type = MySqlTypeConstant.VARCHAR, isNull=false)
	private String city;
	
	private List<Favorite> collect;
	
	public User(String openId, Integer uid, String nickName, String country, String city, @Nullable String avatar) {
		this.openId = openId;
		this.uid = uid;
		this.nickname = nickName;
		this.country = country;
		this.city = city;
		this.avatar = avatar;
	}
}
