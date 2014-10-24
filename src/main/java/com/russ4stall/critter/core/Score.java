package com.russ4stall.critter.core;

/**
 * Created by russellf on 10/24/2014.
 */
public class Score {
    private int upVotes;
    private int downVotes;

    public int getScore() {
        return upVotes - downVotes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}

