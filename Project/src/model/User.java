package model;
//とりあえず見本をコピペしただけなのであとでよく読んで、内容を理解する。
import java.util.Date;

/**
 * Userテーブルのデータを格納するためのBeans
 * @author satoh
 *
 */
public class User {
	private int id;
	private String login_Id;
	private String name;
	private Date birth_Date;
	private String password;
	private String create_Date;
	private String update_Date;


	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.login_Id = loginId;
		this.name = name;
	}



	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, Date birthDate, String password, String createDate,
			String updateDate) {
		this.id = id;
		this.login_Id = loginId;
		this.name = name;
		this.birth_Date = birthDate;
		this.password = password;
		this.create_Date = createDate;
		this.update_Date = updateDate;
	}

	//フォームに入力された情報を保持するためにデータをセットするコンストラクタを作る(UserUpdateServletで使用)
	public User(int id, String loginId, String name, Date birthDate) {
		this.id = id;
		this.login_Id = loginId;
		this.name = name;
		this.birth_Date = birthDate;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return login_Id;
	}
	public void setLoginId(String loginId) {
		this.login_Id = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birth_Date;
	}
	public void setBirthDate(Date birthDate) {
		this.birth_Date = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return create_Date;
	}
	public void setCreateDate(String createDate) {
		this.create_Date = createDate;
	}
	public String getUpdateDate() {
		return update_Date;
	}
	public void setUpdateDate(String updateDate) {
		this.update_Date = updateDate;
	}





}
