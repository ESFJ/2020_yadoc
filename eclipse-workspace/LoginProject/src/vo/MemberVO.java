package vo;

public class MemberVO {
	//������ ���Ἲ�빮�� ������ ĸ��ȭ �ʿ�
	//���α׷��ȿ��� �̷� �Ӽ����� �ٷ�ٴ�.
	//ȸ�������� ó���ϴ� Ŭ����
	//DB�� �÷��� �����ؾ���(�÷��� �����Ͱ� ����)
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
