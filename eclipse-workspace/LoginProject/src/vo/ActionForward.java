package vo;
//Ư�� ������ �����ϴ� Ŭ���� (VO)
//�����Ͻ� ������ ó���� �� ���������� �� �������� �������Ҷ� �ʿ��� ������ �����ϴ� Ŭ����
public class ActionForward {
	private String url;
	private boolean redirect; //� ������� �������ϴ��� //�� ���� ó���ϸ� � �������� ����

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
