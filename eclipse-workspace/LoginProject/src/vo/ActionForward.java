package vo;
//특정 정보를 저장하는 클래스 (VO)
//비지니스 로직을 처리한 후 최종적으로 뷰 페이지로 포워딩할때 필요한 정보를 저장하는 클래스
public class ActionForward {
	private String url;
	private boolean redirect; //어떤 방식으로 포워딩하는지 //이 로직 처리하면 어떤 페이지로 갈지

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
