package MockBookViewList;

import hkust.comp4521.project.R;
import activity.bookview.BookViewInfo;

public class MockBookViewList {
	BookViewInfo bookViewOne = new BookViewInfo("first orgfirst orgfirst orgfirst orgfirst orgfirst orgfirst orgfirst orgfirst org", "first review", R.drawable.testpor1, 1, "bookOneName");
    BookViewInfo bookViewTwo = new BookViewInfo("second orgsecond orgsecond orgsecond orgsecond orgsecond orgsecond orgsecond org", "second review", R.drawable.testpor2, 2, "BookTwoName");
  
    public BookViewInfo[] bookViewArray = {bookViewOne, bookViewTwo};
    public BookViewInfo[] bookViewArray1 = {bookViewOne, bookViewOne,bookViewOne,bookViewOne};
    public BookViewInfo[] bookViewArray2 = {bookViewOne, bookViewTwo,bookViewOne,bookViewTwo};
    
}
