package vo;

public class MemberVO {
	//데이터 무결성대문에 무조건 캡슐화 필요
	//프로그램안에선 이런 속성들을 다루겟다.
	//회원정보를 처리하는 클래스
	//DB의 컬럼과 동일해야함(컬럼과 데이터가 매핑)
	private String id;
	private String name;
	private String passwd;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
