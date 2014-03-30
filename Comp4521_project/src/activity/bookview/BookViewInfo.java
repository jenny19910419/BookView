package activity.bookview;

public class BookViewInfo {
	private String originalText;
	private String viewText;
	private int imageId;
	
	public BookViewInfo(String org, String view, int im) {
		originalText = org;
		viewText = view;
		imageId = im;
	}
}
