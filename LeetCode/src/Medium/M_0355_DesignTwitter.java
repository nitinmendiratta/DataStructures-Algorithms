package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/design-twitter/
 */
public class M_0355_DesignTwitter {

	private static class Tweet {
		int tweetId;
		int timePosted;

		public Tweet(int tId, int time) {
			tweetId = tId;
			timePosted = time;
		}
	}

	static int timeStamp;
	int feedMaxNum;
	Map<Integer, Set<Integer>> followees;
	Map<Integer, List<Tweet>> tweets;

	/** Initialize your data structure here. */
	public M_0355_DesignTwitter() {
	    timeStamp = 0;
	    feedMaxNum = 10;
	    followees = new HashMap<>();
	    tweets = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!tweets.containsKey(userId)) {
			tweets.put(userId, new LinkedList<Tweet>());
			follow(userId, userId); // follow itself
		}
		tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++)); // add new tweet on the first place
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		// min heap that the earliest tweet is on the top
		PriorityQueue<Tweet> feedHeap = new PriorityQueue<>(new Comparator<Tweet>() {
			public int compare(Tweet t1, Tweet t2) {
				return t1.timePosted - t2.timePosted;
			}
		});

		// add tweets of the followees
		Set<Integer> myFollowees = followees.get(userId);
		if (myFollowees != null) {
			for (int followeeId : myFollowees) {
				List<Tweet> followeeTweets = tweets.get(followeeId);
				if (followeeTweets == null)
					continue;
				for (Tweet t : followeeTweets) {
					if (feedHeap.size() < feedMaxNum)
						feedHeap.add(t); // keep adding until we reach max heap size
					else {
						if (t.timePosted <= feedHeap.peek().timePosted)
							break; // as we reached max heap size and the new tweet is older then the peek so dont add
						else {
							feedHeap.add(t);
							feedHeap.poll(); // remove the oldest tweet
						}
					}
				}
			}
		}
		List<Integer> myFeed = new LinkedList<>();
		while (!feedHeap.isEmpty()) {
			myFeed.add(0, feedHeap.poll().tweetId);
		}
		return myFeed;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!followees.containsKey(followerId))
			followees.put(followerId, new HashSet<Integer>());
		followees.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (!followees.containsKey(followerId) || followerId == followeeId)
			return; // cannot unfollow itself
		followees.get(followerId).remove(followeeId);
	}

	public static void main(String[] args) {
		M_0355_DesignTwitter twitter = new M_0355_DesignTwitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		List<Integer> topTweets = twitter.getNewsFeed(1);
		System.out.println(topTweets);

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		topTweets = twitter.getNewsFeed(1);
		System.out.println(topTweets);

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		topTweets = twitter.getNewsFeed(1);
		System.out.println(topTweets);
	}

}
