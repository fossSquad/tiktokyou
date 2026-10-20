package com.ss.android.ugc.aweme.friendstab.repo;

/**
 * Minimal stand-in for the host class absent from the 47.4.3 base and the mod.
 * Only the constructor contract used by the hook is preserved.
 */
public class RepostTextExtra {
    public Integer spanStart;
    public Integer spanEnd;
    public String mentionUserId;
    public Integer mentionType;
    public String emojiId;

    public RepostTextExtra(Integer spanStart, Integer spanEnd, String mentionUserId,
                           Integer mentionType, String emojiId) {
        this.spanStart = spanStart;
        this.spanEnd = spanEnd;
        this.mentionUserId = mentionUserId;
        this.mentionType = mentionType;
        this.emojiId = emojiId;
    }
}
