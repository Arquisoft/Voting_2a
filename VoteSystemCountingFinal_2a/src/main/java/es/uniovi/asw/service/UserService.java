package es.uniovi.asw.service;

import java.util.List;

import es.uniovi.asw.model.UserInfo;

public interface UserService {
	UserInfo validar(UserInfo user);
	UserInfo update(UserInfo user);
	UserInfo get(Long id);
	List<UserInfo> getAll();
	
}
