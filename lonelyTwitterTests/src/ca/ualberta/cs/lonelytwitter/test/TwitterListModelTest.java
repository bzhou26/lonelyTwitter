package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TwitterListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	
	TweetListModel tweets;
	public TwitterListModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		tweets = new TweetListModel();
		
	}
	
	public void testCounts(){
		NormalTweetModel normalTweet = new NormalTweetModel("Hello");
		tweets.addTweet(normalTweet);
		assertEquals("Count should be one", tweets.getCount(),2);
	}
	
	public void testAddTweets(){
		NormalTweetModel notmalTweet= new NormalTweetModel("Hi");
		tweets.addTweet(normalTweet);
		assertEquals("There should be a tweet in the list",1,tweets.getTweets().size());
		assertNotNull("The tweets list is not initialized", tweets.getTweets());
	}
	
	public void testGetTweets(){}
	
	public void testHasTweets(){}
	
	public void testRemoveTweets(){}
	
		
		
	}
}
